package com.alexiskang.tarifazero.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.alexiskang.tarifazero.ui.fragment.HomeFragment;
import com.alexiskang.tarifazero.ui.fragment.NotificationFragment;
import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.ui.fragment.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnvNavegation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initializeComponents();

        bnvNavegation.setSelectedItemId(R.id.nav_home);

        loadFragment(new HomeFragment());

        setListeners();
    }

    private void initializeComponents(){
        bnvNavegation = findViewById(R.id.bnv_navigation);
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private void setListeners(){
        bnvNavegation.setOnItemSelectedListener(item -> {

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
}