package com.ihu.treasurehunt_front_end.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ihu.treasurehunt_front_end.R;

import java.util.ArrayList;
import java.util.List;

import static com.google.maps.android.SphericalUtil.computeDistanceBetween;


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
    List<Marker> markerList = new ArrayList<Marker>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MainActivity.appContainer.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        hintButton = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tei, 17));

        MarkerOnMap();

        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(@NonNull Location location) {

                try {
                    latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    if (motionMarker == null) {
                        MarkerOptions options = new MarkerOptions().position(latLng).title("Player 1").icon(mapMarkerOptions.bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_person_pin_circle_24));
                        motionMarker = mMap.addMarker(options);
                    } else {
                        motionMarker.setPosition(latLng);
                    }
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()),16 ));

                    DistanceBetween(MainActivity.game.getPositionOfLocation());


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
            startActivity(new Intent (MapsActivity.this,RiddleActivity.class));
            return false;
        });

        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

    }

    void openDialog(){
        HintDialog hintDialog = new HintDialog();
        hintDialog.show(getSupportFragmentManager(),"Hint dialog");
    }

    void MarkerOnMap() {
        for (int i = 0; i < MainActivity.appContainer.mapLocationList.getMapLocationList().size(); i++) {
            LatLng latLng = new LatLng(MainActivity.appContainer.mapLocationList.getMapLocationList().get(i).getV()
                    ,MainActivity.appContainer.mapLocationList.getMapLocationList().get(i).getV1());
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(latLng)
                    .title(MainActivity.appContainer.mapLocationList
                            .getMapLocationList()
                            .get(i)
                            .getTitle()).icon(mapMarkerOptions.bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_check_24));
            Marker marker = mMap.addMarker(markerOptions);
            markerList.add(marker);
            marker.setVisible(false);
        }
    }

    void DistanceBetween(int markerToMakeVisible){
        if(MainActivity.game.getPositionOfLocation()==0) {
            distance = computeDistanceBetween(latLng, markerList.get(markerToMakeVisible).getPosition());
            markerList.get(markerToMakeVisible).setVisible(distance <= 50);
        }
        else {
            distance = computeDistanceBetween(latLng, markerList.get(markerToMakeVisible).getPosition());
            markerList.get(markerToMakeVisible-1).setVisible(false);
            markerList.get(markerToMakeVisible).setVisible(distance <= 50);
        }
        }
    }

