package com.example.cmghim.myapplication.popup_act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmghim.myapplication.R;

public class popup_reservation extends Activity {

    TextView tv1;
    NumberPicker np1;
    String starttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_reservation);
        tv1 = (TextView) findViewById(R.id.pop_resname);
        Intent intent = getIntent();
        starttime = intent.getStringExtra("all");

        np1 = (NumberPicker) findViewById(R.id.pop_np);
        np1.setMinValue(1);
        np1.setMaxValue(3);
    }

    public void reservationok(View v)
    {
        int i = np1.getValue();
        String str = "Thank you - "+ starttime + "\n\n you reserved " + i +" hour(s)";
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
