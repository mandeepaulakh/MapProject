package com.dupleit.apps.mapproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mancj.slideup.SlideUp;

import es.dmoral.toasty.Toasty;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private SlideUp slideUp;
    private View dim;
    private View sliderView;
    TextView textImages,textVideos,textAudios;
    LinearLayout btnImage,btnVideo,btnAudio;
    Boolean checkSlide = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        checkSlide =false;
        sliderView = findViewById(R.id.slideView);
        dim = findViewById(R.id.dim);
        textImages = findViewById(R.id.textImages);
        textVideos = findViewById(R.id.textVideos);
        textAudios= findViewById(R.id.textAudios);
        btnImage =findViewById(R.id.llImage);
        btnVideo =findViewById(R.id.llVideo);
        btnAudio =findViewById(R.id.llAudio);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/LatoLight.ttf");
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(),  "fonts/LatoRegular.ttf");
        textImages.setTypeface(custom_font1);
        textVideos.setTypeface(custom_font1);
        textAudios.setTypeface(custom_font1);
        slideUp = new SlideUp(sliderView);
        slideUp.hideImmediately();
        slideUp.setSlideListener(new SlideUp.SlideListener() {
            @Override
            public void onSlideDown(float v) {
                dim.setAlpha(1 - (v / 100));
            }

            @Override
            public void onVisibilityChanged(int i) {
                if (i == View.GONE){
                    //mMap.mar
                }

            }
        });

        if (!checkInternetState.getInstance(this).isOnline()) {
            Toasty.warning(this, "No Internet connection.", Toast.LENGTH_SHORT, true).show();
        }else {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }



        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MapsActivity.this,GridImages.class);
                intent.putExtra("activityType","Images");
                startActivity(intent);
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MapsActivity.this,GridImages.class);
                intent.putExtra("activityType","Videos");
                startActivity(intent);
            }
        });
        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MapsActivity.this,GridImages.class);
                intent.putExtra("activityType","Audios");
                startActivity(intent);
            }
        });

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //mMap.getUiSettings().setZoomControlsEnabled(true);
        //mMap.setMinZoomPreference(11);

        LatLng latLng = new LatLng(28.6139, 77.2090);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng)
                .icon(BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_ROSE));
        mMap.addMarker(markerOptions);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                //int position = (int)(marker.getTag());
                slideUp.animateIn();
                checkSlide=true;
                return false;
            }
        });
        //mCurrLocationMarker = mMap.addMarker(markerOptions)
        // Showing the current location in Google Map
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));
    }
    @Override
    public void onBackPressed() {
        if (checkSlide==true) {    // 2 secs
            slideUp.animateOut();
            checkSlide= false;
        } else {
            super.onBackPressed();
        }
    }

}