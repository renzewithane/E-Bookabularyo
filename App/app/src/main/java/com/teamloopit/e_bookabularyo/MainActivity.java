package com.teamloopit.e_bookabularyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private boolean isNewUser;
    private final boolean NewUserKey;
    private SharedPreferences mPreferences;
    public MainActivity(boolean NewUser) {
        this.NewUserKey = NewUser;
    }

    private String sharedPrefFile = "com.teamloopit.e_bookabularyo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);


    }
}