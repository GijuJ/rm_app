package com.example.cmghim.myapplication;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmghim.myapplication.network_related.network_connect;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class selectgroup extends AppCompatActivity {

    TextView tv;
    ListView lv;
    ArrayAdapter adapter;
    myapp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectgroup);

        Intent get = getIntent();
        String did = get.getStringExtra("cus_id");
        app = (myapp) getApplication();

        tv = (TextView) findViewById(R.id.yourid);
        tv.setText("Your id : " +  did + "\n\n Your group List:");
        tv.setTypeface(null, Typeface.BOLD_ITALIC);

        String urlid = "http://uni06.unist.ac.kr:1364/customers/" + app.Getid() + "/belongs_to.json" ;
        new callgroupid().execute(urlid);

    }

    private class callgroupid extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... params) {
            String groupids = network_connect.getStringUrl(params[0]);
            return groupids;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JSONArray gids;
            JSONObject gid;

            try
            {
                gids = new JSONArray(s);
                gid = null;

                ArrayList Gids = new ArrayList();

                for(int i = 0; i<gids.length(); i++)
                {
                        gid = gids.getJSONObject(i);
                        Gids.add(gid.getString("g_name"));
                        Log.d("line : " , gid.getString("g_name"));
                }

                adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, Gids);
                lv = (ListView) findViewById(R.id.grouplist) ;
                lv.setAdapter(adapter);
            }
            catch (JSONException e)

            {
                e.printStackTrace();
            }

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String data = (String) parent.getAdapter().getItem(position);
                    app.Setgroupid(data);

                    String tt = "You select " + data;
                    Toast.makeText(getApplicationContext(), tt, Toast.LENGTH_SHORT);

                    Intent intent = new Intent(getApplication(), centeractivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    public void call_making(View v)
    {
        Intent intent = new Intent(getApplicationContext(), GroupId.class);
        startActivity(intent);
    }

}
