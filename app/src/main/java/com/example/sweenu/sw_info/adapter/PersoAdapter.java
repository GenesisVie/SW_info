package com.example.sweenu.sw_info.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sweenu.sw_info.R;
import com.example.sweenu.sw_info.model.Perso;

import java.util.ArrayList;

public class PersoAdapter extends RecyclerView.Adapter<PersoAdapter.PersoViewHolder>{
    private Context context;
    private ArrayList<Perso> persos;
    public PersoAdapter(Context context, ArrayList<Perso>persos){

        this.context = context;
        this.persos = persos;

    }


    public static class PersoViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name,tv_height,tv_hair,tv_skin,tv_birth,tv_gender;

        public PersoViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_height = itemView.findViewById(R.id.tv_height);
            tv_skin = itemView.findViewById(R.id.tv_skin);
            tv_birth = itemView.findViewById(R.id.tv_birth);
            tv_gender = itemView.findViewById(R.id.tv_gender);
        }
    }

    @Override
    public PersoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.perso_row, parent, false);
        return new PersoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersoViewHolder holder, int position) {
        Perso perso = persos.get(position);
        if (persos != null) {

            holder.tv_name.setText(perso.getName());
            holder.tv_height.setText(perso.getHeight());
            holder.tv_skin.setText(perso.getSkincolor());
            holder.tv_birth.setText(perso.getBirthyear());
            holder.tv_gender.setText(perso.getGender());
        }
    }

    @Override
    public int getItemCount() {
        return 9;
    }

}
