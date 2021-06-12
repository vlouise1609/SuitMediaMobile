package com.example.suitmediamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GuestActivity extends AppCompatActivity {

    ArrayList<Guest> guestList;
    GridView gridView;
    public static ArrayList<Guest> guestList1 = new ArrayList<>();
    JsonTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);


//        Retrofit retrofit = ApiClient.getRetrofit();
//        Api service = retrofit.create(Api.class);

//        Call<Guest> listData = service.getGuest();
//        listData.enqueue(new Callback<Guest>() {
//            @Override
//            public void onResponse(Call<Guest> call, Response<Guest> response) {
//                Guest guestData = response.body();
//                guestList.add(guestData);
//                //guestAdapter.setGuestLists(guestList);
//
//                gridView = findViewById(R.id.gridView);
//                GuestAdapter guestAdapter = new GuestAdapter(getApplicationContext(), guestList);
//                gridView.setAdapter(guestAdapter);
//
//            }
//
//            @Override
//            public void onFailure(Call<Guest> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Connection failed!",
//                        Toast.LENGTH_LONG).show();
//            }
//        })

        gridView = findViewById(R.id.gridView);

        task = new JsonTask();
        task.execute();
        GuestAdapter guestAdapter = new GuestAdapter(this, guestList1);
        gridView.setAdapter(guestAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = guestList1.get(position).getBirthdate();
                String cut = str.substring(8, 10);
                int date = Integer.parseInt(cut);

                if(date%2==0 && date%3==0){
                    Toast.makeText(getApplicationContext(),"IOS",Toast.LENGTH_SHORT).show();
                }else if(date%2==0){
                    Toast.makeText(getApplicationContext(),"Blackberry",Toast.LENGTH_SHORT).show();
                }else if(date%3==0){
                    Toast.makeText(getApplicationContext(),"Android",Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                intent.putExtra("guestNameTxt", guestList1.get(position).getName());
                intent.putExtra("flag", 2);
                startActivity(intent);
            }
        });

    }



}