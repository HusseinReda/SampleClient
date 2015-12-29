package com.imenu.sampleclient2.model;

/**
 * Created by __Hussein__ on 12/29/2015.
 */
public class Meal {

    private long id;

    private int price;

    private String name;

    public Meal(){}

    public Meal(String name, int price) {
        this.price = price;
        this.name = name;
    }
    public long getId() {
        return id;
    }
    public void setId(long value) {
        this.id = value;
    }
    public long getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
    }
}

