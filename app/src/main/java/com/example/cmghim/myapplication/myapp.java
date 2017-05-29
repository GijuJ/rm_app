package com.example.cmghim.myapplication;

import android.app.Application;

/**
 * Created by cmghim on 2017-05-15.
 */

public class myapp extends Application {
    private String id;
    private String Groupid;

    public String Getid()
    {
        return id;
    }

    public String Getgroupid()
    {
        return Groupid;
    }

    public void Setid(String S)
    {
        id = S;
    }

    public void Setgroupid(String S)
    {
        Groupid = S;
    }
}
