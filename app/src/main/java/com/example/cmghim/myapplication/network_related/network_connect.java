package com.example.cmghim.myapplication.network_related;

import android.net.http.HttpResponseCache;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cmghim on 2017-05-15.
 */

public class network_connect {

    public static void setStringUrl(String url, String data)
    {
        try
        {
            URL curl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) curl.openConnection();

            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Cache-Control","no-cache");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("Content-type","application/json");

            httpURLConnection.setDoOutput(true);
            //httpURLConnection.setDoInput(true);

            OutputStream os = httpURLConnection.getOutputStream();
            os.write(data.getBytes("UTF-8"));
            os.flush();

            httpURLConnection.getResponseCode();
            os.close();

            Log.d("Transfer complete:", data);
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String getStringUrl(String str)
    {
        BufferedReader br = null;
        HttpURLConnection urlConnection = null;

        StringBuffer strbuf = new StringBuffer();

        try
        {
            URL url = new URL(str);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(3000);
            InputStream is = urlConnection.getInputStream();

            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = null;

            while((line = br.readLine()) != null)
            {
                Log.d("line : " , line);
                strbuf.append(line);
            }


        }

        catch(IOException e)
        {
            e.printStackTrace();
        }

        finally
        {
            try
            {
                if(br != null)
                    br.close();

                if(urlConnection != null)
                    urlConnection.disconnect();
            }

            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return strbuf.toString();
    }



}
