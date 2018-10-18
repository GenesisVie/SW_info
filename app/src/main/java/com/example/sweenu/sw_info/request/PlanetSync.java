package com.example.sweenu.sw_info.request;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.sweenu.sw_info.model.Planet;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import com.android.volley.Request;

public class PlanetSync {

    public PlanetSync (RequestQueue queue) {
        this.queue= queue;
    }


    public interface PlanetInterfaces {
        void onSucess(ArrayList<Planet> planets);
        void onError(String message);
    }


    private static final String TAG = "APP";

    private RequestQueue queue;

    private static final String URLperso = ("https://swapi.co/api/planets/");

    public void getPlanetlist(final PlanetInterfaces callback) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,URLperso, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse" + response);

                ArrayList<Planet> planets = new ArrayList<>();
                if (response.length() > 0) {
                    for (int i = 0; i < 9; i++) {
                        try {
                            JSONObject planetObject = response.getJSONArray("results").getJSONObject(i);
                            String name = planetObject.getString("name");
                            int rotation= planetObject.getInt("rotation_period");
                            int orbital= planetObject.getInt("orbital_period");
                            int diameter= planetObject.getInt("diamerter");
                            String climate= planetObject.getString("climate");
                            int population= planetObject.getInt("population");


                            Planet planet = new Planet(name,rotation, orbital, diameter, climate, population);

                            planets.add(planet);
                        } catch (JSONException e) {
                            Log.d(TAG, "onSKURT" + e.getMessage());
                            callback.onError("Une erreur s'est produite");
                            e.printStackTrace();
                        }
                    }
                    callback.onSucess(planets);
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