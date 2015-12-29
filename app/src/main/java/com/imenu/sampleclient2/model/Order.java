package com.imenu.sampleclient2.model;

import com.imenu.sampleclient2.Global;

import java.util.List;

/**
 * Created by __Hussein__ on 12/29/2015.
 */
public class Order {
    private List<Meal> meals;

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Meal> getMeals() {
        return meals;
    }
}
