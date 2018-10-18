package com.example.sweenu.sw_info.request;

import android.app.DownloadManager;
import android.nfc.Tag;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.sweenu.sw_info.model.Espece;
import com.example.sweenu.sw_info.model.Perso;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import com.android.volley.Request;

import com.android.volley.toolbox.JsonArrayRequest;
import com.example.sweenu.sw_info.model.Vaisseau;

public class EspeceSync {

    public EspeceSync(RequestQueue queue) {
        this.queue= queue;
    }


    public interface EspeceInterfaces{
        void onSucess(ArrayList<Espece> species);
        void onError(String message);
    }


    private static final String TAG = "APP";

    private RequestQueue queue;

    private static final String URLEspece = ("https://swapi.co/api/species/");

    public void getEspeceList(final EspeceInterfaces callback) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,URLEspece, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse" + response);

                ArrayList<Espece> species = new ArrayList<>();
                if (response.length() > 0) {
                    for (int i = 0; i < 9; i++) {
                        try {
                            JSONObject EspeceObject = response.getJSONArray("results").getJSONObject(i);

                            String name = EspeceObject.getString("name");
                            String classification = EspeceObject.getString("classification");
                            String designation= EspeceObject.getString("designation");
                            int average_height = EspeceObject.getInt("average_height");
                            String skin_colors = EspeceObject.getString("skin_colors");
                            String hair_colors = EspeceObject.getString("hair_colors");
                            String eye_colors = EspeceObject.getString("eye_colors");
                            String language = EspeceObject.getString("language");

                            Espece espece = new Espece(name, classification, designation, average_height, skin_colors, hair_colors, eye_colors,language);

                            species.add(espece);
                        } catch (JSONException e) {
                            Log.d(TAG, "onSKURT" + e.getMessage());
                            callback.onError("Une erreur s'est produite");
                            e.printStackTrace();
                        }
                    }
                    callback.onSucess(species);
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