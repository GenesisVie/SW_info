package com.example.sweenu.sw_info.request;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.sweenu.sw_info.model.Perso;
import com.example.sweenu.sw_info.model.Vaisseau;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VaisseauSync {

    public VaisseauSync(RequestQueue queue) {
        this.queue= queue;
    }

    public interface SpaceshipInterface{
        void onSucess(ArrayList<Vaisseau> vaisseaux);
        void onError(String message);
    }
    private static final String TAG = "APP";

    private RequestQueue queue;

    private static final String URLvaisseau = ("https://swapi.co/api/starships/");

    public void getVaisseauList(final SpaceshipInterface callback) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,URLvaisseau, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse" + response);

                ArrayList<Vaisseau> vaisseaux = new ArrayList<>();
                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject vaisseauObject = response.getJSONArray("results").getJSONObject(i);
                            String name = vaisseauObject.getString("name");
                            String model = vaisseauObject.getString("model");
                            String manufacturer = vaisseauObject.getString("manufacturer");
                            int price = vaisseauObject.getInt("cost_in_credits");
                            int length = vaisseauObject.getInt("length");
                            int nbplaces = vaisseauObject.getInt("passengers");
                            int nbplacesCargo =vaisseauObject.getInt("cargo_capacity");
                            Vaisseau vaisseau = new Vaisseau(name, model, manufacturer, price, length,nbplaces, nbplacesCargo);
                            vaisseaux.add(vaisseau);
                        } catch (JSONException e) {
                            Log.d(TAG, "onSKURT" + e.getMessage());
                            callback.onError("Une erreur s'est produite");
                            e.printStackTrace();
                        }
                    }
                    callback.onSucess(vaisseaux);
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