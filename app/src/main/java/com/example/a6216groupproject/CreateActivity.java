package com.example.a6216groupproject;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.widget.ToggleButton;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class CreateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation);

        ToggleButton catToggleButton = (ToggleButton) findViewById(R.id.catToggleButton);

        EditText title = (EditText) findViewById(R.id.titleEditText);
        EditText departureLocation = (EditText) findViewById(R.id.depEditText);
        EditText destination = (EditText) findViewById(R.id.desEditText);
        EditText depTime = (EditText) findViewById(R.id.timeEditText);
        EditText content = (EditText) findViewById(R.id.contentEditText);

        Button postButton = (Button) findViewById(R.id.postButton);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.create);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String catString = "";
                String titleString = title.getText().toString();
                String departureLocationString = departureLocation.getText().toString();
                String destinationString = destination.getText().toString();
                String depTimeString = depTime.getText().toString();
                String contentString = content.getText().toString();

                if (catToggleButton.isChecked()){
                    catString = "Passenger";

                } else {
                    catString = "Driver";
                }


                if (TextUtils.isEmpty(titleString) || TextUtils.isEmpty(departureLocationString)|| TextUtils.isEmpty(destinationString) || TextUtils.isEmpty(depTimeString) || TextUtils.isEmpty(contentString)){
                    Toast.makeText(getApplicationContext(), "Please fill in your post information.", Toast.LENGTH_LONG).show();
                } else {
                    String currentDate = new SimpleDateFormat("M/dd/yyyy", Locale.getDefault()).format(new Date());

                    Intent intent = new Intent(CreateActivity.this, HomeActivity.class);
                    intent.putExtra("catStore", catString);
                    intent.putExtra("titleStore", titleString);
                    intent.putExtra("departureLocationStore", departureLocationString);
                    intent.putExtra("destinationStore", destinationString);
                    intent.putExtra("depTimeStore", depTimeString);
                    intent.putExtra("contentStore", contentString);
                    intent.putExtra("postDateStore", currentDate);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Your Post has been created successfully!", Toast.LENGTH_LONG).show();
                }


            }
        });

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.message:
                        startActivity(new Intent(getApplicationContext(),MessageActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.create:
                        return true;
                }
                return false;
            }
        });
    }
    public void backHomeLayout(View view){
        Intent intent = new Intent(CreateActivity.this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
