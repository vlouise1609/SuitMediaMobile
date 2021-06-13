package com.example.suitmediamobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private TextView nameTextProfile;
    private Button eventButton, guestButton;
    String eventTextButton, guestTextButton;
    String name;
    int flag = 0;
    AlertDialog.Builder builder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        flag = 0;
        name = "";

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("nameTxt");

        if(name==null){
            name="";
        }

        builder = new AlertDialog.Builder(this);
        CheckPalindrome(name);

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

    public void openDialog(String message){
        builder.setMessage(message).setCancelable(false)
                                    .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    });
        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle("Palindrome");
        alertDialog.show();
    }

    public void CheckPalindrome(String name)
    {
        String original, reverse = ""; // Objects of String class
        original = name;
        int length = name.length();
        for ( int i = length - 1; i >= 0; i-- )
            reverse = reverse + name.charAt(i);
        if (original.equals(reverse)) {
            openDialog("Name is a palindrome");
            //Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
        }
        else {
            openDialog("Name is not a palindrome");
            //Toast.makeText(getApplicationContext(),"Name is not a palindrome",Toast.LENGTH_SHORT).show();
        }
    }

}