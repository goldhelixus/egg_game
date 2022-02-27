package com.example.egggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // This is a variable that is used to keep track of the number of eggs left in the game.
    private int mCount = 23;
    // This is a variable that is used to keep track of what player's turn it is.
    private int turn = 0;
    private TextView mShowCount;
    private TextView playerTurn;
    String player_1 = "Player 1's Turn";
    String player_2 = "Player 2's Turn";
    String player_1_win = "Player 1 Wins!";
    String player_2_win = "Player 2 Wins!";
    String debug = "Oh Fuck";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.textView_Remaining);
        playerTurn = (TextView) findViewById(R.id.textView_Turn);
    }

    /**
     * This function is used to pop the image when the user clicks on it
     *
     * @param view The view that will be animated.
     */
    public void pop(View view){
        TextView image = (TextView)findViewById(R.id.textView_Remaining);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pop);
        image.startAnimation(animation1);
    }

    /**
     * This function is used to change the player's turn
     *
     * @param view The view that was clicked.
     */
    public void turn(View view) {
        if (playerTurn != null) {
            switch (turn) {
                case 1:
                    playerTurn.setText(player_1);
                    turn = turn - 1;
                    break;
                case 0:
                    playerTurn.setText(player_2);
                    turn = turn + 1;
                    break;
                default:
                    playerTurn.setText(debug);
                    break;
            }
        }

    }

    /**
     * This function resets the turn to player 1
     *
     * @param view The view that was clicked.
     */
    public void turn_reset(View view) {
        if (playerTurn != null)
            playerTurn.setText(player_1);
        turn = 0;
    }

    /**
     * This function is called when the game is over. It displays the winner of the game
     *
     * @param view The view that was clicked.
     */
    public void victory(View view) {
        if (playerTurn != null) {
            switch (turn) {
                case 0:
                    playerTurn.setText(player_1_win);
                    break;
                case 1:
                    playerTurn.setText(player_2_win);
                    break;
                default:
                    playerTurn.setText(debug);
                    break;

            }
        }
    }


    /**
     * It resets the count to 23 and restarts the game.
     *
     * @param view The view that was clicked.
     */
    public void restart(View view) {
        mCount = 23;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        turn_reset(view);
        pop(view);
    }

    /**
     * If the count is greater than or equal to 3, subtract 3 from the count and update the text view.
     * If the count is 0, display a victory message and pop the stack. If the count is not 0, display a
     * turn message and pop the stack
     *
     * @param view The view that was clicked.
     */
    public void take_3(View view) {
        if (mCount >= 3) {
            mCount = mCount - 3;
            if (mShowCount != null)
                mShowCount.setText(Integer.toString(mCount));
            switch (mCount) {
                case 0:
                    victory(view);
                    pop(view);
                    break;
                default:
                    turn(view);
                    pop(view);
            }
        } else {
            Toast toast = Toast.makeText(this, R.string.toast_warning, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * If the count is greater than or equal to 2, subtract 2 from the count and update the text view.
     * If the count is 0, display a victory message and pop the stack. If the count is not 0, display a
     * turn message and pop the stack
     *
     * @param view The view that was clicked.
     */
    public void take_2(View view) {
        if (mCount >= 2) {
            mCount = mCount - 2;
            if (mShowCount != null)
                mShowCount.setText(Integer.toString(mCount));
            switch (mCount) {
                case 0:
                    victory(view);
                    pop(view);
                    break;
                default:
                    turn(view);
                    pop(view);
            }
        } else {
            Toast toast = Toast.makeText(this, R.string.toast_warning, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * If the count is greater than 0, subtract 1 from the count and update the text view. If the count
     * is 0, display a toast and pop the activity
     *
     * @param view The view that was clicked.
     */
    public void take_1(View view) {
        if (mCount >= 1) {
            mCount = mCount - 1;
            if (mShowCount != null) {
                mShowCount.setText(Integer.toString(mCount));
            }
            switch (mCount) {
                case 0:
                    victory(view);
                    pop(view);
                    break;
                default:
                    turn(view);
                    pop(view);
            }
        } else {
            Toast toast = Toast.makeText(this, R.string.toast_warning, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * Toast a message to the user
     *
     * @param view The view that triggered the event.
     */
    public void help(View view) {
        Toast toast = Toast.makeText(this,R.string.toast_help,Toast.LENGTH_LONG );
        toast.show();
    }
}
