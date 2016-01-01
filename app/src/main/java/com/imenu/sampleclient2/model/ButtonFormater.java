package com.imenu.sampleclient2.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.os.AsyncTask;
import android.text.Html;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imenu.sampleclient2.controller.MealsGetRequestActivity;

import java.io.IOException;
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
    public ButtonFormater(){}
    public void setParams(ImageView imageView,Button button, Meal meal, MealsGetRequestActivity act) {
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
}