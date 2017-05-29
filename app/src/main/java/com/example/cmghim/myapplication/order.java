package com.example.cmghim.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public void onBackPressed()
    {
        Toast.makeText(this, "After meals, Please press the button", Toast.LENGTH_LONG);
    }

    public void Call_Poll(View v)
    {
        Intent get = getIntent();
        Intent intent = new Intent(getApplicationContext(), poll.class);
        String[] orderednames = get.getStringArrayExtra("order_set");
        intent.putExtra("order_list", orderednames);
        startActivity(intent);

    }
}
