package com.singh.daman.dontmessup.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.singh.daman.dontmessup.R;
import com.singh.daman.dontmessup.utils.Utility;

public class OverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setFullScreen(this);
        setContentView(R.layout.activity_over);
    }
}
