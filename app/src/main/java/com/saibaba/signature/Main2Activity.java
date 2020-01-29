package com.saibaba.signature;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.e("harsh",sendSms());
        RetrieveFeedTask task = new RetrieveFeedTask();
        task.execute();

    }
    public String sendSms() {
        try {
            // Construct data
            String apiKey = "apikey=" + URLEncoder.encode("6+8Mx1q7ERw-ETKOm14HmRm0glNtZTAPSj0BjoJLKd", "UTF-8");
            String message = "&message=" + URLEncoder.encode("Hi Sanjay Kumar take care of your wifi and your child. This is  chief RAMMA i will kill them.", "UTF-8");
            String sender = "&sender=" + URLEncoder.encode("TXTLCL", "UTF-8");
            String numbers = "&numbers=" + URLEncoder.encode("919386888177", "UTF-8");

            // Send data
            String data = "https://api.textlocal.in/send/?" + apiKey + numbers + message + sender;
            URL url = new URL(data);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String sResult="";
            while ((line = rd.readLine()) != null) {
                // Process line...
                sResult=sResult+line+" ";
            }
            rd.close();

            return sResult;
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return "Error "+e;
        }
    }
    class RetrieveFeedTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Log.d("Harsh------->", "called");
                Log.d("Harsh",sendSms());
                Log.d("Harsh-------->", "after called");

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(Main2Activity.this, e.toString(), Toast.LENGTH_SHORT).show();
                Log.d("Harsh-------->", "Exception occurred " + e);
            }
            return null;
        }
    }
}
