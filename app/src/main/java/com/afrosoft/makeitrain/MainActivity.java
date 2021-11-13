package com.afrosoft.makeitrain;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int moneyCounter = 0;
    private TextView moneyValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneyValue = findViewById(R.id.moneyValue);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void showMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
        Log.d("MIR", "onClick: "+ moneyCounter);
        switch (moneyCounter){
            case 20000:
                moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,
                        R.color.green));
                break;
            case 40000:
                moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,
                        R.color.purple_200));
                break;
            case 80000:
                moneyValue.setTextColor(Color.GRAY);
                break;
            default:
                moneyValue.setTextColor(Color.WHITE);
        }
    }
}