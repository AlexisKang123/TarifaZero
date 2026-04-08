package com.alexiskang.tarifazero.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.ui.activity.AdressActivity;
import com.alexiskang.tarifazero.ui.activity.BusStopActivity;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class HomeFragment extends Fragment {

    public HomeFragment() {}

    private CardView cardSupport, cardHistory, cardAllBusStop, cardAdress;
    private TextView txtMorInfo, txtDriver, txtVehicle, txtPlate;
    private LinearLayout layoutMoreInfo;
    private boolean card_more_info = false;
    private Button btnOpenMap, btnCheckIn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initializeComponents(view);

        listeners();

        return view;


    }

    private void initializeComponents(View view){
        cardAdress = (CardView) view.findViewById(R.id.card_adress_home);
        cardAllBusStop = (CardView) view.findViewById(R.id.card_all_bus_stop_home);
        cardHistory = (CardView) view.findViewById(R.id.card_history_home);
        cardSupport = (CardView) view.findViewById(R.id.card_support_home);
        txtMorInfo = (TextView)  view.findViewById(R.id.txt_more_info);
        layoutMoreInfo = (LinearLayout) view.findViewById(R.id.layout_more_info);
        txtDriver = (TextView) view.findViewById(R.id.txt_driver);
        txtVehicle = (TextView) view.findViewById(R.id.txt_vehicle);
        txtPlate = (TextView) view.findViewById(R.id.txt_plate);
        btnOpenMap = (Button) view.findViewById(R.id.btn_maps_card_bus);
        btnCheckIn = (Button) view.findViewById(R.id.btn_checkin);
    }

    private void listeners(){
        cardAdress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AdressActivity.class);
                startActivity(intent);
            }
        });

        cardAllBusStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BusStopActivity.class);
                startActivity(intent);
            }
        });

        cardHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, AdressActivity.class);
                //startActivity(intent);
            }
        });

        cardSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, .class);
                //startActivity(intent);
            }
        });

        txtMorInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!card_more_info){
                    layoutMoreInfo.setVisibility(v.VISIBLE);
                    txtDriver.setText("Alexis Daniel Kang");
                    txtVehicle.setText("Fusca 2010");
                    txtPlate.setText("1234-123");
                    txtMorInfo.setText("- menos informações");
                    card_more_info = true;
                }else{
                    layoutMoreInfo.setVisibility(v.GONE);
                    txtMorInfo.setText("- mais informações");
                    card_more_info = false;
                }
            }
        });

        btnOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adress = "Av. Barão do Rio Branco, 90 - Centro. Palmas - PR";
                openMap(adress);
            }
        });
        btnCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });
    }

    private void openMap(String adress){

        Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(adress));

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");

        startActivity(intent);
    }

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher =
            registerForActivityResult(new ScanContract(), result -> {

                if(result.getContents() != null){

                    String content = result.getContents();

                    Toast.makeText(getContext(), content, Toast.LENGTH_SHORT).show();
                }
            });

    private void openCamera(){

        ScanOptions options = new ScanOptions();
        options.setPrompt("Escaneie o QR Code");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);

        barcodeLauncher.launch(options);
    }
}



//funçao de abrir o card
//Funçao de editar foto
//Funçao de alterar endereco
//Funcao check-in
//Funcao lembrete
//Funçao abrir mapa