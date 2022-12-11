package com.example.a6216groupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;



public class SignupActivity extends Activity {
    String usernameAcc = "unset";
    String passwordAcc = "unset";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        EditText username = (EditText) findViewById(R.id.registerUsername);
        EditText password = (EditText) findViewById(R.id.registerPassword);
        EditText passwordConfirm = (EditText) findViewById(R.id.registerPasswordConfirm);
        Button registerButton = (Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString = username.getText().toString();
                String passwordString = password.getText().toString();
                String passwordConfirmString = passwordConfirm.getText().toString();

                if (TextUtils.isEmpty(usernameString) || TextUtils.isEmpty(passwordString)|| TextUtils.isEmpty(passwordConfirmString)){
                    Toast.makeText(getApplicationContext(), "Please fill in your account information.", Toast.LENGTH_LONG).show();
                } else if (! passwordString.equals(passwordConfirmString)){
                    Toast.makeText(getApplicationContext(), "Passwords must match!", Toast.LENGTH_LONG).show();
                } else {
                    usernameAcc =  usernameString;
                    passwordAcc = passwordString;
                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                    intent.putExtra("usernameStore", usernameString);
                    intent.putExtra("passwordStore", passwordString);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Your Account has been created successfully!", Toast.LENGTH_LONG).show();
                }


            }
        });


        }

}
