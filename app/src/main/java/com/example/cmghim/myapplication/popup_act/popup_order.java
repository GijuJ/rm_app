package com.example.cmghim.myapplication.popup_act;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.cmghim.myapplication.R;

public class popup_order extends Activity {

    TextView tv;
    NumberPicker np;
    String foodname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_order);

        Intent intent = getIntent();
        foodname = intent.getExtras().getString("menu_name");

        tv = (TextView) findViewById(R.id.pop_name);
        tv.setText(foodname + ":  ");

        np = (NumberPicker) findViewById(R.id.np_menu);
        np.setMinValue(0);
        np.setMaxValue(100);
        np.setWrapSelectorWheel(false);

    }

    public void orderok(View v)
    {
        Intent intent = new Intent();
        intent.putExtra("nof", np.getValue());
        intent.putExtra("f_name", foodname);
        setResult(RESULT_OK, intent);

        finish();
    }

    public void ordercancel(View v)
    {
        Intent intent  =  new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
