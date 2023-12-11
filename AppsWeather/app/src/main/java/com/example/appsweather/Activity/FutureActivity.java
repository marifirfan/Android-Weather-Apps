package com.example.appsweather.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appsweather.Adapters.FutureAdapter;
import com.example.appsweather.Domains.FutureDomain;
import com.example.appsweather.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);


        InitRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backBtn=findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v -> startActivity(new Intent(FutureActivity.this,MainActivity.class)));
    }

    private void InitRecyclerView() {
        ArrayList<FutureDomain> items = new ArrayList<>();
        items.add(new FutureDomain("Sat", "storm", "Storm", 24, 12));
        items.add(new FutureDomain("Sun", "cloudy", "Cloudy", 25, 16));
        items.add(new FutureDomain("Mon", "windy", "Windy", 29, 15));
        items.add(new FutureDomain("Tue", "cloudy_sunny", "Cloudy sunny", 23, 15));
        items.add(new FutureDomain("Wen", "sunny", "Sunny", 28, 11));
        items.add(new FutureDomain("Thu", "rainy", "Rainy", 23, 12));

        recyclerView = findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterTomorrow = new FutureAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);
    }
}
