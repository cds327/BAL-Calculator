package com.example.nathan_mccauslin.bloodalcoholcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    // Event handler used to start menu activity
    public void MenuButtonClicked(View view)
    {
        Intent menuInt = new Intent(this, MenuActivity.class);
        startActivity(menuInt);
    }
}
