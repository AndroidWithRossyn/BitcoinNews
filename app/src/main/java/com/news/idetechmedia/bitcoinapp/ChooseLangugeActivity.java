package com.news.idetechmedia.bitcoinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.TextView;

public class ChooseLangugeActivity extends AppCompatActivity {
    TextView ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_languge);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        getWindow().setStatusBarColor(Color.TRANSPARENT);
//        android.graphics.drawable.Drawable background = ChooseLangugeActivity.this.getResources().getDrawable(R.drawable.button);
//        getWindow().setBackgroundDrawable(background);
        ok=(TextView) findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChooseLangugeActivity.this,SelectTopicsActivity.class);
                startActivity(intent);
            }
        });
    }
}