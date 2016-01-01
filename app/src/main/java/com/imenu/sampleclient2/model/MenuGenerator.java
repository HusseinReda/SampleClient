package com.imenu.sampleclient2.model;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.imenu.sampleclient2.controller.HttpGetRequestActivity;
import com.imenu.sampleclient2.controller.MealsGetRequestActivity;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by hamed on 12/30/15.
 */
public class MenuGenerator {

    private Meal[] meals ;
    private MealsGetRequestActivity act;
    private LinearLayout menu;
    ButtonFormater buttonFormater ;
    private int assyncCounter;
    public MenuGenerator(Meal[] meals, MealsGetRequestActivity act)
    {
        assyncCounter =0;
        this.meals=meals;
        this.act= act;
        buttonFormater = new ButtonFormater();
    }
    public ScrollView getView(   )
    {
        ScrollView menuContainer = new ScrollView(act);
        menuContainer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT))  ;
        menu = new LinearLayout(act);
        menu.setOrientation(LinearLayout.VERTICAL);
        menu.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)   );

        for (int i=0;i<meals.length;i++){
            new GetBitmapFromUrl().execute(meals[i].getImageUrl());
        }
        menuContainer.addView(menu);
        return menuContainer;
    }
    public class GetBitmapFromUrl extends AsyncTask<String,Void,Bitmap> {
        ImageView imageView;
        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                return bmp;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ImageView img = new ImageView(act);
            img.setImageBitmap(bitmap);
            Button button = new Button(act);
            buttonFormater.setParams(img, button, meals[assyncCounter++], act);
            menu.addView(buttonFormater.extractButton());
        }

    }


}
