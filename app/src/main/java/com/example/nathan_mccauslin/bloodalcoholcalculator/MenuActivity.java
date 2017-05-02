package com.example.nathan_mccauslin.bloodalcoholcalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.*;

public class MenuActivity extends AppCompatActivity {

    SharedPreferences pref = null;
    BufferedReader eReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        pref = getSharedPreferences("com.example.nathan_mccauslin.bloodalcoholcalculator", MODE_PRIVATE);
        try {
            eReader = new BufferedReader(new InputStreamReader(new FileInputStream("data/data/com.example.nathan_mccauslin.bloodalcoholcalculator/files/saved_text")));
        }
        catch(Exception e){

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (pref.getBoolean("firstrun", true)) {
            //First run we create a file to save future data.
            try{
                File file = new File("/data/data/com.example.nathan_mccauslin.bloodalcoholcalculator/files/saved_text");
                if(!file.exists()) // Create the file if it does not exist.
                    file.createNewFile();
                file.setReadable(true, false);
            }
            catch(Exception e){

            }

        }
    }

    // Event handler used to start BAL calculator
    public void StartCalculatorActivity(View view)
    {
        Intent calcInt = new Intent(this, MainActivity.class);
        startActivity(calcInt);
    }

    // TODO: placeholder event handler until activities are created
    public void StartComingSoon(View view)
    {
        Intent comingSoonInt = new Intent(this, ComingSoonActivity.class);
        startActivity(comingSoonInt);
    }

    // Event handler method that directs the user to the credits activity
    public void StartCredits(View view)
    {
        Intent creditsInt = new Intent(this, CreditsActivity.class);
        startActivity(creditsInt);
    }
}
