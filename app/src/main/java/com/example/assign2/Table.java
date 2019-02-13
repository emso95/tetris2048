package com.example.assign2;

public class Table {

    Grid[][] grids;
    int currentX;
    int currentY;
    int currentNum;
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
                    if(grids[currentY+1][currentX].isTaken()&& grids[currentY+1][currentX].getNum()==currentNum){
                        currentNum++;
                        tmp=true;
                        this.resetGrid(currentY,currentX);
                    }
                    else if(!grids[currentY+1][currentX].isTaken())
                        tmp=true;
                    else {
                        tmp = false;

                    }
                }
                break;
            case 3:
                if(currentX+1>3){
                    tmp=false;
                }
                else{
                    if(grids[currentY][currentX+1].isTaken()&& grids[currentY][currentX+1].getNum()==currentNum){
                        currentNum++;
                        tmp=true;
                        this.resetGrid(currentY,currentX);
                    }
                    else if(!grids[currentY][currentX+1].isTaken())
                        tmp=true;
                    else {
                        tmp = false;
                    }
                }
                break;
            case 4:
                if(currentX-1<0){
                    tmp=false;
                }
                else{
                    if(grids[currentY][currentX-1].isTaken() && grids[currentY][currentX-1].getNum()==currentNum){
                        currentNum++;
                        tmp=true;
                        this.resetGrid(currentY,currentX);
                    }
                    else if(!grids[currentY][currentX-1].isTaken())
                        tmp=true;
                    else {

                        tmp = false;
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
    public void resetGrid(int y,int x){
        grids[y][x].setTaken(false);
        grids[y][x].makeInvisible();
    }

    public boolean checkEndGame(){
        if(currentY==0){
            return true;
        }
        else{
            if(currentNum==10){
                return true;
            }
            else {
                return false;
            }
        }
    }
    public boolean checkDouble(int currentNum,int y,int x){
        if(grids[y][x].getNum()==currentNum){
            return true;
        }
        else
            return false;
    }
    public void changeNum(){
        grids[currentY][currentX].setNum(currentNum);
    }
}
