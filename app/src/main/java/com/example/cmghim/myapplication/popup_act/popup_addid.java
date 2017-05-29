package com.example.cmghim.myapplication.popup_act;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cmghim.myapplication.R;

public class popup_addid extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_addid);
    }

    public void idreg(View v)//id가 데이터 베이스에 있는지 확인하고 있으면 insert없으면 토스트메시지
    {

    }
}
