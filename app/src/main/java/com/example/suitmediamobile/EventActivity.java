package com.example.suitmediamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Event> eventList;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("nameTxt");

        eventList = new ArrayList<>();

        //dummy datas
        Event event1 = new Event("Coldplay Summer Tour", "15 September 2022", R.drawable.event1);
        Event event2 = new Event("New Year New York", "03 July 2022", R.drawable.event2);
        Event event3 = new Event("SeaFood Festival", "14 May 2022", R.drawable.event3);
        Event event4 = new Event("Karate Kid Day", "11 June 2022", R.drawable.event4);
        eventList.add(event1);
        eventList.add(event2);
        eventList.add(event3);
        eventList.add(event4);

        listView = findViewById(R.id.eventListView);
        EventAdapter adapter = new EventAdapter(this, eventList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(this, ProfileActivity.class);
                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                intent.putExtra("nameTxt", name);
                intent.putExtra("eventNameTxt", eventList.get(position).cEventName);
                intent.putExtra("flag", 1);
                startActivity(intent);
            }
        });

    }
}