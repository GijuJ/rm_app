package com.example.cmghim.myapplication.fooditems;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmghim on 2017-05-12.
 */

public class foodlistAdapter extends BaseAdapter {
    private Context contexts;
    private List<fooditem> fooditems = new ArrayList<fooditem>();

    public foodlistAdapter(Context context)
    {
        contexts = context;
    }

    public void addItem(fooditem fi)
    {
        fooditems.add(fi);
    }

    public void setFooditems(List<fooditem> fis)
    {
        fooditems = fis;
    }

    public int getCount()
    {
        return fooditems.size();
    }

    public Object getItem(int pos)
    {
        return fooditems.get(pos);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public boolean isSelectable(int pos) {
        try {
            return fooditems.get(pos).isSelectable();
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }


    public View getView(int pos, View cview, ViewGroup parent)
    {
        foodview fv;
        if(cview == null)
        {
         fv = new foodview(contexts, fooditems.get(pos));
        }

        else
        {
            fv = (foodview) cview;
        }

        fv.setText(0, fooditems.get(pos).getData(0));
        fv.setText(1, fooditems.get(pos).getData(1));
        return fv;
    }




}
