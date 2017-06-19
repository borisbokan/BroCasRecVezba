package com.borcha.mybroadcastsend.Activitys;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.borcha.mybroadcastsend.R;
import com.borcha.mybroadcastsend.Recivers.MyBroadcasReciver;

public class MainActivityActivity extends AppCompatActivity implements View.OnClickListener {

    public static final  String MYBROADCAST_SVIMA = "com.borcha.mybroadcastsend.svima";
    public static final String MYBROADCAST_ZA_APP1 = "com.borcha.mybroadcastsend.app1";
    public static final String MYBROADCAST_ZA_APP2 = "com.borcha.mybroadcastsend.app2";
    public static final  String MYBROADCAST_ZA_MYAPP = "com.borcha.mybroadcastsend.myapp";

    Button btnBroadcastSvima,btnZaApp1,btnZaApp2,btnUnutarApp;
    private MyBroadcasReciver myReciver;
    private IntentFilter intFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btnBroadcastSvima=(Button)findViewById(R.id.btnBrocastSvima);
        btnZaApp1=(Button)findViewById(R.id.btnZaApp1);
        btnZaApp2=(Button)findViewById(R.id.btnZaApp2);
        btnUnutarApp=(Button)findViewById(R.id.btnUnutarMyApp);

        btnBroadcastSvima.setOnClickListener(this);
        btnZaApp1.setOnClickListener(this);
        btnZaApp2.setOnClickListener(this);
        btnUnutarApp.setOnClickListener(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
         myReciver=new MyBroadcasReciver();
         intFilter=new IntentFilter();   //Definisan ovde u kodu a ne u manifestu
         intFilter.addAction(MYBROADCAST_ZA_MYAPP);
        intFilter.addAction(MYBROADCAST_SVIMA);
         registerReceiver(myReciver,intFilter); //ovde registrovati u onStop unregistovati, obavezno!!
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnBrocastSvima:
                saljiSvima();
                break;

            case R.id.btnZaApp1:
                 saljiZaApp1();
                break;


            case R.id.btnZaApp2:

                 saljiZaApp2();
                break;

            case R.id.btnUnutarMyApp:
                  saljiZaMyApp();
                break;

            default:

                break;
        }


    }

    private void saljiSvima(){
        Intent intSvima=new Intent();
        intSvima.setAction(MYBROADCAST_SVIMA);
        intSvima.putExtra("poruka","Svima poruka...");
        intSvima.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intSvima);
    }

    private void saljiZaApp1(){
        Intent inte=new Intent();
        inte.setAction(MYBROADCAST_ZA_APP1);
        inte.putExtra("poruka","poruka za App1...");
        inte.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(inte);
    }


    private void saljiZaApp2(){
        Intent inte=new Intent();
        inte.setAction(MYBROADCAST_ZA_APP2);
        inte.putExtra("poruka","Poruka za App 2...");
        inte.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(inte);
    }


    private void saljiZaMyApp(){
        Intent intemyapp=new Intent();
        intemyapp.setAction(MYBROADCAST_ZA_MYAPP);
        intemyapp.putExtra("poruka","Stigla poruka za My App...  :) ");
        intemyapp.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intemyapp);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //postaviti za svaki slucaj prvo null vrednost
        if(myReciver!=null){
            myReciver=null;

        }
        //odregistrovati reciver
        unregisterReceiver(myReciver);
    }
}
