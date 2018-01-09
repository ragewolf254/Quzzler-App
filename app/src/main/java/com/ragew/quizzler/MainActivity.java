package com.ragew.quizzler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here
    Button m_TrueButton;
    Button m_FalseButton;
    Context m_context;
    // TODO: Declare member variables here:


    // TODO: Uncomment to create question bank
//    private TrueFalse[] mQuestionBank = new TrueFalse[] {
//            new TrueFalse(R.string.question_1, true),
//            new TrueFalse(R.string.question_2, true),
//            new TrueFalse(R.string.question_3, true),
//            new TrueFalse(R.string.question_4, true),
//            new TrueFalse(R.string.question_5, true),
//            new TrueFalse(R.string.question_6, false),
//            new TrueFalse(R.string.question_7, true),
//            new TrueFalse(R.string.question_8, false),
//            new TrueFalse(R.string.question_9, true),
//            new TrueFalse(R.string.question_10, true),
//            new TrueFalse(R.string.question_11, false),
//            new TrueFalse(R.string.question_12, false),
//            new TrueFalse(R.string.question_13,true)
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_TrueButton = (Button) findViewById(R.id.true_button);
        m_FalseButton = (Button) findViewById(R.id.false_button);

        m_TrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Quizzap", "True has been pressed");
                Toast.makeText(getApplicationContext(),"True button has been pressed!", Toast.LENGTH_LONG).show();
            }
        });

        m_FalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Quizapp", "False has been pressed");
                Toast.makeText(getApplicationContext(), "False button has been pressed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
