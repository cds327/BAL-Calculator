package com.example.nathan_mccauslin.bloodalcoholcalculator;

/**
 * Created by christophersimcox on 3/7/17.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.io.*;
import android.content.Context;

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
        StringBuilder sb = new StringBuilder();
        String filename = "data/data/com.example.nathan_mccauslin.bloodalcoholcalculator/files/saved_text";
        String string = "BAL Result: " + calculatedData.toString() + ",";
        FileOutputStream outputStream;
        BufferedReader br;
        String line;


        try {
            FileInputStream inputStream = new FileInputStream(filename);
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            string = string + sb;
            outputStream = new FileOutputStream(filename);
            outputStream.write(string.getBytes());
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Event handler used to start menu activity
    public void MenuButtonClicked(View view)
    {
        Intent menuInt = new Intent(this, MenuActivity.class);
        startActivity(menuInt);
    }
}
