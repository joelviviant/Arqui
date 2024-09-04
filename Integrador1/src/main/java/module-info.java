module com.example.integrador1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.integrador1 to javafx.fxml;
    exports com.example.integrador1;
}