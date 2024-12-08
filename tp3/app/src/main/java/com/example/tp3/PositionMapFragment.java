package com.example.tp3;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PositionMapFragment extends Fragment {

    private String clientCoordinate = "36.2624235,6.5069478";
    @Nullable
    @Override
    public View onCreateView(@NonNull android.view.LayoutInflater inflater,
                             @Nullable android.view.ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_position_map, container, false);

        WebView webView = root.findViewById(R.id.webview_map);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        String staticMapUrl = "https://www.google.com/maps?q=" + clientCoordinate;
        webView.loadUrl(staticMapUrl);
        return root;
    }
}
