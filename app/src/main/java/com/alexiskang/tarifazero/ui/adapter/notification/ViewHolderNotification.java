package com.alexiskang.tarifazero.ui.adapter.notification;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexiskang.tarifazero.R;

public class ViewHolderNotification extends RecyclerView.ViewHolder{

    public TextView txtTitleNotification, txtDescribeNotification, txtDelayNotification;

    public ViewHolderNotification(@NonNull View itemView) {
        super(itemView);

        txtTitleNotification = itemView.findViewById(R.id.txt_title_notification);
        txtDescribeNotification = itemView.findViewById(R.id.txt_describe_notification);
        txtDelayNotification = itemView.findViewById(R.id.txt_delay_notification);
    }
}
