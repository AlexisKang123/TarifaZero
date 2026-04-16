package com.alexiskang.tarifazero.ui.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.database.SupabaseClient;
import com.alexiskang.tarifazero.database.SupabaseConfig;
import com.alexiskang.tarifazero.database.SupabaseService;
import com.alexiskang.tarifazero.model.BusStop;
import com.alexiskang.tarifazero.ui.adapter.busstop.AdapterBusStop;
import com.alexiskang.tarifazero.utils.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusStopActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterBusStop adapter;
    private ArrayList<BusStop> busStops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bus_stop);

        initializeComponents();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getBusStops();

    }

    private void initializeComponents(){
        recyclerView = findViewById(R.id.recycler_bus_stop);
    }

    private void getBusStops(){

        SessionManager session = new SessionManager(this);

        SupabaseService service = SupabaseClient
                .getClient()
                .create(SupabaseService.class);

        service.getBusStops(
                SupabaseConfig.API_KEY,
                "Bearer " + session.getToken()
        ).enqueue(new Callback<List<BusStop>>() {

            @Override
            public void onResponse(Call<List<BusStop>> call, Response<List<BusStop>> response) {

                if(response.isSuccessful() && response.body() != null){

                    busStops = new ArrayList<>(response.body());

                    adapter = new AdapterBusStop(BusStopActivity.this, busStops);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<BusStop>> call, Throwable t) {

            }
        });
    }

}