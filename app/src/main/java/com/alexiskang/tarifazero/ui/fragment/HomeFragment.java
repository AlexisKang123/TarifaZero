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
import com.alexiskang.tarifazero.database.SupabaseClient;
import com.alexiskang.tarifazero.database.SupabaseConfig;
import com.alexiskang.tarifazero.database.SupabaseService;
import com.alexiskang.tarifazero.model.Address;
import com.alexiskang.tarifazero.model.BusStop;
import com.alexiskang.tarifazero.model.User;
import com.alexiskang.tarifazero.model.UserAddress;
import com.alexiskang.tarifazero.ui.activity.AddressActivity;
import com.alexiskang.tarifazero.ui.activity.BusStopActivity;
import com.alexiskang.tarifazero.utils.SessionManager;
import com.bumptech.glide.Glide;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import de.hdodenhof.circleimageview.CircleImageView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    public HomeFragment() {}

    private CardView cardSupport, cardHistory, cardAllBusStop, cardAdress;
    private TextView txtMorInfo, txtDriver, txtVehicle, txtPlate, txtAddress, txtFullName, txtAdressCardBus;
    private CircleImageView imgProfile;
    private LinearLayout layoutMoreInfo;
    private boolean card_more_info = false;
    private Button btnOpenMap, btnCheckIn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initializeComponents(view);

        loadAddress();

        loadUser();

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
        txtAddress = (TextView) view.findViewById(R.id.txt_adress_main);
        txtFullName = (TextView) view.findViewById(R.id.txt_name_main);
        imgProfile = (CircleImageView) view.findViewById(R.id.img_profile_main);
        txtAdressCardBus = (TextView) view.findViewById(R.id.txt_adress_card_bus);
    }

    private void listeners(){
        cardAdress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddressActivity.class);
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

    private void loadAddress(){
        SessionManager session = new SessionManager(getContext());

        if(session.getAddress().isEmpty()){
            txtAddress.setText("Carregando...");
        }


        txtAddress.setText(session.getAddress());

        SupabaseService service = SupabaseClient
                .getClient()
                .create(SupabaseService.class);

        service.getUserAddresses(
                SupabaseConfig.API_KEY,
                "Bearer " + session.getToken()
        ).enqueue(new Callback<List<UserAddress>>() {

            @Override
            public void onResponse(Call<List<UserAddress>> call, Response<List<UserAddress>> response) {
                if(response.isSuccessful() && response.body() != null && !response.body().isEmpty()){

                    Address address = response.body().get(0).getAddress();

                    String formatAddress = address.getStreet() + ", " + address.getNumber() + " - " + address.getDistrict() + ". " + address.getZip_code() ;

                    session.saveLat(address.getLatitude());
                    session.saveLon(address.getLongitude());

                    txtAddress.setText(formatAddress);
                    session.saveAddress(formatAddress);

                    buscarBusStopMaisProximo();

                }
            }

            @Override
            public void onFailure(Call<List<UserAddress>> call, Throwable t) {

            }
        });
    }
    private void loadUser(){

        SessionManager session = new SessionManager(getContext());

        if(session.getUserName().isEmpty()){
            txtFullName.setText("Carregando...");
        }

        txtFullName.setText(session.getUserName());

        SupabaseService service = SupabaseClient
                .getClient()
                .create(SupabaseService.class);

        service.getUser(
                SupabaseConfig.API_KEY,
                "Bearer " + session.getToken()
        ).enqueue(new Callback<List<User>>() {

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if(response.isSuccessful() && response.body() != null && !response.body().isEmpty()){

                    User user = response.body().get(0);

                    txtFullName.setText(user.getName());
                    session.saveUserName(user.getName());

                    if (getContext() != null) {
                        Glide.with(getContext())
                                .load(user.getImage())
                                .placeholder(R.drawable.baseline_person_24)
                                .error(R.drawable.baseline_person_24)
                                .into(imgProfile);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {

        final int R = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }

    private void buscarBusStopMaisProximo() {

        SessionManager session = new SessionManager(requireContext());

        double userLat = session.getLat();
        double userLon = session.getLon();

        if (userLat == 0.0 || userLon == 0.0) return;

        SupabaseService service = SupabaseClient
                .getClient()
                .create(SupabaseService.class);

        service.getBusStops(
                SupabaseConfig.API_KEY,
                "Bearer " + session.getToken()
        ).enqueue(new Callback<List<BusStop>>() {

            @Override
            public void onResponse(Call<List<BusStop>> call, Response<List<BusStop>> response) {

                if (!isAdded()) return;

                if (response.isSuccessful() && response.body() != null) {

                    BusStop maisProximo = null;
                    double menorDistancia = Double.MAX_VALUE;

                    for (BusStop bs : response.body()) {

                        if (bs.getAddress().getLatitude() != 0 && bs.getAddress().getLongitude() != 0) {

                            double distancia = calcularDistancia(
                                    userLat,
                                    userLon,
                                    bs.getAddress().getLatitude(),
                                    bs.getAddress().getLongitude()
                            );

                            if (distancia < menorDistancia) {
                                menorDistancia = distancia;
                                maisProximo = bs;
                            }
                        }
                    }

                    if (maisProximo != null) {

                        String dist = String.format("%.2f km", menorDistancia);

                        txtAdressCardBus.setText(maisProximo.getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<BusStop>> call, Throwable t) {

            }
        });
    }
}
