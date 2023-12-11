package com.example.appsweather.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsweather.Adapters.HourlyAdapters;
import com.example.appsweather.Domains.Hourly;
import com.example.appsweather.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        setVariable();
        displayCurrentDateTime();
    }

    private void setVariable() {
        TextView next7dayBtn=findViewById(R.id.nextBtn);
        next7dayBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,FutureActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<Hourly> items=new ArrayList<>();

        items.add(new Hourly("9 pm",28,"cloudy"));
        items.add(new Hourly("10 pm",29,"sunny"));
        items.add(new Hourly("11 pm",30,"wind"));
        items.add(new Hourly("12 pm",31,"rainy"));
        items.add(new Hourly("1 pm",32,"storm"));


        RecyclerView recyclerView = findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterHourly=new HourlyAdapters(items);
        recyclerView.setAdapter(adapterHourly);
    }
    private void displayCurrentDateTime() {

        TextView dateTimeTextView = findViewById(R.id.dateTimeTextView);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy HH:mm a", Locale.getDefault());
        String currentDateTime = dateFormat.format(calendar.getTime());

        dateTimeTextView.setText(currentDateTime);
    }

}