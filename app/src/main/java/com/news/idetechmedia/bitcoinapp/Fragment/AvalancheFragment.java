package com.news.idetechmedia.bitcoinapp.Fragment;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.news.idetechmedia.bitcoinapp.DashboardActivity;
import com.news.idetechmedia.bitcoinapp.R;
import com.pesonal.adsdk.AppManage;


public class AvalancheFragment extends Fragment {
    ProgressBar progress_bar2;
    LinearLayout native_ads;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_avalanche, container, false);
        WebView webView2 =(WebView) view.findViewById(R.id.webView2);
        webView2.getSettings().setUseWideViewPort(true);
        progress_bar2=view.findViewById(R.id.progress_bar2);
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
        webView2.loadUrl(getString(R.string.avalanche_news));
        webView2.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progress_bar2.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progress_bar2.setVisibility(View.GONE);
            }
        });
//        webView2.setWebChromeClient(new WebChromeClient() {
//            public void onProgressChanged(WebView view, int progress) {
//                if (progress < 100) {
//                    progress_bar2.setVisibility(View.VISIBLE);
//                }
//                if (progress == 100) {
//                    progress_bar2.setVisibility(View.GONE);
//                }
//            }
//        });
        return view;
    }

}