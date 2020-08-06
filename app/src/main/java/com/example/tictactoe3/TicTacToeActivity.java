package com.example.tictactoe3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };

    int activePlayer = KNIFE;
    RelativeLayout msgLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_ground);
        setRandomPlayer();
        msgLayout = findViewById(R.id.msg_layout);
        msgLayout.setVisibility(View.GONE);

    }
    private void setRandomPlayer()
    {
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
        winnerMsg();



    }

    private void winnerMsg() {
        winner = checkWinner();
        if(winner != NO_WINNER || filled())
        {
            String msg = "";
            if(winner == NO_WINNER)
            {
                msg= "No Winner";
                msgLayout.setBackgroundColor(Color.argb(220,207,26,52));
            }else if (winner == KNIFE)
            {
                msg = "Knife Player Winner";
                msgLayout.setBackgroundColor(Color.argb(220,128,215,255));
                ((ImageView)findViewById(R.id.img_winner)).setImageResource(R.drawable.knife);

            }else if(winner == SHIELD)
            {
                msg = "Shield Player Winner";
                msgLayout.setBackgroundColor(Color.argb(220,244,255,129));
                ((ImageView)findViewById(R.id.img_winner)).setImageResource(R.drawable.shield);
            }


//            String win_MSG = (winner ==KNIFE)? "Knife Won " :
//                    (winner == SHIELD) ? "Shield Won" :
//                            (winner == NO_WINNER)? "NO Winner":"Error MSG";
            ((TextView)msgLayout.findViewById(R.id.winner_message)).setText(msg);
            msgLayout.setVisibility(View.VISIBLE);
        }
    }


    //no Winnder -1
    //KNIFE winner KNIFE_CODE
    //SHIELD winner SHIELD_CODE
    public int checkWinner()
    {

      for ( int[] position : winingPostion)
      { if(
                  gameState[position[0]] == gameState[position[1]] &&
                  gameState[position[1]] == gameState[position[2]] &&
                          gameState[position[0]] != NOT_PLAYED )
          {
              return gameState[position[0]];
          }
      }
      return  NO_WINNER;
    }


    public boolean filled(){
        for(int i = 0 ; i < gameState.length ; i++)
        {
            if (gameState[i] == NOT_PLAYED)
            {
                return false;
            }
        }
        return true;
    }

    public void reset(View v){
        //active Player-------------------------------------------------------Reset
        setRandomPlayer();

        //winner--------------------------------------------------------------Reset
        winner = NO_WINNER;

        //game state----------------------------------------------------------Reset
        for(int i = 0 ; i<gameState.length; i++)
        {
            gameState[i]=NOT_PLAYED;
        }

        //play ground--------------------------------------------------------Reset
        LinearLayout pgLayout = (LinearLayout) findViewById(R.id.pg_layout);
        for ( int i = 0 ; i< pgLayout.getChildCount(); i++)
            {
          //  Toast.makeText(this, "pg.Layout, ChildCount = "+pgLayout.getChildCount(), Toast.LENGTH_SHORT).show();
            LinearLayout row = (pgLayout.getChildAt(i) instanceof LinearLayout) ?
            (LinearLayout) pgLayout.getChildAt(i) : null ;

            if (row == null ) return;

            for(int j = 0 ; j < row.getChildCount(); j++)
                {
                    Toast.makeText(this, "iv. = "+row.getChildCount(), Toast.LENGTH_SHORT).show();
                    ImageView iv = (row.getChildAt(j) instanceof ImageView) ?
                            (ImageView) row.getChildAt(j) : null ;
                    if (iv == null ) return;
                    iv.setImageResource(0);
                }

            }

        //show layout End----------------------------------------------------------Rest
        msgLayout.setVisibility(View.GONE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Reset").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                reset(null);
                return false;
            }
        }).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }
}