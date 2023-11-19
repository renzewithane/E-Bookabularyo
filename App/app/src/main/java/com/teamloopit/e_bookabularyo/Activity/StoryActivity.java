package com.teamloopit.e_bookabularyo.Activity;

import androidx.appcompat.app.AppCompatActivity;

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

    private TextView title, author;
    private Button read, watch;

    private ImageView bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitializeActivity();

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

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

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoryActivity.this, FlipActivity.class);

                intent.putExtra("storyTitleData", storyToShow);

                startActivity(intent);
            }
        });

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