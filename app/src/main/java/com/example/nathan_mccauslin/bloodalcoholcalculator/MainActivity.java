package com.example.nathan_mccauslin.bloodalcoholcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RadioGroup genderGroup;
    private RadioButton genderButton;
    private RadioGroup goalGroup;
    private RadioButton goalButton;
    private RadioGroup activityGroup;
    private RadioButton activityButton;
    private EditText ageF;
    private EditText weightF;
    private EditText heightF;
    private Button genButton;
    private int age;
    private double weight;
    private double height;
    private double BMR;
    private int numMeals = 5;
    private double activityMultiplier;
    private double caloriesBurned;
    private double caloriesToBeConsumed;
    private static double amtProteinToConsume;
    private static double amtCarbToConsume;
    private static double amtFatToConsume;
    private static Random rand = new Random();
    private static String[] proteinSource =   {"Chicken Breasts(oz)","Pork Chops(oz)","Canned Tuna in Water(full can)","Whole Eggs(large egg)"};
    private static double[] proteinContent =  {7,6,22,6};
    private static double[] proteinFatContent={1,2,.5,5}; //fat content in order Chicken = 1 gram of fat per ounce

    private static String[] carbSource =    {"Oats(1/2cup)","Brown Rice(1/2cup)","Whole Wheat Bread(slice)","Refried Beans(1/2cup)"}; //need to get more exact using brand names for stuff like bread
    private static double[] carbContent =   {11.5,14,16,15}; // these are not accurate, just for testing
    private static double[] carbFatContent ={1,2,1,1,1};

    static Map<String, Integer> mealPlan = new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickListenerButton();
    }
    public void onClickListenerButton(){
        genderGroup = (RadioGroup)findViewById(R.id.rGrpGender); // get info. from id rGrpGender        genButton = (Button)findViewById(R.id.generateButton); // associate genButton with generateButton id
        genButton = (Button)findViewById(R.id.generateButton); // associate genButton with generateButton id
        genButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        int selectedGender = genderGroup.getCheckedRadioButtonId();
                        genderButton = (RadioButton)findViewById(selectedGender);

                        ageF = (EditText)findViewById(R.id.ageField);    // sets variables with value the user entered
                        weightF = (EditText)findViewById(R.id.weightField);
                        heightF = (EditText)findViewById(R.id.heightField);


                        age = Integer.parseInt(ageF.getText().toString()); // convert ageF to string then string to int
                        weight = Double.parseDouble(weightF.getText().toString())/2.2; //set weight after converting input to kg
                        height = Double.parseDouble(heightF.getText().toString())*2.54;
    };
    });
    }}