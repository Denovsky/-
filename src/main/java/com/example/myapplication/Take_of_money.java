package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Take_of_money extends AppCompatActivity implements View.OnClickListener {
    EditText take_of_balance1;
    Button take_of1;
    Button exit1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_of_activity);
        take_of_balance1 = findViewById(R.id.take_of_balance);
        take_of1 = findViewById(R.id.take_of);
        exit1 = findViewById(R.id.exit);
        take_of1.setOnClickListener(this);
        exit1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.take_of:
                Intent intent1 = new Intent();
                if (take_of_balance1.getText().toString().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(), "свали, а?", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    intent1 = intent1.putExtra("num_from", take_of_balance1.getText().toString());
                    setResult(2, intent1);
                    finish();
                }
                break;
            case R.id.exit:
                Intent intent2 = new Intent();
                intent2.putExtra("num_from", "0");
                setResult(2, intent2);
                finish();
                break;
        }
    }
}
