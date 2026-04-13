package com.alexiskang.tarifazero.ui.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.model.BusStop;
import com.alexiskang.tarifazero.ui.adapter.busstop.AdapterBusStop;

import java.util.ArrayList;

public class BusStopActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterBusStop adapter;
    private ArrayList<BusStop> busStops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bus_stop);

        //busStops = getBusStops();

        initializeComponents();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdapterBusStop(this, busStops);

        recyclerView.setAdapter(adapter);

    }

    private void initializeComponents(){
        recyclerView = findViewById(R.id.recycler_bus_stop);
    }

}