package com.alexiskang.tarifazero.ui.adapter.busstop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.model.BusStop;

import java.util.List;

public class AdapterBusStop extends RecyclerView.Adapter<ViewHolderBusStop> {

    private Context context;
    private List<BusStop> busStops;

    public AdapterBusStop(Context context, List<BusStop> busStops) {
        this.context = context;
        this.busStops = busStops;
    }

    @NonNull
    @Override
    public ViewHolderBusStop onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_bus_stop, parent, false);

        return new ViewHolderBusStop(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBusStop holder, int position) {
        BusStop busStop = busStops.get(position);

        Log.d("BUSSTOP", busStop.toString());

        String adress = busStop.getAddress().getStreet() + ", " +
                busStop.getAddress().getNumber() + " - " +
                busStop.getAddress().getDistrict() + " - " +
                busStop.getAddress().getZip_code();

        holder.txtTitleBusStop.setText(busStop.getTitle());
        holder.txtAdressBusStop.setText(adress);

        holder.btnOpenMapBusStop.setOnClickListener(v -> {

            Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(adress));

            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return busStops.size();
    }
}
