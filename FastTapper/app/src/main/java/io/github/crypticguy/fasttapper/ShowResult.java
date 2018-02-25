package io.github.crypticguy.fasttapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        Intent getWinner = getIntent();
        String winner = getWinner.getStringExtra("Winner");
        TextView winnerDisp = (TextView)findViewById(R.id.winnerHere);
        winnerDisp.setText("Winner is: " + winner);
    }

    public void backToMenu(View view) {
        Intent goToMenu = new Intent(this, HomePageActivity.class);
        startActivity(goToMenu);
    }
}
