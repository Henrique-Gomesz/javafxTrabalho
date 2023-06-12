package com.example.operacoesfx;

import com.example.operacoesfx.db.entidades.Cidade;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

public class CadClienteController implements Initializable {
    @FXML
    private Button btCancelar;

    @FXML
    private Button btConfirmar;

    @FXML
    private TableColumn<Cidade, String> colCidade;

    @FXML
    private TableColumn<Cidade, Integer> colId;

    @FXML
    private TableColumn<Cidade, String> colNome;

    @FXML
    private Label lbAdicionar;

    @FXML
    private TableView<Cidade> table;

    @FXML
    private TextField tfBairro;

    @FXML
    private TextField tfCEP;

    @FXML
    private TextField tfCidade;

    @FXML
    private TextField tfDocumento;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfFiltro;

    @FXML
    private TextField tfFone;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfJuros;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfNumero;

    @FXML
    private TextField tfUF;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void evtNovoBanco(MouseEvent mouseEvent) {
    }

    public void evtConfirmar(ActionEvent actionEvent) {
    }

    public void evtCancelar(ActionEvent actionEvent) {
    }

    public void evtAlterar(ActionEvent actionEvent) {
    }

    public void evtApagar(ActionEvent actionEvent) {
    }

    public void evtFiltro(KeyEvent keyEvent) {
    }

    public String consultaCep(String cep, String formato)
    {
        StringBuffer dados = new StringBuffer();
        try {
            URL url = new URL("https://viacep.com.br/ws/"+ cep + "/"+formato+"/");
            URLConnection con = url.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setAllowUserInteraction(false);
            InputStream in = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String s = "";
            while (null != (s = br.readLine()))
                dados.append(s);
            br.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return dados.toString();
    }

    public void evtBuscaCep(KeyEvent keyEvent) {
        if(tfCEP.getText().length()==8) {
            Task task = new Task<Void>() {
                @Override
                protected Void call() {
                    String json = consultaCep(tfCEP.getText(), "json");
                    JSONObject my_obj = new JSONObject(json);
                    tfCidade.setText(my_obj.getString("localidade"));
                    tfBairro.setText(my_obj.getString("bairro"));
                    Platform.runLater(()->tfNumero.requestFocus());
                    return null;
                }
            };
            new Thread(task).start();

        }
    }
}
