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
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

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

        // Request user location
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        }

        mMap.setMyLocationEnabled(true);
        mMap.setOnMapLongClickListener(latLng -> {
            // Add a marker at the clicked location
            mMap.addMarker(new MarkerOptions().position(latLng).title("New Location"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
        });
        fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
            if (location != null) {
                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());
                LatLng clientLocation = new LatLng(
                        getIntent().getDoubleExtra("client_lat", 0.0),
                        getIntent().getDoubleExtra("client_lon", 0.0)
                );

                // Add markers for user and client
                mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location"));
                mMap.addMarker(new MarkerOptions().position(clientLocation).title("Client Location"));

                // Move camera to user location
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 12));

                // Draw a line between the two locations
                mMap.addPolyline(new PolylineOptions()
                        .add(userLocation, clientLocation)
                        .width(10)
                        .color(0xFF0000FF)); // Blue line
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            onMapReady(mMap);
        }
    }
}
