package com.example.cmghim.myapplication;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cmghim.myapplication.popup_act.popup_poll;

public class poll extends AppCompatActivity {


    ListView listView;
    ArrayAdapter arrayAdapter;
    String[] orderedmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);

        Intent intent = getIntent();
        orderedmenu = intent.getStringArrayExtra("order_list");

        listView = (ListView) findViewById(R.id.atemenu);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, orderedmenu);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = (String) parent.getAdapter().getItem(position);
                String tt = "You select " + data;
                Toast.makeText(getApplicationContext(), tt, Toast.LENGTH_SHORT);
                Intent intent = new Intent(getApplication(), popup_poll.class);
                intent.putExtra("name", data);
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1)
        {
            if(resultCode == RESULT_OK)
            {
               // Toast.makeText(getApplicationContext(), "thanks you poll!", Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                String str = intent.getStringExtra("name");
                arrayAdapter.remove(str);
                if(arrayAdapter.isEmpty())
                {
                    Intent intent2 = new Intent(getApplicationContext(), fin.class);
                    Toast.makeText(getApplicationContext(), "Thanks your poll, Good Bye!", Toast.LENGTH_SHORT).show();
                    startActivity(intent2);
                }
                arrayAdapter.notifyDataSetChanged();
            }
        }
        else
        {

        }
    }

    public void call_final(View v)
    {
        Intent intent = new Intent(getApplicationContext(), fin.class);
        startActivity(intent);
    }
}
