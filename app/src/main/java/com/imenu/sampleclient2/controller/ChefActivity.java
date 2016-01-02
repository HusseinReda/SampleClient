package com.imenu.sampleclient2.controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.imenu.sampleclient2.R;
import com.imenu.sampleclient2.model.Meal;
import com.imenu.sampleclient2.model.Order;
import com.imenu.sampleclient2.model.OrdersGenerator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChefActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef);
        Order[] orders = new Order[10];
        for (int i=0;i<10;i++){
            ArrayList <Meal> meals = new ArrayList<Meal>();
            meals.add( new Meal("Shawerma",110)  );
            orders[i] = new Order(i,meals);
        }
        RelativeLayout chefActivity = (RelativeLayout) findViewById(R.id.activity_chef );
        chefActivity.addView( new OrdersGenerator(orders,this ).getView()  );
    }
}
