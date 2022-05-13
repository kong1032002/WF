package com.example.wf.Model;

import java.util.ArrayList;
import java.util.List;


public class JsonResult {
    private int cod;
    private int message;
    private int cnt;
    private List<DailyWeather> dailyWeathers = new ArrayList<>();
    private City city = new City();

    public int getCod() {
        return cod;
    }

    public int getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public List<DailyWeather> getDailyWeathers() {
        return dailyWeathers;
    }

    public City getCity() {
        return city;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void setDailyWeathers(List<DailyWeather> dailyWeathers) {
        this.dailyWeathers = dailyWeathers;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void addDailyWeather(DailyWeather dailyWeather) {
        this.dailyWeathers.add(dailyWeather);
    }

    public DailyWeather getPeek() {
        return dailyWeathers.get(dailyWeathers.size() - 1);
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "cod=" + cod +
                ", message=" + message +
                ", cnt=" + cnt +
                ", dailyWeathers=" + dailyWeathers +
                ", city=" + city +
                '}';
    }
}
