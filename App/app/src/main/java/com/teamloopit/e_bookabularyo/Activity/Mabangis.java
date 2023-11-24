package com.teamloopit.e_bookabularyo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.PorterDuff;
import android.os.Bundle;

import com.teamloopit.e_bookabularyo.R;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.teamloopit.e_bookabularyo.Fragments.Quiz;
import com.teamloopit.e_bookabularyo.R;
import com.teamloopit.e_bookabularyo.Utilities;

public class Mabangis extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout relativeLayout_test1,relativeLayout_test2,relativeLayout_test3;
    int score_test1_value=0;
    //test1
    TextView questions;
    Button OpA,OpB;
    int totalQuestion = MabangisQA.questions_test1.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    //test1

    //test2
    TextView questions2;
    int score_test2_value=0;
    Button OpA_test2,OpB_test2,OpC_test2;

    int totalQuestion_test2 = MabangisQA.questions_test2.length;
    int currentQuestionIndex_test2 = 0;
    //test2

    //test3

    TextView questions3;
    int score_test3_value=0;
    Button OpA_test3,OpB_test3,OpC_test3,OpD_test3,OpE_test3;

    int totalQuestion_test3 = MabangisQA.questions_test3.length;
    int currentQuestionIndex_test3 = 0;

    //test3

    ///Panuto pop

    LinearLayout panuto;
    TextView panuto_text;
    Button ok;

    RelativeLayout score_board;
    TextView score1, score2,score3;
    Button confirm;

    //Panuto pop

    private Button startQuizButton;
    private TextView quizTitle;
    private String quizTitleStr;
    private RelativeLayout openingStatementLayout;

    private long time = 1500;
    int activity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mabangis);

        panuto = findViewById(R.id.Panuto);
        panuto_text = findViewById(R.id.Panuto_tes2);
        ok = findViewById(R.id.agree_test);

        score_board = findViewById(R.id.alert);
        score1 = findViewById(R.id.score_test1);
        score2 = findViewById(R.id.score_test2);
        score3 = findViewById(R.id.score_test3);
        confirm = findViewById(R.id.done);

        //test1
        relativeLayout_test1 = findViewById(R.id.test1);
        questions = findViewById(R.id.Q1_questions);

        OpA = findViewById(R.id.Q1_A);
        OpB = findViewById(R.id.Q1_B);
        OpA.setOnClickListener(this);
        OpB.setOnClickListener(this);


        //test1

        //test2
        relativeLayout_test2 = findViewById(R.id.test2);
        questions2 = findViewById(R.id.Q2_questions);

        OpA_test2 = findViewById(R.id.Q2_A);
        OpB_test2 = findViewById(R.id.Q2_B);
        OpC_test2 = findViewById(R.id.Q2_C);
        OpA_test2.setOnClickListener(this);
        OpB_test2.setOnClickListener(this);
        OpC_test2.setOnClickListener(this);


        //test2

        //test3

        relativeLayout_test3 = findViewById(R.id.test3);
        questions3 = findViewById(R.id.Q3_questions);

        OpA_test3 = findViewById(R.id.Q3_A);
        OpB_test3 = findViewById(R.id.Q3_B);
        OpC_test3 = findViewById(R.id.Q3_C);
        OpD_test3 = findViewById(R.id.Q3_D);
        OpE_test3 = findViewById(R.id.Q3_E);

        OpA_test3.setOnClickListener(this);
        OpB_test3.setOnClickListener(this);
        OpC_test3.setOnClickListener(this);
        OpD_test3.setOnClickListener(this);
        OpE_test3.setOnClickListener(this);


        //test3


        // Starter

        InitializedMain();

        ShowQuizTime();



    }
    private void StartQuiz()
    {
        panuto_text.setText(R.string.Panuto1);
        panuto.setVisibility(View.VISIBLE);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panuto.setVisibility(View.GONE);
                relativeLayout_test1.setVisibility(View.VISIBLE);
                loadQuestion_tes1();
            }
        });
    }
    private void ShowQuizTime()
    {
        startQuizButton = findViewById(R.id.startQuizAnswerButton);
        quizTitle = findViewById(R.id.quizKwentoTitle);
        openingStatementLayout = findViewById(R.id.openingStatementLayout);

        quizTitle.setText(quizTitleStr);

        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartQuiz();

                openingStatementLayout.setVisibility(View.GONE);
            }
        });
    }

    private void InitializedMain()
    {
        Intent intent = getIntent();

        if (intent == null)
        {
            Utilities.ShowCriticalErrorDialog(this, "Failed Intent", "The app failed to get intent");
            return;
        }
        String data = intent.getStringExtra("storyTitleData");

        if(data.isEmpty())
        {
            Utilities.ShowCriticalErrorDialog(this, "Failed Extra", "The extra seems to be empty!");
            return;
        }

        quizTitleStr = data;
    }
    @Override
    public void onClick(View view) {
        if (relativeLayout_test1.getVisibility() == View.VISIBLE){
            OpA.setBackgroundColor(Color.WHITE);
            OpB.setBackgroundColor(Color.WHITE);
            OpA.setEnabled(false);
            OpB.setEnabled(false);
            Button clickedButton = (Button) view;
            selectedAnswer  = clickedButton.getText().toString();
            if(selectedAnswer.equals(MabangisQA.Correct_answer_test1[currentQuestionIndex])){
                clickedButton.getBackground().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.green), PorterDuff.Mode.MULTIPLY);
                clickedButton.setText("CORRECT");
                score_test1_value++;
            }
            else{
                clickedButton.getBackground().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.red), PorterDuff.Mode.MULTIPLY);
                clickedButton.setText("WRONG");
                selectedAnswer  = clickedButton.getText().toString();


            }

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    currentQuestionIndex++;
                    loadQuestion_tes1();

                }
            },time);
        }

        else if (relativeLayout_test1.getVisibility() == View.GONE && relativeLayout_test2.getVisibility() == View.VISIBLE) {

            OpA_test2.setBackgroundColor(Color.WHITE);
            OpB_test2.setBackgroundColor(Color.WHITE);
            OpC_test2.setBackgroundColor(Color.WHITE);
            OpA_test2.setEnabled(false);
            OpB_test2.setEnabled(false);
            OpC_test2.setEnabled(false);
            Button clickedButton = (Button) view;
            selectedAnswer  = clickedButton.getText().toString();
            if(selectedAnswer.equals(MabangisQA.Correct_answer_test2[currentQuestionIndex_test2])){
                clickedButton.getBackground().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.green), PorterDuff.Mode.MULTIPLY);
                clickedButton.setText("CORRECT");
                score_test2_value++;
            }
            else{
                clickedButton.getBackground().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.red), PorterDuff.Mode.MULTIPLY);
                clickedButton.setText("WRONG");
                selectedAnswer  = clickedButton.getText().toString();


            }

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    currentQuestionIndex_test2++;
                    loadQuestion_tes2();

                }
            },time);
        }
        else if (relativeLayout_test1.getVisibility() == View.GONE && relativeLayout_test2.getVisibility() == View.GONE
                && relativeLayout_test3.getVisibility() == View.VISIBLE) {
            OpA_test3.setBackgroundColor(Color.WHITE);
            OpB_test3.setBackgroundColor(Color.WHITE);
            OpC_test3.setBackgroundColor(Color.WHITE);
            OpD_test3.setBackgroundColor(Color.WHITE);
            OpE_test3.setBackgroundColor(Color.WHITE);
            OpA_test3.setEnabled(false);
            OpB_test3.setEnabled(false);
            OpC_test3.setEnabled(false);
            OpD_test3.setEnabled(false);
            OpE_test3.setEnabled(false);
            Button clickedButton = (Button) view;
            selectedAnswer  = clickedButton.getText().toString();
            if(selectedAnswer.equals(MabangisQA.Correct_answer_test3[currentQuestionIndex_test3])){
                clickedButton.getBackground().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.green), PorterDuff.Mode.MULTIPLY);
                clickedButton.setText("CORRECT");
                score_test3_value++;
            }
            else{
                clickedButton.getBackground().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.red), PorterDuff.Mode.MULTIPLY);
                clickedButton.setText("WRONG");
                selectedAnswer  = clickedButton.getText().toString();


            }

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    currentQuestionIndex_test3++;
                    loadQuestion_tes3();

                }
            },time);
        }


    }
    void loadQuestion_tes1(){
        OpA.setEnabled(true);
        OpB.setEnabled(true);

        OpA.setBackgroundColor(Color.WHITE);
        OpB.setBackgroundColor(Color.WHITE);

        OpA.getBackground().clearColorFilter();
        OpB.getBackground().clearColorFilter();
        if(currentQuestionIndex == totalQuestion ){
            test_Panuto();
            relativeLayout_test1.setVisibility(View.GONE);
            return;
        }

        questions.setText(MabangisQA.questions_test1[currentQuestionIndex]);
        OpA.setText(MabangisQA.Answers_test1[currentQuestionIndex][0]);
        OpB.setText(MabangisQA.Answers_test1[currentQuestionIndex][1]);


    }

    void loadQuestion_tes2(){
        OpA_test2.setEnabled(true);
        OpB_test2.setEnabled(true);
        OpC_test2.setEnabled(true);

        OpA_test2.setBackgroundColor(Color.WHITE);
        OpB_test2.setBackgroundColor(Color.WHITE);
        OpC_test2.setBackgroundColor(Color.WHITE);

        OpA_test2.getBackground().clearColorFilter();
        OpB_test2.getBackground().clearColorFilter();
        OpC_test2.getBackground().clearColorFilter();
        if(currentQuestionIndex_test2 == totalQuestion_test2){

            test_Panuto();
            return;
        }
        if (currentQuestionIndex_test2 == 0){
            questions2.setText(R.string.Q1_test2);
        } else if (currentQuestionIndex_test2 == 1) {
            questions2.setText(R.string.Q2_test2);
        }
        else if (currentQuestionIndex_test2 == 2) {
            questions2.setText(R.string.Q3_test2);
        }
        else if (currentQuestionIndex_test2 == 3) {
            questions2.setText(R.string.Q4_test2);
        }
        else if (currentQuestionIndex_test2 == 4) {
            questions2.setText(R.string.Q5_test2);
        }
        else if (currentQuestionIndex_test2 == 5) {
            questions2.setText(R.string.Q6_test2);
        }
        else if (currentQuestionIndex_test2 == 6) {
            questions2.setText(R.string.Q7_test2);
        }
        else if (currentQuestionIndex_test2 == 7) {
            questions2.setText(R.string.Q8_test2);
        }else if (currentQuestionIndex_test2 == 8) {
            questions2.setText(R.string.Q9_test2);
        }
        else if (currentQuestionIndex_test2 == 9) {
            questions2.setText(R.string.Q10_test2);
        }

        OpA_test2.setText(MabangisQA.Answers_test2[currentQuestionIndex_test2][0]);
        OpB_test2.setText(MabangisQA.Answers_test2[currentQuestionIndex_test2][1]);
        OpC_test2.setText(MabangisQA.Answers_test2[currentQuestionIndex_test2][2]);



    }

    void loadQuestion_tes3(){
        OpA_test3.setEnabled(true);
        OpB_test3.setEnabled(true);
        OpC_test3.setEnabled(true);
        OpD_test3.setEnabled(true);
        OpE_test3.setEnabled(true);

        OpA_test3.setBackgroundColor(Color.WHITE);
        OpB_test3.setBackgroundColor(Color.WHITE);
        OpC_test3.setBackgroundColor(Color.WHITE);
        OpD_test3.setBackgroundColor(Color.WHITE);
        OpE_test3.setBackgroundColor(Color.WHITE);


        OpA_test3.getBackground().clearColorFilter();
        OpB_test3.getBackground().clearColorFilter();
        OpC_test3.getBackground().clearColorFilter();
        OpD_test3.getBackground().clearColorFilter();
        OpE_test3.getBackground().clearColorFilter();

        if(currentQuestionIndex_test3 == totalQuestion_test3){
            relativeLayout_test2.setVisibility(View.GONE);
            finishQuiz();
            return;
        }
        questions3.setText(MabangisQA.questions_test3[currentQuestionIndex_test3]);
        OpA_test3.setText(MabangisQA.Answers_test3[currentQuestionIndex_test3][0]);
        OpB_test3.setText(MabangisQA.Answers_test3[currentQuestionIndex_test3][1]);
        OpC_test3.setText(MabangisQA.Answers_test3[currentQuestionIndex_test3][2]);
        OpD_test3.setText(MabangisQA.Answers_test3[currentQuestionIndex_test3][3]);
        OpE_test3.setText(MabangisQA.Answers_test3[currentQuestionIndex_test3][4]);



    }



    void continue_test2(){
        relativeLayout_test1.setVisibility(View.GONE);
        relativeLayout_test2.setVisibility(View.VISIBLE);
        loadQuestion_tes2();
    }
    void continue_test3(){
        relativeLayout_test2.setVisibility(View.GONE);
        relativeLayout_test3.setVisibility(View.VISIBLE);
        loadQuestion_tes3();
    }

    void finishQuiz(){
        relativeLayout_test3.setVisibility(View.GONE);
        score_board.setVisibility(View.VISIBLE);
        String passStatus_test1 = "";
        String passStatus_test2 = "";
        String passStatus_test3 = "";
        if (score_test1_value >= totalQuestion*0.60){
            passStatus_test1 = "MAHUSAY!";
        }else {
            passStatus_test1 = "GALINGAN PA!";
        }
        if (score_test2_value >= totalQuestion_test2*0.60){
            passStatus_test2 = "MAHUSAY!";
        }else {
            passStatus_test2 = "GALINGAN PA!";
        }
        if (score_test3_value >= totalQuestion_test3*0.60){
            passStatus_test3 = "MAHUSAY!";
        }else {
            passStatus_test3 = "GALINGAN PA!";
        }


        score1.setText(score_test1_value + "/" + totalQuestion + " " + passStatus_test1);
        score2.setText(score_test2_value + "/" + totalQuestion_test2 + " " + passStatus_test2);
        score3.setText(score_test3_value + "/" + totalQuestion_test3 + " " + passStatus_test3);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    void test_Panuto(){
        if (activity == 0){
            panuto_text.setText(R.string.Panuto2_kite);

        } else if (activity == 1) {
            panuto_text.setText(R.string.Panuto3_kite);

        }


        relativeLayout_test2.setVisibility(View.GONE);
        questions.setText("\n \n");
        OpA.setEnabled(false);
        OpB.setEnabled(false);
        panuto.setVisibility(View.VISIBLE);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity == 0){
                    panuto_text.setText(R.string.Panuto2_kite);
                    relativeLayout_test1.setVisibility(View.GONE);
                    panuto.setVisibility(View.GONE);
                    activity++;
                    continue_test2();


                } else if (activity == 1) {
                    panuto_text.setText(R.string.Panuto3_kite);
                    panuto.setVisibility(View.GONE);
                    continue_test3();

                }


            }
        });






    }

}