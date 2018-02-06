package com.dupleit.apps.mapproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class GridImages extends AppCompatActivity {
    ImageView image1,image2,image3,image4;
    String activityType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_images);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activityType = getIntent().getStringExtra("activityType");
        setTitle(activityType);

        image1=findViewById(R.id.imageView1);
        image2=findViewById(R.id.imageView2);
        image3=findViewById(R.id.imageView3);
        image4=findViewById(R.id.imageView4);


        if (activityType.equals("Images")){
            Glide.with(this).load("https://api.androidhive.info/images/glide/large/cacw.jpg").into(image1);
            Glide.with(this).load("https://api.androidhive.info/images/glide/small/bourne.jpg").into(image2);
            Glide.with(this).load("https://api.androidhive.info/images/glide/large/doctor.jpg").into(image3);
            Glide.with(this).load("https://api.androidhive.info/images/glide/large/ipman3.jpg").into(image4);

        }else if (activityType.equals("Videos")){
            Glide.with(this).load("http://i3.ytimg.com/vi/UzlKXyxgmBk/maxresdefault.jpg").into(image1);
            Glide.with(this).load("http://i3.ytimg.com/vi/UzlKXyxgmBk/maxresdefault.jpg").into(image2);
            Glide.with(this).load("http://i3.ytimg.com/vi/UzlKXyxgmBk/maxresdefault.jpg").into(image3);
            Glide.with(this).load("http://i3.ytimg.com/vi/UzlKXyxgmBk/maxresdefault.jpg").into(image4);

        }else if (activityType.equals("Audios")){
            Glide.with(this).load(R.drawable.headphone).into(image1);
            Glide.with(this).load(R.drawable.headphone).into(image2);
            Glide.with(this).load(R.drawable.headphone).into(image3);
            Glide.with(this).load(R.drawable.headphone).into(image4);
        }
        gotoNext();



    }

    private void gotoNext() {
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activityType.equals("Images")){
                    Intent intent =new Intent(GridImages.this,FullImage.class);
                    intent.putExtra("imageUrl","https://api.androidhive.info/images/glide/large/cacw.jpg");
                    startActivity(intent);
                }else if (activityType.equals("Videos")){
                    Intent intent =new Intent(GridImages.this,videoPlayerActivity.class);
                    startActivity(intent);

                }else if (activityType.equals("Audios")){
                    Intent intent =new Intent(GridImages.this,audioPlayerActivity.class);
                    startActivity(intent);
                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activityType.equals("Images")){
                    Intent intent =new Intent(GridImages.this,FullImage.class);
                    intent.putExtra("imageUrl","https://api.androidhive.info/images/glide/small/bourne.jpg");
                    startActivity(intent);
                }else if (activityType.equals("Videos")){
                    Intent intent =new Intent(GridImages.this,videoPlayerActivity.class);
                    startActivity(intent);

                }else if (activityType.equals("Audios")){
                    Intent intent =new Intent(GridImages.this,audioPlayerActivity.class);
                    startActivity(intent);
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activityType.equals("Images")){
                    Intent intent =new Intent(GridImages.this,FullImage.class);
                    intent.putExtra("imageUrl","https://api.androidhive.info/images/glide/large/doctor.jpg");
                    startActivity(intent);
                }else if (activityType.equals("Videos")){
                    Intent intent =new Intent(GridImages.this,videoPlayerActivity.class);
                    startActivity(intent);

                }else if (activityType.equals("Audios")){
                    Intent intent =new Intent(GridImages.this,audioPlayerActivity.class);
                    startActivity(intent);
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activityType.equals("Images")){
                    Intent intent =new Intent(GridImages.this,FullImage.class);
                    intent.putExtra("imageUrl","https://api.androidhive.info/images/glide/large/ipman3.jpg");
                    startActivity(intent);
                }else if (activityType.equals("Videos")){
                    Intent intent =new Intent(GridImages.this,videoPlayerActivity.class);
                    startActivity(intent);

                }else if (activityType.equals("Audios")){
                    Intent intent =new Intent(GridImages.this,audioPlayerActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
