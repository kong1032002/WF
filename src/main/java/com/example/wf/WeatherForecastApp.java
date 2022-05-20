package com.example.wf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherForecastApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherForecastApp.class.getResource("WF.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 880, 540);
        stage.setTitle("BrainStorm's Weather Forecast!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}