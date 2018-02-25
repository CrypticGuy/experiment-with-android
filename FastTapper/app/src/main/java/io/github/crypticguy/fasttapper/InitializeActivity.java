package io.github.crypticguy.fasttapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InitializeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize);
    }

    public void initializeGame(View view) {
        EditText et1 = (EditText)findViewById(R.id.player1);
        String p1 = String.valueOf(et1.getText());
        EditText et2 = (EditText)findViewById(R.id.player2);
        String p2 = String.valueOf(et2.getText());
        if (!p1.isEmpty() && !p2.isEmpty()) {
            Intent initialize = new Intent(this, FastTapper.class);
            initialize.putExtra("player1", p1);
            initialize.putExtra("player2", p2);
            startActivity(initialize);
        }
    }
}
