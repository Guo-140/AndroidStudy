package com.example.testlib;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();
    public String mStr = "123";
    private LinearLayout mLinearLayout;
    private int mId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void setCommend() {
        Utils.getValue();
        Log.d(TAG, "setValue: ");
    }

    public void setLinearLayout(int id) {
        mId = id;
    }

    public void setButton(String str) {
        Button button = new Button(this);
        button.setText(str);
        LinearLayout layout = findViewById(mId);
        layout.addView(button);
    }
}
