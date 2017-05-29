package com.example.cmghim.myapplication;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.cmghim.myapplication.popup_act.popup_order;
import com.example.cmghim.myapplication.popup_act.popup_reservation;

import java.util.Date;

import static com.example.cmghim.myapplication.R.id.grouplist;
import static com.example.cmghim.myapplication.R.id.now;

public class reservation extends AppCompatActivity {

    private int ryear;
    private int rmonth;
    private int rdate;

    private int rhour;
    private int rmin;

    DatePicker dp;
    TimePicker tp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        dp = (DatePicker) findViewById(R.id.res_date);
        dp.setMinDate(System.currentTimeMillis());
        tp = (TimePicker) findViewById(R.id.res_time);

    }

    public  void reservation_Clicked(View v)
    {
        rdate = dp.getDayOfMonth();
        ryear = dp.getYear();
        rmonth = dp.getMonth();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            rhour = tp.getHour();
            rmin = tp.getMinute();
        }

        String resd = ryear + "-" + rmonth + "-" + rdate + " " + rhour + ":" + rmin;

        Toast.makeText(this, resd, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), popup_reservation.class);
        intent.putExtra("year", ryear);
        intent.putExtra("month", rmonth);
        intent.putExtra("date", rdate);
        intent.putExtra("hour", rhour);
        intent.putExtra("min", rmin);
        intent.putExtra("all", resd);

        startActivity(intent);
    }
}
