package com.example.nathan_mccauslin.bloodalcoholcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
