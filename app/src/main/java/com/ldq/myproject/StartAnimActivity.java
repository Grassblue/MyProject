package com.ldq.myproject;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.ldq.myproject.ui.activity.MainActivity;

public class StartAnimActivity extends AppCompatActivity {
    private Animator animator;
    private ImageView imageView;
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_anim);
        imageView = (ImageView) findViewById(R.id.imageView);
        animatorSet = new AnimatorSet();
        ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", 0.6f, 1.0f);
        alpha.setDuration(3000);
        ValueAnimator x = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.5f);
        x.setDuration(3000);
        ValueAnimator y = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.5f);
        y.setDuration(3000);
        animatorSet.playTogether(alpha, x, y);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                imageView.setBackgroundResource(R.mipmap.ic_start_page);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(StartAnimActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }
}
