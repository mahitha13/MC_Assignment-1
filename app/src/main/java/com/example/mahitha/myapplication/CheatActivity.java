package com.example.mahitha.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        MainActivity.flag_cheat = true;

        //Toast.makeText(getApplicationContext(), "The flag has been set to"  , Toast.LENGTH_LONG).show();
        textView = (TextView)findViewById(R.id.cheat_text);
        textView2 = (TextView) findViewById(R.id.random_text);
        textView.setTextSize(40);
        int rand_no = getIntent().getExtras().getInt("number");
        textView2.setText(" "+ rand_no);
        if(MainActivity.answer == 0)
        {
            textView.setText("This number is NOT prime! ");
        }
        if(MainActivity.answer == 0)
        {
            textView.setText("This number is prime!! ");
        }

    }
}
