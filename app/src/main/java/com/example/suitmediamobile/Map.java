package com.example.suitmediamobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends Fragment implements OnMapReadyCallback {

    Double coordinate1, coordinate2;
    MapView mMapView;
    View mView;
    String nameEvent;
    GoogleMap map;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMapView = (MapView) mView.findViewById(R.id.mapFragment);
        if(mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);


        coordinate1 = 28.633169;
        coordinate2 = 77.248993;
        nameEvent = "Coldplay";

        //ambil dari bundle
        if(getArguments()!=null){
            coordinate1 = getArguments().getDouble("coordinate1");
            coordinate2 = getArguments().getDouble("coordinate2");
            nameEvent = getArguments().getString("nameEvent");
        }

        SupportMapFragment supportMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.mapFragment);


        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                LatLng uniLocation = new LatLng(coordinate1, coordinate2);
                map.addMarker(new MarkerOptions().position(uniLocation).title(nameEvent));
//                map.moveCamera(CameraUpdateFactory.newLatLng(uniLocation));
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(uniLocation, 15));
                //teken Build -> Build Bundle/APK -> Build APK
            }
        });

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        map = googleMap;
        map.addMarker(new MarkerOptions().position(new LatLng(28.633169,77.248993)).title("Status"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(28.633169,77.248993)).zoom(16).bearing(0).tilt(45).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

    }
}
