package com.example.a6216groupproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String usernameAcc = "unset";
    String passwordAcc = "unset";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Intent intent = getIntent();
        String usernameString = intent.getStringExtra("usernameStore");
        String passwordString = intent.getStringExtra("passwordStore");

        EditText username = (EditText) findViewById(R.id.loginUsername);
        EditText password = (EditText) findViewById(R.id.loginPassword);
        Button loginButton = (Button) findViewById(R.id.loginButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameType = username.getText().toString();
                String passwordType = password.getText().toString();

                if (TextUtils.isEmpty(usernameString) || TextUtils.isEmpty(passwordString)){
                    Toast.makeText(getApplicationContext(), "Please fill in your account information.", Toast.LENGTH_LONG).show();
                } else if (!usernameType.equals(usernameString) || !passwordType.equals(passwordString)){
                    Toast.makeText(getApplicationContext(), "Username or Password is incorrect.", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("usernameStore", usernameString);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Login successfully!", Toast.LENGTH_LONG).show();
                }


            }
        });
    }



    public void registerLayout(View view){
        Intent intent = new Intent(MainActivity.this, SignupActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}