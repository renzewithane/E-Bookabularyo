package com.teamloopit.e_bookabularyo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.teamloopit.e_bookabularyo.R;

public class MainActivity extends AppCompatActivity {

    /**
     * Variables
     * SharedPrefs - for storing user usage in the app locally
     */
    private boolean isNewUser;
    private String userName;
    private SharedPreferences mPreferences;

    private String sharedPrefFile = "com.teamloopit.e_bookabularyo";

    private Button proceedButton;
    private EditText editTextInputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Fetch sharedprefs data
        isNewUser = mPreferences.getBoolean("isNewUser", true);
        userName = mPreferences.getString("userName", "");

        // Checks if the user already had used the app
        if (isNewUser)
        {
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();
            return;
        }

        // Checks if the user already stored user name in the app
        if(!userName.isEmpty())
        {
            // Proceed to Home
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            return;
        }

        setContentView(R.layout.activity_main);

        proceedButton = findViewById(R.id.proceedButton);
        editTextInputName = findViewById(R.id.ediTextNameInput);

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = editTextInputName.getText().toString().trim();

                if(userInput.isEmpty())
                {
                    editTextInputName.setError("This field cannot be empty");
                    return;
                }

                // Store username data

                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putString("userName", userInput);
                editor.apply();

                // Proceed to Home
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();

            }
        });
    }
}