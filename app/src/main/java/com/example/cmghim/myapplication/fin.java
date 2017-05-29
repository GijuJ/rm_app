package com.example.cmghim.myapplication;

import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class fin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        SystemClock.sleep(5000);

        ActivityCompat.finishAffinity(this);
        System.exit(0);
    }
}
