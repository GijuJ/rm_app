package com.example.cmghim.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmghim.myapplication.network_related.network_connect;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.spec.ECField;


public class MainActivity extends AppCompatActivity {

    EditText id;
    EditText pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText theid = (EditText)findViewById(R.id.theid);
        EditText thepd = (EditText)findViewById(R.id.thepd);

        theid.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                if(keyCode == event.KEYCODE_ENTER)
                {
                    return true;
                }
                return false;
            }
        });

        thepd.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                if(keyCode == event.KEYCODE_ENTER)
                {
                    return true;
                }
                return false;
            }
        });


    }

    public void call_select_group(View v)
    {
         id = (EditText) findViewById(R.id.theid);
         pd = (EditText) findViewById(R.id.thepd);

        /*
        if(id.getText().toString().length() == 0 || pd.getText().toString().length() == 0)
        {
            Toast.makeText(this, "Write your id and password", Toast.LENGTH_SHORT).show();
            return;
        }
        */

        new idpdconfirm().execute("http://uni06.unist.ac.kr:1364/customers.json");

    }

    private class idpdconfirm extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... params) {
            String ids = network_connect.getStringUrl(params[0]);
            String data = "{\"g_name\":\"WTF\",\"customer_id\":101850804}";
            String url = "http://uni06.unist.ac.kr:1364/groups/write";
            //network_connect.setStringUrl(url, data);

            return ids;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            String typedid = null;
            JSONObject person = null;
            boolean check = false;
            try
            {
                JSONArray people = new JSONArray(s);
                for(int i = 0; i<people.length(); i++)
                {
                    person = people.getJSONObject(i);
                    String personid = person.getString("login_ID");
                    String personpd = person.getString("login_PW");

                    typedid = id.getText().toString();
                    String typedpd = pd.getText().toString();

                    if(personid.equals(typedid) && personpd.equals(typedpd))
                    {
                        check = true;
                        break;
                    }
                }

                if(!check)
                {
                    Toast.makeText(getApplicationContext(), "id or password are incorrect", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }

            catch (Exception e)
            {
                e.printStackTrace();
            }


            myapp allapp = (myapp) getApplication();

            try {
                allapp.Setid(person.getString("id"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(getApplicationContext(), selectgroup.class);
            intent.putExtra("cus_id", typedid);
            startActivity(intent);
        }
    }

    public void callchef(View v)
    {
        Intent intent = new Intent(getApplicationContext(), chef.class);
        startActivity(intent);
    }
}


