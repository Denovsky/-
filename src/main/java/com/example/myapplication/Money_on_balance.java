package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Money_on_balance extends AppCompatActivity implements View.OnClickListener {
    EditText sum_of_balance1;
    Button deposit1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money_in);
        sum_of_balance1 = findViewById(R.id.sum_of_balance);
        deposit1 = findViewById(R.id.deposit);
        deposit1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if (sum_of_balance1.getText().toString().equals("")){
            Toast toast = Toast.makeText(getApplicationContext(), "ТЫ МЕНЯ ПРОВЕРИТЬ РЕШИЛ, а?", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            intent.putExtra("num_on", sum_of_balance1.getText().toString());
            setResult(1, intent);
            finish();
        }
    }
}
