package com.example.user.dorafinal1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class audioTwo extends AppCompatActivity {
    Button play;
    Button stop;
    private MediaPlayer mMediaPlayer;

    SeekBar volumeBar;

    //playing state
    private static final int PLAYING = 0;
    //pause state
    private static final int PAUSE = 1;
    //stop state
    private static final int STOP = 2;
    //idle state
    private static final int IDLE = 3;
    //current state
    private int state = IDLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_two);

        play = (Button) findViewById(R.id.playBtn);
        stop = (Button) findViewById(R.id.stopBtn);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state == PLAYING) {
                    pause();
                } else {
                    start();
                }
            }
        });

        stop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                stop();
            }
        });

        volumeBar = (SeekBar) findViewById(R.id.volumeBar);
        volumeBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        float volumeNum = progress / 100f;
                        if (mMediaPlayer != null){
                            mMediaPlayer.setVolume(volumeNum, volumeNum);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }

    private void pause() {
        mMediaPlayer.pause();
        state = PAUSE;
        play.setBackgroundResource(R.drawable.ic_doraplay);
    }

    private void start() {
        if (state == IDLE || state == STOP) {
            play();
        } else if (state == PAUSE) {
            mMediaPlayer.start();
            state = PLAYING;
        }
        play.setBackgroundResource(R.drawable.ic_dorapause);
    }

    private void stop() {
        mMediaPlayer.stop();
        state = STOP;
        play.setBackgroundResource(R.drawable.ic_doraplay);
    }

    private void play() {
        try {
            if (mMediaPlayer == null || state == STOP) {
                // 创建MediaPlayer对象并设置Listener
                mMediaPlayer = MediaPlayer.create(this, R.raw.meditation);
                mMediaPlayer.setVolume(0.5f, 0.5f);
                mMediaPlayer.setOnPreparedListener(listener);
            } else {
                // 复用MediaPlayer对象
                mMediaPlayer.reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MediaPlayer.OnPreparedListener listener = new MediaPlayer.OnPreparedListener() {
        public void onPrepared(MediaPlayer mediaPlayer) {
            mMediaPlayer.start();
            state = PLAYING;
        }
    };



    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Activity销毁后，释放播放器资源
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
