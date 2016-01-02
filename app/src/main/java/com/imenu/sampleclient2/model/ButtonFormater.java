package com.imenu.sampleclient2.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.os.AsyncTask;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.imenu.sampleclient2.Global;
import com.imenu.sampleclient2.R;
import com.imenu.sampleclient2.controller.MealsGetRequestActivity;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by hamed on 1/1/16.
 */
public class ButtonFormater {
    private Button button;
    private Meal meal;
    private MealsGetRequestActivity act;
    private ImageView imageView;
    public ButtonFormater(ImageView imageView ,Button button, Meal meal, MealsGetRequestActivity act) {
        this.meal = meal;
        this.button= button;
        this.act=act;
        this.imageView = imageView;
    }
    public LinearLayout extractButton(){
        LinearLayout.LayoutParams buttonLayoutParams  = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,370);
        buttonLayoutParams.setMargins(0, 10, 0, 10);
        button.setText(Html.fromHtml("<h3>" + meal.getName() + "</h3>" +
                "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;" + meal.getPrice() + " LE"));
        button.setLayoutParams(buttonLayoutParams);
        button.setOnClickListener(new View.OnClickListener() {
            private Meal buttonMeal;

            @Override
            public void onClick(View v) {
                ArrayList<Meal> meals = new ArrayList<Meal>();
                meals.add(meal);
                Order order = new Order( 0,meals);
                new OrderPostRequestTask().execute(order);
            }
        });
        LinearLayout mainLayout = new LinearLayout(act);
        mainLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams mainLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 400 );
        LinearLayout.LayoutParams imageViewParams  = new LinearLayout.LayoutParams(400,400);
        imageViewParams.setMargins(0,0,0,20);
        imageView.setLayoutParams( imageViewParams);
        mainLayout.addView(imageView);
        mainLayout.addView(button);
        return mainLayout;
    }
    private class OrderPostRequestTask extends AsyncTask<Order, Void, String> {
        @Override
        protected String doInBackground(Order... params) {
            Order order = params[0];
            final String url = act.getString(R.string.url)+"order/add";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            String response = restTemplate.postForObject(url, order, String.class);
            return response;
        }
        @Override
        protected void onPostExecute(String result) {
//            Toast.makeText(act,result, Toast.LENGTH_LONG).show();
        }
    }
}
