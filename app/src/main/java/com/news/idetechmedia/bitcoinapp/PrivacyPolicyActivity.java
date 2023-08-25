package com.news.idetechmedia.bitcoinapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pesonal.adsdk.AppManage;

public class PrivacyPolicyActivity extends AppCompatActivity {
    RelativeLayout agree_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        AppManage.getInstance(PrivacyPolicyActivity.this).loadInterstitialAd(this);
        android.graphics.drawable.Drawable background = PrivacyPolicyActivity.this.getResources().getDrawable(R.color.black);
        getWindow().setBackgroundDrawable(background);
        agree_btn=(RelativeLayout) findViewById(R.id.agree_btn);
        agree_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(PrivacyPolicyActivity.this).showInterstitialAd(PrivacyPolicyActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent=new Intent(PrivacyPolicyActivity.this,SelectTopicsActivity.class);
                        startActivity(intent);
                    }
                }, "", AppManage.app_mainClickCntSwAd);

            }
        });
    }

    @Override
    public void onBackPressed() {
        exitApp();
    }
    public void exitApp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.exit_app_dailog, null);
        TextView no_btn = view.findViewById(R.id.no_btn);
        TextView yes_btn = view.findViewById(R.id.yes_btn);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        no_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);

            }
        });
    }
}