package com.example.suitmediamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    private Button nextBtn;
    private EditText nameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        nameTxt = findViewById(R.id.nameText);
        nextBtn = findViewById(R.id.nextBtn);

    }

    public void nextActivity(View v) {
        nextBtn.setBackgroundResource(R.drawable.btn_signup_selected);
        Intent intent = new Intent(this, ProfileActivity.class);
        String name = nameTxt.getText().toString();
        intent.putExtra("nameTxt", name);
        startActivity(intent);

    }
}