package com.example.tp3;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.tp3.R;
import java.util.List;


public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {

    private List<Client> clientList;

    public ClientAdapter(List<Client> clientList) {
        this.clientList = clientList;
    }

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_client, parent, false);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        Client client = clientList.get(position);
        holder.clientName.setText(client.getName());
        holder.clientAddress.setText(client.getAdresse());

        // Load the client's image using Glide
        Glide.with(holder.itemView.getContext())
                .load(client.getImage()) // URL or local path
                .placeholder(R.drawable.placeholder) // Default image
                .into(holder.clientImage);

        // Set click listener for the location icon
        holder.locationIcon.setOnClickListener(v -> {
            // Open RouteActivity with the client's coordinates
            Intent intent = new Intent(holder.itemView.getContext(), RouteActivity.class);
            intent.putExtra("client_coordinates", client.getCoordinates()); // Replace with actual field
            holder.itemView.getContext().startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return clientList.size();
    }

    public static class ClientViewHolder extends RecyclerView.ViewHolder {
        ImageView clientImage,locationIcon;
        TextView clientName, clientAddress, clientDate;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            clientImage = itemView.findViewById(R.id.client_image);
            clientName = itemView.findViewById(R.id.client_name);
            clientAddress = itemView.findViewById(R.id.client_address);
            locationIcon = itemView.findViewById(R.id.location_icon);
        }
    }

}

