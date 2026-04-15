package com.alexiskang.tarifazero.ui.adapter.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.model.Notification;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterNotification extends RecyclerView.Adapter<ViewHolderNotification>{

    private Context context;
    private List<Notification> notifications;

    public AdapterNotification(Context context, List<Notification> notifications) {
        this.context = context;
        this.notifications = notifications;
    }

    @NonNull
    @Override
    public ViewHolderNotification onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_notification, parent, false);

        return new ViewHolderNotification(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNotification holder, int position) {
        Notification notification =  notifications.get(position);

        holder.txtTitleNotification.setText(notification.getTitle());
        holder.txtDescribeNotification.setText(notification.getDescribe());
        holder.txtDelayNotification.setText(notification.getStatus());

        Glide.with(context)
                .load(notification.getImage())
                .placeholder(R.drawable.baseline_home_24)
                .error(R.drawable.baseline_home_24)
                .into(holder.imgNotification);
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }
}
