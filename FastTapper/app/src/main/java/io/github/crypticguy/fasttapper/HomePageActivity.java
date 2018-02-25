package io.github.crypticguy.fasttapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void playTheGame(View view) {
        Intent playGame = new Intent(this, InitializeActivity.class);
        startActivity(playGame);
    }

    public void showTheRules(View view) {
        Intent showRules = new Intent(this, RulesActivity.class);
        startActivity(showRules);
    }
}
