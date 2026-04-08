package com.alexiskang.tarifazero.ui.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.model.Adress;
import com.alexiskang.tarifazero.model.BusStop;
import com.alexiskang.tarifazero.ui.adapter.adress.AdapterAdress;
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

        busStops = getBusStops();

        initializeComponents();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdapterBusStop(this, busStops);

        recyclerView.setAdapter(adapter);

    }

    private void initializeComponents(){
        recyclerView = findViewById(R.id.recycler_bus_stop);
    }

    private ArrayList<BusStop> getBusStops(){
        ArrayList<BusStop> listBusStops = new ArrayList<>();

        listBusStops.add(new BusStop(
                "1",
                "Ponto Centro",
                new Adress("80010-000", "Centro", "100", "Rua XV de Novembro", "1", false),
                null
        ));

        listBusStops.add(new BusStop(
                "2",
                "Ponto Terminal",
                new Adress("70040-010", "Asa Norte", "200", "Esplanada dos Ministérios", "2", false),
                null
        ));

        listBusStops.add(new BusStop(
                "3",
                "Ponto Universidade",
                new Adress("30130-010", "Centro", "300", "Avenida Afonso Pena", "3", false),
                null
        ));

        return listBusStops;
    }
}