package com.example.wf.Controller.API;

import com.example.wf.Controller.Adapter.JsonResult_Adapter;
import com.example.wf.Model.JsonResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HandleAPI {
    public static JsonResult getData(String city) {
        JsonResult jsonResult = new JsonResult();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(JsonResult.class,new JsonResult_Adapter())
                .create();
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q="
                    + city
                    + "&cnt=50&APPID=bffca17bcb552b8c8e4f3b82f64cccd2&units=metric");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            jsonResult.setCod(connection.getResponseCode());
            if (connection.getResponseCode() == 200) {
                Scanner scanner = new Scanner(url.openStream());
                String jsonData = "";

                while (scanner.hasNextLine()) {
                    jsonData = jsonData.concat(scanner.nextLine());
                }
                jsonResult = gson.fromJson(jsonData, JsonResult.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }
}
