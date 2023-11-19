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
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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
            // Method: Go to Home
            SwitchToHome(userName);
            return;
        }

        setContentView(R.layout.activity_main);

        proceedButton = findViewById(R.id.proceedButton);
        editTextInputName = findViewById(R.id.ediTextNameInput);

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = editTextInputName.getText().toString().trim();

                // Check
                if(userInput.isEmpty())
                {
                    editTextInputName.setError("This field cannot be empty");
                    return;
                }

                // Store username data
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putString("userName", userInput);
                editor.apply();

                // Method: Go to Home
                SwitchToHome(userInput);

                // End
                finish();

            }
        });
    }

    /**
     * Method for switching the activity to home with extra data
     */
    private void SwitchToHome(String userName)
    {
        // Intent
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);

        // Send Data to home
        intent.putExtra("userData", userName);

        // Proceed to Home
        startActivity(intent);
    }
}