package com.example.a6216groupproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle; // for saving state information
import android.text.TextUtils;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText; // for bill amount input
import android.widget.Toast;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String usernameAcc = "unset";
    String passwordAcc = "unset";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText username = (EditText) findViewById(R.id.loginUsername);
        EditText password = (EditText) findViewById(R.id.loginPassword);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        Intent intent = getIntent();
        String usernameStore = intent.getStringExtra("usernameStore");
        String passwordStore = intent.getStringExtra("passwordStore");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString = username.getText().toString();
                String passwordString = password.getText().toString();

                if (TextUtils.isEmpty(usernameString) || TextUtils.isEmpty(passwordString)){
                    Toast.makeText(getApplicationContext(), "Please fill in your account information.", Toast.LENGTH_LONG).show();
                } else if (!usernameString.equals(usernameStore) || !passwordString.equals(passwordStore)){
                    Toast.makeText(getApplicationContext(), "Username or Password is incorrect.", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent2 = new Intent(MainActivity.this, HomeActivity.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent2);
                    Toast.makeText(getApplicationContext(), "Login successfully!", Toast.LENGTH_LONG).show();
                }


            }
        });
    }



    public void registerLayout(View view){
        Intent intent3 = new Intent(MainActivity.this, SignupActivity.class);
        intent3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent3);
    }
}