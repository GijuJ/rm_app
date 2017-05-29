package com.example.cmghim.myapplication.fooditems;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cmghim.myapplication.R;

/**
 * Created by cmghim on 2017-05-12.
 */

public class foodview extends LinearLayout {
    private TextView name;
    private TextView cost;


    public foodview(Context context, fooditem foodtem)
    {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listfood, this ,true);

        name = (TextView) findViewById(R.id.foodname);
        name.setText(foodtem.getData(0));
        name.setTextSize(30.0f);
        cost = (TextView) findViewById(R.id.foodcost);
        cost.setText(foodtem.getData(1));
        cost.setTextSize(30.0f);
    }

    public void setText(int index , String str)
    {
        if(index == 0)
        {
            name.setText(str);
        }
        else if(index == 1)
        {
            cost.setText(str);
        }

        else
        {
            throw new IllegalArgumentException();
        }
    }
}
