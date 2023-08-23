package com.example.project1;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.GridLayout;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;
import java.util.Date;


public class MainActivity2 extends AppCompatActivity {

    public int ClickCounter = 0;
    public int choices = 0;
    public String Pick1;
    public String Pick2;
    ImageView FirstImagePicked;
    ImageView SecondImagePicked;
    int Targetsolved;
    int CurrentSolved=0;
    public static final String FinalScore = "com.example.project1.FinalScore";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_activity);

        /* Gets me the Difficulty */
        Intent intent = getIntent();
        String Difficulty = intent.getStringExtra(MainActivity.GameDifficulty);
        if (Difficulty.equalsIgnoreCase("Easy")) {
            Targetsolved = 4;
            newEasyGame();
        } else if (Difficulty.equalsIgnoreCase("Medium")) {
            Targetsolved = 16;
            newMediumGame();
        } else if (Difficulty.equalsIgnoreCase("Hard")) {
            Targetsolved = 36;
            newHardmGame();
        }
    }

    void newEasyGame() {

        //creates gridlayout with imagebuttons
        GridLayout gridLayout = findViewById(R.id.GridLayout);
        int column = 2;
        gridLayout.setColumnCount(column);

        CardHandler EasyGame = new CardHandler();
        String Cards[] = EasyGame.imageIDeasy;
        int IndexCards[] = EasyGame.createShuffledArray(Cards);

        /* why doesnt ViewGroup.LayoutParams.WRAP_CONTENT work*/
        for (int i = 0; i < column * column; i++) {
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    300,
                    400
            );

            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(param);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.backofcard, null));
            gridLayout.addView(imageView);

/*
            ImageButton coverCard = new ImageButton(this);
            coverCard.setLayoutParams(param);
            coverCard.setImageResource(R.drawable.backofcard);
            gridLayout.addView(coverCard);
*/
            final int finalI = i; //
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int id = getResources().getIdentifier(Cards[IndexCards[finalI]], "drawable", "com.example.project1");
                    imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), id, null));
                    getResources().getIdentifier(Cards[IndexCards[finalI]], "drawable", "com.example.project1");
                    ClickCounter = ClickCounter + 1;
                    String score = Integer.toString(ClickCounter);
                    TextView txtView = (TextView) findViewById(R.id.ClickCount);
                    txtView.setText(score);

                    if (choices == 0) {
                        FirstImagePicked = imageView;
                        Pick1 = Cards[IndexCards[finalI]];
                    } else if (choices == 1) {
                        imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), id, null));
                        SecondImagePicked = imageView;
                        Pick2 = Cards[IndexCards[finalI]];

                    }

                    choices = choices + 1;


                    if (choices == 2) {
                        final Handler handler = new Handler();
                        handler.postDelayed(r, 500);
                        choices = 0;
                    }

                }
            });
        }




    }
final Runnable r = new Runnable() {
    @Override
    public void run() {
        checkCards();
    }
};

    void checkCards() {
        SystemClock.sleep(500);
        if (Pick1 == Pick2) {
            SecondImagePicked.setVisibility(View.GONE);
            FirstImagePicked.setVisibility(View.GONE);
            CurrentSolved = CurrentSolved + 2;
            if (Targetsolved == CurrentSolved) {
                solved();
            }
        } else {
            SecondImagePicked.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.backofcard, null));
            FirstImagePicked.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.backofcard, null));
        }

    }


    void newMediumGame() {

        //creates gridlayout with imagebuttons
        GridLayout gridLayout = findViewById(R.id.GridLayout);
        int column = 4;
        gridLayout.setColumnCount(column);

        CardHandler EasyGame = new CardHandler();
        String Cards[] = EasyGame.imageIDmedium;
        int IndexCards[] = EasyGame.createShuffledArray(Cards);

        /* why doesnt ViewGroup.LayoutParams.WRAP_CONTENT work*/
        for (int i = 0; i < column * 4; i++) {
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    200,
                    250
            );

            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(param);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.backofcard, null));
            gridLayout.addView(imageView);

            final int finalI = i; //
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = getResources().getIdentifier(Cards[IndexCards[finalI]], "drawable", "com.example.project1");

                    imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), id, null));
                    ClickCounter = ClickCounter + 1;
                    String score = Integer.toString(ClickCounter);
                    TextView txtView = (TextView) findViewById(R.id.ClickCount);
                    txtView.setText(score);

                    if (choices == 0) {
                        FirstImagePicked = imageView;
                        Pick1 = Cards[IndexCards[finalI]];
                    } else if (choices == 1) {
                        SecondImagePicked = imageView;
                        Pick2 = Cards[IndexCards[finalI]];
                    }

                    choices = choices + 1;

                    if (choices == 2) {
                        final Handler handler = new Handler();
                        handler.postDelayed(r, 500);
                        choices = 0;
                    }



                }
            });
        }

    }

    void solved() {
        /* Used intent so that we can send the game mode to the activity */
        Intent intent2 = new Intent(this, MainActivity3.class);
        String CurrentSolvedstr = Integer.toString(ClickCounter);
        intent2.putExtra(FinalScore,CurrentSolvedstr);
        startActivity(intent2);
        System.exit(0);
    }

    void newHardmGame() {

        //creates gridlayout with imagebuttons
        GridLayout gridLayout = findViewById(R.id.GridLayout);
        int column = 6;
        gridLayout.setColumnCount(column);

        CardHandler EasyGame = new CardHandler();
        String Cards[] = EasyGame.imageIDhard;
        int IndexCards[] = EasyGame.createShuffledArray(Cards);

        /* why doesnt ViewGroup.LayoutParams.WRAP_CONTENT work*/
        for (int i = 0; i < column * 6; i++) {
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    125,
                    150
            );

            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(param);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.backofcard, null));
            gridLayout.addView(imageView);

            final int finalI = i; //
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = getResources().getIdentifier(Cards[IndexCards[finalI]], "drawable", "com.example.project1");

                    imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), id, null));
                    ClickCounter = ClickCounter + 1;
                    String score = Integer.toString(ClickCounter);
                    TextView txtView = (TextView) findViewById(R.id.ClickCount);
                    txtView.setText(score);

                    if (choices == 0) {
                        FirstImagePicked = imageView;
                        Pick1 = Cards[IndexCards[finalI]];
                    } else if (choices == 1) {
                        SecondImagePicked = imageView;
                        Pick2 = Cards[IndexCards[finalI]];
                    }

                    choices = choices + 1;

                    if (choices == 2) {
                        final Handler handler = new Handler();
                        handler.postDelayed(r, 500);
                        choices = 0;
                    }



                }
            });
        }

    }
}