package com.borcha.mybroadcastsend.Recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by borcha on 19.06.17..
 */

public class MyBroadcasReciver extends BroadcastReceiver {

    public MyBroadcasReciver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Poruka: " + intent.getStringExtra("poruka"),Toast.LENGTH_LONG).show();
    }



}
