package com.imenu.sampleclient2.controller;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.imenu.sampleclient2.R;
import com.imenu.sampleclient2.model.Meal;
import com.imenu.sampleclient2.model.MenuGenerator;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by __Hussein__ on 12/29/2015.
 */
public class MealsGetRequestActivity extends AppCompatActivity {
    final private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

    }
    @Override
    protected void onStart() {
        super.onStart();
        new MealsGetRequestTask().execute();
    }
    private class MealsGetRequestTask extends AsyncTask<Void, Void, Meal[] > {
        @Override
        protected Meal[]  doInBackground(Void... params) {
      //      try {
                final String url = getString(R.string.url)+"/meals";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Meal[] meals= restTemplate.getForObject(url, Meal[].class);
                return meals;
  //          }catch (Exception e){
//                Toast.makeText(getApplicationContext(), "No meals Found", Toast.LENGTH_LONG).show();
   //             return null;
    //        }
        }

        @Override
        protected void onPostExecute(Meal[] meals) {
            LinearLayout menuActivity = (LinearLayout) findViewById(R.id.activity_meals);
            MenuGenerator menuGenerator = new MenuGenerator(meals, (MealsGetRequestActivity) context) ;
            ScrollView menu = menuGenerator.getView();
            menuActivity.addView( menu);
        }
    }
}
