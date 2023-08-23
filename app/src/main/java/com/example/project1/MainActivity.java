package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /* needs the implement onClickListener since the activity is basically acting like a listener */

    public static final String GameDifficulty = "com.example.project1.GameDifficulty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button easy = (Button) findViewById(R.id.Easy);
        easy.setOnClickListener(this);
        Button medium = (Button) findViewById(R.id.Medium);
        medium.setOnClickListener(this);
        Button hard = (Button) findViewById(R.id.Hard);
        hard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.Easy) {
            /* Getting the view of the button since that was what was clicked*/
            Button mode = (Button) view;
            String gameMode = mode.getText().toString();

            /* Used intent so that we can send the game mode to the activity */
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra(GameDifficulty,gameMode);
            startActivity(intent);
            System.exit(0);
        }
        else if (view.getId() == R.id.Medium){
            /* Getting the view of the button since that was what was clicked*/
            Button mode = (Button) view;
            String gameMode = mode.getText().toString();

            /* Used intent so that we can send the game mode to the activity */
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra(GameDifficulty,gameMode);
            startActivity(intent);
            System.exit(0);
        }
        else if (view.getId() == R.id.Hard){
            /* Getting the view of the button since that was what was clicked*/
            Button mode = (Button) view;
            String gameMode = mode.getText().toString();

            /* Used intent so that we can send the game mode to the activity */
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra(GameDifficulty,gameMode);
            startActivity(intent);
            System.exit(0);
        }
    }

}