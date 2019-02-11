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
                if(currentY+1>4){
                    tmp=false;
                }
                else{
                    if(grids[currentY+1][currentX].isTaken()){
                        tmp=false;
                    }
                    else {
                        tmp = true;

                    }
                }
                break;
            case 3:
                if(currentX+1>3){
                    tmp=false;
                }
                else{
                    if(grids[currentY][currentX+1].isTaken()){
                        tmp=false;
                    }
                    else {
                        tmp = true;
                    }
                }
                break;
            case 4:
                if(currentX-1<0){
                    tmp=false;
                }
                else{
                    if(grids[currentY][currentX-1].isTaken()){
                        tmp=false;
                    }
                    else {

                        tmp = true;
                    }
                }
                break;

        }
        return tmp;
    }
    public void fillGrid(int imageName){
        grids[currentY][currentX].setTaken(true);
        grids[currentY][currentX].changeResource(imageName);
    }
    public void resetGrid(int x,int y){
        grids[x][y].setTaken(false);
        grids[x][y].changeResource(R.drawable.grid);
    }

    public boolean checkEndGame(){
        if(currentY==0){
            return true;
        }
        else{
            return false;
        }
    }
}
