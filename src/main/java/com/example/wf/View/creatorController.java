package com.example.wf.View;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class creatorController implements Initializable {
    public Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText("Nguyễn Thành Công \n" +
                "Chu Ngọc Chiến \n" +
                "Trần Minh Hiếu \n" +
                "Lê Xuân Dương \n");
    }
}
