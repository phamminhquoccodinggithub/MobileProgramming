package com.example.game2048;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

public class BatteryBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("NotifyBroadcast", "Your Battery is low!");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //set title, message
        builder.setTitle("WARNING!").setMessage("Your Battery is low!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
