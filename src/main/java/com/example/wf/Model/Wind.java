package com.example.wf.Model;

public class Wind {
    private double speed;
    private int deg;
    private double gust;

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public void setGust(double gust) {
        this.gust = gust;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }

    public double getGust() {
        return gust;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                ", gust=" + gust +
                '}';
    }
}
