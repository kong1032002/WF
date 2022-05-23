package com.example.wf.View;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorPanel implements Initializable {
    public Label label;

    public void internetError() {
        label.setText("internet is disconnected!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        internetError();
    }
}
