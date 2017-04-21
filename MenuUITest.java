package com.example.nathan_mccauslin.bloodalcoholcalculator;

import android.app.Instrumentation;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.app.Instrumentation.ActivityMonitor;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by treyb on 4/20/2017.
 */

public class MenuUITest {

    @Test
    public void BALLoads() throws Exception {
        // register next activity that need to be monitored.
        ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

        // open current activity.
        MenuActivity myActivity = getActivity();
        final Button button = (Button) myActivity.findViewById(com.example.nathan_mccauslin.bloodalcoholcalculator.id.open_next_activity);
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open next activity.
                button.performClick();
            }
        });

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        MainActivity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity .finish();
    }

    @Test
    public void CreditsLoads() throws Exception {
        // register next activity that need to be monitored.
        ActivityMonitor activityMonitor = getInstrumentation().addMonitor(CreditsActivity.class.getName(), null, false);

        // open current activity.
        MenuActivity myActivity = getActivity();
        final Button button = (Button) myActivity.findViewById(com.example.nathan_mccauslin.bloodalcoholcalculator.id.open_next_activity);
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open next activity.
                button.performClick();
            }
        });

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        CreditsActivity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity .finish();
    }

    @Test
    public void ResultsLoads() throws Exception {
        // register next activity that need to be monitored.
        ActivityMonitor activityMonitor = getInstrumentation().addMonitor(BALResults.class.getName(), null, false);

        // open current activity.
        MenuActivity myActivity = getActivity();
        final Button button = (Button) myActivity.findViewById(com.example.nathan_mccauslin.bloodalcoholcalculator.id.open_next_activity);
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open next activity.
                button.performClick();
            }
        });

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        BALResults nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity .finish();
    }
}
