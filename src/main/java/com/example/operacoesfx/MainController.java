package com.example.operacoesfx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public BorderPane painel;
    static public BorderPane spainel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      spainel=painel;
    }

    public void evtCadCliente(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cadcliente-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        painel.setCenter(scene.getRoot());
    }

    public void evtCadBanco(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cadbanco-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        painel.setCenter(scene.getRoot());
    }

    public void evtFechar(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void evtDefault(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("default_view.fxml"));
        painel.setCenter(fxmlLoader.load());
    }

    public void evtNova(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("operacao-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        painel.setCenter(scene.getRoot());
    }

    public void evtConsultar(ActionEvent actionEvent) {
    }
}