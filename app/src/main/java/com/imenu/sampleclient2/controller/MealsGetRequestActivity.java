package com.imenu.sampleclient2.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.imenu.sampleclient2.R;
import com.imenu.sampleclient2.model.Meal;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by __Hussein__ on 12/29/2015.
 */
public class MealsGetRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //Button sendingButton = (Button) findViewById(R.id.sendingButton);
        //onCreate();
        //sendingButton.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        new HttpGetRequest().execute();
        //        //Toast.makeText(getApplicationContext(), "7amada bel ganzabeel", Toast.LENGTH_LONG).show();
        //    }
        //});

    }
    @Override
    protected void onStart() {
        super.onStart();
        new MealsGetRequestTask().execute();
    }
    private class MealsGetRequestTask extends AsyncTask<Void, Void, Meal[] > {
        @Override
        protected Meal[]  doInBackground(Void... params) {
            final String url = getString(R.string.url)+"/meals";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Meal[] meals= restTemplate.getForObject(url, Meal[].class);
            return meals;
        }

        @Override
        protected void onPostExecute(Meal[] meals) {
            Toast.makeText(getApplicationContext(), "yes", Toast.LENGTH_LONG).show();
        }

    }
}
