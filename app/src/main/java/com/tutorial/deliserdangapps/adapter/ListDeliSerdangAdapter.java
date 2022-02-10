package com.tutorial.deliserdangapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tutorial.deliserdangapps.DetailActivity;
import com.tutorial.deliserdangapps.MainActivity;
import com.tutorial.deliserdangapps.R;
import com.tutorial.deliserdangapps.model.ModelDeliSerdang;

import java.util.List;

public class ListDeliSerdangAdapter extends RecyclerView.Adapter<ListDeliSerdangAdapter.ListViewHolder> {
    Context context;
    List<ModelDeliSerdang> modelDeliSerdangList;

    public ListDeliSerdangAdapter(Context context, List<ModelDeliSerdang> modelDeliSerdangList) {
        this.context = context;
        this.modelDeliSerdangList = modelDeliSerdangList;
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView photo;
        TextView kabupaten, provinsi;
        Button like;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            photo = (ImageView) itemView.findViewById(R.id.photo);
            kabupaten = (TextView) itemView.findViewById(R.id.kabupaten);
            provinsi = (TextView) itemView.findViewById(R.id.provinsi);
            like = (Button) itemView.findViewById(R.id.like);


        }
    }


    @NonNull
    @Override
    public ListDeliSerdangAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_deli, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListDeliSerdangAdapter.ListViewHolder holder, int position) {

        holder.kabupaten.setText(modelDeliSerdangList.get(position).getKabupaten());
        holder.provinsi.setText(modelDeliSerdangList.get(position).getProvinsi());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), DetailActivity.class);
                intent.putExtra("kabupaten",modelDeliSerdangList.get(position).getKabupaten());
                intent.putExtra("provinsi",modelDeliSerdangList.get(position).getProvinsi());
                intent.putExtra("detaillengkap",modelDeliSerdangList.get(position).getDetaillengkap());
                intent.putExtra("photo",modelDeliSerdangList.get(position).getPhoto());
                ((MainActivity) context).startActivity(intent);
            }
        });
        Glide.with(context.getApplicationContext()).load(modelDeliSerdangList.get(position).getPhoto()).into((holder.photo));
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getApplicationContext(), "Menyukai Halaman ini", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelDeliSerdangList.size();
    }


}
