package com.tutorial.deliserdangapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.tutorial.deliserdangapps.adapter.ListDeliSerdangAdapter;
import com.tutorial.deliserdangapps.model.ModelDeliSerdang;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ModelDeliSerdang> modelDeliSerdangList;
    ListDeliSerdangAdapter deliSerdangAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        setTitle("Kabupaten Apps");

        modelDeliSerdangList = new ArrayList<>();
        deliSerdangAdapter = new ListDeliSerdangAdapter(MainActivity.this, modelDeliSerdangList);
        recyclerView = (RecyclerView) findViewById(R.id.viewDeli);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(deliSerdangAdapter);

        modelDeliSerdangList.add(new ModelDeliSerdang("DELI SERDANG", "SUMATERA UTARA", getApplicationContext().getString(R.string.detail1), R.drawable.img));
        modelDeliSerdangList.add(new ModelDeliSerdang("SERDANG BEDAGAI", "SUMATERA UTARA", getApplicationContext().getString(R.string.detail2), R.drawable.img_1));
        modelDeliSerdangList.add(new ModelDeliSerdang("ASAHAN", "SUMATERA UTARA", getApplicationContext().getString(R.string.detail3), R.drawable.img_2));
        modelDeliSerdangList.add(new ModelDeliSerdang("TEBING TINGGI", "SUMATERA UTARA", getApplicationContext().getString(R.string.detail4), R.drawable.img_3));
        modelDeliSerdangList.add(new ModelDeliSerdang("BATU BARA", "SUMATERA UTARA", getApplicationContext().getString(R.string.detail5), R.drawable.img_4));
        modelDeliSerdangList.add(new ModelDeliSerdang("PEMATANG SIANTAR", "SUMATERA UTARA", getApplicationContext().getString(R.string.detail6), R.drawable.img_5));
        modelDeliSerdangList.add(new ModelDeliSerdang("BINJAI", "SUMATERA UTARA", getApplicationContext().getString(R.string.detail7), R.drawable.img_6));
        modelDeliSerdangList.add(new ModelDeliSerdang("KARO", "SUMATERA UTARA", getApplicationContext().getString(R.string.detail8), R.drawable.img_7));
        modelDeliSerdangList.add(new ModelDeliSerdang("LABUHANBATU", "SUMATERA UTARA", getApplicationContext().getString(R.string.detail9), R.drawable.img_8));
        modelDeliSerdangList.add(new ModelDeliSerdang("LANGKAT", "SUMATERA UTARA", getApplicationContext().getString(R.string.detail10), R.drawable.img_9));

        deliSerdangAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();
        if (itemid == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        MenuItem profile = menu.findItem(R.id.profile);
        profile.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}