package com.tutorial.deliserdangapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView photo;
    TextView kabupaten, detaillengkap;
    Button like;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        like = (Button) findViewById(R.id.like);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "Anda Menyukai Halaman ini", Toast.LENGTH_SHORT).show();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Detail");

        Intent intent = getIntent();

        photo = (ImageView) findViewById(R.id.photo);
        kabupaten = (TextView) findViewById(R.id.kabupaten);
        detaillengkap = (TextView) findViewById(R.id.detiallengkap);



        kabupaten.setText(intent.getStringExtra("kabupaten"));
        detaillengkap.setText(intent.getStringExtra("detaillengkap"));

        Glide.with(DetailActivity.this).load(intent.getIntExtra("photo", 0)).into((photo));
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();
        if (itemid == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}


