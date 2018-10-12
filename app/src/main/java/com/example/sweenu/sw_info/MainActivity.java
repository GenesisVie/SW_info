package com.example.sweenu.sw_info;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        URL url = null;
        try {
            url = new URL("");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (urlConnection.getResponseCode() == HttpURLConnection.HttpURLConnection.HTT_OK) {
                BufferedReader in = null;
                try {
                    in = new BufferedReader(
                            new InputStreamReader(urlConnection.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Log.d("Async", in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
