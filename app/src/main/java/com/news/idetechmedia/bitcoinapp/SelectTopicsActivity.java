package com.news.idetechmedia.bitcoinapp;

import static com.news.idetechmedia.bitcoinapp.R.color.teal_700;
import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pesonal.adsdk.AppManage;

import java.awt.font.TextAttribute;

public class SelectTopicsActivity extends AppCompatActivity {
    CheckBox main_grid;
    CheckBox  t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27;
    boolean isPressed=false;
    TextView ok;
    LinearLayout native_ads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_topics);
        native_ads=findViewById(R.id.native_ads);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        android.graphics.drawable.Drawable background = SelectTopicsActivity.this.getResources().getDrawable(R.color.black);
        getWindow().setBackgroundDrawable(background);
        AppManage.getInstance(SelectTopicsActivity.this).loadInterstitialAd(this);
        AppManage.getInstance(SelectTopicsActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        //setSingleEvent(main_grid);
        //setToggleEvent(main_grid);
        t1=findViewById(R.id.t1);
        ok=findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(SelectTopicsActivity.this).showInterstitialAd(SelectTopicsActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                    }
                }, "", AppManage.app_mainClickCntSwAd);
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t1.isChecked()) {
                    t1.setTextColor(
                            getResources().getColor(
                                    R.color.black));
                }
                else {
                    t1.setTextColor(
                            getResources().getColor(
                                    R.color.white));
                }
            }
        });
    }


    private void setToggleEvent(GridLayout main_grid) {
        for(int i=0;i<main_grid.getChildCount();i++) {
            CardView cardView=(CardView) main_grid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardView.getCardBackgroundColor().getDefaultColor()==-1){
                        cardView.setCardBackgroundColor(Color.parseColor("#FF03DAC5"));
                        Toast.makeText(SelectTopicsActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    }else{
                        cardView.setCardBackgroundColor(Color.parseColor("#ffffff"));
                        Toast.makeText(SelectTopicsActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }

    private void setSingleEvent(GridLayout main_grid) {
        for(int i=0;i<main_grid.getChildCount();i++){
            TextView textView=(TextView) main_grid.getChildAt(i);
            int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SelectTopicsActivity.this, "Clicked at index"+ finalI, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    @Override
    public void onBackPressed() {
        AppManage.getInstance(SelectTopicsActivity.this).showInterstitialAd(SelectTopicsActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                SelectTopicsActivity.super.onBackPressed();
            }
        }, "", AppManage.app_mainClickCntSwAd);
    }


}