package com.example.cmghim.myapplication.popup_act;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cmghim.myapplication.R;
import com.example.cmghim.myapplication.order;

import static android.R.attr.button;

public class popup_recomorder extends Activity {

    TextView name_recom;
    String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_recomorder);
        name_recom = (TextView) findViewById(R.id.recomname);
        Intent intent = getIntent();
        str = intent.getStringExtra("menu_name");

        name_recom.setText(str);
    }

    public void recom_cancel(View v)
    {

    }

    public void call_recom(View v)
    {
        Intent intent = new Intent(getApplicationContext(), order.class);
        intent.putExtra("order_set", str);
        startActivity(intent);
    }
}
