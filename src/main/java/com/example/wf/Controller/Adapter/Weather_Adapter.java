package com.example.wf.Controller.Adapter;

import com.example.wf.Model.Weather;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Weather_Adapter extends TypeAdapter<Weather> {

    @Override
    public void write(JsonWriter jsonWriter, Weather weather) throws IOException {


    }

    @Override
    public Weather read(JsonReader jsonReader) throws IOException {
        Weather weather = new Weather();
        jsonReader.beginArray();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "id" -> weather.setId(jsonReader.nextInt());
                case "main" -> weather.setMain(jsonReader.nextString());
                case "description" -> weather.setDescription(jsonReader.nextString());
                case "icon" -> weather.setIcon(jsonReader.nextString());
                default -> jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.endArray();
        return weather;
    }
}
