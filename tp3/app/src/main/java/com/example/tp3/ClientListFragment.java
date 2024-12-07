package com.example.tp3;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ClientListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_client_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.client_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Université Constantine 2", "Université Constantine 2 Abdelhamid Mehri – Nouvelle ville Ali Mendjeli BP : 67A, Constantine – Algérie La Nouvelle Ville Ali Mendjeli, 25016", R.drawable.sample_image, 36.246579, 6.569953));
        clients.add(new Client("Université D'Avignon", "339 Chem. des Meinajaries, 84000 Avignon, France", R.drawable.sample_image, 43.910254, 4.888752)); // Example client

        ClientAdapter adapter = new ClientAdapter(getContext(), clients);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
