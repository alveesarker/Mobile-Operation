module com.example.mobileoperation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mobileoperation to javafx.fxml;
    exports com.example.mobileoperation;
}