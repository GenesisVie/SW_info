package com.example.sweenu.sw_info.request;

import android.app.DownloadManager;
import android.nfc.Tag;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.sweenu.sw_info.model.Vehicule;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import com.android.volley.Request;

import com.android.volley.toolbox.JsonArrayRequest;
import com.example.sweenu.sw_info.model.Vaisseau;
import com.example.sweenu.sw_info.model.Vehicule;

public class VehiculeSync {

    public VehiculeSync(RequestQueue queue) {
        this.queue= queue;
    }


    public interface VehiculeInterfaces{
        void onSucess(ArrayList<Vehicule> vehicules);
        void onError(String message);
    }


    private static final String TAG = "APP";

    private RequestQueue queue;

    private static final String URLVehicule = ("https://swapi.co/api/vehicles/");

    public void getPersoList(final VehiculeInterfaces callback) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,URLVehicule, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse" + response);

                ArrayList<Vehicule> vehicules = new ArrayList<>();
                if (response.length() > 0) {
                    for (int i = 0; i < 9; i++) {
                        try {
                            JSONObject vehiculeObject = response.getJSONArray("results").getJSONObject(i);
                            String name = vehiculeObject.getString("name");
                            String model = vehiculeObject.getString("model");
                            int price = vehiculeObject.getInt("cost_in_price");
                            long length = vehiculeObject.getLong("length");
                            int speed = vehiculeObject.getInt("max_atmosphering_speed");
                            int crew = vehiculeObject.getInt("crew");
                            int capacity = vehiculeObject.getInt("cargo_capacity");
                            String Vclass = vehiculeObject.getString("vehicle_class");
                            Vehicule vehicule = new Vehicule(name, model, price, length, speed, crew, capacity,Vclass);

                            vehicules.add(vehicule);
                        } catch (JSONException e) {
                            Log.d(TAG, "onSKURT" + e.getMessage());
                            callback.onError("Une erreur s'est produite");
                            e.printStackTrace();
                        }
                    }
                    callback.onSucess(vehicules);
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