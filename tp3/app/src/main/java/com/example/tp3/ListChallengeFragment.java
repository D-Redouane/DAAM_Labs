package com.example.tp3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ListChallengeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ClientAdapter clientAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_challenge, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_clients);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client("Université Constantine 2", R.drawable.ic_univconst2 , "Category 2", "Université Constantine 2 Abdelhamid Mehri – Nouvelle ville Ali Mendjeli BP : 67A, Constantine – Algérie La Nouvelle Ville Ali Mendjeli, 25016", "36.246579,6.569953"));
        clientList.add(new Client("Université D'Avignon", R.drawable.ic_avignon , "Category 3", "339 Chem. des Meinajaries, 84000 Avignon, France", "43.910254,4.888752"));

        // clients.add(new Client("Université Constantine 2", "Université Constantine 2 Abdelhamid Mehri – Nouvelle ville Ali Mendjeli BP : 67A, Constantine – Algérie La Nouvelle Ville Ali Mendjeli, 25016", R.drawable.sample_image, 36.246579, 6.569953));
        // clients.add(new Client("Université D'Avignon", "339 Chem. des Meinajaries, 84000 Avignon, France", R.drawable.sample_image, 43.910254, 4.888752)); // Example client

        clientAdapter = new ClientAdapter(clientList);
        recyclerView.setAdapter(clientAdapter);


        return view;
    }
}

