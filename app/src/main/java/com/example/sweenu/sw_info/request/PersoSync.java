package com.example.sweenu.sw_info.request;

import android.app.DownloadManager;
import android.nfc.Tag;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.sweenu.sw_info.model.Perso;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import com.android.volley.Request;

import com.android.volley.toolbox.JsonArrayRequest;
import com.example.sweenu.sw_info.model.Vaisseau;

public class PersoSync {

    public PersoSync(RequestQueue queue) {
        this.queue= queue;
    }


    public interface PersonnageInterfaces{
        void onSucess(ArrayList<Perso> persos);
        void onError(String message);
    }


    private static final String TAG = "APP";

    private RequestQueue queue;

    private static final String URLperso = ("https://swapi.co/api/people/");

    public void getPersoList(final PersonnageInterfaces callback) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,URLperso, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse" + response);

                ArrayList<Perso> persos = new ArrayList<>();
                if (response.length() > 0) {
                    for (int i = 0; i < 9; i++) {
                        try {
                            JSONObject persoObject = response.getJSONArray("results").getJSONObject(i);
                            String name = persoObject.getString("name");
                            int height = persoObject.getInt("height");
                            int mass = persoObject.getInt("mass");
                            String haircolor = persoObject.getString("hair_color");
                            String skincolor = persoObject.getString("skin_color");
                            String birthyear = persoObject.getString("birth_year");
                            String gender = persoObject.getString("gender");

                            Perso perso = new Perso(name, height, mass, haircolor, skincolor, birthyear, gender);

                            persos.add(perso);
                        } catch (JSONException e) {
                            Log.d(TAG, "onSKURT" + e.getMessage());
                            callback.onError("Une erreur s'est produite");
                            e.printStackTrace();
                        }
                    }
                    callback.onSucess(persos);
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