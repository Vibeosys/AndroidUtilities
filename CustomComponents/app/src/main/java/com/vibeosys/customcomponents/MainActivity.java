package com.vibeosys.customcomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vibeosys.shuttercomponent.ShutterComponent;
import com.vibeosys.shuttercomponent.ShutterHeader;

public class MainActivity extends AppCompatActivity {

    ShutterHeader component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        component = (ShutterHeader) findViewById(R.id.txtHeader);
        component.setTxtType("INR TO USD");
        component.setTxtPrice("0.84563");
        component.setTxtBuyOrSellColor(getResources().getColor(R.color.accentText));
    }
}
