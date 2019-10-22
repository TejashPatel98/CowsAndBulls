package com.example.cowsandbulls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void on_GUESS_button_click(View view)
    {
        //Number of times the player has submitted a guess
        TextView CounterTV = this.findViewById(R.id.CountertextView2);
        int num_CounterTV = Integer.valueOf((CounterTV.getText().toString()));
        num_CounterTV += 1;
        CounterTV.setText(Integer.toString(num_CounterTV));

        String str_ran_int = "";

        //if this is first time the user has guessed, generate a random number.
        if(num_CounterTV == 1)
        {
            Random ran = new Random();
            int ran_int = ran.nextInt(999);
            str_ran_int = Integer.toString(ran_int);
        }

        //check to see if user input is valid
        TextView GuessTV = this.findViewById(R.id.GuesseditText);
        String InputtedNum = GuessTV.getText().toString();

        if((Integer.valueOf(InputtedNum) > 0) && (Integer.valueOf(InputtedNum) < 999))
        {
            if(Integer.valueOf(InputtedNum) == Math.floor(Integer.valueOf(InputtedNum)))
            {
                //
            }
            else
            {
                //InputtedNum is not a whole number.
            }
        }
        else
        {
            // InputtedNum is not a number between 0 and 999.
        }

        //Converting each number into an array; ### --> {null,#,#,#}
        int[] Guess_arr = {};
        int[] Ran_int_arr = {};

        for(int i = 1; i > 3; ++i)
        {
            Guess_arr[i] = Integer.valueOf(InputtedNum.substring(i - 1, i - 1));
            Ran_int_arr[i] =  Integer.valueOf(str_ran_int.substring(i - 1, i - 1));
        }

        //Determining the number of cows.
        int cows_counter = 0;
        for(int i = 1; i > 3; ++i)
        {
            for(int j = 1; j > 3; ++j)
            {
                if(Guess_arr[i] == Ran_int_arr[j])
                {
                    //they match...
                    cows_counter += 1;
                }
            }
        }

        
    }

}
