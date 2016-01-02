package com.imenu.sampleclient2.controller;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.imenu.sampleclient2.R;
import com.imenu.sampleclient2.model.Meal;
import com.imenu.sampleclient2.model.Order;
import com.imenu.sampleclient2.model.OrdersGenerator;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChefActivity extends AppCompatActivity {
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef);
        Order[] orders = new Order[100];

//        for (int i=0;i<10;i++){
//            ArrayList <Meal> meals = new ArrayList<Meal>();
//            meals.add( new Meal("Shawerma",110)  );
//            orders[i] = new Order(i,meals);
//        }
        Button chef_refresh = (Button) findViewById(R.id.chef_refresh);
        chef_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetOrdersTask().execute();
            }
        });

    }
    private class GetOrdersTask extends AsyncTask<Void, Void, Order[] > {

        @Override
        protected Order[] doInBackground(Void... params) {
            final String url = getString(R.string.url)+"order";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Order[] orders= restTemplate.getForObject(url, Order[].class);
            return orders;
        }
        @Override
        protected void onPostExecute(Order[] orders) {
            RelativeLayout chefActivity = (RelativeLayout) findViewById(R.id.activity_chef );
            chefActivity.addView( new OrdersGenerator(orders, (ChefActivity) context).getView()  );
        }
    }
}
