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

public class NewPostActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_post);



        TextView title = (TextView) findViewById(R.id.newTitle);
        TextView category = (TextView) findViewById(R.id.catTextView);
        TextView departureLocation = (TextView) findViewById(R.id.newDepLocation);
        TextView destination = (TextView) findViewById(R.id.newDestination);
        TextView depTime = (TextView) findViewById(R.id.newDepTime);
        TextView content = (TextView) findViewById(R.id.newContent);

        Intent intent = getIntent();
        String usernameString = intent.getStringExtra("usernameStore");
        String titleString = intent.getStringExtra("titleStore");
        String categoryString = intent.getStringExtra("catStore");
        String departureLocationString = intent.getStringExtra("departureLocationStore");
        String destinationString = intent.getStringExtra("destinationStore");
        String depTimeString = intent.getStringExtra("depTimeStore");
        String contentString = intent.getStringExtra("contentStore");

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);


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
                        startActivity(new Intent(getApplicationContext(),CreateActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
    public void backHomeLayout(View view){
        Intent intent = new Intent(NewPostActivity.this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
