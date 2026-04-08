package com.alexiskang.tarifazero.ui.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.ui.activity.LoginActivity;
import com.alexiskang.tarifazero.utils.SessionManager;

public class SettingsFragment extends Fragment {

    private Button btnLogout;

    public SettingsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        initializeComponents(view);

        listeners();

        return view;
    }

    private void initializeComponents(View view){
        btnLogout = (Button) view.findViewById(R.id.btn_logout);
    }

    private void listeners(){
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(getContext())
                        .setTitle("Sair")
                        .setMessage("Deseja realmente sair?")
                        .setPositiveButton("Sim", (dialog, which) -> {
                            SessionManager session = new SessionManager(getContext());
                            session.logout();

                            Intent intent = new Intent(getActivity(), LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                            startActivity(intent);
                            // redireciona
                        })
                        .setNegativeButton("Cancelar", null)
                        .show();

            }
        });
    }
}