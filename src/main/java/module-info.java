module org.fventura.lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.fventura.lab4 to javafx.fxml;
    exports org.fventura.lab4;
}