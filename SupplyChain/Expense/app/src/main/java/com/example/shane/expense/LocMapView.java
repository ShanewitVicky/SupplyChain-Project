package com.example.shane.expense;

import android.app.AlertDialog;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocMapView extends FragmentActivity  implements OnMapReadyCallback{
    private String[] scanLable={"ProductName","Production Date","Expiration Date","Location","User_Id","User_Name","First_Name","Last_Name"
            ,"Email_Id","Phone_Number","Address"};
    private static final int GPS_ERRORDIALOG_REQUEST=9001;
    Geocoder geoLocation;
    LatLng loc=new LatLng(0,0);
    protected static final String TAG = "MapsActvity";
    String location="Invalid";
    Bundle bundleData;



    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         //Sets up the Full Screen for the Activity
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_map_view);
        //Creating fragment for the map
        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_map);
        mapFragment.getMapAsync(this);
        //Gets Value from the previous Activity
       Intent intentData=getIntent();
       bundleData=intentData.getExtras();
      if(bundleData!=null){
          //System.out.println("Inside Bundle"+bundleData.getString("Location"));
         location=bundleData.getString("Location");
      }

        //Gets the Latitude and Longitude based on the Location Given by the user
        geoLocation=new Geocoder(this);
        try {
            List<Address> addressList=new ArrayList<>();
            addressList.clear();
            addressList= geoLocation.getFromLocationName(location, 1);
           System.out.println("City"+addressList.get(0));
            if(addressList.size()!=0) {
                Address address = addressList.get(0);
                String locality = address.getLocality();
                Toast.makeText(this, locality, Toast.LENGTH_LONG).show();
                System.out.println("After Marking the Location");
                loc=new LatLng(address.getLatitude(),address.getLongitude());
                System.out.println("address.getLatitude()"+address.getLatitude()+"address.getLongitude()"+address.getLongitude());


            }else{
                Toast.makeText(this, "The Location is invalid", Toast.LENGTH_LONG).show();
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
        //End of Geo Coding


    }



    //Populates the map and marks given location on the map
    @Override
    public void onMapReady(GoogleMap googleMap)

    {
        googleMap.addMarker(new MarkerOptions().position(loc).title("Product Location"));
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(loc));
        LatLngBounds bounds=new LatLngBounds(loc,loc);
        googleMap.setLatLngBoundsForCameraTarget(bounds);
        Toast.makeText(this, "Product Name:"+bundleData.getString("ProductName")+"\nProduction Date:"+bundleData.getString("Production Date")+"\nExpiration Date:"+bundleData.getString("Expiration Date")+"\nProducer Name:"+bundleData.getString("First_Name")+" "+bundleData.getString("Last_Name")+"\nLocation:"+bundleData.getString("Location"), Toast.LENGTH_LONG).show();

    }


}
