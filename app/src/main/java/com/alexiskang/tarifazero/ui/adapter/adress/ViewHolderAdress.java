package com.alexiskang.tarifazero.ui.adapter.adress;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexiskang.tarifazero.R;

public class ViewHolderAdress extends RecyclerView.ViewHolder {

    public TextView txtTitle;
    public TextView txtAdress;
    public TextView txtTime;
    public RadioButton radioButton;

    public ViewHolderAdress(@NonNull View itemView) {
        super(itemView);

        txtTitle = itemView.findViewById(R.id.txt_title_adress);
        txtAdress = itemView.findViewById(R.id.txt_adress_adress);
        txtTime = itemView.findViewById(R.id.txt_time_adress);
        radioButton = itemView.findViewById(R.id.rdb_is_checked_adress);
    }
}
