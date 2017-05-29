package com.example.cmghim.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class reservation_check extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_check);
    }



    public void backtocenter(View v)
    {
        Intent intent = new Intent(getApplicationContext(), centeractivity.class);
        startActivity(intent);
    }

}
