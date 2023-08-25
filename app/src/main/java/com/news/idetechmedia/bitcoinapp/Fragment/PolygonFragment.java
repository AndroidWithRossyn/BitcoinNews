package com.news.idetechmedia.bitcoinapp.Fragment;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.news.idetechmedia.bitcoinapp.R;


public class PolygonFragment extends Fragment {
    ProgressBar progress_bar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_polygon, container, false);
        WebView webView = view.findViewById(R.id.webView18);
        progress_bar = view.findViewById(R.id.progress_bar18);
        webView.loadUrl(getString(R.string.polygon_news));  // Url of portal is passed
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progress_bar.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progress_bar.setVisibility(View.GONE);
            }
        });
        return view;
    }
}