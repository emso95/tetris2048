package com.example.assign2;

import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;

public class Square {
    ImageView img;
    private int num;
    private int imageName;
    private ConstraintLayout.LayoutParams squarePos;

    public Square(ImageView image,int imageName,int num,ConstraintLayout.LayoutParams squarePos) {
        this.img=image;
        image.setImageResource(imageName);
        image.setLayoutParams(squarePos);
        this.num=num;


    }
    public void makeDouble(){
        num=num*2;
    }
    public void setPos(ConstraintLayout.LayoutParams newPos){
        img.setLayoutParams(newPos);
    }
    public void changeImage(int imageName){
        this.imageName=imageName;
        img.setImageResource(imageName);
    }
}
