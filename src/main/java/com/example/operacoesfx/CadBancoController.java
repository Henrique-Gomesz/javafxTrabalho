package com.example.operacoesfx;

import com.example.operacoesfx.db.dal.BancoDAL;
import com.example.operacoesfx.db.entidades.Banco;
import com.example.operacoesfx.db.util.DBSingleton;
import com.example.operacoesfx.util.MaskFieldUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CadBancoController implements Initializable {
    public TextField tfFiltro;
    public Label lbAdicionar;
    @FXML
    private Button btCancelar;

    @FXML
    private Button btConfirmar;

    @FXML
    private TableColumn<Banco, Integer> colId;

    @FXML
    private TableColumn<Banco, String> colNome;

    @FXML
    private TableColumn<Banco, Integer> colNumero;

    @FXML
    private TableView<Banco> table;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfNBanco;

    @FXML
    private TextField tfNomeBanco;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        MaskFieldUtil.maxField(tfNomeBanco,30);
        MaskFieldUtil.maxField(tfNBanco,3);
        MaskFieldUtil.numericField(tfNBanco);
        modoPadrao();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        carregarTabela("");
    }

    private void carregarTabela(String filtro) {
        List<Banco> bancos = new BancoDAL().get(filtro);
        table.setItems(FXCollections.observableArrayList(bancos));
    }

    @FXML
    void evtCancelar(ActionEvent event) {
        modoPadrao();

    }

    @FXML
    void evtConfirmar(ActionEvent event) {
        Banco banco = new Banco(0,Integer.parseInt(tfNBanco.getText()),
                tfNomeBanco.getText());
        if(!tfId.getText().isEmpty()) {
            banco.setId(Integer.parseInt(tfId.getText()));
            new BancoDAL().alterar(banco);
        }
        else
            new BancoDAL().gravar(banco);
        carregarTabela("");
        modoPadrao();
    }

    @FXML
    void evtFiltro(KeyEvent event) {
        carregarTabela("upper(bco_nome) like '%"+tfFiltro.getText().toUpperCase()+"%'");
    }

    public void evtNovoBanco(MouseEvent mouseEvent) {
        modoEdicao();

    }
    public void modoEdicao()
    {
        tfId.setDisable(false);
        tfNBanco.setDisable(false);
        tfNomeBanco.setDisable(false);
        tfFiltro.setDisable(true);
        table.setDisable(true);
        lbAdicionar.setDisable(true);
        tfNBanco.requestFocus();
        btConfirmar.setDisable(false);
        btCancelar.setDisable(false);
    }
    public void modoPadrao()
    {
        tfId.setDisable(true);
        tfNBanco.setDisable(true);
        tfNomeBanco.setDisable(true);
        tfFiltro.setDisable(false);
        table.setDisable(false);
        lbAdicionar.setDisable(false);
        btCancelar.setDisable(true);
        btConfirmar.setDisable(true);
        tfNBanco.setText("");
        tfNomeBanco.clear();
        tfId.clear();
    }

    public void evtAlterar(ActionEvent actionEvent) {
        //colocar os valores do objeto selecionado no formulario
        Banco banco=table.getSelectionModel().getSelectedItem();
        if(banco!=null)
        {
            tfId.setText(""+banco.getId());
            tfNBanco.setText(""+banco.getNumero());
            tfNomeBanco.setText(banco.getNome());
        }
        modoEdicao();
    }

    public void evtApagar(ActionEvent actionEvent) {
        Banco banco=table.getSelectionModel().getSelectedItem();
        if(banco!=null)
        {
           Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
           alert.setHeaderText("Apagar o banco?");
           if(alert.showAndWait().get()==ButtonType.OK) {
               if (!new BancoDAL().apagar(banco))
                   System.out.println(DBSingleton.getCon().getMensagemErro());
               carregarTabela("");
           }
        }
    }
}
