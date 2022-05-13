package com.example.wf.Controller.Adapter;

import com.example.wf.Model.Rain;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Rain_Adapter extends TypeAdapter<Rain> {
    @Override
    public void write(JsonWriter jsonWriter, Rain rain) throws IOException {

    }

    @Override
    public Rain read(JsonReader jsonReader) throws IOException {
        Rain rain = new Rain();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "3h" -> rain.setThreeH(jsonReader.nextDouble());
                default -> jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return rain;
    }
}
