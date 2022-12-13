package com.example.a6216groupproject;

import android.app.Activity;
import android.os.Bundle; // for saving state information
import android.text.TextUtils;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText; // for bill amount input
import android.widget.TextView;
import android.widget.Toast;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        Button postButton = (Button) findViewById(R.id.post1Button);
        Intent intent = getIntent();
        TextView title = (TextView) findViewById(R.id.titleTextView);
        TextView category = (TextView) findViewById(R.id.catTextView);
        TextView departureLocation = (TextView) findViewById(R.id.depTextView);
        TextView destination = (TextView) findViewById(R.id.desTextView);
        TextView depTime = (TextView) findViewById(R.id.depTimeTextView);
        TextView username= (TextView) findViewById(R.id.userTextView);
        String usernameString = intent.getStringExtra("usernameStore");
        String titleString = intent.getStringExtra("titleStore");
        String categoryString = intent.getStringExtra("catStore");
        String departureLocationString = intent.getStringExtra("departureLocationStore");
        String destinationString = intent.getStringExtra("destinationStore");
        String depTimeString = intent.getStringExtra("depTimeStore");
        String contentString = intent.getStringExtra("contentStore");





        if (!TextUtils.isEmpty(titleString) || !TextUtils.isEmpty(departureLocationString)|| !TextUtils.isEmpty(destinationString) || !TextUtils.isEmpty(depTimeString)) {
            title.setText(titleString);
            category.setText(categoryString);
            departureLocation.setText("Departure Location: " + departureLocationString);
            destination.setText("Destination Location: " + destinationString);
            depTime.setText("Departure Time: " + depTimeString);
            username.setText("By: " + usernameString);

            postButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(HomeActivity.this, PostActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.putExtra("usernameStore", usernameString);
                    intent.putExtra("titleStore", titleString);
                    intent.putExtra("catStore", categoryString);
                    intent.putExtra("departureLocationStore", departureLocationString);
                    intent.putExtra("destinationStore", destinationString);
                    intent.putExtra("depTimeStore", depTimeString);
                    intent.putExtra("contentStore", contentString);
                    startActivity(intent);


                }
            });
        }

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
                        return true;
                    case R.id.create:
                        startActivity(new Intent(getApplicationContext(),CreateActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
    public void postLayout(View view){
        Intent intent = new Intent(HomeActivity.this, PostActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}