package com.news.idetechmedia.bitcoinapp.Fragment;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.news.idetechmedia.bitcoinapp.R;
import com.pesonal.adsdk.AppManage;


public class EOSFragment extends Fragment {
    ProgressBar progress_bar;
    LinearLayout native_ads;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_e_o_s, container, false);
        WebView webView = view.findViewById(R.id.webView10);
        progress_bar = view.findViewById(R.id.progress_bar10);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        native_ads=view.findViewById(R.id.native_ads);
        AppManage.getInstance(getContext()).showNative((ViewGroup) view.findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        String userAgent = webView.getSettings().getUserAgentString();

        try {
            String androidString = webView.getSettings().getUserAgentString().
                    substring(userAgent.indexOf("("),userAgent.indexOf(")")+ 1);

            userAgent = webView.getSettings().getUserAgentString().replace(androidString,"X11; Linux x86_64");

        }catch (Exception e){
            e.printStackTrace();
        }

        webView.getSettings().setUserAgentString(userAgent);
        webView.reload();
        webView.loadUrl(getString(R.string.eos_news));  // Url of portal is passed
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