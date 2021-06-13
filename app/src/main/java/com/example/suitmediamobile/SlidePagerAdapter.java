package com.example.suitmediamobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class SlidePagerAdapter extends RecyclerView.Adapter<SlidePagerAdapter.SlideViewHolder>{

    private ArrayList<Event> slideItem;
    private ViewPager2 viewPager2;

    public SlidePagerAdapter(ArrayList<Event> slideItem, ViewPager2 viewPager2) {
        this.slideItem = slideItem;
        this.viewPager2 = viewPager2;
    }

    @Override
    public SlideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SlideViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_image_container,
                        parent, false
                ));
    }

    @Override
    public void onBindViewHolder(SlidePagerAdapter.SlideViewHolder holder, int position) {
        holder.setImage(slideItem.get(position));
    }

    @Override
    public int getItemCount() {
        return slideItem.size();
    }

    class SlideViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;

        public SlideViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_container);
        }

        void setImage(Event event){
            image.setImageResource(event.cEventImages);

            Bundle bundle1 = new Bundle();
            bundle1.putDouble("coordinate1", event.coordinate1);
            bundle1.putDouble("coordinate2", event.coordinate2);
            bundle1.putString("nameEvent", event.cEventName);
            // set Fragmentclass Arguments
            Map fragobj = new Map();
            fragobj.setArguments(bundle1);
        }

    }

}