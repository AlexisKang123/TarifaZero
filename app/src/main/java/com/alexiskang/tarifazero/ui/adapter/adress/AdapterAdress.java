package com.alexiskang.tarifazero.ui.adapter.adress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.model.Address;
import com.alexiskang.tarifazero.model.UserAddress;

import java.util.List;

public class AdapterAdress extends RecyclerView.Adapter<ViewHolderAdress> {

    private Context context;
    private List<UserAddress> adresses;
    private OnAddressClick listener;

    public AdapterAdress(Context context, List<UserAddress> adresses, OnAddressClick listener) {
        this.context = context;
        this.adresses = adresses;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolderAdress onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_adress, parent, false);

        return new ViewHolderAdress(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdress holder, int position) {



        holder.txtTitle.setText("Endereço");

        UserAddress address = adresses.get(position);

        String endereco = address.getAddress().getStreet() + ", " +
                address.getAddress().getNumber() + " - " +
                address.getAddress().getDistrict() + " - " +
                address.getAddress().getZip_code();

        holder.txtAdress.setText(endereco);

        holder.radioButton.setChecked(address.isSelected());

        holder.itemView.setOnClickListener(v -> {

            for (UserAddress a : adresses) {
                a.setSelected(false);
            }

            address.setSelected(true);

            notifyDataSetChanged();

            listener.onSelect(address);
        });

        holder.radioButton.setOnClickListener(v -> {

            if(address.isSelected()){
                address.setSelected(false);
            }else{
                address.setSelected(true);
            }

            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return adresses.size();
    }

    public interface OnAddressClick {
        void onSelect(UserAddress address);
    }
}