package com.example.wf.View;

import com.example.wf.Controller.API.HandleAPI;
import com.example.wf.Model.DailyWeather;
import com.example.wf.Model.JsonResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class forecastController implements Initializable {
    private final String[] DOW = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public Label temperature;
    public Label weather;
    public Label date;
    public ImageView todayIcon;
    public Label dayOfWeek;
    public Label description;
    public Label wind;
    public Label humidity;
    public Label day1;
    public ComboBox<String> city;
    public ImageView icon1;
    public Label temp1;
    public Label day2;
    public ImageView icon2;
    public Label temp2;
    public Label day3;
    public ImageView icon3;
    public Label temp3;
    public Label day4;
    public ImageView icon4;
    public Label temp4;
    public Label day5;
    public ImageView icon5;
    public Label temp5;
    public Label country;
    public Label advise;

    public void selectCity(ActionEvent actionEvent) {
        String selectedCity = city.getSelectionModel().getSelectedItem();
        JsonResult jsonResult = HandleAPI.getData(selectedCity);
        if (jsonResult.getCod() != 200) {
            if (jsonResult.getCod() == 404) {
                country.setText("City is not found!");
            }
            return;
        }
        List<DailyWeather> dailyWeather = jsonResult.getDailyWeathers();

        temperature.setText(dailyWeather.get(1).getMain().getTemp() + " °C");
        wind.setText("Gió: " + dailyWeather.get(1).getWinds().getSpeed() + "m/s");
        String today = dailyWeather.get(1).getDt_txt();
        String[] time = today.split(" ");
        date.setText(today);
        weather.setText(dailyWeather.get(1).getWeather().getMain());
        description.setText(dailyWeather.get(1).getWeather().getDescription());
        humidity.setText("Độ ẩm: " + dailyWeather.get(1).getMain().getHumidity() + "%");
        dayOfWeek.setText(LocalDate.now().getDayOfWeek().name());
        int now = LocalDate.now().getDayOfWeek().getValue();
        country.setText( jsonResult.getCity().getName() + " - " + jsonResult.getCity().getCountry());
        day1.setText(DOW[(++now - 1) % 7]);
        day2.setText(DOW[(++now - 1) % 7]);
        day3.setText(DOW[(++now - 1) % 7]);
        day4.setText(DOW[(++now - 1) % 7]);
        day5.setText(DOW[(++now - 1) % 7]);
        if (Integer.parseInt(time[1].substring(0, 2)) < 18) {
            switch (weather.getText()) {
                case "Rain" -> {
                    switch (description.getStyle()) {
                        case "heavy intensity rain" -> advise.setText("Mưa to, mưa rào lớn, gia cố, che chắn các cửa số để tránh bị nước hắt vào, hạn chế ra ngoài nhé");
                        case "light rain" -> advise.setText("Mưa nhỏ, bạn nghĩ sao nếu ngắm mưa với một cốc cafe và một quyển sách");
                        default -> advise.setText("Bạn nên phơi đồ trong nhà, ra ngoài nhớ mang theo ô nhé!");
                    }
                }
                case "Clear" -> advise.setText("Trời quang, thích hợp phơi đồ, nên thoa kem chống nắng khi ra ngoài khi trời sáng");
                case "Clouds" -> {
                    switch (description.getText()) {
                        case "overcast clouds" -> advise.setText("Trời u ám có thể có mưa ra ngoài nên mang theo ô để đề phòng nhé");
                        case "few clouds" -> advise.setText("Trời quang, mây tạnh, ra ngoài nhớ đội mũ nhé");
                        case "scattered clouds", "broken clouds" -> advise.setText("Mây rải rác!!!!!!!!!!!");
                        default -> advise.setText("Trời có mây, phù hợp cho các hoạt động thể thao ngoài trời!!!!");
                    }
                }
            }
        }
        temp1.setText(dailyWeather.get(9).getMain().getTemp() + " °C");
        temp2.setText(dailyWeather.get(17).getMain().getTemp() + " °C");
        temp3.setText(dailyWeather.get(26).getMain().getTemp() + " °C");
        temp4.setText(dailyWeather.get(35).getMain().getTemp() + " °C");
        temp5.setText(dailyWeather.get(39).getMain().getTemp() + " °C");

        icon1.setImage(new Image(getIcon(dailyWeather.get(9).getWeather().getMain())));
        icon2.setImage(new Image(getIcon(dailyWeather.get(17).getWeather().getMain())));
        icon3.setImage(new Image(getIcon(dailyWeather.get(26).getWeather().getMain())));
        icon4.setImage(new Image(getIcon(dailyWeather.get(35).getWeather().getMain())));
        icon5.setImage(new Image(getIcon(dailyWeather.get(39).getWeather().getMain())));
        todayIcon.setImage(new Image(getIcon(dailyWeather.get(1).getWeather().getMain())));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> observableList =
                FXCollections.observableArrayList(cities());
        city.setItems(observableList);
    }

    private String getIcon(String weather) {
        switch (weather) {
            case "Rain" -> {
                return getClass().getResource("/com/example/wf/Rain.png").toString();
            }
            case "Clouds" -> {
                return getClass().getResource("/com/example/wf/Clouds.png").toString();
            }
            case "Snow" -> {
                return getClass().getResource("/com/example/wf/Snow.png").toString();
            }
            case "Clear" -> {
                return getClass().getResource("/com/example/wf/Clear.png").toString();
            }
            default -> {
                return getClass().getResource("/com/example/wf/Sunny-icon.png").toString();
            }
        }
    }

    public ArrayList<String> cities() {
        Scanner scanner;
        String url = "src\\main\\resources\\com\\example\\wf\\city.txt";
        ArrayList<String> cities = new ArrayList<>();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(url);
            scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                cities.add(scanner.nextLine());
            }
        } catch (IOException ex) {
            System.out.println(-1);
        }
        return cities;
    }
}