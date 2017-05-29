package com.example.cmghim.myapplication.popup_act;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmghim.myapplication.R;

public class popup_poll extends Activity {

    TextView tv;
    RadioGroup r1;
    RadioGroup r2;
    RadioGroup r3;
    RadioGroup r4;
    RadioGroup r5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_poll);

        Intent intent = getIntent();
        String pollname = intent.getStringExtra("name");

        tv = (TextView) findViewById(R.id.popup_pollname);
        tv.setText(pollname);

        r1 = (RadioGroup) findViewById(R.id.radio01);
        r2 = (RadioGroup) findViewById(R.id.radio02);
        r3 = (RadioGroup) findViewById(R.id.radio3);
        r4 = (RadioGroup) findViewById(R.id.radio4);
        r5 = (RadioGroup) findViewById(R.id.radio5);

        r1.check(R.id.radiobutton0103);
        r2.check(R.id.radiobutton0203);
        r3.check(R.id.radiobutton0303);
        r4.check(R.id.radiobutton0403);
        r5.check(R.id.radiobutton0503);
    }

    public void return_poll(View v)
    {
        int cheked1 = r1.getCheckedRadioButtonId();
        int cheked2 = r2.getCheckedRadioButtonId();
        int cheked3 = r3.getCheckedRadioButtonId();
        int cheked4 = r4.getCheckedRadioButtonId();
        int cheked5 = r5.getCheckedRadioButtonId();

        int[] res = checked(cheked1, cheked2, cheked3, cheked4, cheked5);



        String st = res + " is selected";
        Toast.makeText(getApplicationContext(), st, Toast.LENGTH_SHORT);

        Intent intent = new Intent();
        String nam = tv.getText().toString();
        intent.putExtra("name", nam);
        setResult(RESULT_OK, intent);
        finish();
    }

    private int[] checked(int c1, int c2, int c3, int c4, int c5)
    {
        int[] results = new int[5];

        switch(c1)
        {
            case R.id.radiobutton0101:
                results[0] = 1;
                break;
            case R.id.radiobutton0102:
                results[0] = 2;
                break;
            case R.id.radiobutton0103:
                results[0] = 3;
                break;
            case R.id.radiobutton0104:
                results[0] = 4;
                break;
            case R.id.radiobutton0105:
                results[0] = 5;
                break;
        }

        switch(c2)
        {
            case R.id.radiobutton0201:
                results[1] = 1;
                break;
            case R.id.radiobutton0202:
                results[1] = 2;
                break;
            case R.id.radiobutton0203:
                results[1] = 3;
                break;
            case R.id.radiobutton0204:
                results[1] = 4;
                break;
            case R.id.radiobutton0205:
                results[1] = 5;
                break;
        }

        switch(c3)
        {
            case R.id.radiobutton0301:
                results[2] = 1;
                break;
            case R.id.radiobutton0302:
                results[2] = 2;
                break;
            case R.id.radiobutton0303:
                results[2] = 3;
                break;
            case R.id.radiobutton0304:
                results[2] = 4;
                break;
            case R.id.radiobutton0305:
                results[2] = 5;
                break;
        }

        switch(c4)
        {
            case R.id.radiobutton0401:
                results[3] = 1;
                break;
            case R.id.radiobutton0402:
                results[3] = 2;
                break;
            case R.id.radiobutton0403:
                results[3] = 3;
                break;
            case R.id.radiobutton0404:
                results[3] = 4;
                break;
            case R.id.radiobutton0405:
                results[3] = 5;
                break;
        }

        switch(c5)
        {
            case R.id.radiobutton0501:
                results[4] = 1;
                break;
            case R.id.radiobutton0502:
                results[4] = 2;
                break;
            case R.id.radiobutton0503:
                results[4] = 3;
                break;
            case R.id.radiobutton0504:
                results[4] = 4;
                break;
            case R.id.radiobutton0505:
                results[4] = 5;
                break;
        }

        return results;
    }

    
}
