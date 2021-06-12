package com.example.suitmediamobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Event> {

    Context context;
    ArrayList<Event> eventList;
    LayoutInflater inflater;
    TextView aEventName, aEventTime;
    ImageView aEventPicture;

    public EventAdapter(@NonNull Context context, ArrayList<Event> events) {
        super(context, R.layout.row_event, events);
        this.context = context;
        this.eventList = events;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_event, null);
        }

        aEventName = convertView.findViewById(R.id.eventName);
        aEventTime = convertView.findViewById(R.id.eventTime);
        aEventPicture = convertView.findViewById(R.id.eventPicture);

        //Set text and picture
        aEventName.setText(eventList.get(position).cEventName);
        aEventTime.setText(eventList.get(position).cEventTime);
        aEventPicture.setImageResource(eventList.get(position).cEventImages);

        return convertView;
    }
}
