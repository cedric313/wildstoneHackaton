package com.example.wildstone;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.wildstone.models.Heroes;

import java.util.ArrayList;


public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private ArrayList<Heroes> mHeroes;
    private ArrayList<Heroes> heroesArrayList = new ArrayList<>();
    Context context;
    public CardAdapter(ArrayList<Heroes> heroes) {
        mHeroes = heroes;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {

        final Heroes heroes = mHeroes.get(position);
        holder.tvName.setText(heroes.getName());
        holder.tvDurability.setText(String.valueOf(heroes.getDurability()));
        holder.tvPower.setText(String.valueOf(heroes.getPower()));
        Glide.with(holder.itemView)
                .load(heroes.getImages()).apply(RequestOptions.circleCropTransform())
                .into(holder.ivImages);
        holder.btChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heroesArrayList.add(heroes);
                Toast.makeText(v.getContext(), "Héro ajouté !", Toast.LENGTH_SHORT).show();
                if(heroesArrayList.size() >= 5){
                    UserSingleton userSingleton = UserSingleton.getUserInstance();
                    userSingleton.setHeroes(heroesArrayList);

                    Toast.makeText(v.getContext(), "Votre deck est prét!", Toast.LENGTH_LONG).show();
                    v.getContext().startActivity(new Intent(v.getContext(), BattleField.class));


                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return mHeroes.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView tvName,tvChoose, tvDurability, tvPower;
        final ImageView ivImages;
        final Button btChoose;

        public ViewHolder(View v) {
            super(v);
            this.tvName = v.findViewById(R.id.tvName);
            this.tvChoose = v.findViewById(R.id.tvChoisir5cartes);
            this.tvDurability = v.findViewById(R.id.tvDurability);
            this.tvPower = v.findViewById(R.id.tvPower);
            this.ivImages = v.findViewById(R.id.ivImages);
            this.btChoose = v.findViewById(R.id.btChoose);

        }
    }

}
