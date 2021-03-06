package com.sanyagupta.healthdream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Help2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help2);

        VideoView rain=findViewById(R.id.videoview);
        rain.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.inhaler);
        MediaController mediaController= new MediaController(this);
        rain.setMediaController(mediaController);
        mediaController.setAnchorView(rain);
        rain.start();
    }
}