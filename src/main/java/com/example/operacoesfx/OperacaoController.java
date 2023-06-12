package com.example.operacoesfx;
import com.example.operacoesfx.db.dal.BancoDAL;
import com.example.operacoesfx.db.dal.ClienteDAL;
import com.example.operacoesfx.db.dal.OperacaoDAL;
import com.example.operacoesfx.db.entidades.Banco;
import com.example.operacoesfx.db.entidades.Cheque;
import com.example.operacoesfx.db.entidades.Cliente;
import com.example.operacoesfx.db.entidades.Operacao;
import com.example.operacoesfx.util.ModalTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;

public class OperacaoController implements Initializable {
    @FXML
    private Button btAddCheque;

    @FXML
    private Button btCancelar;

    @FXML
    private Button btCliente;

    @FXML
    private Button btConfirmar;

    @FXML
    private ComboBox<Banco> cbBanco;

    @FXML
    private TableColumn<Cheque, Integer> colAgencia;

    @FXML
    private TableColumn<Cheque, Integer> colBanco;

    @FXML
    private TableColumn<Cheque, Integer> colConta;

    @FXML
    private TableColumn<Cheque, String> colCorrentista;

    @FXML
    private TableColumn<Cheque, String> colData;

    @FXML
    private TableColumn<Cheque, Integer> colDocumento;

    @FXML
    private TableColumn<Cheque, Integer> colValor;

    @FXML
    private DatePicker dpData;

    @FXML
    private DatePicker dpDataOp;

    @FXML
    private Label lbCliente;

    @FXML
    private Label lbTotal;

    @FXML
    private TableView<Cheque> tableView;

    @FXML
    private TextField tfAgencia;

    @FXML
    private TextField tfConta;

    @FXML
    private TextField tfCorrentista;

    @FXML
    private TextField tfDocumento;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfValor;

    @FXML
    private TextField tfJuros;

    private double total=0;
    private Cliente cliente=null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dpDataOp.setValue(LocalDate.now());
        lbTotal.setText("0.00");
        lbCliente.setText("indefinido");
        colAgencia.setCellValueFactory(new PropertyValueFactory<>("agencia"));
        colBanco.setCellValueFactory(new PropertyValueFactory<>("banco"));
        colConta.setCellValueFactory(new PropertyValueFactory<>("conta"));
        colCorrentista.setCellValueFactory(new PropertyValueFactory<>("correntista"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colDocumento.setCellValueFactory(new PropertyValueFactory<>("documento"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        carregarCBClientes();
        carregarCBBancos();
    }

    private void carregarCBBancos() {
        List<Banco> bancos;
        bancos=new BancoDAL().get("");
        cbBanco.setItems(FXCollections.observableArrayList(bancos));
    }

    private void carregarCBClientes()
    {
        //List<Cliente> clientes = new ClienteDAL().get("");
        //cb
    }
    @FXML
    void evtAddCheque(ActionEvent event) {
        Cheque cheque = new Cheque(Integer.parseInt(tfAgencia.getText()),
                                   Integer.parseInt(tfConta.getText()),
                                   Long.parseLong(tfDocumento.getText()),
                                   tfCorrentista.getText(),
                                   Double.parseDouble(tfValor.getText()),
                                   dpData.getValue(),
                                   cbBanco.getSelectionModel().getSelectedItem());
        tableView.getItems().add(cheque);
        int diasDeposito = (int)(dpDataOp.getValue().until(dpData.getValue(),
                                                      ChronoUnit.DAYS));
        double juros_cheque=cheque.getValor()*
                (Double.parseDouble(tfJuros.getText())/30*diasDeposito/100);
        total+=cheque.getValor()-juros_cheque;
        lbTotal.setText(String.format("%.2f",total));
        // apagar o formulário do cheque
        cbBanco.requestFocus();
    }

    @FXML
    void evtCancelar(ActionEvent event) {
        limparView();
    }

    @FXML
    void evtConfirmar(ActionEvent event) {
        //cadastrar nova operação
        Operacao op=new Operacao();
        op.setCliente(cliente);
        op.setId(0);
        op.setJuros(Double.parseDouble(tfJuros.getText()));
        //...
        for (Cheque c : tableView.getItems())
            op.addCheque(c);
        new OperacaoDAL().gravar(op);
        limparView();
    }

    private void limparView()  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("default_view.fxml"));
            MainController.spainel.setCenter(fxmlLoader.load());
        }catch (Exception e){}
    }


    public void evtBuscaCliente(ActionEvent actionEvent) {
        ModalTable mt=new ModalTable(new ClienteDAL().get(""),new String[]{"id","nome","fone","juros"});
        Stage stage=new Stage();
        stage.setScene(new Scene(mt));
        stage.setWidth(640); stage.setHeight(480); stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        cliente = (Cliente)mt.getSelecionado();
        if (cliente!=null) {
            lbCliente.setText(cliente.getNome());
            tfJuros.setText(""+cliente.getJuros());
        }
    }
}
