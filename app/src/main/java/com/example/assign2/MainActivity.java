package com.example.assign2;

import android.animation.ObjectAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Animation.AnimationListener {

    Animation anim;
    ImageView imageView,imageView2;
    Button btn;
    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    private GestureDetectorCompat gestureDetectorCompat = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();
        gestureListener.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

        loadAnimations();
        loadUI();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Pass activity on touch event to the gesture detector.
        gestureDetectorCompat.onTouchEvent(event);
        // Return true to tell android OS that event has been consumed, do not pass it to other event listeners.
        return true;
    }

    private void loadUI() {
        //imageView=(ImageView)findViewById(R.id.imageView);
        //imageView2=(ImageView)findViewById(R.id.imageView2);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(this);

    }

    private void loadAnimations() {
        anim= AnimationUtils.loadAnimation(this,R.anim.down);
        anim.setAnimationListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button) {

            anim.setDuration(100);
            anim.setAnimationListener(this);
            anim.setFillEnabled(true);

            imageView.startAnimation(anim);
            //imageView2.startAnimation(anim);


        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        /*imageView.clearAnimation();
        ConstraintLayout.LayoutParams newLayoutParams = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        ConstraintLayout.LayoutParams newLayoutParams2 = (ConstraintLayout.LayoutParams) imageView2.getLayoutParams();

        newLayoutParams.topMargin = newLayoutParams2.topMargin;
        Toast.makeText(MainActivity.this,
                "Your Message:"+newLayoutParams.topMargin, Toast.LENGTH_LONG).show();
        imageView.setLayoutParams(newLayoutParams);*/
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void displayMessage(String s) {
        Toast.makeText(MainActivity.this,
                ""+s, Toast.LENGTH_LONG).show();
    }
}
