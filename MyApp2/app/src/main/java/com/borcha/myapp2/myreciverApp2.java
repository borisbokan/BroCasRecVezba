package com.borcha.myapp2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by borcha on 19.06.17..
 */

public class myreciverApp2 extends BroadcastReceiver {

    public myreciverApp2() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Poruka u app 2: " + intent.getStringExtra("poruka"),Toast.LENGTH_LONG).show();

    }
}
