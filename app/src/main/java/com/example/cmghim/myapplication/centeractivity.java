package com.example.cmghim.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cmghim.myapplication.R;
import com.example.cmghim.myapplication.Recommended_menu;
import com.example.cmghim.myapplication.reservation;

public class centeractivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centeractivity);
    }


    public void nowClicked(View v)
    {
        Intent intent = new Intent(getApplicationContext(), Recommended_menu.class);
        startActivity(intent);
    }


    public void reservationClicked(View v)
    {
        Intent intent = new Intent(getApplicationContext(), reservation.class);
        startActivity(intent);
    }

    public void resconfirm(View v)
    {
        Intent intent = new Intent(getApplicationContext(), reservation_check.class);
        startActivity(intent);
    }

}
