package com.example.cmghim.myapplication.fooditems;

/**
 * Created by cmghim on 2017-05-12.
 */

public class fooditem {
    private  String[] datas;
    private boolean selectable = true;

    public fooditem(String []obj)
    {
        datas = obj;
    }

    public fooditem(String str1, String str2)
    {
        datas = new String[2];
        datas[0] = str1;
        datas[1] = str2;
    }

    public boolean isSelectable()
    {
        return selectable;
    }

    public void setSelectable(boolean selectflag)
    {
        selectable = selectflag;
    }

    public String[] getData()
    {
        return datas;
    }

    public String getData(int index)
    {
        if(datas == null||index>datas.length)
        {
            return null;
        }

        return datas[index];
    }

    public void setData(String[] obj)
    {
        datas = obj;
    }

}
