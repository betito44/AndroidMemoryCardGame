package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent2 = getIntent();
        String Score = intent2.getStringExtra(MainActivity2.FinalScore);

        TextView txtView = (TextView) findViewById(R.id.CongratsScore);
        txtView.setText(Score);

    }

    public void PlayAgain(View view) {
        Intent NewGame = new Intent(this, MainActivity.class);
        startActivity(NewGame);
        System.exit(0);
    }

    public void ExitGame(View view) {
        System.exit(0);
    }

}
