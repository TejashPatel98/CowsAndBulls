package com.example.cowsandbulls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Integer.valueOf;

public class MainActivity extends AppCompatActivity {
    private String str_ran_int= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //makes the textview scrollable
        TextView OutputTV = this.findViewById(R.id.OuputtextView);
        OutputTV.setMovementMethod(new ScrollingMovementMethod());
    }

    public void on_GUESS_button_click(View view) {
        TextView CounterTV = this.findViewById(R.id.CountertextView2);
        TextView OutputTV = this.findViewById(R.id.OuputtextView);
        TextView GuessTV = this.findViewById(R.id.GuesseditText);
        //Number of times the player has submitted a guess

        int num_CounterTV = Integer.valueOf((CounterTV.getText().toString()));
        num_CounterTV += 1;
        CounterTV.setText(Integer.toString(num_CounterTV));


        //if this is first time the user has guessed, generate a random number.
        if (num_CounterTV == 1) {
            Random ran = new Random();
            int ran_int = ran.nextInt(888) + 100;
            str_ran_int = Integer.toString(ran_int);
        }

        //check to see if user input is valid

        String InputtedNum = GuessTV.getText().toString();

        if ((Integer.valueOf(InputtedNum) >= 100) && (Integer.valueOf(InputtedNum) <= 999)) {
            if (Integer.valueOf(InputtedNum) != Math.floor(Integer.valueOf(InputtedNum))) {
                //InputtedNum is not a whole number.
                OutputTV.append("Error: Input is not a integer number." + "\n");
                return;
            }
        } else {
            // InputtedNum is not a number between 0 and 999.
            OutputTV.append("Error: Input is not a number between 100 and 999." + "\n");
            return;
        }

        //Converting each number into an array; ### --> {null,#,#,#}
        int[] Guess_arr = new int[3];
        int[] Ran_int_arr = new int[3];


        for (int i = 0; i <= 2 ; i++)
        {
            Guess_arr[i] = Integer.valueOf(InputtedNum.substring(i, i+1));
            Ran_int_arr[i] = Integer.valueOf(str_ran_int.substring(i, i+1));
        }

        //Determining the number of bulls.
        int bulls_counter = 0;
        for(int i = 0; i <= 2; i++)
        {
            if (Guess_arr[i] == Ran_int_arr[i])
            {
                //they match ...
                bulls_counter += 1;
            }
        }

        //Determining the number of cows.
        int matched_counter = 0;
        for(int i = 0; i <= 2; i++)
        {
            for(int j = 0; j <= 2; j++)
            {
                if(Guess_arr[i] == Ran_int_arr[j])
                {
                    //they match...
                    matched_counter += 1;
                    break;
                }
            }
        }

        int cows_counter = matched_counter - bulls_counter;

        OutputTV.append(Integer.toString(num_CounterTV) + ". You Guessed " + InputtedNum + "| Cows: " + cows_counter + " Bulls: " + bulls_counter + "." + "\n" );

        if(bulls_counter == 3)
        {
            OutputTV.append("       You guessed the number correctly!" + "\n");
        }
    }
    public void on_RESET_button_click(View view)
    {

    }


}
