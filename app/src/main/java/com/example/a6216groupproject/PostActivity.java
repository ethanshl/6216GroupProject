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
import android.widget.TextView;
import android.widget.ImageView;

public class PostActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        Intent intent = getIntent();
        String titleString = intent.getStringExtra("titleStore");
        String categoryString = intent.getStringExtra("catStore");
        String departureLocationString = intent.getStringExtra("departureLocationStore");
        String destinationString = intent.getStringExtra("destinationStore");
        String depTimeString = intent.getStringExtra("depTimeStore");
        String contentString = intent.getStringExtra("contentStore");
        String currentDate = intent.getStringExtra("postDateStore");

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        TextView title = (TextView) findViewById(R.id.titleTextView);
        TextView username = (TextView) findViewById(R.id.nameTextView);
        TextView profile = (TextView) findViewById(R.id.profileTextView);
        TextView postDate = (TextView) findViewById(R.id.postDateTextView);
        TextView category = (TextView) findViewById(R.id.catTextView);
        TextView departureLocation = (TextView) findViewById(R.id.depLocationTextView);
        TextView destination = (TextView) findViewById(R.id.destinationTextView);
        TextView depTime = (TextView) findViewById(R.id.depTimeTextView);
        TextView content = (TextView) findViewById(R.id.contentTextView);
        ImageView userImage = (ImageView) findViewById(R.id.headImageView);



        if (!TextUtils.isEmpty(titleString) || !TextUtils.isEmpty(departureLocationString)|| !TextUtils.isEmpty(destinationString) || !TextUtils.isEmpty(depTimeString)) {

            title.setText(titleString);
            userImage.setImageResource(R.drawable.user2);
            username.setText("Ethan");
            profile.setText("Demo User");
            postDate.setText(currentDate);
            category.setText(categoryString);
            departureLocation.setText(departureLocationString);
            destination.setText(destinationString);
            depTime.setText(depTimeString);
            content.setText(contentString);

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
        Intent intent = new Intent(PostActivity.this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}

