package com.example.wf.View;

import com.example.wf.WeatherForecastApp;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TaskPanel {
    public VBox taskList;
    public TextField textField;
    public CheckBox task;

    public void setOnButtonClick(MouseEvent mouseEvent) {
        try {
            HBox hBox = new FXMLLoader(WeatherForecastApp.class.getResource("taskForm.fxml")).load();
            task = (CheckBox) hBox.getChildren().get(0);
            task.setText(textField.getText());
            taskList.getChildren().add(hBox);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
