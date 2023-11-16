package com.teamloopit.e_bookabularyo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Visibility;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class WelcomeActivity extends AppCompatActivity {
    private String sharedPrefFile = "com.teamloopit.e_bookabularyo";

    private Button nextButton;

    private RelativeLayout welcomeMessageLayout, introductionLayout1, introductionLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        SharedPreferences preferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isNewUser", false);
        editor.apply();


        nextButton = findViewById(R.id.nextButton);
        welcomeMessageLayout = findViewById(R.id.welcomeMessageLayout);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this, IntroductionActivity.class));
                finish();
            }
        });


    }

}