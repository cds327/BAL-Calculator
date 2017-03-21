package com.example.nathan_mccauslin.bloodalcoholcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import java.util.HashMap;
import java.util.Map;
import android.content.Intent;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RadioGroup genderGroup;
    private RadioButton genderButtonMale;
    private RadioButton genderButtonFemale;
    private EditText ageF;
    private EditText weightF;
    private EditText heightF;
    private Button genButton;
    private EditText alcoholConsump;
    private int alcohol;
    private double BALResult;
    private double genderConstant;
    private double alcoholGrams;
    private double lbsGrams;
    private EditText lastDrink;
    private int lastDrinkNum;
    private int age;
    private double weight;
    private double height;
    private AlertDialog.Builder dlgAlert;
    private static final int RB1_ID = 1000;//first radio button id
    private static final int RB2_ID = 1001;//second radio button id


    static Map<String, Integer> mealPlan = new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickListenerButton();
        genderButtonMale = (RadioButton) findViewById(R.id.radioButton);
        genderButtonFemale = (RadioButton) findViewById(R.id.radioButton2);
        lastDrink = (EditText) findViewById(R.id.lastDrinkID);

        // Username or password false, display and an error
        dlgAlert  = new AlertDialog.Builder(this);
    }
    public void onClickListenerButton(){
        genderGroup = (RadioGroup)findViewById(R.id.rGrpGender); // get info. from id rGrpGender, associate genButton with generateButton id

        genButton = (Button)findViewById(R.id.generateButton); // associate genButton with generateButton id
        genButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        int checker = -1;
                        int selectedGender = genderGroup.getCheckedRadioButtonId();
                        if(selectedGender == genderButtonMale.getId()){
                            checker = 0;
                            genderConstant = 0.70;
                        }
                        else if(selectedGender == genderButtonFemale.getId()){
                            checker = 0;
                            genderConstant = 0.61;
                        }
                        weightF = (EditText)findViewById(R.id.weightField);
                        heightF = (EditText)findViewById(R.id.heightField);
                        alcoholConsump = (EditText) findViewById(R.id.alcoholDrinks);
                        if(lastDrink.getText().toString().trim().length() != 0 && checker == 0 && weightF.getText().toString().trim().length() != 0 && heightF.getText().toString().trim().length() != 0 && alcoholConsump.getText().toString().trim().length() != 0) {
                            lastDrinkNum = Integer.parseInt(lastDrink.getText().toString());
                            weight = Double.parseDouble(weightF.getText().toString()) / 2.2; //set weight after converting input to kg
                            lbsGrams = weight * 453.592; //Convert pounds to grams
                            height = Double.parseDouble(heightF.getText().toString()) * 2.54;
                            alcohol = Integer.parseInt(alcoholConsump.getText().toString());
                            alcoholGrams = alcohol * 28.3495; //Convent alcohol oz to grams
                            BALResult = (((alcoholGrams) / (lbsGrams * genderConstant)) * 100) * (0.15 * lastDrinkNum); //BAL Calculation
                            //Pass off to Results Intent
                            Intent getResults = new Intent(MainActivity.this, BALResults.class);
                            getResults.putExtra("result", BALResult);
                            finish();
                            startActivity(getResults);
                        }
                        else{


                            dlgAlert.setMessage("One or more fields are empty");
                            dlgAlert.setTitle("Error");
                            dlgAlert.setPositiveButton("OK", null);
                            dlgAlert.setCancelable(true);
                            dlgAlert.create().show();

                            dlgAlert.setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    });

                        }

    };
    });
    }}