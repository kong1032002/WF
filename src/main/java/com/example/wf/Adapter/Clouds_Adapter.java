package com.example.wf.Adapter;

import com.example.wf.data.Clouds;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Clouds_Adapter extends TypeAdapter<Clouds> {

    @Override
    public void write(JsonWriter jsonWriter, Clouds clouds) throws IOException {

    }

    @Override
    public Clouds read(JsonReader jsonReader) throws IOException {
        Clouds clouds = new Clouds();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "all" -> clouds.setAll(jsonReader.nextInt());
                default -> jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return clouds;
    }
}
