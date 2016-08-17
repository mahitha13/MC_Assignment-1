package com.example.mahitha.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textOne = (TextView) findViewById(R.id.textView2);
        Button incorrect = ( Button ) findViewById(R.id.button);
        Button correct = ( Button ) findViewById(R.id.button2);
        Button next = ( Button ) findViewById(R.id.button3);

        int randno = (int)(Math.random()*1000);
        incorrect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textOne.setText("Incorrect!");
            }
        });
    }
}
