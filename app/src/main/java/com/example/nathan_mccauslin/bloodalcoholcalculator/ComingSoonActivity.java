package com.example.nathan_mccauslin.bloodalcoholcalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.*;
import android.util.Log;
import java.lang.String;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ComingSoonActivity extends AppCompatActivity {
    TextView first;
    TextView second;
    TextView third;
    TextView fourth;
    TextView fifth;
    BufferedReader br = null;
    StringBuilder sb = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coming_soon);
        first = (TextView) findViewById(R.id.firstHistory);
        second = (TextView) findViewById(R.id.secondHistory);
        third = (TextView) findViewById(R.id.thirdHistory);
        fourth = (TextView) findViewById(R.id.fourthHistory);
        fifth = (TextView) findViewById(R.id.fifthHistory);
        String line;
        String[] results;
        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream("data/data/com.example.nathan_mccauslin.bloodalcoholcalculator/files/saved_text")));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        results = sb.toString().split(",");
        int i;
        for(i = 0; i<results.length; i++){
            if(first.getText() == "" || first.getText().equals("No history to show yet!")){
                first.setText(results[i]);
            }
            else if(second.getText() == ""){
                second.setText(results[i]);
            }
            else if(third.getText() == ""){
                third.setText(results[i]);
            }
            else if(fourth.getText() == ""){
                fourth.setText(results[i]);
            }
            else if(fifth.getText() == ""){
                fifth.setText(results[i]);
            }
        }



    }

    // Event handler used to start menu activity
    public void MenuButtonClicked(View view)
    {
        Intent menuInt = new Intent(this, MenuActivity.class);
        startActivity(menuInt);
    }
}
