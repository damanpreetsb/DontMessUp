package com.singh.daman.dontmessup.ui;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.singh.daman.dontmessup.R;
import com.singh.daman.dontmessup.data.Data;
import com.singh.daman.dontmessup.enums.GestureEnum;
import com.singh.daman.dontmessup.listeners.AnimListener;
import com.singh.daman.dontmessup.utils.Utility;

public class GameActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener, AnimListener {

    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;
    private AnimListener animListener;
    private TextView textView;
    private ArrayMap<String, String> arrayMap;
    private String[] s = new String[2];
    private Handler handler = new Handler();
    private int progress = 0;
    private ProgressBar progressBar;
    private boolean click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setFullScreen(this);
        setContentView(R.layout.activity_game);
        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);
        textView = (TextView) findViewById(R.id.text_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        arrayMap = Data.createArrayMap();
        s = Data.getData(arrayMap);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setText(s[0]);
                loop();
            }
        },500);

    }

    Runnable updateTime = new Runnable() {
        public void run() {
            handler.postDelayed(this, 20);
            progress = progress + 2;
            progressBar.setProgress(progress);
            System.out.println(progress);
            if(progress > 100){
                if(click) {
                    loop();
                    s = Data.getData(arrayMap);
                    textView.setText(s[0]);
                    progress = 0;
                    click = false;
                }
                else {
                    handler.removeCallbacks(this);
                    Toast.makeText(GameActivity.this, "Out", Toast.LENGTH_SHORT).show();
                    Utility.shakeAnimation(textView, new AnimListener() {
                        @Override
                        public void animEndListener() {
                            startActivity(new Intent(GameActivity.this, OverActivity.class));
                            finish();
                        }
                    });
                }
            }

        }
    };

    private void loop() {
        progressBar.setProgress(progress);
        handler.removeCallbacks(updateTime);
        handler.postDelayed(updateTime, 100);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: " + event1.getAction());
        check(GestureEnum.SWIPE.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTap: " + event.getAction());
        check(GestureEnum.DOUBLETAP.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.getAction());
        check(GestureEnum.TAP.toString());
        return true;
    }

    private void check(String value) {
        click = true;
        if (!s[1].equals(value)) {
            handler.removeCallbacks(updateTime);
            Toast.makeText(this, "OUT", Toast.LENGTH_SHORT).show();
            Utility.shakeAnimation(textView, this);
        }
    }

    @Override
    public void animEndListener() {
        startActivity(new Intent(GameActivity.this, OverActivity.class));
        finish();
    }
}