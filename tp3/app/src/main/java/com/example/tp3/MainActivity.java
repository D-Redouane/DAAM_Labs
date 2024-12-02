package com.example.tp3;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.activity.EdgeToEdge;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // super.onCreate(savedInstanceState);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        String staticMapUrl = "https://www.google.com/maps/dir/" + "36.246453630769395;+6.570260325908719/36.2779689150762," + "+6.588030743330757/@36.2624235,6.5609478";
        webView.loadUrl(staticMapUrl);

        // binding = ActivityMainBinding.inflate(getLayoutInflater());
        // setContentView(binding.getRoot());

        // setSupportActionBar(binding.appBarMain.toolbar);
        // binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View view) {
        //         Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                 .setAction("Action", null)
        //                 .setAnchorView(R.id.fab).show();
        //     }
        // });
        // DrawerLayout drawer = binding.drawerLayout;
        // NavigationView navigationView = binding.navView;
        // // Passing each menu ID as a set of Ids because each
        // // menu should be considered as top level destinations.
        // mAppBarConfiguration = new AppBarConfiguration.Builder(
        //         R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
        //         .setOpenableLayout(drawer)
        //         .build();
        // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        // NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        // NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}