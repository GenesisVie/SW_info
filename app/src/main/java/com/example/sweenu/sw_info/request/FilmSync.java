package com.example.sweenu.sw_info.request;

import android.app.DownloadManager;
import android.nfc.Tag;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.sweenu.sw_info.model.Film;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import com.android.volley.Request;

import com.android.volley.toolbox.JsonArrayRequest;
import com.example.sweenu.sw_info.model.Vaisseau;

public class FilmSync {

    public FilmSync (RequestQueue queue) {
        this.queue= queue;
    }


    public interface FilmInterfaces{
        void onSucess(ArrayList<Film> films);
        void onError(String message);
    }


    private static final String TAG = "APP";

    private RequestQueue queue;

    private static final String URLperso = ("https://swapi.co/api/films/");

    public void getFilmList(final FilmInterfaces callback) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,URLperso, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse" + response);

                ArrayList<Film> films = new ArrayList<>();
                if (response.length() > 0) {
                    for (int i = 0; i < 9; i++) {
                        try {
                            JSONObject filmObject = response.getJSONArray("results").getJSONObject(i);
                            String title = filmObject.getString("title");
                            int episodeID = filmObject.getInt("episode_id");
                            String director = filmObject.getString("director");
                            String producer = filmObject.getString("producer");
                            String date = filmObject.getString("release_date");

                            Film film = new Film(title,episodeID,director,producer,date);

                            films.add(film);
                        } catch (JSONException e) {
                            Log.d(TAG, "onSKURT" + e.getMessage());
                            callback.onError("Une erreur s'est produite");
                            e.printStackTrace();
                        }
                    }
                    callback.onSucess(films);
                } else {
                    callback.onError("Aucun perso trouvé");
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Log.d(TAG,"onBugZer²"+error.getMessage());
                callback.onError("Une erreur s'est produite");
            }
        });
        queue.add(request);
    }
}