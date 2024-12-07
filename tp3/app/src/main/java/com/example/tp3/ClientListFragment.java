package com.example.tp3;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.tp3.MapActivity;

import java.util.ArrayList;
import java.util.List;

public class ClientListFragment extends Fragment {

    private List<Client> clientList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_client_list, container, false);

        // Initialize sample client data
        clientList = new ArrayList<>();
        clientList.add(new Client("Client 1", "image1.jpg", "Category 1", 36.778259, -119.417931));
        clientList.add(new Client("Client 2", "image2.jpg", "Category 2", 40.712776, -74.005974));

        ListView listView = view.findViewById(R.id.client_list_view);
        ArrayAdapter<Client> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, clientList);
        listView.setAdapter(adapter);

        // Handle item clicks
        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Intent intent = new Intent(getActivity(), MapActivity.class);
            intent.putExtra("latitude", clientList.get(position).getLatitude());
            intent.putExtra("longitude", clientList.get(position).getLongitude());
            startActivity(intent);
        });

        return view;
    }
}
