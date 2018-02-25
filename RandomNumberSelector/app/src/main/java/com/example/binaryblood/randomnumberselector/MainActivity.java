package com.example.binaryblood.randomnumberselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int rand1;
    private int rand2;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = 0;
        randomGenerator();
    }

    // This is my first run at writing an android app
    // --> Fuck this is so cool

    public void leftButtonClick(View view) {
        // todo
        if (rand1 > rand2) {
            score++;
        }
        else {
            score--;
        }
        randomGenerator();
    }

    public void rightButtonClick(View view) {
        // todo
        if (rand2 > rand1) {
            score++;
        }
        else {
            score--;
        }
        randomGenerator();
    }

    public void randomGenerator() {
        // This function assigns both the buttons two random variables to click from
        TextView tv = (TextView) findViewById(R.id.score);
        tv.setText("POINTS: " + score);
        Random random = new Random();
        rand1 = random.nextInt(10);
        while(true) {
            rand2 = random.nextInt(10);
            if (rand1 != rand2) {
                break;
            }
        }

        // Assigning the random generated ints to the buttons display text
        Button leftBtn = (Button) findViewById(R.id.left_button);
        Button rightBtn = (Button) findViewById(R.id.right_button);
        leftBtn.setText(Integer.toString(rand1));
        rightBtn.setText(Integer.toString(rand2));
    }
}
