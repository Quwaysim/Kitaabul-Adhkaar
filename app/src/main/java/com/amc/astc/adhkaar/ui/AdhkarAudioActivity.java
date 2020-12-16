package com.amc.astc.adhkaar.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amc.astc.adhkaar.R;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.Util;

public class AdhkarAudioActivity extends AppCompatActivity {
    TextView audio1, audio2, audio3;
    private PlayerView mPlayerView;
    private SimpleExoPlayer player;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playbackPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhkar_audio);
        mPlayerView = findViewById(R.id.player_view);
        mPlayerView.setClipToOutline(true);
        audio1 = findViewById(R.id.audio_one);
        audio2 = findViewById(R.id.audio_two);
        audio3 = findViewById(R.id.audio_three);

        audio1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) {
                    releasePlayer();
                }
                initializePlayer(R.raw.first);
            }
        }));

        audio2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) {
                    releasePlayer();
                }
                initializePlayer(R.raw.second);
            }
        }));

        audio3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) {
                    releasePlayer();
                }
                initializePlayer(R.raw.third);
            }
        }));
    }

    private void initializePlayer(int resId) {
        player = new SimpleExoPlayer.Builder(this).build();
        mPlayerView.setPlayer(player);

        Uri rawResourceDataSource = RawResourceDataSource.buildRawResourceUri(resId);
        MediaSource mediaSource = buildMediaSource(rawResourceDataSource);
        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow, playbackPosition);
        player.prepare(mediaSource, false, false);
    }

    private MediaSource buildMediaSource(Uri uri) {
        DataSource.Factory dataSourceFactory =
                new DefaultDataSourceFactory(this, "exoplayer-codelab");
        return new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri);
    }

/*
    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT >= 24) {
            initializePlayer();
        }
    }
*/
/*
    @Override
    public void onResume() {
        super.onResume();
        if ((Util.SDK_INT < 24 || player == null)) {
            initializePlayer();
        }
    }*/


    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT < 24) {
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT >= 24) {
            releasePlayer();
        }
    }

    private void releasePlayer() {
        if (player != null) {
            playWhenReady = player.getPlayWhenReady();
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            player.release();
            player = null;
        }
    }
}