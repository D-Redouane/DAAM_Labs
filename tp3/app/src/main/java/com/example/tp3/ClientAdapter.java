package com.example.tp3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {

    private final List<Client> clients;
    private final Context context;

    public ClientAdapter(Context context, List<Client> clients) {
        this.context = context;
        this.clients = clients;
    }

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_client, parent, false);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        Client client = clients.get(position);
        holder.name.setText(client.getName());
        holder.description.setText(client.getDescription());
        holder.image.setImageResource(client.getImageResId()); // Assuming image is from drawable
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MapActivity.class);
            intent.putExtra("client_lat", client.getLatitude());
            intent.putExtra("client_lon", client.getLongitude());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return clients.size();
    }

    public static class ClientViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, description;
        ImageView icon;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.client_image);
            name = itemView.findViewById(R.id.client_name);
            description = itemView.findViewById(R.id.client_description);
            icon = itemView.findViewById(R.id.client_icon);
        }
    }
}

