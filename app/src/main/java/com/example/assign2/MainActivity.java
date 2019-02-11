package com.example.assign2;

import android.animation.ObjectAnimator;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Animation.AnimationListener {

    Animation animDown,animUp,animRight,animLeft;
    ImageView imageView,img;
    TextView gameStatus;
    Button btn;
    Table table;
    Grid[][] grids;
    ConstraintLayout cl;
    ConstraintLayout.LayoutParams[] startingPoints;
    private Handler handler,gameHandler;
    private GestureDetectorCompat gestureDetectorCompat = null;
    boolean gameOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstructTable();

        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();
        gestureListener.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);
        handler = new Handler();
        gameHandler= new Handler();
        loadAnimations();
        loadUI();

        img = new ImageView(this);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gestureDetectorCompat.onTouchEvent(event);
        return true;

    }

    private void loadUI() {

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
            cl.addView(img);
            gameHandler.post(runnableGame);
            handler.postDelayed(runnable, 1000);

        }
    }
    private Runnable runnableGame = new Runnable() {
        @Override
        public void run() {
            table.currentY=0;
            final int random = new Random().nextInt(3);
            table.currentX=random;
            img.setLayoutParams(startingPoints[random]);
            img.setImageResource(R.mipmap.ic_launcher);
            gameStatus=(TextView)findViewById(R.id.gameStatus);
        }
    };
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(table.checkAvailability(1)) {
                movement(1);
            }
            else {
                if(!table.checkEndGame()) {
                    table.fillGrid(R.mipmap.ic_launcher);
                    gameHandler.post(runnableGame);
                }
                else{
                    handler.removeCallbacks(runnable);
                    gameHandler.removeCallbacks(runnableGame);
                    gameStatus.setVisibility(View.VISIBLE);
                }
            }

            handler.postDelayed(this, 1000);
        }
    };
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
                    table.currentY++;
                }
                break;
            case 3:
                if(table.checkAvailability(3)) {
                    animRight.setDuration(100);
                    animRight.setAnimationListener(this);
                    animRight.setFillEnabled(true);
                    img.startAnimation(animRight);
                    table.currentX++;
                }
                break;
            case 4:
                if(table.checkAvailability(4)) {
                    animLeft.setDuration(100);
                    animLeft.setAnimationListener(this);
                    animLeft.setFillEnabled(true);
                    img.startAnimation(animLeft);
                    table.currentX--;
                }
                break;
        }
    }
    public void ConstructTable(){
        grids=new Grid[5][4];
        startingPoints=new ConstraintLayout.LayoutParams[4];

        final ImageView imageView1=(ImageView)findViewById(R.id.grid11);
        ConstraintLayout.LayoutParams pos = (ConstraintLayout.LayoutParams) imageView1.getLayoutParams();
        grids[1][0]=new Grid(this,pos,R.id.grid11);

        final ImageView imageView2=(ImageView)findViewById(R.id.grid12);
        pos = (ConstraintLayout.LayoutParams) imageView2.getLayoutParams();
        grids[1][1]=new Grid(this,pos,R.id.grid12);

        final ImageView imageView3=(ImageView)findViewById(R.id.grid13);
        pos = (ConstraintLayout.LayoutParams) imageView3.getLayoutParams();
        grids[1][2]=new Grid(this,pos,R.id.grid13);

        final ImageView imageView4=(ImageView)findViewById(R.id.grid14);
        pos = (ConstraintLayout.LayoutParams) imageView4.getLayoutParams();
        grids[1][3]=new Grid(this,pos,R.id.grid14);

        final ImageView imageView5=(ImageView)findViewById(R.id.grid21);
        pos = (ConstraintLayout.LayoutParams) imageView5.getLayoutParams();
        grids[2][0]=new Grid(this,pos,R.id.grid21);

        final ImageView imageView6=(ImageView)findViewById(R.id.grid22);
        pos = (ConstraintLayout.LayoutParams) imageView6.getLayoutParams();
        grids[2][1]=new Grid(this,pos,R.id.grid22);

        final ImageView imageView7=(ImageView)findViewById(R.id.grid23);
        pos = (ConstraintLayout.LayoutParams) imageView7.getLayoutParams();
        grids[2][2]=new Grid(this,pos,R.id.grid23);

        final ImageView imageView8=(ImageView)findViewById(R.id.grid24);
        pos = (ConstraintLayout.LayoutParams) imageView8.getLayoutParams();
        grids[2][3]=new Grid(this,pos,R.id.grid24);

        final ImageView imageView9=(ImageView)findViewById(R.id.grid31);
        pos = (ConstraintLayout.LayoutParams) imageView9.getLayoutParams();
        grids[3][0]=new Grid(this,pos,R.id.grid31);

        final ImageView imageView10=(ImageView)findViewById(R.id.grid32);
        pos = (ConstraintLayout.LayoutParams) imageView10.getLayoutParams();
        grids[3][1]=new Grid(this,pos,R.id.grid32);

        final ImageView imageView11=(ImageView)findViewById(R.id.grid33);
        pos = (ConstraintLayout.LayoutParams) imageView11.getLayoutParams();
        grids[3][2]=new Grid(this,pos,R.id.grid33);

        final ImageView imageView12=(ImageView)findViewById(R.id.grid34);
        pos = (ConstraintLayout.LayoutParams) imageView12.getLayoutParams();
        grids[3][3]=new Grid(this,pos,R.id.grid34);

        final ImageView imageView13=(ImageView)findViewById(R.id.grid41);
        pos = (ConstraintLayout.LayoutParams) imageView13.getLayoutParams();
        grids[4][0]=new Grid(this,pos,R.id.grid41);

        final ImageView imageView14=(ImageView)findViewById(R.id.grid42);
        pos = (ConstraintLayout.LayoutParams) imageView14.getLayoutParams();
        grids[4][1]=new Grid(this,pos,R.id.grid42);

        final ImageView imageView15=(ImageView)findViewById(R.id.grid43);
        pos = (ConstraintLayout.LayoutParams) imageView15.getLayoutParams();
        grids[4][2]=new Grid(this,pos,R.id.grid43);

        final ImageView imageView16=(ImageView)findViewById(R.id.grid44);
        pos = (ConstraintLayout.LayoutParams) imageView16.getLayoutParams();
        grids[4][3]=new Grid(this,pos,R.id.grid44);

        imageView=(ImageView)findViewById(R.id.startingPoint1);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        startingPoints[0]=pos;
        grids[0][0]=new Grid(this,pos,R.id.startingPoint1);

        imageView=(ImageView)findViewById(R.id.startingPoint2);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        startingPoints[1]=pos;
        grids[0][1]=new Grid(this,pos,R.id.startingPoint2);

        imageView=(ImageView)findViewById(R.id.startingPoint3);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        startingPoints[2]=pos;
        grids[0][2]=new Grid(this,pos,R.id.startingPoint3);

        imageView=(ImageView)findViewById(R.id.startingPoint4);
        pos = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        startingPoints[3]=pos;
        grids[0][3]=new Grid(this,pos,R.id.startingPoint4);

        table=new Table(grids);
        table.currentX=0;
        table.currentY=0;


    }


}
