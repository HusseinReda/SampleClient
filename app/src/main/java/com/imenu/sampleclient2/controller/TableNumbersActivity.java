package com.imenu.sampleclient2.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.imenu.sampleclient2.Global;
import com.imenu.sampleclient2.R;

import java.util.List;

public class TableNumbersActivity extends AppCompatActivity {
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_numbers);
    }
    public void ButtonOnClick(View button) {
        switch (button.getId()) {
            case R.id.table_1:
                Global.setTableNumber(1);
                break;
            case R.id.table_2:
                Global.setTableNumber(2);
                break;
            case R.id.table_3:
                Global.setTableNumber(3);
                break;
            case R.id.table_4:
                Global.setTableNumber(4);
                break;
            case R.id.table_5:
                Global.setTableNumber(5);
                break;
            case R.id.table_6:
                Global.setTableNumber(6);
                break;
        }
        Intent intent = new Intent(context,MealsGetRequestActivity.class);
        startActivity(intent);
    }

}
