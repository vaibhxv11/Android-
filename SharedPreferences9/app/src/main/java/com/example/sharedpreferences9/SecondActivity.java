package com.example.sharedpreferences9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewNames;
    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREFS_NAME = "shared_prefs";
    private static final String KEY_NAMES = "names";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewNames = findViewById(R.id.textViewNames);
        sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);

        Set<String> names = sharedPreferences.getStringSet(KEY_NAMES, new HashSet<String>());
        StringBuilder namesToDisplay = new StringBuilder();
        for (String name : names) {
            namesToDisplay.append(name).append("\n");
        }
        textViewNames.setText(namesToDisplay.toString());
    }
}
