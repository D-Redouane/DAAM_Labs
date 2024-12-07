package com.example.tp3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Retrieve latitude and longitude of the client
        double clientLat = getIntent().getDoubleExtra("client_lat", 43.910254);
        double clientLon = getIntent().getDoubleExtra("client_lon", 4.888752);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Initialize map fragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Extract all clients from the intent
        String clientJson = getIntent().getStringExtra("client_list");
        if (clientJson == null || clientJson.isEmpty()) {
            return; // Exit if no clients are passed
        }

        Type listType = new TypeToken<List<Client>>() {}.getType();
        List<Client> clients = new Gson().fromJson(clientJson, listType);

        // Add markers for all clients and build bounds
        LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();
        for (Client client : clients) {
            LatLng clientPosition = new LatLng(client.getLatitude(), client.getLongitude());
            mMap.addMarker(new MarkerOptions()
                    .position(clientPosition)
                    .title(client.getName())
                    .snippet(client.getDescription()));
            boundsBuilder.include(clientPosition);
        }

        // Adjust camera to show all markers
        int padding = 100; // Padding around the bounds in pixels
        if (clients.size() > 0) {
            LatLngBounds bounds = boundsBuilder.build();
            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
        }
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371; // Radius of Earth in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance in km
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            onMapReady(mMap);
        }
    }
}
