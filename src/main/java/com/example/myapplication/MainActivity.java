package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    public String user_login = "";
    public String user_password = "";
    Button enter1;
    EditText passwordText;
    EditText loginText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginText = findViewById(R.id.login);
        passwordText = findViewById(R.id.password);
        enter1 = findViewById(R.id.enter);
        enter1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Toast toast;
        Intent intent;
        if ((loginText.getText().toString().equals(user_login)) && (passwordText.getText().toString().equals(user_password))) {
            toast = Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT);
            toast.show();
            intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("loginText", loginText.getText().toString());
            startActivity(intent);
        }
        else {
            toast = Toast.makeText(getApplicationContext(), "Wrong login or password", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}