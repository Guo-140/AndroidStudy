package com.example.androidtest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.testcommon.BaseActivity;
import com.example.testlib.Utils;

public class MainActivity extends BaseActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void init() {
        createBtn("button1", v -> {
//            append("button1 \n");
//            text("123456");
        });
        createBtn("button2", v -> {
//            append("button1 \n");
            text("123456\n");
        });
    }

}