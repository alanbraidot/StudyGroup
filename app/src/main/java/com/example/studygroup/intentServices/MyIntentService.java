package com.example.studygroup.intentServices;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;

import androidx.annotation.Nullable;

import com.example.studygroup.receivers.MyReceiver;

public class MyIntentService extends IntentService {

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        BroadcastReceiver br = new MyReceiver();
        //TODO Configurar IntentService
        IntentFilter filter = new IntentFilter();
        filter.addAction(MyReceiver.LOGIN_SUCCESSFULLY);
        getApplication().getApplicationContext().registerReceiver(br,filter);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
    }
}
