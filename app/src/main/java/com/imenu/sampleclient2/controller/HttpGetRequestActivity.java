package com.imenu.sampleclient2.controller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.imenu.sampleclient2.R;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class HttpGetRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendingButton = (Button) findViewById(R.id.sendingButton);
        sendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new HttpGetRequest().execute();
                //Toast.makeText(getApplicationContext(), "7amada bel ganzabeel", Toast.LENGTH_LONG).show();
            }
        });

    }
    private class HttpGetRequest extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
                final String url = "http://imenu.elasticbeanstalk.com/";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                String result = restTemplate.getForObject(url, String.class);
                return result;
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
        }

    }
}
