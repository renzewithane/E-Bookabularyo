package com.teamloopit.e_bookabularyo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.teamloopit.e_bookabularyo.R;
import com.teamloopit.e_bookabularyo.Utilities;

public class VideoActivity extends AppCompatActivity {
    private String storyToShow;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_video);
        InitializeActivity();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        videoView = findViewById(R.id.videoView);
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

    }
    private void SaraggolaCreated(){
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sarangg_final);
        videoView.start();
        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
    }
    private void MabangisCreated(){
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.lungsod);
        videoView.start();
        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Check if the orientation has changed
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Handle portrait orientation
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Handle landscape orientation
        }
    }

}