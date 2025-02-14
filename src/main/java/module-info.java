module com.example.bitcoin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bitcoin to javafx.fxml;
    exports com.example.bitcoin;
}