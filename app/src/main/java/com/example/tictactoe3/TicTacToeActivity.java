package com.example.tictactoe3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class TicTacToeActivity extends AppCompatActivity {
    public static final int KNIFE = 0;
    public static final int SHIELD = 1;
    public static final int NOT_PLAYED = 2;
    private static final int NO_WINNER = -1;
    int winner =NO_WINNER;

    int [] gameState = {NOT_PLAYED, NOT_PLAYED, NOT_PLAYED,
                     NOT_PLAYED, NOT_PLAYED, NOT_PLAYED,
                     NOT_PLAYED, NOT_PLAYED, NOT_PLAYED
    };

    int [][] winingPostion={
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{1,5,8},
            {0,4,8},{2,4,6}
    };

    int activePlayer = KNIFE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_ground);
        Random randomPlayer = new Random();
        activePlayer = (randomPlayer.nextInt(2));
        Toast.makeText(this, ""+activePlayer, Toast.LENGTH_SHORT).show();
    }
    public void dropIn(View view)
    {
        int tag = Integer.parseInt((String) view.getTag());   // Casting String to integer
        if(winner != NO_WINNER || gameState[tag] != NOT_PLAYED)
        {
            return;
        }

        ImageView img = (ImageView) view;
        img.setTranslationY(-2000f);
        //img.animate().translationY(0f).rotationBy(360*10).setDuration(500);
        if(activePlayer == KNIFE)
        {
            img.setImageResource(R.drawable.knife);
            img.animate().translationY(0f).setDuration(150);
            gameState[tag]=KNIFE;
            activePlayer = SHIELD;
        }else if(activePlayer == SHIELD)
        {
            img.setImageResource(R.drawable.shield);
            img.animate().translationY(0f).setDuration(150);
            gameState[tag]=SHIELD;
            activePlayer = KNIFE;
        }
        //Check Winner
        winner = checkWinner();
        if(winner != NO_WINNER)
        {
            Toast.makeText(this, winner+" =Winner : "+ ((winner == KNIFE)? "KNIFE Win":"SHIELD win"), Toast.LENGTH_SHORT).show();
        }



    }


    //no Winnder -1
    //KNIFE winner KNIFE_CODE
    //SHIELD winner SHIELD_CODE
    public int checkWinner()
    {

      for ( int[] position : winingPostion)
      { if(     gameState[position[2]] != NOT_PLAYED &&
                  gameState[position[0]] == gameState[position[1]] &&
                  gameState[position[1]] == gameState[position[2]]         )
          {
              return gameState[position[0]];
          }
      }
      return  NO_WINNER;
    }
}