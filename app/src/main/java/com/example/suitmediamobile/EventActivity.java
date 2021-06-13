package com.example.suitmediamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    String name;
    Button mapViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("nameTxt");

        Bundle bundle1 = new Bundle();
        bundle1.putString("name", name);
        // set Fragmentclass Arguments
        EventListFargment fragobj = new EventListFargment();
        fragobj.setArguments(bundle1);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragobj)
                .addToBackStack(null)
                .commit();

        Map fragobj2 = new Map();
        fragobj2.setArguments(bundle1);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragobj)
                .addToBackStack(null)
                .commit();

    }

    public void fragmentEvent(View v) {
        EventFragment eventFragment = new EventFragment();
        AppCompatActivity activity = (AppCompatActivity) v.getContext();

        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, eventFragment)
                .addToBackStack(null)
                .commit();

    }


}