package com.example.assign2;

public class Table {

    Grid[][] grids;
    int currentX;
    int currentY;
    public Table(Grid[][] grids){
        this.grids=grids;
    }
    public boolean checkAvailability(int direction){
        boolean tmp = false;
        switch (direction){
            case 1:
                if(currentY+1>3){
                    tmp=false;
                }
                else{
                    tmp=true;
                    currentY++;
                }
                break;
            case 2:
                if(currentY-1<0){
                    tmp=false;
                }
                else{
                    currentY--;
                    tmp=true;
                }
                break;
            case 3:
                if(currentX+1>3){
                    tmp=false;
                }
                else{
                    currentX++;
                    tmp=true;
                }
                break;
            case 4:
                if(currentX-1<0){
                    tmp=false;
                }
                else{
                    currentX--;
                    tmp=true;
                }
                break;

        }
        return tmp;
    }
}
