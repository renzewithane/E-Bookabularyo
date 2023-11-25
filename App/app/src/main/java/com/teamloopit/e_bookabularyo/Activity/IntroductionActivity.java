package com.teamloopit.e_bookabularyo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.teamloopit.e_bookabularyo.R;

public class IntroductionActivity extends AppCompatActivity {

    private Button nextButton;
    private TextView message1, message2;
    private LinearLayout layout1, layout2;

    private ImageView char1, char2;

    int clickIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        char1 = findViewById(R.id.character1Pic);
        char2 = findViewById(R.id.character2Pic);

        layout1 = findViewById(R.id.character1);
        layout2 = findViewById(R.id.character2);

        message1 = findViewById(R.id.character1Message);
        message2 = findViewById(R.id.character2Message);

        nextButton = findViewById(R.id.nextButton);

        clickIndex = 0;

        layout2.setVisibility(View.INVISIBLE);
        message2.setVisibility(View.INVISIBLE);
        char2.setVisibility(View.INVISIBLE);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVisibility(layout1, message1, char1, View.INVISIBLE);
                setVisibility(layout2, message2, char2, View.VISIBLE);
                clickIndex++;
                if(clickIndex == 2)
                {
                    startActivity(new Intent(IntroductionActivity.this, MainActivity.class));



                    finish();
                }
            }
        });


    }

    private void setVisibility(View layout, View message, ImageView image, int visibility) {
        layout.setVisibility(visibility);
        message.setVisibility(visibility);
        image.setVisibility(visibility);
    }
}