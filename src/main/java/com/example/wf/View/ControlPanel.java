package com.example.wf.View;

import com.example.wf.Controller.API.HandleAPI;
import com.example.wf.Model.JsonResult;
import com.example.wf.WeatherForecastApp;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControlPanel implements Initializable {
    private static final String SelectedButton = "-fx-background-radius:  0px 100px 100px 0px; -fx-background-color: linear-gradient(to right bottom,  #17baff, #a629fe);";
    private static final String NonSelectedButton = "-fx-background-radius:  0px 100px 100px 0px; -fx-background-color: #294259; -fx-border-color: #726ffe; -fx-border-radius: 0px 100px 100px 0px;";
    private static final String EnteredButton = "-fx-background-radius:  0px 100px 100px 0px; -fx-background-color: #17baff;";

    public Button weatherButton;
    public Button taskButton;
    public Button creatorButton;
    public VBox mainPanel;
    public VBox defaultPanel;
    public VBox creatorPanel;
    public VBox forecastPanel;
    public VBox errorPanel;
    public VBox taskPanel;
    private int selectedButton = 4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonEntered();
        buttonExited();
        buttonClick();
        JsonResult local = HandleAPI.getData("Hanoi");
        try {
            defaultPanel = new FXMLLoader(WeatherForecastApp.class.getResource("defaultPanel.fxml")).load();
            creatorPanel = new FXMLLoader(WeatherForecastApp.class.getResource("creatorPanel.fxml")).load();
            forecastPanel = new FXMLLoader(WeatherForecastApp.class.getResource("forecastPanel.fxml")).load();
            taskPanel = new FXMLLoader(WeatherForecastApp.class.getResource("taskPanel.fxml")).load();
            errorPanel = new FXMLLoader(WeatherForecastApp.class.getResource("errorPanel.fxml")).load();
            mainPanel.getChildren().add(defaultPanel);
//            mainPanel.getChildren().add(taskPanel);
//            mainPanel.getChildren().add(creatorPanel);
//            mainPanel.getChildren().add(errorPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (local.getCod() != 200 && local.getCod() != 404) {
            return;
        }
    }


    private void buttonEntered() {
        weatherButton.setOnMouseEntered(e -> {
            weatherButton.setStyle(EnteredButton);
        });
        taskButton.setOnMouseEntered(e -> {
            taskButton.setStyle(EnteredButton);
        });
        creatorButton.setOnMouseEntered(e -> {
            creatorButton.setStyle(EnteredButton);
        });
    }

    private void buttonExited() {
        weatherButton.setOnMouseExited(e -> {
            if ((selectedButton == 0)) {
                weatherButton.setStyle(SelectedButton);
            } else {
                weatherButton.setStyle(NonSelectedButton);
            }
        });

        taskButton.setOnMouseExited(e -> {
            if ((selectedButton == 1)) {
                taskButton.setStyle(SelectedButton);
            } else {
                taskButton.setStyle(NonSelectedButton);
            }
        });

        creatorButton.setOnMouseExited(e -> {
            if ((selectedButton == 2)) {
                creatorButton.setStyle(SelectedButton);
            } else {
                creatorButton.setStyle(NonSelectedButton);
            }
        });
    }

    private void buttonClick() {
        weatherButton.setOnMouseClicked(e -> {
            weatherButton.setStyle(SelectedButton);
            taskButton.setStyle(NonSelectedButton);
            creatorButton.setStyle(NonSelectedButton);
            selectedButton = 0;
            mainPanel.getChildren().removeAll(mainPanel.getChildren());
            mainPanel.getChildren().add(forecastPanel);
        });

        taskButton.setOnMouseClicked(e -> {
            taskButton.setStyle(SelectedButton);
            weatherButton.setStyle(NonSelectedButton);
            creatorButton.setStyle(NonSelectedButton);
            mainPanel.getChildren().removeAll(mainPanel.getChildren());
            mainPanel.getChildren().add(taskPanel);
            selectedButton = 1;
        });

        creatorButton.setOnMouseClicked(e -> {
            creatorButton.setStyle(SelectedButton);
            weatherButton.setStyle(NonSelectedButton);
            taskButton.setStyle(NonSelectedButton);
            selectedButton = 2;
            mainPanel.getChildren().removeAll(mainPanel.getChildren());
            mainPanel.getChildren().add(creatorPanel);
        });
    }
}
