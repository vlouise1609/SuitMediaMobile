package com.example.suitmediamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventListFargment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventListFargment extends Fragment {

    ListView listView;
    ArrayList<Event> eventList;
    String name;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EventListFargment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventListFargment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventListFargment newInstance(String param1, String param2) {
        EventListFargment fragment = new EventListFargment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_list_fargment, container, false);
        String strname = getArguments().getString("name");

        eventList = new ArrayList<>();

        //dummy datas
        Event event1 = new Event("Coldplay Summer Tour", "15 September 2022", R.drawable.event1, 28.633169, 77.248993);
        Event event2 = new Event("New Year New York", "03 July 2022", R.drawable.event2, 40.662250, -73.640290);
        Event event3 = new Event("SeaFood Festival", "14 May 2022", R.drawable.event3, -6.175110, 106.865036);
        Event event4 = new Event("Karate Kid Day", "11 June 2022", R.drawable.event4, 31.218399, 121.434563);
        eventList.add(event1);
        eventList.add(event2);
        eventList.add(event3);
        eventList.add(event4);

        listView = view.findViewById(R.id.eventListView);
        EventAdapter adapter = new EventAdapter(view.getContext(), eventList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(this, ProfileActivity.class);
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                intent.putExtra("nameTxt", strname);
                intent.putExtra("eventNameTxt", eventList.get(position).cEventName);
                intent.putExtra("flag", 1);
                startActivity(intent);

            }
        });


        return view;
    }


}





