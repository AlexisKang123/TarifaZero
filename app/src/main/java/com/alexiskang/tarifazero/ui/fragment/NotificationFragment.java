package com.alexiskang.tarifazero.ui.fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.database.SupabaseClient;
import com.alexiskang.tarifazero.database.SupabaseConfig;
import com.alexiskang.tarifazero.database.SupabaseService;
import com.alexiskang.tarifazero.model.Notification;
import com.alexiskang.tarifazero.ui.adapter.notification.AdapterNotification;
import com.alexiskang.tarifazero.utils.SessionManager;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        notifications = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getNotification();

        return view;

    }

    private void initializeComponents(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_notification);
    }

    private void getNotification(){

        if (getContext() == null) {
            return;
        }

        SessionManager session = new SessionManager(getContext());

        SupabaseService service = SupabaseClient
                .getClient()
                .create(SupabaseService.class);

        service.getNotification(
                SupabaseConfig.API_KEY,
                "Bearer " + session.getToken()
        ).enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                if (!isAdded()) {
                    return;
                }

                if (response.isSuccessful() && response.body() != null) {
                    notifications = new ArrayList<>(response.body());
                    adapter = new AdapterNotification(requireActivity(), notifications);
                    recyclerView.setAdapter(adapter);
                    Log.d("NOTIFICATION", "Notificacoes carregadas: " + notifications.size());
                } else {
                    String errorBody = "";

                    try {
                        if (response.errorBody() != null) {
                            errorBody = response.errorBody().string();
                        }
                    } catch (IOException e) {
                        Log.e("NOTIFICATION", "Erro ao ler corpo de erro", e);
                    }

                    Log.e("NOTIFICATION", "Falha ao buscar notificacoes. Code: " + response.code() + " Body: " + errorBody);
                }
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {
                Log.e("NOTIFICATION", t.getMessage() != null ? t.getMessage() : "Erro ao buscar notificacoes");
            }
        });
    }
}
