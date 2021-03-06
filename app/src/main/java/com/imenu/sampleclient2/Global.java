package com.imenu.sampleclient2;

import com.imenu.sampleclient2.model.Meal;
import com.imenu.sampleclient2.model.Order;

import java.util.List;

/**
 * Created by __Hussein__ on 12/29/2015.
 */
public class Global {
    static private int tableNumber;
    static private Order order;
    static private Meal[] meals;

    public static void setMeals(Meal[] meals) {
        Global.meals = meals;
    }

    public static Meal[] getMeals() {
        return meals;
    }

    public static void setTableNumber(int tableNumber) {
        Global.tableNumber = tableNumber;
    }

    public static int getTableNumber() {
        return tableNumber;
    }

    public static Order getOrder() {
        return order;
    }
}
