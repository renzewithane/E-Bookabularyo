package com.teamloopit.e_bookabularyo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.teamloopit.e_bookabularyo.Fragments.AboutUs;
import com.teamloopit.e_bookabularyo.Fragments.Home;
import com.teamloopit.e_bookabularyo.Fragments.Quiz;
import com.teamloopit.e_bookabularyo.Fragments.Settings;
import com.teamloopit.e_bookabularyo.R;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.teamloopit.e_bookabularyo.Utilities;

public class HomeActivity extends AppCompatActivity {

    private MeowBottomNavigation bottomNavigation;

    private TextView txtView_UserName;

    private String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        InitializeMain();

        bottomNavigation = findViewById(R.id.bottomNavigation);

        InitializeHomeFragment();

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_quiz_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_person_24));

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                Fragment selectedFragment = null;
                Bundle args = new Bundle();

                switch (model.getId()) {
                    case 1:
                        selectedFragment = new Home();
                        args.putString("userData", userName);
                        selectedFragment.setArguments(args);
                        break;
                    case 2:
                        selectedFragment = new Quiz();
                        args.putString("userData", userName);
                        selectedFragment.setArguments(args);
                        break;
                    case 3:
                        selectedFragment = new AboutUs();
                        break;
                    default:
                        selectedFragment = new Home();
                        args.putString("userData", userName);
                        selectedFragment.setArguments(args);

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();

                return null;
            }
        });




    }

    private void InitializeMain(){

        Intent intent = getIntent();

        if (intent == null)
        {
            Utilities.ShowCriticalErrorDialog(this, "Failed Intent", "The app failed to get intent");
            return;
        }
        String data = intent.getStringExtra("userData");



        userName = data;
    }

    private void InitializeHomeFragment()
    {
        Home home = new Home();
        Bundle args = new Bundle();
        args.putString("userData", userName);
        home.setArguments(args);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, home).commit();
    }

}