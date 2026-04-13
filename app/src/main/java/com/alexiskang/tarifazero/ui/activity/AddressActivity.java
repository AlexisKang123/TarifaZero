package com.alexiskang.tarifazero.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.database.SupabaseClient;
import com.alexiskang.tarifazero.database.SupabaseConfig;
import com.alexiskang.tarifazero.database.SupabaseService;
import com.alexiskang.tarifazero.model.UserAddress;
import com.alexiskang.tarifazero.ui.adapter.adress.AdapterAdress;
import com.alexiskang.tarifazero.utils.SessionManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressActivity extends AppCompatActivity {

    private ArrayList<UserAddress> listAdress;
    private RecyclerView recyclerView;
    private AdapterAdress adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adress);

        initializeComponents();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getAddresses();

    }

    private void initializeComponents(){
        recyclerView = findViewById(R.id.recycler_adress);
    }
    private void getAddresses(){

        SessionManager session = new SessionManager(this);

        SupabaseService service = SupabaseClient
                .getClient()
                .create(SupabaseService.class);

        service.getUserAddresses(
                SupabaseConfig.API_KEY,
                "Bearer " + session.getToken()
        ).enqueue(new Callback<List<UserAddress>>() {

            @Override
            public void onResponse(Call<List<UserAddress>> call, Response<List<UserAddress>> response) {

                if(response.isSuccessful() && response.body() != null){

                    listAdress = new ArrayList<>(response.body());

                    // 🔥 CRIA ADAPTER AQUI (só depois da resposta)
                    adapter = new AdapterAdress(AddressActivity.this, listAdress, userAddress -> {

                        Map<String, String> body = new HashMap<>();
                        body.put("p_address_id", userAddress.getAddress().getId());

                        service.setSelectedAddress(
                                SupabaseConfig.API_KEY,
                                "Bearer " + session.getToken(),
                                body
                        ).enqueue(new Callback<Void>() {

                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                Log.d("ADDRESS", "Selecionado com sucesso");
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.e("ADDRESS", t.getMessage());
                            }
                        });
                    });

                    recyclerView.setAdapter(adapter); // 🔥 só aqui
                }
            }

            @Override
            public void onFailure(Call<List<UserAddress>> call, Throwable t) {
                Log.e("API", t.getMessage());
            }
        });
    }



}