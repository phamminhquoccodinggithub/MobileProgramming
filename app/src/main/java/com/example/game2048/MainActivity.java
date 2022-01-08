package com.example.game2048;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button playgame, choitiep;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Quit?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startActivity(startMain);
                        sendNotification();
                        finish();
//                      System.exit(0);
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        }).show();
            } catch (Exception e) {
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        anhxa();
        batxukienclick();
        batteryCheck();

    }

    public void batteryCheck() {
        BroadcastReceiver receiver = new BatteryBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        registerReceiver(receiver, intentFilter);
    }

    public void batxukienclick() {
        playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, play2048.class);
                intent.putExtra("playgame", 1);
                startService(new Intent(MainActivity.this, MyService.class));
                startActivity(intent);

            }
        });
        choitiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, play2048.class);
                intent.putExtra("playgame", 3);
                startService(new Intent(MainActivity.this, MyService.class));
                startActivity(intent);

            }
        });

    }

    private void sendNotification() {
        Toast.makeText(MainActivity.this, "Notification Set!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, NotifyBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        long timeAtButtonClick = System.currentTimeMillis();
        long tenSecondsInMillis = 1000 * 10;
        alarmManager.set(AlarmManager.RTC_WAKEUP, timeAtButtonClick + tenSecondsInMillis, pendingIntent);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Channel_Notify", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void anhxa() {
        playgame = (Button) findViewById(R.id.playgame2048);
        choitiep = (Button) findViewById(R.id.choitiep);
    }

}
