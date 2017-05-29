package com.example.cmghim.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmghim.myapplication.fooditems.fooditem;
import com.example.cmghim.myapplication.fooditems.foodlistAdapter;
import com.example.cmghim.myapplication.network_related.network_connect;
import com.example.cmghim.myapplication.popup_act.popup_order;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class allmenu extends AppCompatActivity {
    ListView listView1;
    TextView textView1;
    foodlistAdapter adapter;
    String jsondatas;//json data from server, raw data..

    HashMap<String, Integer> orderlist;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allmenu2);

        listView1 = (ListView) findViewById(R.id.listView1);
        textView1 = (TextView) findViewById(R.id.test_menu);
        adapter = new foodlistAdapter(this);
        orderlist = new HashMap();

        new getjsondata().execute("http://uni06.unist.ac.kr:1364/foods.json");
    }



    private class getjsondata extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... params) {
            jsondatas = network_connect.getStringUrl(params[0]);
            return jsondatas;
        }

        protected void onPostExecute(String s)
        {
            try
            {
                JSONObject json;
                JSONArray jarr = new JSONArray(s);
                for(int i = 0; i<jarr.length(); i++)
                {
                    json = jarr.getJSONObject(i);
                    adapter.addItem(new fooditem(json.getString("f_name"), "3000"));
                }

                listView1.setAdapter(adapter);

                listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        fooditem curItem = (fooditem) adapter.getItem(position);
                        String[] curData = curItem.getData();
                        Toast.makeText(getApplicationContext(), "Selected : " + curData[0], Toast.LENGTH_SHORT).show();
                        //토스트가 아니고 팝업창을 띄워서 몇개 시킬건지를 고를수있게한다, 취소누르면 0개로 ㅇㅇ
                        Intent intent = new Intent(getApplicationContext(), popup_order.class);
                        intent.putExtra("menu_name", curData[0]);
                        startActivityForResult(intent, 1);
                    }

                });
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 1)
        {
            if(resultCode == RESULT_OK)
            {
                String f_name = data.getStringExtra("f_name");
                int number = data.getIntExtra("nof", 0);

                if(!orderlist.containsKey(f_name))
                {
                    orderlist.put(f_name, number);
                }

                else
                {
                    orderlist.put(f_name, orderlist.get(f_name) + number);
                }

                String toasttext = "You added to the order\n\n"+ f_name + " : " + orderlist.get(f_name);
                Toast.makeText(this, toasttext, Toast.LENGTH_SHORT).show();
            }

            if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this, "you cancelled order", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void submit_menu(View v)
    {
        //서버에 모든주문 보내고나서
        String yourorder = "the list you gave me is" + orderlist.entrySet();
        Toast.makeText(this, yourorder, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), order.class);
        String[] names = orderlist.keySet().toArray(new String[orderlist.keySet().size()]);
        intent.putExtra("order_set", names);
        startActivity(intent);
    }

}
