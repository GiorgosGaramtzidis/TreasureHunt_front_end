package com.ihu.treasurehunt_front_end;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ihu.treasurehunt_front_end.Model.TreasureHuntGame;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static List<MarkerOptions> markerOptionsList;
    private static List<LatLng> latLngList;
    private static List<Marker> markerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(2);
        //mMap.setPadding(400, 100, 100, 0);


        TreasureHuntGame treasureHuntGame = MainActivity.getTreasureHuntGame();


        for (int i=0;i<treasureHuntGame.getLocationsMaps().size();i++){
            LatLng start = new LatLng(treasureHuntGame.getLocationsMaps().get(i).getV(),treasureHuntGame.getLocationsMaps().get(i).getV1());
            MarkerOptions markerOptions = new MarkerOptions().position(start).title(treasureHuntGame.getLocationsMaps().get(i).getTitle());
            Marker marker = mMap.addMarker(markerOptions);
            if (treasureHuntGame.getLocationsMaps().get(i).getId() == 1){
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                continue;
            }
            switch (treasureHuntGame.getLocationsMaps().get(i).getColor()){
                case "BLUE":
                    marker .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                    break;
                case "MAGENTA":
                    marker .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
                    break;
                case "VIOLET":
                    marker .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
                    break;
            }


        }


        LatLng latLng = new LatLng(41.076797,23.553648);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,17));


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                switch (marker.getTitle()){
                    case "bibliothiki":
                        Intent intent = new Intent(MapsActivity.this,QuizActivity.class);
                        startActivity(intent);
                        break;
                    case "Grammatia":
                        Intent intent1 = new Intent(MapsActivity.this,RiddleActivity.class);
                        startActivity(intent1);
                        break;
                    case "Kafeteria":
                        Intent intent2 = new Intent(MapsActivity.this,MultipleChoiceActivity.class);
                        startActivity(intent2);
                }
                return false;
            }
        });


    }
}