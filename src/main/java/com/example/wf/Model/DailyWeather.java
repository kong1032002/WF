package com.example.wf.Model;

public class DailyWeather {
    private int dt;
    private Main main;
    private Weather weather;
    private Clouds clouds;
    private Wind winds;
    private int visibility;
    private double pop;
    private Rain rain;
    private Sys sys;
    private String dt_txt;

    public void setDt(int dt) {
        this.dt = dt;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setWinds(Wind winds) {
        this.winds = winds;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public int getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public Weather getWeather() {
        return weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWinds() {
        return winds;
    }

    public int getVisibility() {
        return visibility;
    }

    public double getPop() {
        return pop;
    }

    public Rain getRain() {
        return rain;
    }

    public Sys getSys() {
        return sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    @Override
    public String toString() {
        return "DailyWeather{" +
                "dt=" + dt +
                ", main=" + main +
                ", weather=" + weather +
                ", clouds=" + clouds +
                ", winds=" + winds +
                ", visibility=" + visibility +
                ", pop=" + pop +
                ", rain=" + rain +
                ", sys=" + sys +
                ", dt_txt='" + dt_txt + '\'' +
                '}';
    }
}
