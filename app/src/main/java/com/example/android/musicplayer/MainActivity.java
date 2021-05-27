package com.example.android.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.minimum);

        Button playButton = (Button) findViewById(R.id.play);
        playButton.setOnClickListener(v -> {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(mp -> {
                Toast.makeText(MainActivity.this, "I'am Done.", Toast.LENGTH_SHORT).show();
            });
        });

        Button pauseButton = (Button) findViewById(R.id.pause);
        pauseButton.setOnClickListener(v -> {
            mediaPlayer.pause();
        });
    }
}