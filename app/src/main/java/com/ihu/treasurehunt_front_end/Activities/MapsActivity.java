package com.ihu.treasurehunt_front_end.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.CheckUserState;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

import java.util.Objects;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
    private MapMarkerOptions mapMarkerOptions = new MapMarkerOptions();

    private Button hintButton;
    private RetroFitCreate retroFitCreate = new RetroFitCreate();
    private CheckUserState checkUserState = new CheckUserState();
    private LocationListener locationListener;
    private LocationManager locationManager;
    public static TextView textView;
    private GoogleMap mMap;
    Marker motionMarker = null;
    private LatLng latLng;
    protected static Marker marker;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        hintButton = (Button)findViewById(R.id.button);
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

        marker = MainActivity.game.addFirstLocationToMap(mMap);



        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(@NonNull Location location) {

                try {
                    latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    if (motionMarker == null) {
                        MarkerOptions options = new MarkerOptions().position(latLng).title(MainActivity.game.getUserLoggedIn()).icon(mapMarkerOptions.bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_person_pin_circle_24));
                        motionMarker = mMap.addMarker(options);
                    } else {
                        motionMarker.setPosition(latLng);
                    }
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()),16 ));

                    marker = MainActivity.game.addFirstLocationToMap(mMap);

                    MainActivity.game.DistanceBetween(latLng,marker);




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
            checkUserState.checkUserState(retroFitCreate.getJsonPlaceHolderAPI());
            if (marker.getTitle().equals(MainActivity.game.getUserLoggedIn())) {
                Toast.makeText(MapsActivity.this, "It's You", Toast.LENGTH_SHORT).show();
                return false;
            }
            else if (marker.getTitle().equals("end")){
                Toast.makeText(MapsActivity.this, "YOU WON!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (MapsActivity.this, GameWinActivity.class);
                intent.putExtra("WINNER",MainActivity.game.getUserLoggedIn());
                startActivity(intent);
                return false;
            }
            else {
                new Handler().postDelayed(() -> {
                    String stateUserToWIN = checkUserState.getUserToWIN();
                    if (stateUserToWIN.equals("PLAYING")) {
                        startActivity(new Intent(MapsActivity.this, RiddleActivity.class));
                    } else {
                        Intent intent = new Intent (MapsActivity.this, GameWinActivity.class);
                        intent.putExtra("WINNER", stateUserToWIN);
                        startActivity(intent);
                    }
               }, 750);
                return false;
            }
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

}


