package com.teamloopit.e_bookabularyo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamloopit.e_bookabularyo.R;
import com.teamloopit.e_bookabularyo.Utilities;

public class StoryActivity extends AppCompatActivity {

    private String storyToShow;
    private MediaPlayer mediaPlayer;

    private TextView title, author;
    private Button read, watch;

    private ImageView bg;
    private String userName;
    private SharedPreferences mPreferences;

    private String sharedPrefFile = "com.teamloopit.e_bookabularyo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(this, R.raw.woodclick);
        InitializeActivity();

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        setContentView(R.layout.activity_story);

        title = findViewById(R.id.bookTitle);
        author = findViewById(R.id.bookAuthor);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        userName = mPreferences.getString("userName", "");

        read = findViewById(R.id.readTitle);

        watch = findViewById(R.id.watchTitle);
        bg = findViewById(R.id.imageViewBG);

        switch (storyToShow)
        {
            case "Saranggola":
                playSound();
                SaraggolaCreated();
                break;
            case "Mabangis Na Lungsod":
                playSound();
                MabangisCreated();
                break;
        }

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoryActivity.this, FlipActivity.class);

                intent.putExtra("storyTitleData", storyToShow);

                startActivity(intent);

            }
        });

        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoryActivity.this, VideoActivity.class);

                intent.putExtra("storyTitleData", storyToShow);

                startActivity(intent);
            }
        });

    }
    public void onBackPressed() {
        Intent intent = new Intent(StoryActivity.this, HomeActivity.class);
        intent.putExtra("userData", userName);
        finish();
        startActivity(intent);
        super.onBackPressed();
    }
    public void SaraggolaCreated()
    {
        title.setText("Saranggola");
        author.setText("Ni Efren R. Abueg");
        bg.setImageResource(R.drawable.book_pic_one);


    }

    private void MabangisCreated()
    {
        title.setText("Mabangis na Lungsod");
        author.setText("Ni Efren R. Abueg");
        bg.setImageResource(R.drawable.book_pic_two);


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

    private void playSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }
}