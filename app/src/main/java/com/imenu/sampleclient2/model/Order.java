package com.imenu.sampleclient2.model;

import com.imenu.sampleclient2.Global;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by __Hussein__ on 12/29/2015.
 */
public class Order {
    private List<Meal> meals;
    private int tableNumber;
    private long id;
    public void setId(long id) {
        this.id = id;
    }
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
    public long getId() {
        return id;
    }
    public int getTableNumber (){return tableNumber;}
    public List<Meal> getMeals (){return meals;}

    public Order(){}
    public Order( int tableNumber,List<Meal> meals){
        this.tableNumber=tableNumber;
        this.meals=meals;
    }

}
