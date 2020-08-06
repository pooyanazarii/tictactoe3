package com.example.tictactoe3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TicTacToeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_ground);
    }
    public void dropIn(View view)
    {
        ImageView img = (ImageView) view;
        img.setImageResource(R.drawable.knife);
    }
}