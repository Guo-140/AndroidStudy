package com.example.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.aidl.IMyAidlInterface;

public class MyService extends Service {


    @Override
    public IBinder onBind(Intent intent) {

        return mBind;
    }

    IMyAidlInterface.Stub mBind = new IMyAidlInterface.Stub() {

        @Override
        public String doCommend() throws RemoteException {
            return "doCommend";
        }
    };
}
