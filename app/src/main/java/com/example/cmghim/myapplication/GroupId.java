package com.example.cmghim.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cmghim.myapplication.popup_act.popup_addid;

public class GroupId extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_id);
    }

    public void produce_GI(View v)
    {
        //그룹아이디가 중복이 되거나 칸이 비어있을때 등을 제외하고 서버에 저장(이 id로)

        Intent intent = new Intent(getApplicationContext(), selectgroup.class);
        startActivity(intent);
    }

    public void call_addid(View v)
    {
        Intent intent = new Intent(getApplicationContext(), popup_addid.class);
        startActivity(intent);
    }
}
