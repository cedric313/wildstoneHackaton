package com.example.wildstone;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private ArrayList<Heroes> mHeroes;

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
        Heroes heroes = mHeroes.get(position);
        holder.tvName.setText(heroes.getName());
        holder.tvDurability.setText(heroes.getDurability());
        holder.tvPower.setText(heroes.getPower());
        holder.tvRace.setText(heroes.getRace());
        //holder.ivImages.setImageDrawable(heroes.getImages());
    }

    @Override
    public int getItemCount() {
        return mHeroes.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView tvName, tvDurability, tvPower, tvRace;
        final ImageView ivImages;
        public ViewHolder(View v) {
            super(v);
            this.tvName = v.findViewById(R.id.tvName);
            this.tvDurability = v.findViewById(R.id.tvDurability);
            this.tvPower = v.findViewById(R.id.tvPower);
            this.tvRace = v.findViewById(R.id.tvRace);
            this.ivImages = v.findViewById(R.id.ivImages);
        }
    }
}
