package com.example.mahitha.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class HintActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        MainActivity.flag_cheat = true;
        //Toast.makeText(getApplicationContext(), "The flag has been set to"  , Toast.LENGTH_LONG).show();
        textView = (TextView)findViewById(R.id.hint_text);
        textView.setTextSize(40);
        textView.setText(" This is how you check a prime number:\n" +
                "Divide the number by 0 till mid of number. If it is divisible then it is not a prime else it is a prime.");

    }
}
