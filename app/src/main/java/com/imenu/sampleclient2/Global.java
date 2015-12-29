package com.imenu.sampleclient2;

import com.imenu.sampleclient2.model.Order;

import java.util.List;

/**
 * Created by __Hussein__ on 12/29/2015.
 */
public class Global {
    static private int tableNumber;
    static private List<Order> orders;

    public static void setTableNumber(int tableNumber) {
        Global.tableNumber = tableNumber;
    }

    public static int getTableNumber() {
        return tableNumber;
    }

    public static void addOrder(Order order){
        orders.add(order);
    }
    public static List<Order> getOrders() {
        return orders;
    }
}
