package com.example.seconddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seconddemo.databinding.ActivityGameBinding;

import java.util.Random;


public class Game extends AppCompatActivity {

    TextView textView;
    ActivityGameBinding activityGameBinding;
    Button rollButton;
    ImageView imageView;
    Random random;
    int luckyNumber;
    TextView attemptTextView;
    boolean flag;
    int count = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_game);
        activityGameBinding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(activityGameBinding.getRoot());
        textView = activityGameBinding.welcomeID;
        rollButton = activityGameBinding.rollButtonId;
        imageView = activityGameBinding.imageViewID;
        attemptTextView = activityGameBinding.attemptTextId;
        flag = false;
        Intent intent = getIntent();
        String name = intent.getStringExtra("myName");
        textView.setText(name);
        attemptTextView.setText("You have "+count+" attempt(s)");
        random = new Random();
        luckyNumber = random.nextInt(6) + 1;
        //To see the lucky number on Logcat
        Log.i("number", luckyNumber+" lucky");
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = random.nextInt(6)+1;
                //To see the generated random number on Logcat
                Log.i("number", number+"");
                switch (number) {
                    case 1:
                        imageView.setImageResource(R.drawable.dice_1);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.dice_2);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.dice_3);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.dice_4);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.dice_5);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.dice_6);
                        break;
                }
                attemptTextView.setText("You have "+(--count)+" more attempt(s)");
                if(number == luckyNumber){
                    flag = true;
                    Toast.makeText(getApplicationContext(), "Congratulations! You won the game.", Toast.LENGTH_LONG).show();
                    finish();
                }
                if (count == 0){
                    Toast.makeText(getApplicationContext(), "Better luck next time! Try again.", Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        });
    }
}