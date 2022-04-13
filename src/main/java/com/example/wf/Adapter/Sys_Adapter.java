package com.example.wf.Adapter;

import com.example.wf.data.Sys;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Sys_Adapter extends TypeAdapter<Sys> {
    @Override
    public void write(JsonWriter jsonWriter, Sys sys) throws IOException {

    }

    @Override
    public Sys read(JsonReader jsonReader) throws IOException {
        Sys sys = new Sys();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "pod" -> sys.setPod(jsonReader.nextString());
                default -> jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return sys;
    }
}
