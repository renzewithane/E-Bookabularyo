package com.teamloopit.e_bookabularyo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_flip);
        InitializeActivity();

        viewPager = findViewById(R.id.viewPager);


        switch (storyToShow)
        {
            case "Saranggola":
                SaraggolaCreated();
                break;
            case "Mabangis Na Lungsod":
                MabangisCreated();
                break;
        }

    }
    public void SaraggolaCreated()
    {
        List<Integer> arguments = new ArrayList<>();

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

        FlipAdapter pagerAdapter = new FlipAdapter(getSupportFragmentManager(), arguments, R.drawable.sarang_bg_flip, "Saranggola", "Ni Efren R. Abueg");
        viewPager.setAdapter(pagerAdapter);
    }

    private void MabangisCreated()
    {

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
}