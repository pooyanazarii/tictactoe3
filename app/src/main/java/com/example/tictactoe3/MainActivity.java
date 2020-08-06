package com.example.tictactoe3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rel = findViewById(R.id.lay_about_msg);
        rel.setVisibility(View.GONE);

    }

    public void onClickPlay(View v) {
            startActivity(new Intent(MainActivity.this, TicTacToeActivity.class));
    }

    public void aboutUs(View v) {
        rel.setVisibility(View.VISIBLE);

    }

    public void exit(View v) {
        finish();
    }
    public void closeLy(View v) {
        rel.setVisibility(View.GONE);
    }
}