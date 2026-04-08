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
import com.alexiskang.tarifazero.ui.adapter.adress.AdapterAdress;

import java.util.ArrayList;

public class AdressActivity extends AppCompatActivity {

    private ArrayList<Adress> listAdress;
    private RecyclerView recyclerView;
    private AdapterAdress adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adress);

        listAdress = getAdress();
        initializeComponents();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdapterAdress(this, listAdress);

        recyclerView.setAdapter(adapter);

    }

    private void initializeComponents(){
        recyclerView = findViewById(R.id.recycler_adress);
    }

    private ArrayList<Adress> getAdress(){

        ArrayList<Adress> listAdress =  new ArrayList<>();

        listAdress.add(new Adress(
                "01001-000",
                "Sé",
                "100",
                "Praça da Sé",
                "1",
                false
        ));

        listAdress.add(new Adress(
                "20040-020",
                "Centro",
                "50",
                "Rua da Assembleia",
                "2",
                true
        ));

        listAdress.add(new Adress(
                "30130-010",
                "Centro",
                "200",
                "Avenida Afonso Pena",
                "3",
                false
        ));

        listAdress.add(new Adress(
                "80010-000",
                "Centro",
                "300",
                "Rua XV de Novembro",
                "4",
                false
        ));

        listAdress.add(new Adress(
                "70040-010",
                "Asa Norte",
                "400",
                "Esplanada dos Ministérios",
                "5",
                false
        ));

        listAdress.add(new Adress(
                "40020-000",
                "Centro",
                "500",
                "Praça Castro Alves",
                "6",
                false
        ));

        listAdress.add(new Adress(
                "69005-070",
                "Centro",
                "600",
                "Avenida Eduardo Ribeiro",
                "7",
                false
        ));

        listAdress.add(new Adress(
                "69005-070",
                "Centro",
                "600",
                "Avenida Eduardo Ribeiro",
                "8",
                false
        ));
        return listAdress;
    }
}