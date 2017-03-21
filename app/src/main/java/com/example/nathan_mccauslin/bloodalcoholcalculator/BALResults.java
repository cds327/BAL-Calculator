package com.example.nathan_mccauslin.bloodalcoholcalculator;

/**
 * Created by christophersimcox on 3/7/17.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BALResults extends AppCompatActivity{
    private Double calculatedData;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        calculatedData = getIntent().getDoubleExtra("result", 0.0);
        resultText = (TextView)findViewById(R.id.result);
        resultText.setText(calculatedData.toString());
    }


}
