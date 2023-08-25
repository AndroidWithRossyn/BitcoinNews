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


public class EtherumFragment extends Fragment {
    ProgressBar progress_bar;
    LinearLayout native_ads;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_etherum, container, false);
        WebView webView2 = view.findViewById(R.id.webView11);

        //This the the enabling of the zoom controls
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setLoadsImagesAutomatically(true);
        webView2.getSettings().setLoadWithOverviewMode(true);
        webView2.getSettings().setUseWideViewPort(true);
        webView2.getSettings().setDomStorageEnabled(true);
        webView2.getSettings().setBuiltInZoomControls(true);
        native_ads=view.findViewById(R.id.native_ads);
        AppManage.getInstance(getContext()).showNative((ViewGroup) view.findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        String userAgent = webView2.getSettings().getUserAgentString();

        try {
            String androidString = webView2.getSettings().getUserAgentString().
                    substring(userAgent.indexOf("("),userAgent.indexOf(")")+ 1);

            userAgent = webView2.getSettings().getUserAgentString().replace(androidString,"X11; Linux x86_64");

        }catch (Exception e){
            e.printStackTrace();
        }

        webView2.getSettings().setUserAgentString(userAgent);
        webView2.reload();
        progress_bar = view.findViewById(R.id.progress_bar11);
        webView2.loadUrl(getString(R.string.etherum_news));
        webView2.setWebViewClient(new WebViewClient() {
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