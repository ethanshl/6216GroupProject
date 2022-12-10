package com.example.a6216groupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.CompoundButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnFocusChangeListener;



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
                String usernameString = (String) username.getText().toString();
                String passwordString = (String) password.getText().toString();
                String passwordConfirmString = (String) passwordConfirm.getText().toString();

                if (usernameString == "" || passwordString == "" || passwordConfirmString == ""){
                    Toast.makeText(getApplicationContext(), "Please fill in your account information.", Toast.LENGTH_LONG).show();
                } else if (passwordString != passwordConfirmString){
                    Toast.makeText(getApplicationContext(), "Passwords must match!", Toast.LENGTH_LONG).show();
                } else {
                    usernameAcc =  usernameString;
                    passwordAcc = passwordString;
                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Please fill in your account information.", Toast.LENGTH_LONG).show();
                }


            }
        });


        }

}
