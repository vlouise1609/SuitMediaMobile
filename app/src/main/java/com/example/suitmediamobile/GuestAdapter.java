package com.example.suitmediamobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GuestAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Guest> guestList;

    public GuestAdapter(@NonNull Context context, ArrayList<Guest> guests){
        this.context = context;
        this.guestList = guests;
    }

    public void setGuestLists(ArrayList<Guest> listGuests) {
        this.guestList = listGuests;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return guestList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_event, null);
        }


        ImageView guestImg = convertView.findViewById(R.id.guestImage);
        TextView guestName = convertView.findViewById(R.id.guestName);

        guestName.setText(guestList.get(position).getName());
        guestImg.setImageResource(guestList.get(position).getGuestImage());

        return convertView;
    }
}
