package com.example.assign2;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.view.View;
import android.widget.ImageView;

import java.util.zip.Inflater;

public class Grid {

    public Activity myActivity;
    private int id;
    private ConstraintLayout.LayoutParams pos;
    private boolean taken;
    ImageView img;
    private int num;
    public Grid(Activity myActivity,ConstraintLayout.LayoutParams pos,int id){
        this.myActivity=myActivity;
        this.id=id;
        this.pos=pos;

    }

    public ConstraintLayout.LayoutParams getPos(){
        return pos;
    }

    public void changeResource(int imageName){

        img=(ImageView)myActivity.findViewById(this.id);
        img.setImageResource(imageName);
        img.setVisibility(View.VISIBLE);
    }
    public void setTaken(boolean taken){
        this.taken=taken;
    }
    public boolean isTaken(){
        return this.taken;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public void makeInvisible(){
        img=(ImageView)myActivity.findViewById(this.id);
        img.setVisibility(View.INVISIBLE);
    }
}
