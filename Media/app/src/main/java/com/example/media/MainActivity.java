package com.example.media;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button play = (Button) findViewById(R.id.music_play);
        Button pause = (Button) findViewById(R.id.music_pause);
        Button stop = (Button) findViewById(R.id.music_stop);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest. permission.
                WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission. WRITE_EXTERNAL_STORAGE }, 1);
        } else {
            initMediaPlayer(); // 初始化MediaPlayer
            initVideoPath();
        }

        videoView = (VideoView) findViewById(R.id.videoView);
        Button play_video = (Button) findViewById(R.id.video_play);
        Button pause_video = (Button) findViewById(R.id.video_pause);
        Button replay_video = (Button) findViewById(R.id.video_replay);
        play_video.setOnClickListener(this);
        pause_video.setOnClickListener(this);
        replay_video.setOnClickListener(this);
    }
    private void initMediaPlayer() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(),
                    "music.mp3");
            mediaPlayer.setDataSource(file.getPath()); // 指定音频文件的路径
//            Toast.makeText(this, file.getPath(), Toast.LENGTH_SHORT).show();
            mediaPlayer.prepare(); // 让MediaPlayer进入到准备状态
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initVideoPath() {
        File file_video = new File(Environment.getExternalStorageDirectory(), "movie.mp4");
        videoView.setVideoPath(file_video.getPath()); // 指定视频文件的路径
//        Toast.makeText(this, file_video.getPath(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.
                        PERMISSION_GRANTED) {
                    initMediaPlayer();
                    initVideoPath();
                } else {
                    Toast.makeText(this, "拒绝权限将无法使用程序",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.music_play:
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start(); // 开始播放
                }
                break;
            case R.id.music_pause:if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause(); // 暂停播放
            }
                break;
            case R.id.music_stop:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.reset(); // 停止播放
                    initMediaPlayer();
                }
                break;
            case R.id.video_play:
                if (!videoView.isPlaying()) {
                    videoView.start(); // 开始播放
                }
                break;
            case R.id.video_pause:
                if (videoView.isPlaying()) {
                    videoView.pause(); // 暂停播放
                }
                break;
            case R.id.video_replay:
                if (videoView.isPlaying()) {
                    videoView.resume(); // 重新播放
                }
                break;
            default:
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        if (videoView != null) {
            videoView.suspend();
        }
    }
}