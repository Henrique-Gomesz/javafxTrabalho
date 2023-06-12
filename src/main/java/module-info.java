module com.example.operacoesfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.swing;
    requires java.logging;
    requires org.json;
    opens com.example.operacoesfx.db.entidades;
    opens com.example.operacoesfx to javafx.fxml;
    exports com.example.operacoesfx;
}