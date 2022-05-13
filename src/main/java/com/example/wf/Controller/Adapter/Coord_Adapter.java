package com.example.wf.Controller.Adapter;

import com.example.wf.Model.Coord;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Coord_Adapter extends TypeAdapter<Coord>    {
    @Override
    public void write(JsonWriter jsonWriter, Coord coord) throws IOException {

    }

    @Override
    public Coord read(JsonReader jsonReader) throws IOException {
        Coord coord = new Coord();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "lat" -> coord.setLat(jsonReader.nextDouble());
                case "lon" -> coord.setLon(jsonReader.nextDouble());
                default -> jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return coord;
    }
}
