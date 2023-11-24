package com.teamloopit.e_bookabularyo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.teamloopit.e_bookabularyo.FlipAdapter;
import com.teamloopit.e_bookabularyo.Fragments.FlipFragment;
import com.teamloopit.e_bookabularyo.R;
import com.teamloopit.e_bookabularyo.Utilities;

import java.util.ArrayList;
import java.util.List;


public class FlipActivity extends AppCompatActivity {
    private String storyToShow;
    ViewPager viewPager;

    private String userName;
    private SharedPreferences mPreferences;

    private String sharedPrefFile = "com.teamloopit.e_bookabularyo";

    List<Integer> arguments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_flip);
        InitializeActivity();

        viewPager = findViewById(R.id.viewPager);


        // Determine the story to show in the flip
        switch (storyToShow)
        {
            // if saranggola is the value of the storyToShow, run the method SaraggolaCreated(), vice versa to mabangis
            case "Saranggola":
                SaraggolaCreated();
                break;
            case "Mabangis Na Lungsod":
                MabangisCreated();
                break;
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                saveProgress(position, storyToShow, arguments.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void SaraggolaCreated()
    {
        // declare list int of the arguments to be passed in the fragment
        // arguments is consist of the string resource


        // add the string resoucrs for each swipeable page of the flip fragment
        arguments.add(R.string.saranggola1);
        arguments.add(R.string.saranggola2);
        arguments.add(R.string.saranggola3);
        arguments.add(R.string.saranggola4);
        arguments.add(R.string.saranggola5);
        arguments.add(R.string.saranggola6);
        arguments.add(R.string.saranggola7);
        arguments.add(R.string.saranggola8);
        arguments.add(R.string.saranggola9);
        arguments.add(R.string.saranggola10);
        arguments.add(R.string.saranggola11);

        // create a FlipAdapter with the arguments, background image, title, and author
        FlipAdapter pagerAdapter = new FlipAdapter(getSupportFragmentManager(), arguments, R.drawable.sarang_bg_flip, "Saranggola", "Ni Efren R. Abueg", R.drawable.book_pic_one);
        // set the pager
        viewPager.setAdapter(pagerAdapter);
    }

    private void MabangisCreated()
    {

        arguments.add(R.string.mabangis1);
        arguments.add(R.string.mabangis2);
        arguments.add(R.string.mabangis3);
        arguments.add(R.string.mabangis4);
        arguments.add(R.string.mabangis5);
        arguments.add(R.string.mabangis6);
        arguments.add(R.string.mabangis7);


        FlipAdapter pagerAdapter = new FlipAdapter(getSupportFragmentManager(), arguments, R.drawable.sarang_bg_flip, "Mabangis na Lungsod", "Ni Efren R. Abueg", R.drawable.book_pic_two);
        viewPager.setAdapter(pagerAdapter);
    }

    private void InitializeActivity()
    {
        Intent intent = getIntent();

        String data = intent.getStringExtra("storyTitleData");

        if(data.isEmpty())
        {
            Utilities.ShowCriticalErrorDialog(this, "Failed Argument", "The argument seems to be empty.");
            return;
        }

        storyToShow = data;
    }
    public void navigateToFirstPage() {
        // Implement logic to navigate to the first page of the ViewPager.
        if (viewPager != null) {
            viewPager.setCurrentItem(0, true);
        }
    }

    public void navigateToHome() {
        // Implement logic to navigate to the first page of the ViewPager.
        if (viewPager != null) {
            finish();
        }
    }

    private void saveProgress(int position, String title, int count) {
        SharedPreferences preferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("currentPage", position);
        editor.putInt("currentTotalFragment", count);
        editor.putString("currentTitle", title);
        editor.apply();
    }
}