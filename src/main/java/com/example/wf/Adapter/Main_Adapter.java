package com.example.wf.Adapter;

import com.example.wf.data.Main;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Main_Adapter extends TypeAdapter<Main> {

    @Override
    public void write(JsonWriter jsonWriter, Main main) throws IOException {

    }

    @Override
    public Main read(JsonReader jsonReader) throws IOException {
        Main main = new Main();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "temp" -> main.setTemp(jsonReader.nextDouble());
                case "feels_like" -> main.setFeels_like(jsonReader.nextDouble());
                case "temp_min" -> main.setTemp_min(jsonReader.nextDouble());
                case "temp_max" -> main.setTemp_max(jsonReader.nextDouble());
                case "temp_kf" -> main.setTemp_kf(jsonReader.nextDouble());
                case "pressure" -> main.setPressure(jsonReader.nextInt());
                case "sea_level" -> main.setSea_level(jsonReader.nextInt());
                case "grnd_level" -> main.setGrnd_level(jsonReader.nextInt());
                case "humidity" -> main.setHumidity(jsonReader.nextInt());
                default -> jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return main;
    }
}
