package com.imenu.sampleclient2;

/**
 * Created by __Hussein__ on 12/29/2015.
 */
public class Global {
    static private int tableNumber;

    public static void setTableNumber(int tableNumber) {
        Global.tableNumber = tableNumber;
    }

    public static int getTableNumber() {
        return tableNumber;
    }
}
