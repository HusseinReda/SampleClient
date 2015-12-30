package com.imenu.sampleclient2.model;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.imenu.sampleclient2.controller.HttpGetRequestActivity;
import com.imenu.sampleclient2.controller.MealsGetRequestActivity;

import java.util.ArrayList;

/**
 * Created by hamed on 12/30/15.
 */
public class MenuGenerator {

    private ArrayList<Meal> meals ;
    private MealsGetRequestActivity act;
    public MenuGenerator(ArrayList<Meal> meals, MealsGetRequestActivity act)
    {
        this.meals=meals;
        this.act= act;
    }
    public RelativeLayout getView(   )
    {
        RelativeLayout rel = new RelativeLayout(act);
        rel.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT ,LinearLayout.LayoutParams.MATCH_PARENT ));
        LinearLayout lin1 = new LinearLayout(act);
        LinearLayout lin2 = new LinearLayout(act);
        lin1.setOrientation(LinearLayout.VERTICAL);
        lin2.setOrientation(LinearLayout.VERTICAL);
        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT );
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT );
        lin1.setLayoutParams(params1);
        lin2.setLayoutParams(params2);
        params1.setMargins(10,10,500,10);
        params2.setMargins(500,10,10,10);

        rel.addView(lin1);
        rel.addView(lin2);
        for (int i=0;i<meals.size();i++){
            Button newItem = new Button(act);
            newItem.setHeight(300);
            newItem.setWidth(500);
            newItem.setText(meals.get(i).getName());
            newItem.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT , LinearLayout.LayoutParams.WRAP_CONTENT)  );
            if (i%2==0){
                lin1.addView(newItem);
            }
            else{
                lin2.addView(newItem);
            }
        }/**/
        return rel;
    }
}
