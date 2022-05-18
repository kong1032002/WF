package com.example.wf.View;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class creatorController implements Initializable {
    public Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText("""
                Các thành viên trong nhóm:\s
                Nguyễn Thành Công\s
                Chu Ngọc Chiến\s
                Trần Minh Hiếu\s
                Lê Xuân Dương\s
                """);
    }
}
