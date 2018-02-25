package io.github.crypticguy.fasttapper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RulesActivity extends AppCompatActivity {

    String[] rules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        rules = getResources().getStringArray(R.array.ruleList);
        ListView rulesList = (ListView)findViewById(R.id.ruleList);
        ArrayAdapter<String> rulesOfTheGame = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rules);
        rulesList.setAdapter(rulesOfTheGame);
    }


}
