package com.alexiskang.tarifazero;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnvNavegacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

        bnvNavegacao.setSelectedItemId(R.id.nav_home);

        loadFragment(new HomeFragment());

        bnvNavegacao.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_home) {
                loadFragment(new HomeFragment());
                return true;
            }
            else if (item.getItemId() == R.id.nav_notification) {
                loadFragment(new NotificationFragment());
                return true;
            }
            else if (item.getItemId() == R.id.nav_settings) {
                loadFragment(new SettingsFragment());
                return true;
            }

            return false;
        });
    }

    private void inicializarComponentes(){
        bnvNavegacao = findViewById(R.id.bnv_navigation);
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}