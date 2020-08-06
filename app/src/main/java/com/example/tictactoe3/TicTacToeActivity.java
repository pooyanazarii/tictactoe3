package com.example.tictactoe3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class TicTacToeActivity extends AppCompatActivity {
    public static final int KNIFE = 0;
    public static final int SHIELD = 1;
    public static final int NOT_PLAYED = 2;

    int [] status = {NOT_PLAYED, NOT_PLAYED, NOT_PLAYED,
                     NOT_PLAYED, NOT_PLAYED, NOT_PLAYED,
                     NOT_PLAYED, NOT_PLAYED, NOT_PLAYED
    };

    int activePlayer = KNIFE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_ground);
        Random randomPlayer = new Random();
        activePlayer = (randomPlayer.nextInt(1));
    }
    public void dropIn(View view)
    {
        ImageView img = (ImageView) view;
        img.setTranslationY(-2000f);
        img.setImageResource(R.drawable.knife);
        //img.animate().translationY(0f).rotationBy(360*10).setDuration(500);
        img.animate().translationY(0f).setDuration(150);
    }
}