package com.example.sanath.quizapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout splash_screen2;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            splash_screen2.setVisibility(View.VISIBLE);
        }
    };
//    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splash_screen2 = (RelativeLayout) findViewById(R.id.spalash_screen2);

        handler.postDelayed(runnable,3200);

//        viewPager = findViewById(R.id.viewpager);
//        IntroAdapter adapter = new IntroAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(adapter);
    }

    public void findCountry(View view) {
        startActivity(new Intent(this,FindCountryActivity.class));
    }
}
