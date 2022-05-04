package com.example.wf;

import com.example.wf.API.HandleAPI;
import com.example.wf.data.DailyWeather;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class WFController implements Initializable {
    public Label temperature;
    public Label wind;
    public Label weather;
    public Label humidity;
    public Label date;
    public Label description;
    public Label dayOfWeek;
    public Label advise;
    public Label day1;
    public Label day2;
    public Label day3;
    public Label day4;
    public Label day5;
    public Label temp1;
    public Label temp2;
    public Label temp3;
    public Label temp4;
    public Label temp5;
    private final String[] DOW = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public ImageView icon1;
    public ImageView icon2;
    public ImageView icon3;
    public ImageView icon4;
    public ImageView icon5;
    public ComboBox city;
    public ImageView todayIcon;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> observableList =
                FXCollections.observableArrayList("hanoi", "saigon", "halong", "danang", "sydney");
        city.setItems(observableList);
    }

    public void WeatherForecastClicked(ActionEvent actionEvent) {

    }

    public void selectCity(ActionEvent actionEvent) {
        String selectedCity = city.getSelectionModel().getSelectedItem().toString();
        List<DailyWeather> dailyWeather = HandleAPI.getData(selectedCity).getDailyWeathers();
        temperature.setText(dailyWeather.get(1).getMain().getTemp() + " C");
        wind.setText("Gió: " + dailyWeather.get(1).getWinds().getSpeed() + "m/s");
        date.setText(String.valueOf(dailyWeather.get(1).getDt_txt()));
        weather.setText(dailyWeather.get(1).getWeather().getMain());
        description.setText(dailyWeather.get(1).getWeather().getDescription());
        humidity.setText("Độ ẩm: " + dailyWeather.get(1).getMain().getHumidity() + "%");
        dayOfWeek.setText(LocalDate.now().getDayOfWeek().name());
        int now = LocalDate.now().getDayOfWeek().getValue();
        System.out.println(DOW[now - 1]);
        day1.setText(DOW[(++now - 1) % 7]);
        day2.setText(DOW[(++now - 1) % 7]);
        day3.setText(DOW[(++now - 1) % 7]);
        day4.setText(DOW[(++now - 1) % 7]);
        day5.setText(DOW[(++now - 1) % 7]);
        switch (weather.getText()) {
            case "Rain" -> advise.setText("Bạn nên phơi đồ trong nhà, ra ngoài nhớ mang theo ô nhé!");
            case "Clear" -> advise.setText("Trời quang, thích hợp phơi đồ, nên thoa kem chống nắng khi ra ngoài khi trời sáng");
            case "Cloud" -> advise.setText("Trời có mây!!!!");
        }
        temp1.setText(dailyWeather.get(9).getMain().getTemp() + " C");
        temp2.setText(dailyWeather.get(17).getMain().getTemp() + " C");
        temp3.setText(dailyWeather.get(26).getMain().getTemp() + " C");
        temp4.setText(dailyWeather.get(35).getMain().getTemp() + " C");
        temp5.setText(dailyWeather.get(39).getMain().getTemp() + " C");

        icon1.setImage(new Image(getIcon(dailyWeather.get(9).getWeather().getMain())));
        icon2.setImage(new Image(getIcon(dailyWeather.get(17).getWeather().getMain())));
        icon3.setImage(new Image(getIcon(dailyWeather.get(26).getWeather().getMain())));
        icon4.setImage(new Image(getIcon(dailyWeather.get(35).getWeather().getMain())));
        icon5.setImage(new Image(getIcon(dailyWeather.get(39).getWeather().getMain())));
        todayIcon.setImage(new Image(getIcon(dailyWeather.get(1).getWeather().getMain())));
//        Image image = new Image(getIcon(dailyWeather.get(9).getWeather().getMain()));
//        icon3.setImage(image);
//        img1.setImage(icon3);
    }

    private String getIcon(String weather) {
        System.out.println(weather);
        switch (weather) {
            case "Rain" -> {
                return getClass().getResource("/com/example/wf/rainy-icon-1.jpg").toString();
            }
            case "Clouds" -> {
                return getClass().getResource("/com/example/wf/1163624.png").toString();
            }
            case "Snow" -> {
                return getClass().getResource("/com/example/wf/bg.png").toString();
            }
            case "Clear" -> {
                return getClass().getResource("/com/example/wf/Sunny-icon.png").toString();
            }
            default -> {
                return getClass().getResource("/com/example/wf/Sunny-icon.png").toString();
            }
        }
    }
}
