package com.example.suitmediamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView nameTextProfile;
    private Button eventButton, guestButton;
    String eventTextButton, guestTextButton;
    String name;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        flag = 0;

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("nameTxt");

        nameTextProfile = (TextView) findViewById(R.id.nameTextProfile);
        nameTextProfile.setText(name);

        flag = bundle.getInt("flag");
        if(flag == 1){
            eventTextButton = bundle.getString("eventNameTxt");
            eventButton = findViewById(R.id.buttonEvent);
            eventButton.setText(eventTextButton);
        } else if(flag == 2){
            guestTextButton = bundle.getString("guestNameTxt");
            guestButton = findViewById(R.id.buttonGuest);
            guestButton.setText(guestTextButton);
        }

    }

    public void eventFragment(View v) {
        Intent intent = new Intent(this, EventActivity.class);
        intent.putExtra("nameTxt", name);
        startActivity(intent);
    }

    public void guestFragment(View v) {
        Intent intent = new Intent(this, GuestActivity.class);
        intent.putExtra("nameTxt", name);
        startActivity(intent);
    }
}