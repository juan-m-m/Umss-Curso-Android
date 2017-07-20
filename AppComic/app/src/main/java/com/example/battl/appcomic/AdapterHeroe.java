package com.example.battl.appcomic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.battl.appcomic.models.Heroe;

import java.util.List;

/**
 * Created by Battl on 19/07/2017.
 */

public class AdapterHeroe extends RecyclerView.Adapter<ItemHeroes> {
    List<Heroe> heroeList;

    public AdapterHeroe(List<Heroe> heroeList) {
        this.heroeList = heroeList;
    }

    @Override
    public ItemHeroes onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_heroes,parent,false);
        return new ItemHeroes(view);
    }

    @Override
    public void onBindViewHolder(ItemHeroes holder, int position) {
        final Heroe heroe = heroeList.get(position);
        final Context context = holder.txtNombre.getContext();
        holder.txtNombre.setText(heroe.getNombre());
        holder.txtPoder.setText(heroe.getPoder());
        holder.imgHeroe.setBackground(heroe.getImage());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(context, heroe.getNombre(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroeList.size();
    }
}
