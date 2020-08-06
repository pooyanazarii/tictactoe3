package com.example.tictactoe3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.img_play);
        play.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == play.getId())
        {
            startActivity(new Intent(MainActivity.this, TicTacToeActivity.class));
        }
    }
}