package com.imenu.sampleclient2.model;

import android.text.Html;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.imenu.sampleclient2.controller.ChefActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by hamed on 1/2/16.
 */
public class OrdersGenerator {
    private  Order[] ordersList;
    private ChefActivity act ;
    public OrdersGenerator(Order[] ordersList, ChefActivity act)
    {
        this.act =act;
        this.ordersList = ordersList;
    }
    public ScrollView getView ()
    {
        ScrollView ordersContainer = new ScrollView(act);
        RelativeLayout.LayoutParams ordersContainerParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT
                , RelativeLayout.LayoutParams.MATCH_PARENT);
        ordersContainerParams.setMargins(0,0,0,100);
        ordersContainer.setLayoutParams(ordersContainerParams);
        //ordersContainer.setPadding(0,0,0,100);

        LinearLayout orders = new LinearLayout(act);
        orders.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.
                MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        orders.setOrientation(LinearLayout.VERTICAL);

        for (int i=0;i<ordersList.length;i++){
            TextView tv = new TextView(act);
            TextViewFormater textViewFormater = new TextViewFormater(tv,ordersList[i]);
            orders.addView(textViewFormater.extractTextView());
        }
        ordersContainer.addView(orders);
        return ordersContainer;
    }
}
