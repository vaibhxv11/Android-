package com.example.sharedpreferences9;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private EditText inputName;
    private Button buttonSave, buttonShow;
    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREFS_NAME = "shared_prefs";
    private static final String KEY_NAMES = "names";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.inputName);
        buttonSave = findViewById(R.id.buttonSave);
        buttonShow = findViewById(R.id.buttonShow);
        sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                if (!name.isEmpty()) {
                    Set<String> names = sharedPreferences.getStringSet(KEY_NAMES, new HashSet<String>());
                    names.add(name);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putStringSet(KEY_NAMES, names);
                    editor.apply();
                    inputName.setText(""); // Clear input field after saving
                }
            }
        });

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}


