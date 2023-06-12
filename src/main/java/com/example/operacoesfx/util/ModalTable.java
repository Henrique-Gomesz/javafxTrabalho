package com.example.operacoesfx.util;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.List;

public class ModalTable extends BorderPane {
    private TableView tabela;
    private Button btConfirmar, btCancelar;
    private Object selecionado=null;
    public ModalTable(List<?> dados,  String[] colunas) {
        super();
        this.setStyle("-fx-border-color:black;-fx-background-color:lightgray");
        int i=0;
        tabela=new TableView(FXCollections.observableArrayList(dados));
        tabela.setStyle("-fx-border-color:black;-fx-background-color:lightgray");
        for (String col : colunas) {
            TableColumn column = new TableColumn(col);
            column.setCellValueFactory(new PropertyValueFactory<>(col));
            tabela.getColumns().add(column);
        }
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        carregarTabela(dados);
        this.setCenter(tabela);
        btConfirmar=new Button("Confirmar");
        btCancelar=new Button("Cancelar");
        btConfirmar.setOnAction(e->{confirmar();});
        btCancelar.setOnAction(e->{cancelar();});
        HBox hbox=new HBox(btConfirmar,btCancelar);
        hbox.setAlignment(Pos.CENTER); hbox.setSpacing(20); hbox.setMinHeight(40);
        this.setBottom(hbox);
    }

    private void cancelar() {
        selecionado=null;
        btConfirmar.getScene().getWindow().hide();
    }

    private void confirmar() {
        if (tabela.getSelectionModel().getSelectedItem()!=null)
            selecionado=tabela.getSelectionModel().getSelectedItem();
        btConfirmar.getScene().getWindow().hide();
    }

    private void carregarTabela(List dados) {
        tabela.setItems(FXCollections.observableArrayList(dados));
    }
    public Object getSelecionado() {
        return selecionado;
    }
}
