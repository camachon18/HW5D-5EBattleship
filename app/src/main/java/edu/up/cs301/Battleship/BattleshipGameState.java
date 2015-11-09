package edu.up.cs301.Battleship;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by aljawad18 on 11/5/2015.
 */
public class BattleshipGameState extends GameState {
    private int player1Hits;
    private int player2Hits;
    private int playerID;
    private boolean isHit = false;
    private int[] shipsLife = new int[5];//human's ships life
    private int[] computerShipsLife = new int[5];
    private int[] shipID = {1,2,3,4,5};
    private int[][] userGrid;
    private int[][] computerGrid;

    public BattleshipGameState(){

        player1Hits = 0;
        player2Hits = 0;
        playerID = 0;

        shipsLife[0] = 5;//carrier ship
        shipsLife[1] = 4;//battleship
        shipsLife[2] = 3;//destroyer ship
        shipsLife[3] = 3;//submarine ship
        shipsLife[4] = 2;//patrol boat

        computerShipsLife[0] = 5;//carrier ship
        computerShipsLife[1] = 4;//battleship
        computerShipsLife[2] = 3;//destroyer ship
        computerShipsLife[3] = 3;//submarine ship
        computerShipsLife[4] = 2;//patrol boat

        userGrid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                userGrid[i][j] = 0;//0 means nothing there and it has not been clicked on yet
            }
        }
        computerGrid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                computerGrid[i][j] = 0;
            }
        }
    }

    public BattleshipGameState(BattleshipGameState object){

        this.player1Hits = object.player1Hits;
        this.player2Hits = object.player2Hits;
        this.playerID = object.playerID;

        this.shipsLife[0] = object.shipsLife[0];
        this.shipsLife[1] = object.shipsLife[1];
        this.shipsLife[2] = object.shipsLife[2];
        this.shipsLife[3] = object.shipsLife[3];
        this.shipsLife[4] = object.shipsLife[4];

        this.computerShipsLife[0] = object.computerShipsLife[0];
        this.computerShipsLife[1] = object.computerShipsLife[1];
        this.computerShipsLife[2] = object.computerShipsLife[2];
        this.computerShipsLife[3] = object.computerShipsLife[3];
        this.computerShipsLife[4] = object.computerShipsLife[4];

        userGrid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                userGrid[i][j] = object.userGrid[i][j];
            }
        }
        computerGrid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                computerGrid[i][j] = object.computerGrid[i][j];
            }
        }

    }

    public int getPtBoatLife() {return shipsLife[4];}

    public void setPtBoatLife(int ptBoatLife) {this.shipsLife[4] = ptBoatLife;}

    public int getSubmarineLife() {return shipsLife[3];}

    public void setSubmarineLife(int submarineLife) {this.shipsLife[3] = submarineLife;}

    public int getDestroyerLife() {return shipsLife[2];}

    public void setDestroyerLife(int destroyerLife) {
        this.shipsLife[2] = destroyerLife;
    }

    public int getBattleshipLife() {
        return shipsLife[1];
    }

    public void setBattleshipLife(int battleshipLife) {
        this.shipsLife[1] = battleshipLife;
    }

    public int getCarrierLife() {
        return shipsLife[0];
    }

    public void setCarrierLife(int carrierLife) {
        this.shipsLife[0] = carrierLife;
    }

    public int getAIPtBoatLife() {return computerShipsLife[4];}

    public void setAIPtBoatLife(int ptBoatLife) {this.computerShipsLife[4] = ptBoatLife;}

    public int getAISubmarineLife() {return computerShipsLife[3];}

    public void setAISubmarineLife(int submarineLife) {this.computerShipsLife[3] = submarineLife;}

    public int getAIDestroyerLife() {return computerShipsLife[2];}

    public void setAIDestroyerLife(int destroyerLife) {
        this.computerShipsLife[2] = destroyerLife;
    }

    public int getAIBattleshipLife() {
        return computerShipsLife[1];
    }

    public void setAIBattleshipLife(int battleshipLife) {
        this.computerShipsLife[1] = battleshipLife;
    }

    public int getAICarrierLife() {
        return computerShipsLife[0];
    }

    public void setAICarrierLife(int carrierLife) {
        this.computerShipsLife[0] = carrierLife;
    }


    public boolean getIsHit() {
        return isHit;
    }
    public void setIsHit(boolean isHit) {
        this.isHit = isHit;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getPlayer2Hits() {
        return player2Hits;
    }

    public void setPlayer2Hits(int player2Hits) {
        this.player2Hits = player2Hits;
    }

    public int getPlayer1Hits() {
        return player1Hits;
    }

    public void setPlayer1Hits(int player1Hits) {
        this.player1Hits = player1Hits;
    }

    public int[][] getUserGrid() {
        return userGrid;
    }
    public int[][] getComputerGrid() {
        return computerGrid;
    }

    public int[] getShipsLife() { return shipsLife; }
    public int[] getComputerShipsLife() { return computerShipsLife; }

    public void shipHit(int row, int col, int ID) {
            if (this.playerID == 0) {//human hit computer
                //the player should be unable to click on a spot they already missed
                //their turn may not end until they hit or miss a new spot on the opponent's grid
                if (computerGrid[row][col] == 3) { //if a grid position equals 3, that means a ship is there
                    player1Hits = player1Hits + 1;
                    this.playerID = 1;
                    computerGrid[row][col] = 1;//1 means there is a hit in this position
                    for (int i = 0; i < shipID.length; i++) {
                        if (ID == shipID[i]) {
                            computerShipsLife[i] = computerShipsLife[i] - 1;
                        }
                    }
                } else {
                    this.shipMissed(row, col);
                }
            } else { //computer hit human
                if (userGrid[row][col] == 3) {
                    player2Hits = player2Hits + 1;
                    this.playerID = 0;
                    userGrid[row][col] = 1;
                    for (int i = 0; i < shipID.length; i++) {
                        if (ID == shipID[i]) {
                            shipsLife[i] = shipsLife[i] - 1;

                        }
                    }
                } else {
                    this.shipMissed(row, col);
                }
            }
    }
    public void shipMissed(int row,int col) {
        if (this.playerID == 0){
            //We don't want to change a spot that was hit to a miss
            if (computerGrid[row][col] == 0) {
                computerGrid[row][col] = 2;
                this.playerID = 1;
            }
        }
        else {
            if (userGrid[row][col] == 0) {
                userGrid[row][col] = 2;
                this.playerID = 0;
            }
        }

    }
    //assume we are being passed valid row, and col positions
    public void setUpUserShips(int shipNum, int row, int col, boolean isHorizontal) {
        if (shipNum == 1) {//carrier
            if (isHorizontal == true) {

                userGrid[row][col] = 3;
                userGrid[row + 1][col] = 3;
                userGrid[row + 2][col] = 3;
                userGrid[row + 3][col] = 3;
                userGrid[row + 4][col] = 3;

            } else {
                userGrid[row][col] = 3;
                userGrid[row][col + 1] = 3;
                userGrid[row][col + 2] = 3;
                userGrid[row][col + 3] = 3;
                userGrid[row][col + 4] = 3;
            }
        }
        if (shipNum == 2) {//battleship
            if (isHorizontal == true) {

                userGrid[row][col] = 3;
                userGrid[row + 1][col] = 3;
                userGrid[row + 2][col] = 3;
                userGrid[row + 3][col] = 3;

            } else {
                userGrid[row][col] = 3;
                userGrid[row][col + 1] = 3;
                userGrid[row][col + 2] = 3;
                userGrid[row][col + 3] = 3;
            }
        }
        if (shipNum == 3) {//destroyer
            if (isHorizontal == true) {

                userGrid[row][col] = 3;
                userGrid[row + 1][col] = 3;
                userGrid[row + 2][col] = 3;

            } else {
                userGrid[row][col] = 3;
                userGrid[row][col + 1] = 3;
                userGrid[row][col + 2] = 3;
            }
        }
        if (shipNum == 4) {//submarine
            if (isHorizontal == true) {

                userGrid[row][col] = 3;
                userGrid[row + 1][col] = 3;
                userGrid[row + 2][col] = 3;
            } else {
                userGrid[row][col] = 3;
                userGrid[row][col + 1] = 3;
                userGrid[row][col + 2] = 3;
            }
        }
        if (shipNum == 5) {//pt boat
            if (isHorizontal == true) {

                userGrid[row][col] = 3;
                userGrid[row + 1][col] = 3;

            } else {
                userGrid[row][col] = 3;
                userGrid[row][col + 1] = 3;
            }
        }

    }
    //assume we are being passed valid row, and col positions
    public void setUpComputerShips(int shipNum, int row, int col, boolean isHorizontal) {
        if (shipNum == 1) {//carrier
            if (isHorizontal == true) {

                computerGrid[row][col] = 3;
                computerGrid[row + 1][col] = 3;
                computerGrid[row + 2][col] = 3;
                computerGrid[row + 3][col] = 3;
                computerGrid[row + 4][col] = 3;

            } else {
                computerGrid[row][col] = 3;
                computerGrid[row][col + 1] = 3;
                computerGrid[row][col + 2] = 3;
                computerGrid[row][col + 3] = 3;
                computerGrid[row][col + 4] = 3;
            }
        }
        if (shipNum == 2) {//battleship
            if (isHorizontal == true) {

                computerGrid[row][col] = 3;
                computerGrid[row + 1][col] = 3;
                computerGrid[row + 2][col] = 3;
                computerGrid[row + 3][col] = 3;

            } else {
                computerGrid[row][col] = 3;
                computerGrid[row][col + 1] = 3;
                computerGrid[row][col + 2] = 3;
                computerGrid[row][col + 3] = 3;
            }
        }
        if (shipNum == 3) {//destroyer
            if (isHorizontal == true) {

                computerGrid[row][col] = 3;
                computerGrid[row + 1][col] = 3;
                computerGrid[row + 2][col] = 3;

            } else {
                computerGrid[row][col] = 3;
                computerGrid[row][col + 1] = 3;
                computerGrid[row][col + 2] = 3;
            }
        }
        if (shipNum == 4) {//submarine
            if (isHorizontal == true) {

                computerGrid[row][col] = 3;
                computerGrid[row + 1][col] = 3;
                computerGrid[row + 2][col] = 3;
            } else {
                computerGrid[row][col] = 3;
                computerGrid[row][col + 1] = 3;
                computerGrid[row][col + 2] = 3;
            }
        }
        if (shipNum == 5) {//pt boat
            if (isHorizontal == true) {

                computerGrid[row][col] = 3;
                computerGrid[row + 1][col] = 3;

            } else {
                computerGrid[row][col] = 3;
                computerGrid[row][col + 1] = 3;
            }
        }

    }
}
