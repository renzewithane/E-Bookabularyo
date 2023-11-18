package com.teamloopit.e_bookabularyo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamloopit.e_bookabularyo.R;
import com.teamloopit.e_bookabularyo.Utilities;

public class StoryActivity extends AppCompatActivity {

    private String storyToShow;

    private TextView title, author;
    private Button read, watch;

    private ImageView bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitializeActivity();

        setContentView(R.layout.activity_story);

        title = findViewById(R.id.bookTitle);
        author = findViewById(R.id.bookAuthor);

        read = findViewById(R.id.readTitle);
        watch = findViewById(R.id.watchTitle);
        bg = findViewById(R.id.imageViewBG);

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
        title.setText("Saranggola");
        author.setText("Isunulat ni Efren R. Abueg");
        bg.setImageResource(R.drawable.book_pic_one);

    }

    private void MabangisCreated()
    {
        title.setText("Mabangis na Lunsod");
        author.setText("Isunulat ni Efren R. Abueg");
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
}