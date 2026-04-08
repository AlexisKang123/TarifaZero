package com.alexiskang.tarifazero.ui.adapter.adress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.model.Adress;
import com.alexiskang.tarifazero.ui.adapter.adress.ViewHolderAdress;

import java.util.List;

public class AdapterAdress extends RecyclerView.Adapter<ViewHolderAdress> {

    private Context context;
    private List<Adress> adresses;

    public AdapterAdress(Context context, List<Adress> adresses) {
        this.context = context;
        this.adresses = adresses;
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

        Adress adress = adresses.get(position);

        holder.txtTitle.setText("Endereço");

        String endereco = adress.getStreet() + ", " +
                adress.getNumber() + " - " +
                adress.getDistrict() + " - " +
                adress.getZip_code();

        holder.txtAdress.setText(endereco);

        holder.radioButton.setChecked(adress.isSelected());

        holder.itemView.setOnClickListener(v -> {

           if(adress.isSelected()){
               adress.setSelected(false);
           }else{
               adress.setSelected(true);
           }

            notifyDataSetChanged();
        });

        holder.radioButton.setOnClickListener(v -> {

            if(adress.isSelected()){
                adress.setSelected(false);
            }else{
                adress.setSelected(true);
            }

            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return adresses.size();
    }
}