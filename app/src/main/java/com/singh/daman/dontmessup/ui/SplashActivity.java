package com.singh.daman.dontmessup.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.singh.daman.dontmessup.R;
import com.singh.daman.dontmessup.utils.Utility;

public class SplashActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setFullScreen(this);
        setContentView(R.layout.activity_splash);
        textView = (TextView) findViewById(R.id.text_app_name);
        Handler handler = new Handler();
        handler.postDelayed(runnable, 3000);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(SplashActivity.this, textView, getString(R.string.shared_textview));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                startActivity(intent, options.toBundle());
            } else{
                startActivity(intent);
            }
//            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        }
    };
}
