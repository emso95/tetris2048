package com.example.assign2;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;

public class Grid {

    private ConstraintLayout.LayoutParams pos;
    private Square square;

    public Grid(ConstraintLayout.LayoutParams pos){
        this.pos=pos;
        square=null;
    }

    public ConstraintLayout.LayoutParams getPos(){
        return pos;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Square getSquare() {
        return square;
    }
    public void resetGrid(){
        this.square=null;
    }
}
