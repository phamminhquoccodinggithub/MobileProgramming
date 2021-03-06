package com.example.game2048;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.Random;

public class MyService extends Service {
    MediaPlayer myPlayer;
    int selectSong;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myPlayer = MediaPlayer.create(this, getRandomMusic(selectSong));
        myPlayer.setLooping(true);
    }

    @Override
    public void onStart(Intent intent, int startid) {
//        Toast.makeText(this, "Music Started", Toast.LENGTH_SHORT).show();
        myPlayer.start();
    }

    @Override
    public void onDestroy() {
//        Toast.makeText(this, "Music Stopped", Toast.LENGTH_SHORT).show();
        myPlayer.stop();
    }

    private int getRandomMusic(int x) {
        Random random = new Random();
        x = random.nextInt(10 - 0 + 1) + 0;

        switch (x) {
            case 0:
                return R.raw.duongtoichoemve;
            case 1:
                return R.raw.danhmatem;
            case 2:
                return R.raw.pinkpanthercut;
            case 3:
                return R.raw.phokhongem;
            case 4:
                return R.raw.batnhaclen;
            case 5:
                return R.raw.gapnguoidungluc;
            case 6:
                return R.raw.thithoi;
            case 7:
                return R.raw.didetroive;
            case 8:
                return R.raw.phidieuvesau;
            case 9:
                return R.raw.tramcamcut;
            case 10:
                return R.raw.dungnguoi;
        }
        return x;

    }
}
