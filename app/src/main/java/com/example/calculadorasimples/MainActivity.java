package com.example.calculadorasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Declare elements
    EditText edtNbr1;
    EditText edtNbr2;
    TextView txtRes;
    Typeface monofettFont;
    Typeface tekoFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize elements
        edtNbr1 = (EditText) findViewById(R.id.edtNbr1);
        edtNbr2 = (EditText) findViewById(R.id.edtNbr2);
        txtRes = (TextView) findViewById(R.id.txtRes);
        monofettFont = Typeface.createFromAsset(getAssets(), "fonts/Monofett-Regular.ttf");
        tekoFont = Typeface.createFromAsset(getAssets(), "fonts/Teko-SemiBold.ttf");
        edtNbr1.setTypeface(tekoFont);
        edtNbr2.setTypeface(tekoFont);
        txtRes.setTypeface(monofettFont);

    }

    public void compute(View v){

        //Setup animation
        v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_animation));

        //Declare variables
        String firstInputAsText = edtNbr1.getText().toString();
        String secondInputAsText = edtNbr2.getText().toString();
        double firstNumber = 0;
        double secondNumber = 0;
        double resultAsNumber = 0;

        //Toast.makeText(this, "OK", Toast.LENGTH_LONG);

        //Validate inputs
        if(!firstInputAsText.isEmpty() && !secondInputAsText.isEmpty()){
            firstNumber = Double.parseDouble(firstInputAsText);
            secondNumber = Double.parseDouble(secondInputAsText);
        }

        //Get tag
        String operation = v.getTag().toString();

        //Setup result
        if(operation.equals("addition")){
            resultAsNumber = firstNumber + secondNumber;
        }
        else if(operation.equals("subtraction")){
            resultAsNumber = firstNumber - secondNumber;
        }
        else if(operation.equals("multiplication")){
            resultAsNumber = firstNumber * secondNumber;
        }
        else if(operation.equals("division")){
            resultAsNumber = firstNumber / secondNumber;
        }
        else if(operation.equals("remainder")){
            resultAsNumber = firstNumber % secondNumber;
        }else if(operation.equals("exponent")){
            resultAsNumber = Math.pow(firstNumber, secondNumber);
        }

        DecimalFormat formatter = new DecimalFormat("#,###.##");
        String resultAsText = formatter.format(resultAsNumber);
        txtRes.setText(resultAsText);

    }
}