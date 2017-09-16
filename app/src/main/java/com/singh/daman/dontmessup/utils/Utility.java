package com.singh.daman.dontmessup.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.singh.daman.dontmessup.listeners.AnimListener;

/**
 * Created by Daman on 9/9/2017.
 */

public final class Utility {
    public Utility() {
    }

    public static void setFullScreen(@NonNull final Activity activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public static void shakeAnimation(View view, final AnimListener animListener) {
        ObjectAnimator objectAnimator = ObjectAnimator
                .ofFloat(view, "translationX", 0, 25, -25, 25, -25, 15, -15, 6, -6, 0);
        objectAnimator.setDuration(1000);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animListener.animEndListener();
            }
        });
        objectAnimator.start();
    }

}
