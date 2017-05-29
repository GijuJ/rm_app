package com.example.cmghim.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cmghim.myapplication.fooditems.fooditem;
import com.example.cmghim.myapplication.fooditems.foodlistAdapter;
import com.example.cmghim.myapplication.network_related.network_connect;
import com.example.cmghim.myapplication.popup_act.popup_recomorder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Recommended_menu extends AppCompatActivity {

    ListView RecomList;
    foodlistAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_menu);

        RecomList = (ListView) findViewById(R.id.list_recom);
        adapter = new foodlistAdapter(this);
        new getrecomfromserver().execute("http://uni06.unist.ac.kr:1364/foods/most_three.json");
    }


    private class getrecomfromserver extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... params) {
            String line = network_connect.getStringUrl(params[0]);
            return line;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try
            {
                String foodname;
                JSONObject recom;
                JSONArray recomarr = new JSONArray(s);
                for(int i = 0; i<recomarr.length(); i++)
                {
                    recom = recomarr.getJSONObject(i);
                    adapter.addItem(new fooditem(recom.getString("f_name"), "3000"));
                }

                RecomList.setAdapter(adapter);

                RecomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        fooditem curItem = (fooditem) adapter.getItem(position);
                        String[] curData = curItem.getData();
                        Toast.makeText(getApplicationContext(), "Selected : " + curData[0], Toast.LENGTH_SHORT).show();
                        //토스트가 아니고 팝업창을 띄워서 몇개 시킬건지를 고를수있게한다, 취소누르면 0개로 ㅇㅇ
                        Intent intent = new Intent(getApplicationContext(), popup_recomorder.class);
                        intent.putExtra("menu_name", curData[0]);
                        startActivityForResult(intent, 1);
                    }

                });
            }
            catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

    public void allClicked(View v)
    {
        Intent intent = new Intent(getApplicationContext(), allmenu.class);
        startActivity(intent);
    }

    public void differentClicked(View v)
    {
        Toast.makeText(this, "다른 추천메뉴를 누르셨습니당", Toast.LENGTH_LONG).show();
    }

}
