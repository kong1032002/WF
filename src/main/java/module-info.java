module com.example.wf {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.example.wf to javafx.fxml;
    exports com.example.wf;
}