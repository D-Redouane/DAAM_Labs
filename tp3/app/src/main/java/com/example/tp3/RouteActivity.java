package com.example.tp3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class RouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        // Get the client coordinates from the intent
        String clientCoordinates = getIntent().getStringExtra("client_coordinates");

        // Initialize the WebView to display the route
        WebView webView = findViewById(R.id.webview_route);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        // Load the Google Maps URL with the client's coordinates
        String mapUrl = "https://www.google.com/maps/dir/?api=1&destination=" + clientCoordinates;
        webView.loadUrl(mapUrl);
    }
}
