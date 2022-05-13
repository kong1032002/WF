package com.example.wf.Controller.Adapter;

import com.example.wf.Model.DailyWeather;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class DailyWeather_Adapter extends TypeAdapter<DailyWeather> {

    @Override
    public void write(JsonWriter jsonWriter, DailyWeather dailyWeather) throws IOException {

    }

    @Override
    public DailyWeather read(JsonReader jsonReader) throws IOException {
        DailyWeather dailyWeather = new DailyWeather();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "dt" -> dailyWeather.setDt(jsonReader.nextInt());
                case "main" -> dailyWeather.setMain(new Main_Adapter().read(jsonReader));
                case "weather" -> dailyWeather.setWeather(new Weather_Adapter().read(jsonReader));
                case "visibility" -> dailyWeather.setVisibility(jsonReader.nextInt());
                case "pop" -> dailyWeather.setPop(jsonReader.nextDouble());
                case "sys" -> dailyWeather.setSys(new Sys_Adapter().read(jsonReader));
                case "dt_txt" -> dailyWeather.setDt_txt(jsonReader.nextString());
                case "rain" -> dailyWeather.setRain(new Rain_Adapter().read(jsonReader));
                case "wind" -> dailyWeather.setWinds(new Wind_Adapter().read(jsonReader));
                default -> jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return dailyWeather;
    }
}
