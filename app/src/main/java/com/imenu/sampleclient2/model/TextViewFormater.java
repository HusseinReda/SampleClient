package com.imenu.sampleclient2.model;

import android.graphics.Color;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hamed on 1/2/16.
 */
public class TextViewFormater {
    private TextView textView ;
    private Order order ;
    public TextViewFormater ( TextView textView, Order order  )
    {
        this.textView= textView;
        this.order =order;
    }
    public TextView extractTextView()
    {
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT    );
        textViewParams.setMargins(0,0,0,20);
        textView.setLayoutParams(textViewParams);
        textView.setTextSize(24);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setTextColor(Color.BLACK);
        textView.setText(Html.fromHtml(
                  order.getMeals().get(0).getName() + "<br>" +
                "table number: " + order.getTableNumber() ));
        textView.setBackgroundColor(Color.rgb(189,192,179)  );
        return textView;
    }
}