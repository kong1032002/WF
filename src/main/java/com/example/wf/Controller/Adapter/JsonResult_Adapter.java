package com.example.wf.Controller.Adapter;

import com.example.wf.Model.JsonResult;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class JsonResult_Adapter extends TypeAdapter<JsonResult> {
    @Override
    public void write(JsonWriter jsonWriter, JsonResult jsonResult) throws IOException {

    }

    @Override
    public JsonResult read(JsonReader jsonReader) throws IOException {
        JsonResult jsonResult = new JsonResult();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "cod" -> jsonResult.setCod(jsonReader.nextInt());
                case "message" -> jsonResult.setMessage(jsonReader.nextInt());
                case "cnt" -> jsonResult.setCnt(jsonReader.nextInt());
                case "list" -> {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonResult.addDailyWeather(new DailyWeather_Adapter().read(jsonReader));
                    }
                    jsonReader.endArray();
                }
                case "city" -> jsonResult.setCity(new City_Adapter().read(jsonReader));
                default -> jsonReader.skipValue();
            }
        }
        jsonReader.endObject();

        return jsonResult;
    }
}

