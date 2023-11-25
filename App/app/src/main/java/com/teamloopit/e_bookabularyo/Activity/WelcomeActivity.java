package com.teamloopit.e_bookabularyo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamloopit.e_bookabularyo.R;

public class WelcomeActivity extends AppCompatActivity {
    Animation top,left,bot;
    ImageView Logo;
    TextView textView;
    Button button;
    private String sharedPrefFile = "com.teamloopit.e_bookabularyo";

    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Logo = findViewById(R.id.logo);
        textView = findViewById(R.id.text_desc);
        button = findViewById(R.id.nextButton);

        top = AnimationUtils.loadAnimation(this,R.anim.from_top);
        bot = AnimationUtils.loadAnimation(this,R.anim.from_bot);
        left = AnimationUtils.loadAnimation(this,R.anim.from_left);

        Logo.setAnimation(top);
        textView.setAnimation(bot);
        button.setAnimation(left);

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
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }
}