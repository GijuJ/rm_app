package com.example.cmghim.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cmghim.myapplication.fooditems.fooditem;
import com.example.cmghim.myapplication.fooditems.foodlistAdapter;
import com.example.cmghim.myapplication.popup_act.popup_order;

public class chef extends AppCompatActivity {

    private foodlistAdapter orderedmenus;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef);

        orderedmenus = new foodlistAdapter(this);
        lv = (ListView) findViewById(R.id.orderedlist);
        orderedmenus.addItem(new fooditem("food list", "table number"));
        orderedmenus.addItem(new fooditem("Ramen", "3"));//귀찮으니까 이거 이용해서 써먹을까 계속
        lv.setAdapter(orderedmenus);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                {

                }
                else
                    {
                    fooditem curItem = (fooditem) orderedmenus.getItem(position);
                    String[] curData = curItem.getData();
                    Toast.makeText(getApplicationContext(), "Selected : " + curData[0], Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
