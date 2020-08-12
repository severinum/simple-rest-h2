package com.severinu.resttest;

import net.minidev.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        URL beersUrl = new URL("https://com-severinu-java-rest.herokuapp.com/beers");
        HttpURLConnection conn = (HttpURLConnection) beersUrl.openConnection();

        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if(responseCode != 200){
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            String jsonCode = "";
            Scanner sc = new Scanner(beersUrl.openStream());
            while (sc.hasNext()){
                jsonCode += sc.nextLine();
            }
            System.out.println(jsonCode);
            sc.close();

            //JSONObject obj = new JSONObject(jsonCode);

        }
    }
}
