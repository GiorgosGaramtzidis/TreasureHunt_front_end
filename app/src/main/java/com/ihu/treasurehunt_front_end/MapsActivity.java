package com.ihu.treasurehunt_front_end;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ihu.treasurehunt_front_end.Model.TreasureHuntGame;
import java.util.ArrayList;
import java.util.List;
import static com.google.maps.android.SphericalUtil.computeDistanceBetween;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
 {

    private LocationListener locationListener;
    private LocationManager locationManager;
    public static ProgressBar progressBar;
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
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
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
        //mMap.setPadding(400, 100, 100, 0);
        final LatLng tei = new LatLng(41.076797, 23.553648);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tei, 17));

        MarkerOnMap();

        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(@NonNull Location location) {
                try {
                    latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    if (motionMarker == null) {
                        MarkerOptions options = new MarkerOptions().position(latLng).title("Player 1");
                        motionMarker = mMap.addMarker(options);
                    } else {
                        motionMarker.setPosition(latLng);
                    }
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()),16 ));

                    DistanceBetween();


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
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker)
            {
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


    void MarkerOnMap() {
        TreasureHuntGame treasureHuntGame = MainActivity.getTreasureHuntGame();

        for (int i = 0; i < treasureHuntGame.getLocationsMaps().size(); i++) {
            LatLng latLng = new LatLng(treasureHuntGame.getLocationsMaps().get(i).getV(), treasureHuntGame.getLocationsMaps().get(i).getV1());
            //MarkerOptions markerOptions = new MarkerOptions().position(latLng);
            MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(treasureHuntGame.getLocationsMaps().get(i).getTitle());
            Marker marker = mMap.addMarker(markerOptions);
            markerList.add(marker);
            marker.setVisible(false);

            }
        }

     void DistanceBetween(){
         for (int i = 0; i < 4; i++) {
             distance = computeDistanceBetween(latLng, markerList.get(i).getPosition());
             markerList.get(i).setVisible(distance <= 50);

         }
     }

}
