package com.example.wf.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Student_Apdapter extends TypeAdapter<Student> {
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(Parent.class, new Parent_Adapter())
            .create();
    @Override
    public void write(JsonWriter jsonWriter, Student student) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("name").value(student.getName());
        jsonWriter.name("grade").value(student.getGrade());
        jsonWriter.name("parent").value(gson.toJson(student.getParent()));
//        jsonWriter.name("parent").value(gson.toJson(student.getParent()));
//        System.out.println(parentString);
//        System.out.println(gson.toJson(student.getParent()));
        jsonWriter.endObject();
    }

    @Override
    public Student read(JsonReader jsonReader) throws IOException {
        Student student = new Student();
        Parent_Adapter parent_adapter = new Parent_Adapter();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "name" -> student.setName(jsonReader.nextString());
                case "grade" -> student.setGrade(jsonReader.nextInt());
                default ->
                    student.setParent(parent_adapter.read(jsonReader));
//                        jsonReader.skipValue();

            }
        }
        jsonReader.endObject();
        return student;
    }
}
