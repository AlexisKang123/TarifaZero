package com.alexiskang.tarifazero;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}

//funçao de abrir o card
//Funçao de editar foto
//Funçao de alterar endereco
//Funcao check-in
//Funcao lembrete
//Funçao abrir mapa