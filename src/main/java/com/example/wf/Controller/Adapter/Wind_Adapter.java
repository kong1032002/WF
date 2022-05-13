package com.example.wf.Controller.Adapter;

import com.example.wf.Model.Wind;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Wind_Adapter extends TypeAdapter<Wind> {
    @Override
    public void write(JsonWriter jsonWriter, Wind wind) throws IOException {

    }

    @Override
    public Wind read(JsonReader jsonReader) throws IOException {
        Wind wind = new Wind();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "speed" -> wind.setSpeed(jsonReader.nextDouble());
                case "deg" -> wind.setDeg(jsonReader.nextInt());
                case "gust" -> wind.setGust(jsonReader.nextDouble());
                default -> jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return wind;
    }

}
