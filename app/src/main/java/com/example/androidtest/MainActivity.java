package com.example.androidtest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.aidl.IMyAidlInterface;
import com.example.testcommon.BaseActivity;

public class MainActivity extends BaseActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private IMyAidlInterface mIMyAidlInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void init() {
        createBtn("button1", v -> {
            append(doCommend());
        });
        createBtn("button2", v -> {

        });
    }
    private String doCommend() {
        if (mIMyAidlInterface==null) {
            attemptToBindService();
        }
        try {
            return mIMyAidlInterface.doCommend();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error";
    }
    private void attemptToBindService() {
        Intent intent = new Intent();
        intent.setAction("com.xxx.aidl");
        intent.setPackage("com.example.testservice");
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIMyAidlInterface = null;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        if (mIMyAidlInterface==null) {
            attemptToBindService();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mIMyAidlInterface!=null) {
            unbindService(conn);
        }
    }

}