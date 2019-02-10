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

    Animation animDown,animUp,animRight,animLeft;
    ImageView imageView,img;
    Button btn;
    Table table;
    Grid[][] grids;
    ConstraintLayout cl;
    private GestureDetectorCompat gestureDetectorCompat = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstructTable();


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
        animDown= AnimationUtils.loadAnimation(this,R.anim.down);
        animDown.setAnimationListener(this);

        animUp= AnimationUtils.loadAnimation(this,R.anim.up);
        animUp.setAnimationListener(this);

        animRight= AnimationUtils.loadAnimation(this,R.anim.right);
        animRight.setAnimationListener(this);

        animLeft= AnimationUtils.loadAnimation(this,R.anim.left);
        animLeft.setAnimationListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button) {
            cl = findViewById(R.id.myLayout);
            img=new ImageView(this);
            img.setLayoutParams(table.grids[0][0].getPos());
            img.setImageResource(R.mipmap.ic_launcher);
            cl.addView(img);
            //anim.setDuration(100);
            //anim.setAnimationListener(this);
            //anim.setFillEnabled(true);

            //imageView.startAnimation(anim);
            //imageView2.startAnimation(anim);


        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        img.clearAnimation();
        img.setLayoutParams(table.grids[table.currentY][table.currentX].getPos());
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void displayMessage(String s) {
        Toast.makeText(MainActivity.this,
                ""+s, Toast.LENGTH_LONG).show();
    }
    public void movement(int direction){
        switch (direction){
            case 1:
                if(table.checkAvailability(1)) {
                    animDown.setDuration(100);
                    animDown.setAnimationListener(this);
                    animDown.setFillEnabled(true);
                    img.startAnimation(animDown);
                }
                break;
            case 2:
                if(table.checkAvailability(2)) {
                    animUp.setDuration(100);
                    animUp.setAnimationListener(this);
                    animUp.setFillEnabled(true);
                    img.startAnimation(animUp);
                }
                break;
            case 3:
                if(table.checkAvailability(3)) {
                    animRight.setDuration(100);
                    animRight.setAnimationListener(this);
                    animRight.setFillEnabled(true);
                    img.startAnimation(animRight);
                }
                break;
            case 4:
                if(table.checkAvailability(4)) {
                    animLeft.setDuration(100);
                    animLeft.setAnimationListener(this);
                    animLeft.setFillEnabled(true);
                    img.startAnimation(animLeft);
                }
                break;
        }
    }
    public void ConstructTable(){
        grids=new Grid[4][4];

        imageView=(ImageView)findViewById(R.id.grid11);
        ConstraintLayout.LayoutParams pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[0][0]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid12);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[0][1]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid13);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[0][2]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid14);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[0][3]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid21);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[1][0]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid22);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[1][1]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid23);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[1][2]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid24);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[1][3]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid31);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[2][0]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid32);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[2][1]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid33);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[2][2]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid34);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[2][3]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid41);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[3][0]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid42);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[3][1]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid43);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[3][2]=new Grid(pos);

        imageView=(ImageView)findViewById(R.id.grid44);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        grids[3][3]=new Grid(pos);

        table=new Table(grids);
        table.currentX=0;
        table.currentY=0;
    }
}
