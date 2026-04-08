package com.alexiskang.tarifazero.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.model.Notification;
import com.alexiskang.tarifazero.ui.adapter.notification.AdapterNotification;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Notification> notifications;

    private AdapterNotification adapter;

    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        initializeComponents(view);

        notifications = getNotification();

        adapter = new AdapterNotification(getActivity(), notifications);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); // 🔥 faltava isso
        recyclerView.setAdapter(adapter);

        return view;

    }

    private void initializeComponents(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_notification);
    }

    private ArrayList<Notification> getNotification(){

        ArrayList<Notification> listNotifications = new ArrayList<>();

        listNotifications.add(new Notification(
                "1",
                "Ônibus atrasado",
                "Seu ônibus está com atraso de aproximadamente 10 minutos.",
                "Indefinido"
        ));

        listNotifications.add(new Notification(
                "2",
                "Mudança de rota",
                "A linha sofreu alteração devido a obras na via principal.",
                "15 min"
        ));

        listNotifications.add(new Notification(
                "3",
                "Novo horário disponível",
                "Confira os novos horários atualizados da sua linha.",
                "15:30"
        ));

        listNotifications.add(new Notification(
                "4",
                "Ponto alterado",
                "Seu embarque foi redirecionado para outro ponto próximo.",
                "encontro outro ponto"
        ));

        return listNotifications;
    }
}