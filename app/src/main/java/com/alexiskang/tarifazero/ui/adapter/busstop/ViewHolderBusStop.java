package com.alexiskang.tarifazero.ui.adapter.busstop;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexiskang.tarifazero.R;

public class ViewHolderBusStop extends RecyclerView.ViewHolder {

    public TextView txtTitleBusStop, txtAdressBusStop;
    public Button btnOpenMapBusStop;


    @SuppressLint("WrongViewCast")
    public ViewHolderBusStop(@NonNull View itemView) {
        super(itemView);

        txtAdressBusStop = itemView.findViewById(R.id.txt_adress_bus_stop);
        txtTitleBusStop = itemView.findViewById(R.id.txt_title_bus_stop);
        btnOpenMapBusStop = itemView.findViewById(R.id.btn_open_maps_bus_stop);
    }
}
