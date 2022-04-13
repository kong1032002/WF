package com.example.wf.Adapter;

import com.example.wf.data.City;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class City_Adapter extends TypeAdapter<City> {
    @Override
    public void write(JsonWriter jsonWriter, City city) throws IOException {

    }

    @Override
    public City read(JsonReader jsonReader) throws IOException {
        City city = new City();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "id" -> city.setId(jsonReader.nextInt());
                case "name" -> city.setName(jsonReader.nextString());
                case "coord" -> city.setCoord(new Coord_Adapter().read(jsonReader));
                case "country" -> city.setCountry(jsonReader.nextString());
                case "population" -> city.setPopulation(jsonReader.nextInt());
                case "timezone" -> city.setTimeZone(jsonReader.nextInt());
                case "sunset" -> city.setSunset(jsonReader.nextInt());
                case "sunrise" -> city.setSunrise(jsonReader.nextInt());

            }
        }
        jsonReader.endObject();
        return city;
    }
}
