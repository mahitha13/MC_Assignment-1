package com.example.mahitha.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.content.Context;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button is_incorrect;
    private Button is_correct;
    private Button on_next;
    private Button button_cheat;
    private Button button_hint;
    private int rand_num;
    public static boolean flag_hint = false;
    public static boolean flag_cheat = false;
    public final static String EXTRA_MESSAGE = "com.example.myApplication.MESSAGE";
    public static int answer;

    // function to check if number is prime or not
    public int isPrime(int rand_num) {
        int i, mid = 0, check = 0, ans = 0;
        mid = rand_num / 2;
        for (i = 2; i <= mid; i++) {
            if (rand_num % i == 0) {
                ans = 0;
                check = 1;
                break;
            }
        }
        if (check == 0)
            ans = 1;

        return ans;
    }

    public void init(){
        //text view where random number is generated
        final TextView displayRandomNo = (TextView) findViewById(R.id.textView);

        // Generate a random number
        rand_num = (int) (Math.random() * 1000 +1);
        displayRandomNo.setText(" " + rand_num);

        is_incorrect = (Button) findViewById(R.id.button);
        is_correct = (Button) findViewById(R.id.button2);
        on_next = (Button) findViewById(R.id.button3);

        answer = isPrime(rand_num);

        //Adding new activity
        final Intent intent = new Intent(this, NoQuestion.class);
        String message = "No More Questions available currently!";
        intent.putExtra(EXTRA_MESSAGE, message);

        is_incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (answer == 1) { // gives toast for incorrect answer
                    Context context = getApplicationContext();
                    CharSequence message = "Incorrect Answer!";
                    int duration = Toast.LENGTH_LONG;
                    final Toast toastBasic = Toast.makeText(context, message, duration);
                    toastBasic.show();
                }
                else
                {
                    // gives toast for correct answer
                    Context context = getApplicationContext();
                    CharSequence message = "Congratulations! Correct Answer.";
                    int duration = Toast.LENGTH_LONG;
                    final Toast toastBasic = Toast.makeText(context, message, duration);
                    toastBasic.show();
                }
            }
        });

        is_correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer == 0) { // gives toast for incorrect answer
                    Context context = getApplicationContext();
                    CharSequence message = "Incorrect Answer!";
                    int duration = Toast.LENGTH_LONG;
                    final Toast toastBasic = Toast.makeText(context, message, duration);
                    toastBasic.show();
                }
                else
                { // gives toast for correct answer
                    Context context = getApplicationContext();
                    CharSequence message = "Congratulations! Correct Answer.";
                    int duration = Toast.LENGTH_LONG;
                    final Toast toastBasic = Toast.makeText(context, message, duration);
                    toastBasic.show();
                }
            }
        });

        on_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // new activity starts
                startActivity(intent);
            }
        });

        button_cheat = (Button)findViewById(R.id.button_cheat);
        button_hint = (Button)findViewById(R.id.button_hint);
        button_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HintActivity.class);
                intent.putExtra("flag",flag_hint);
                startActivity(intent);
            }
        });

        button_cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CheatActivity.class);
                intent.putExtra("flag",flag_cheat);
                intent.putExtra("number", rand_num);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(flag_hint == true){
            Toast.makeText(getApplicationContext(), "You have used the hint!" , Toast.LENGTH_LONG).show();
        }
        if(flag_cheat == true){
            Toast.makeText(getApplicationContext(), "You have used the cheat!", Toast.LENGTH_LONG).show();
        }
    }
}