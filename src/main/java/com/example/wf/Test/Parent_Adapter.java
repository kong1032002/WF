package com.example.wf.Test;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Parent_Adapter extends TypeAdapter<Parent> {
    @Override
    public void write(JsonWriter jsonWriter, Parent parent) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("name").value(parent.getName());
        jsonWriter.name("age").value(parent.getAge());
        jsonWriter.endObject();
    }

    @Override
    public Parent read(JsonReader jsonReader) throws IOException {
        Parent parent = new Parent();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "name" -> parent.setName(jsonReader.nextString());
                case "age" -> parent.setAge(jsonReader.nextInt());
            }
        }
        jsonReader.endObject();
        return parent;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

