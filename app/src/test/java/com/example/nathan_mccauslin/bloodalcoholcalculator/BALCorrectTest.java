package com.example.nathan_mccauslin.bloodalcoholcalculator;

import org.junit.Test;
import static org.junit.Assert.*;
import com.example.nathan_mccauslin.bloodalcoholcalculator.MainActivity;

/**
 * Created by treyb on 5/4/2017.
 */

public class BALCorrectTest {
    // Duplicate method used to modularize the BAL Calculation used for testing
    public static double CALCBalTest(double alcohol, int heightInt, double weight, double genderConstant, int lastDrinkNum)
    {
        double BALResult = 0.0;
        weight =  weight/ 2.2; //set weight after converting input to kg
        double lbsGrams = weight * 453.592; //Convert pounds to grams
        double height = heightInt * 2.54;
        double alcoholGrams = alcohol * 28.3495;
        if(lastDrinkNum == 0)
        {
            lastDrinkNum = 1;
        }
        BALResult = (((alcoholGrams) / (lbsGrams * genderConstant)) * 100) * (0.15 * lastDrinkNum);
        return BALResult;
    }

    @Test
    public void First_BAL_Correct() throws Exception {
        double balCalc = CALCBalTest(100, 2112, 190, 0.70, 0);
        System.out.println("Test 1: " + balCalc + "," + 1.5507518796992479);
        assertEquals(balCalc, 1.5507518796992479, 0.1);
    }

    @Test
    public void Second_BAL_Correct() throws Exception {
        double balCalc = CALCBalTest(10, 2112, 190, 0.70, 0);
        System.out.println("Test 2: " + balCalc + "," + 0.15507518796992484);
        assertEquals(balCalc, 0.15507518796992484, 0.1);
    }

    @Test
    public void Third_BAL_Correct() throws Exception {
        double balCalc = CALCBalTest(20, 2112, 190, 0.70, 0);
        System.out.println("Test 3: " + balCalc + "," + 0.3101503759398497);
        assertEquals(balCalc, 0.3101503759398497, 0.1);
    }
}
