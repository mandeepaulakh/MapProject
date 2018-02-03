package com.dupleit.apps.mapproject;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class audioPlayerActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    ImageView playpause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Audio");
        playpause =  findViewById(R.id.play);
        mPlayer = new MediaPlayer();
        Uri myUri1 = Uri.parse("https://demo.dupleit.com/VideoFolder/instrumental.mp3");
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mPlayer.setDataSource(getApplicationContext(), myUri1);
        } catch (IllegalArgumentException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            mPlayer.prepare();
        } catch (IllegalStateException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        }

        playpause.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Toast.makeText(audioPlayerActivity.this, "" + mPlayer.getDuration(), Toast.LENGTH_SHORT).show();
                if (mPlayer.isPlaying()) {
                    playpause.setImageDrawable(getDrawable(R.drawable.ic_play));
                    mPlayer.pause();
                } else {
                    playpause.setImageDrawable(getDrawable(R.drawable.ic_pause));
                    mPlayer.start();
                }
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onResume() {
        super.onResume();
        if (mPlayer.isPlaying()) {
            playpause.setImageDrawable(getDrawable(R.drawable.ic_pause));
            // mPlayer.pause();
        } else {
            playpause.setImageDrawable(getDrawable(R.drawable.ic_play));
            //mPlayer.start();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onRestart() {
        super.onRestart();
        if (mPlayer.isPlaying()) {
            playpause.setImageDrawable(getDrawable(R.drawable.ic_pause));
            // mPlayer.pause();
        } else {
            playpause.setImageDrawable(getDrawable(R.drawable.ic_play));
            //mPlayer.start();
        }
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