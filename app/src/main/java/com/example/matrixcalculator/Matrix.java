package com.example.matrixcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Matrix extends AppCompatActivity {
    int i,j;
     TextView tv;
    TextView C [] [] = new TextView[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        Intent in = getIntent();
        tv = (TextView)findViewById(R.id.textView5);
        String name = in.getExtras().getString("Extra");
        tv.setText(name);
        Bundle mBundle = getIntent().getExtras();
        String [][] arrayReceived = (String [] [])mBundle.getSerializable("result");
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                String s = "C"+i+j;
                C [i][j] = findViewById(getResources().getIdentifier(s,"id",getPackageName()));
            }
        }
        for(i=0;i<3;i++) {
            for (j = 0; j < 3; j++) {
                C[i][j].setText(arrayReceived[i][j]);
            }
        }


    }
}