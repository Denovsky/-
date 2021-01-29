package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    int balance;
    int another_balance_int;
    String another_balance_str;
    Button convert;
    Button take_of;
    Button sum_in;
    TextView score;
    TextView greeting2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        greeting2 = findViewById(R.id.greet2);
        score = findViewById(R.id.score);
        sum_in = findViewById(R.id.button);
        take_of = findViewById(R.id.button2);
        convert = findViewById(R.id.button3);
        sum_in.setOnClickListener(this);
        take_of.setOnClickListener(this);
        convert.setOnClickListener(this);

        String text = ("Wellcome, " + getIntent().getStringExtra("loginText"));
        String text2 = ("Your balance: " + balance);
        score.setText(text2);
        greeting2.setText(text);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()) {
            case R.id.button:
                intent = new Intent(SecondActivity.this, Money_on_balance.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.button2:
                intent = new Intent(SecondActivity.this, Take_of_money.class);
                startActivityForResult(intent, 2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent;

        /* кнопка пополнения счёта */
        if(resultCode == 1){
            another_balance_int = Integer.parseInt(data.getStringExtra("num_on"));
            balance = balance + another_balance_int;
            another_balance_str = Integer.toString(balance);
            Toast toast = Toast.makeText(getApplicationContext(), data.getStringExtra("num_on"), Toast.LENGTH_LONG);
            toast.show();
            String text2 = ("Your balance: " + another_balance_str);
            score.setText(text2);
        }

        /* кнопка снятия с счёта */
        else if(resultCode == 2){
            another_balance_int = Integer.parseInt(data.getStringExtra("num_from"));
            if (balance - another_balance_int >= 0) {
                balance = balance - another_balance_int;
                another_balance_str = Integer.toString(balance);
                Toast toast = Toast.makeText(getApplicationContext(), data.getStringExtra("num_from"), Toast.LENGTH_LONG);
                toast.show();
                String text2 = ("Your balance: " + another_balance_str);
                score.setText(text2);
            }
            else if (balance - another_balance_int < 0) {
                Toast toast = Toast.makeText(getApplicationContext(), "Сумма баланса не может быть меньше нуля", Toast.LENGTH_LONG);
                toast.show();
                intent = new Intent(SecondActivity.this, Take_of_money.class);
                startActivityForResult(intent, 2);
            }
            else {
                Toast toast = Toast.makeText(getApplicationContext(), "ТЫ ВЫШЕЛ", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}