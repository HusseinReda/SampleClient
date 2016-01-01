package com.imenu.sampleclient2.model;

import android.text.Html;
import android.widget.Button;

/**
 * Created by hamed on 1/1/16.
 */
public class ButtonFormater {
    private Button button;
    private Meal meal;
    public ButtonFormater(){}
    public void setParams(Button button, Meal meal) {
        this.button = button;
        this.meal = meal;
    }
    public Button extractButton(){
        button.setText(Html.fromHtml("<b><p>" + meal.getName() + "</p></b> <br>" +
                "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;" + meal.getPrice() + " LE"));
        button.setHeight(300);
        button.setWidth(500);
//        button.setBackground(img2);
        return button;
    }
}

