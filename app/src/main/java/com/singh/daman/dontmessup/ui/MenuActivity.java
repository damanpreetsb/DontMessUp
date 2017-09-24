package com.singh.daman.dontmessup.ui;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.singh.daman.dontmessup.R;
import com.singh.daman.dontmessup.utils.Utility;

public class MenuActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setFullScreen(this);
        setContentView(R.layout.activity_menu);
        linearLayout = (LinearLayout) findViewById(R.id.screen);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.text_app_name);

        ObjectAnimator colorFade = ObjectAnimator.ofObject(linearLayout, "backgroundColor", new ArgbEvaluator(), ContextCompat.getColor(this, R.color.colorPrimary), ContextCompat.getColor(this, R.color.colorAccent));
        colorFade.setDuration(3500);
        colorFade.setStartDelay(200);
        colorFade.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, GameActivity.class));
            }
        });
    }
}
