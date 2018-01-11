package com.ragew.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here

    // TODO: Declare member variables here:
    Button m_TrueButton;
    Button m_FalseButton;
    TextView m_questionView;
    TextView m_scoreView;
    ProgressBar m_progressBar;

    int m_index; // get the index of the questions
    int m_question;
    int m_score;
    boolean m_userAnswer;
    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] //initialized as new TrueFalse
    {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0/mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            m_score = savedInstanceState.getInt("ScoreKey");
            m_index = savedInstanceState.getInt("IndexKey");
        } else {
            m_score = 0;
            m_index = 0;
        }

        m_TrueButton = (Button) findViewById(R.id.true_button);
        m_FalseButton = (Button) findViewById(R.id.false_button);
        m_questionView = (TextView) findViewById(R.id.question_text_view);

        m_question = mQuestionBank[m_index].getQuestionID();
        m_questionView.setText(m_question);

        m_scoreView = (TextView) findViewById(R.id.score);

        m_progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        m_scoreView.setText("Score " + m_score + "/" + mQuestionBank.length);

        m_TrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Quizzap", "True has been pressed");
                checkAnswer(true);
                updateQuestion();
            }
        });

        m_FalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Quizapp", "False has been pressed");
                checkAnswer(false);
                updateQuestion();
            }
        });
    }

    private void updateQuestion(){
        m_index = (m_index + 1) % mQuestionBank.length;
        m_question = mQuestionBank[m_index].getQuestionID();
        m_questionView.setText(m_question);
        if (m_index == 0){
            AlertDialog.Builder m_alert = new AlertDialog.Builder(this);
            m_alert.setTitle("Game Over!");
            m_alert.setMessage("Your score is: " + m_score + ".");
            m_alert.setCancelable(false);
            m_alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            m_alert.show();
//            Toast.makeText(getApplicationContext(),"Your score is: " + m_score + ". Goodbye!", Toast.LENGTH_LONG).show();
        }
    }

    private void checkAnswer(boolean userSelection){
        boolean correctAnswer = mQuestionBank[m_index].isTrueFalse();
        if (userSelection == correctAnswer ){
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_LONG).show();
            m_score = m_score + 1;
            m_scoreView.setText("Score " + m_score + "/" + mQuestionBank.length);
            m_progressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
            
        } else {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_LONG).show();
            m_progressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle offState){
        super.onSaveInstanceState(offState);

        offState.putInt("ScoreKey",m_score);
        offState.putInt("IndexKey",m_index);

    }

}
