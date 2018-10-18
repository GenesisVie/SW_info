package com.example.sweenu.sw_info;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.sweenu.sw_info.adapter.PersoAdapter;
import com.example.sweenu.sw_info.model.Espece;
import com.example.sweenu.sw_info.model.Film;
import com.example.sweenu.sw_info.model.Perso;
import com.example.sweenu.sw_info.model.Planet;
import com.example.sweenu.sw_info.model.Vaisseau;
import com.example.sweenu.sw_info.request.EspeceSync;
import com.example.sweenu.sw_info.request.FilmSync;
import com.example.sweenu.sw_info.request.PersoSync;
import com.example.sweenu.sw_info.request.PlanetSync;
import com.example.sweenu.sw_info.request.VaisseauSync;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "APP";
    private RecyclerView recycler;
    private PersoAdapter pAdapter;
    private ArrayList<Perso> persoArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPersoList();

        persoArrayList = new ArrayList<>();

        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        pAdapter = new PersoAdapter(getApplicationContext(), persoArrayList);
    }
    public void getPersoList(){
        RequestQueue queue = VolleySingleton.getInstance(this).getRequestQueue();
        PersoSync request = new PersoSync(queue);

        request.getPersoList(new PersoSync.PersonnageInterfaces() {
            @Override
            public void onSucess(ArrayList<Perso> persos) {
                persoArrayList.addAll(persos);
                pAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void getEspeceList(){
        RequestQueue queue = VolleySingleton.getInstance(this).getRequestQueue();
        EspeceSync request = new EspeceSync(queue);

        request.getEspeceList(new EspeceSync.EspeceInterfaces() {
            @Override
            public void onSucess(ArrayList<Espece> especes) {
                Log.d(TAG, "onSucessss: "+ especes);
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void getFilmList(){
        RequestQueue queue = VolleySingleton.getInstance(this).getRequestQueue();
        FilmSync request = new FilmSync(queue);

        request.getFilmList(new FilmSync.FilmInterfaces() {
            @Override
            public void onSucess(ArrayList<Film> films) {
                Log.d(TAG, "onSucessss: "+ films);
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void getPlanetlist(){
        RequestQueue queue = VolleySingleton.getInstance(this).getRequestQueue();
        PlanetSync request = new PlanetSync(queue);

        request.getPlanetlist(new PlanetSync.PlanetInterfaces() {
            @Override
            public void onSucess(ArrayList<Planet> planets) {
                Log.d(TAG, "onSucessss: "+ planets);
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void getVaisseauList(){
        RequestQueue queue = VolleySingleton.getInstance(this).getRequestQueue();
        VaisseauSync request = new VaisseauSync(queue);

        request.getVaisseauList(new VaisseauSync.SpaceshipInterface() {
            @Override
            public void onSucess(ArrayList<Vaisseau> vaisseaus) {
                Log.d(TAG, "onSucessss: "+ vaisseaus);
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
