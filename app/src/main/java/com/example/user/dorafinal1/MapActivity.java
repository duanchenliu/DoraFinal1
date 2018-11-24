package com.example.user.dorafinal1;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLoadedCallback {
    //public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLoadedCallback, GoogleMap.OnMarkerClickListener {
    private GoogleMap map;
    private LatLng myLocation;
    private LatLng latLng;
    private double lat1,lon1;
    private HospitalRecord hr;
//    private String country;  //= "unknown country";
    private String country;
    double lat = 42.6556, lng = -70.6208;
    Geocoder geocoder = null;
    ArrayList<String> locations; //will contain all the locations

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Mapper");
        actionBar.setDisplayHomeAsUpEnabled(true);  //helps with returning to our MainActivity

        geocoder = new Geocoder(this);
        locations = new ArrayList<String>();

        // This fetches the addresses from a bundle and places them in an ArrayList
        // ArrayList will be used later by GeoCoder
        Intent arts = getIntent();
        Bundle bundle = arts.getExtras();

        hr = (HospitalRecord) bundle.getSerializable("hospital");

        lat1 = hr.getLat();
        lon1 = hr.getLng();

        String msg = "Lng: " + hr.getLng()+ " Lat: " + hr.getLat();
        Log.v("in map",msg);
        System.out.println(msg);
        //gets the maps to load
        MapFragment mf = (MapFragment) getFragmentManager().findFragmentById(R.id.the_map);
        mf.getMapAsync(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //this will catch the <- arrow
        //and return to MainActivity
        //needed since we use fragments to map sites
        switch (item.getItemId()) {
            case android.R.id.home:
                System.out.println("1. here here in go back");
                Intent intent = new Intent(this, emergencyRoomActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                System.out.println("2. here here in go back");
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {    // map is loaded but not laid out yet
        this.map = map;
        map.setOnMapLoadedCallback(this);      // calls onMapLoaded when layout done
        UiSettings mapSettings;
        mapSettings = map.getUiSettings();
        mapSettings.setZoomControlsEnabled(true);
    }

    // maps are loaded and this is where I should perform the getMoreInfo() to grab more data
    //note use of geocoder.getFromLocationName() to find LonLat from address
    @Override
    public void onMapLoaded() {
        // code to run when the map has loaded
        getMoreInfo(); // call this --> use a geoCoder to find the location of the eq
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

//        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
//            @Override
//            public void onInfoWindowClick(Marker marker) {
//                //Toast.makeText(getApplicationContext(), "Info window clicked", Toast.LENGTH_LONG).show();
//                String url = "https://";
//                String query = cr.getWikipedia();
//                String final_url = url + query;
//                Uri uri = Uri.parse(final_url);
//                startActivity(new Intent(Intent.ACTION_VIEW, uri));
//            }
//        });
    }

    public void getMoreInfo() {
        System.out.println("in getMoreInfo " + lat1 + " " + lon1);
        latLng = new LatLng(lat1, lon1);  //used in addMarker below for placing a marker at the Longitude/Latitude spot
        Geocoder gcd = new Geocoder(this);
        try {
            List<Address> list = gcd.getFromLocation(lat1, lon1, 10);
            if (list != null & list.size() > 0) {
                country = list.get(0).getCountryName(); //grab country name from GeoCoder data from Google
                if (country==null)
                    country = "unknown country";
                System.out.println("in map getMoreInfo country " + country);
            }
            else { //no location found
                country = "unknown country";
                System.out.println("in getMoreInfo no location found");
            }
        } catch (IOException e) //no geo address found
        {
            country = "unknown country";
            Log.v("in map new test","hhhh");
        }
        // puts marker icon at location
        map.addMarker(new MarkerOptions()
                .position(latLng)
                .title(String.valueOf(hr.getHospitalName()))
//                .title("City: " + String.valueOf(hr.getCity()))
                .snippet("Country: " + country)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14), 3000, null);
    }
}
