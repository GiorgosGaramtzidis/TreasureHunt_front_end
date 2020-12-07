package com.ihu.treasurehunt_front_end.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ihu.treasurehunt_front_end.Model.MapLocation;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.JsonPlaceHolderAPI;
import com.ihu.treasurehunt_front_end.Requests.MapLocationList;
import com.ihu.treasurehunt_front_end.Requests.RequestNextLocation;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

import java.util.ArrayList;
import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
    private MapMarkerOptions mapMarkerOptions = new MapMarkerOptions();

    private Button hintButton;

    private LocationListener locationListener;
    private LocationManager locationManager;
    public static TextView textView;
    private GoogleMap mMap;
    Marker motionMarker = null;
    private double distance;
    private LatLng latLng;
    private Marker marker1;



    private MapLocationList mapLocationList;
    private List<MapLocation> mapLocationLists1 = new ArrayList<>();

    private RetroFitCreate retroFitCreate = new RetroFitCreate();
    private RequestNextLocation requestNextLocation = new RequestNextLocation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);


    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(2);
        final LatLng tei = new LatLng(41.076797, 23.553648);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tei, 5));




        marker1 = MainActivity.game.addFirstLocationToMap(mMap);



        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(@NonNull Location location) {

                try {
                    latLng = new LatLng(location.getLatitude(), location.getLongitude());

                    if (motionMarker == null) {
                        MarkerOptions options = new MarkerOptions().position(latLng).title(MainActivity.game.getUserLoggedIn()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                        motionMarker = mMap.addMarker(options);
                    } else {
                        motionMarker.setPosition(latLng);

                    }
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()),16 ));

                    MainActivity.game.DistanceBetween(latLng,marker1);



                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        };

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 5, locationListener);
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        mMap.setOnMarkerClickListener(marker -> {
            if (marker.getTitle().equals(MainActivity.game.getUserLoggedIn())) {
                Toast.makeText(MapsActivity.this, "It's You", Toast.LENGTH_SHORT).show();
                return false;
            }
            else {
                startActivity(new Intent(MapsActivity.this, RiddleActivity.class));
                requestNextLocation.getNextLocation(retroFitCreate.getJsonPlaceHolderAPI(),MainActivity.game.getLocation().getNextLocation());
                new Handler().postDelayed(() -> {
                    MainActivity.game.setLocation(requestNextLocation.getMapLocationNext());
                    marker1 = MainActivity.game.addFirstLocationToMap(mMap);

                },1000);

                return false;
            }
        });



    }

}