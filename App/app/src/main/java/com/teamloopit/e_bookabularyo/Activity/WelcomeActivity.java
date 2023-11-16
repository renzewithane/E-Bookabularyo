package com.teamloopit.e_bookabularyo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.teamloopit.e_bookabularyo.R;

public class WelcomeActivity extends AppCompatActivity {
    private String sharedPrefFile = "com.teamloopit.e_bookabularyo";

    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Set the isNewUser to false, since the user started to use the app
        SharedPreferences preferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isNewUser", false);
        editor.apply();

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this, IntroductionActivity.class));
                finish();
            }
        });
    }
}