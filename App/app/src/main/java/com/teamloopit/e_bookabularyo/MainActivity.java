package com.teamloopit.e_bookabularyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private boolean isNewUser;

    private SharedPreferences mPreferences;


    private String sharedPrefFile = "com.teamloopit.e_bookabularyo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Check

        isNewUser = mPreferences.getBoolean("isNewUser", true);

        if (isNewUser)
        {
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();
        }
        else
        {
            setContentView(R.layout.activity_main);
        }
    }
}