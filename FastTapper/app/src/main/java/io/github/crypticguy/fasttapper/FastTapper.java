package io.github.crypticguy.fasttapper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FastTapper extends AppCompatActivity {
    Intent intent;
    private boolean cooldown; // Time lag after a successful play
    private CountDownTimer cdt; // CountDownTimer keeper variable
    private boolean ready; // Checks the condition if buttons are clickable
    private int score1; // Score for player1
    private int score2; // Score for player2
    private CharSequence p1; // text For holder of player1
    private CharSequence p2; // text For holder of player2
    final private int finalScore = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_tapper);
        ready = false;
        cooldown = false;
        score1 = 0;
        score2 = 0;
        intent = getIntent();
        CharSequence p1 = intent.getStringExtra("player1");
        CharSequence p2 = intent.getStringExtra("player2");
        gameLoop();
    }

    private void gameLoop() {
        // The main game loop goes here
        Intent showResult = new Intent(this, ShowResult.class);
        if (score1 == finalScore || score2 == finalScore) {
            if (score1 > score2) {
                showResult.putExtra("Winner", p1);
                startActivity(showResult);
            }
            else {
                showResult.putExtra("Winner", p2);
                startActivity(showResult);
            }
        }
        else {
            Random shuch = new Random();
            int rand = shuch.nextInt(5) + 2;
            countdownTimerFunc(rand * 1000);
        }
    }

    private void countdownTimerFunc(int millis) {
        cdt = new CountDownTimer(millis, 1000) {
            TextView tv = (TextView) findViewById(R.id.countdownTimer);
            public void onTick(long millisUntilFinished) {
                tv.setText("READYYY...SET...");
            }

            public void onFinish() {
                // When its ready to be clicked
                tv.setText("TAP");
                ready = true;
            }
        }.start();
    }

    public void restartGame(View view) {
        // Game will be restarted when pressed here
        if (!cooldown) {
            Button pressed = (Button) view;
            CharSequence text = "You Cliked " + pressed.getText();
            if (!ready) {
                //playerToast(text);
                cdt.cancel();
                if (pressed.getText().equals(p1)) {
                    score1--;
                    updateScore(1, score1, p1);
                } else {
                    score2--;
                    updateScore(2, score2, p2);
                }
                playerToast(pressed.getText() + " pressed early and loses a point!");
            } else {
                cooldown = true;
                if (pressed.getText().equals(p1)) {
                    score1++;
                    updateScore(1, score1, p1);
                } else {
                    score2++;
                    updateScore(2, score2, p2);
                }
                playerToast(pressed.getText() + " pressed first and gets a point!");
                ready = false;
                oneSecDelay();
            }
            gameLoop();
        }
    }

    private void updateScore(int player, int score, CharSequence targetElem) {
        TextView target;
        if (player == 1) {
            target = (TextView) findViewById(R.id.ScoreArea_1);
        }
        else {
            target = (TextView) findViewById(R.id.ScoreArea_2);
        }
        target.setText(targetElem + ": " + score);
    }

    private void playerToast(CharSequence text) {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }

    public void oneSecDelay() {
        cdt = new CountDownTimer(1000, 1000) {
            TextView tv = (TextView) findViewById(R.id.countdownTimer);
            @Override
            public void onTick(long millisUntilFinished) {
                tv.setText("READYYY...SET...");
            }

            @Override
            public void onFinish() {
                cooldown = false;
            }
        }.start();
    }
}