module com.example.snake {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.sql;
    requires java.desktop;


    opens com.example.snake to javafx.fxml;
    exports com.example.snake;
    opens Usuario; // Abre el paquete Usuario al módulo javafx.base

}