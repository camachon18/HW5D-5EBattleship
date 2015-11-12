package edu.up.cs301.Battleship;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * @author Nathan Camacho
 * @author Hashim AlJawad
 * @author Kelson Sipe
 *
 * @version  11/9/2015
 *
 * Description of BattleshipGameState class:
 * BattleshipGameState class inherits from the GameState class which is a part of the game framework.
 * It contains all informaton pertaining to the current state of the game so that the user may make
 * appropriate decisions. Also contains methods needed to modify the state based on user actions and
 * other events.
 *
 */

public class BattleshipGameState extends GameState {
    //Instance variables
    private int player1Hits;
    private int player2Hits;
    private int playerID;//to keep track of whose turn it is
    private int[] shipsLife = new int[5];//human's ships life
    private int[] computerShipsLife = new int[5];//AI's ships life
    private int[] shipID = {1,2,3,4,5};//shipID's
    //1 corresponds to the carrier ship
    //2 corresponds to the battleship
    //3 corresponds to the destroyer ship
    //4 corresponds to the submarine
    //5 corresponds to the patrol boat

    private int[][] userGrid;//grids to place both players ships on
    private int[][] computerGrid;


    /**
     * Description: First constructor, takes no parameters. Initializes all instance variables
     * appropriately.
     */
    public BattleshipGameState(){

        player1Hits = 0;
        player2Hits = 0;
        playerID = 0;//ID 0 refers to the human player. 1 refers to the AI. Human will go first.

        //All ships have a certain amount of life that will decrease by 1 if hit
        shipsLife[0] = 5;//carrier life
        shipsLife[1] = 4;//battleship life
        shipsLife[2] = 3;//destroyer ship life
        shipsLife[3] = 3;//submarine ship life
        shipsLife[4] = 2;//patrol boat life

        computerShipsLife[0] = 5;//carrier ship life
        computerShipsLife[1] = 4;//battleship life
        computerShipsLife[2] = 3;//destroyer ship life
        computerShipsLife[3] = 3;//submarine ship life
        computerShipsLife[4] = 2;//patrol boat life

        //Initialize a 10x10 grid for each player
        //Each location in the 10x10 grid will contain a 0,1,2, or 3
        //0 - means that this coordinate has not been chosen by the user yet, and there is no ship located
        //on this coordinate
        //1 - corresponds to there being a hit on that coordinate
        //2 - corresponds to there being a miss on that coordinate
        //3 - corresponds to there being a ship on that coordinate
        //Here we initialize all coordinates in both grids to 0
        userGrid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                userGrid[i][j] = 0;//0 means nothing there and it has not been touched yet
            }
        }
        computerGrid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                computerGrid[i][j] = 0;
            }
        }
    }

    /**
     * Description: Makes a copy of an existing game state.
     *
     * @param object  existing game state
     */
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

    //Getters and setters
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

    public void setPosInUserGrid(int row, int col, int value) {
        this.userGrid[row][col] = value;
    }
    public int[][] getComputerGrid() {
        return computerGrid;
    }

    public void setPosInComputerGrid(int row, int col, int value) {
        this.computerGrid[row][col] = value;
    }

    public int[] getShipsLife() { return shipsLife; }

    public int[] getComputerShipsLife() { return computerShipsLife; }

    /**
     * Description: Checks to see if one player has hit another player's ship. If this is true, then
     * this method will make the appropriate alterations to the game state. If the action from a player
     * is not a hit, then it must be a miss so it will call the shipMissed method. Also, a player's
     * turn will not change if they have not clicked on a valid location in the grid. i.e. if they clicked
     * on a coordinate they already hit or missed.
     *
     * CAVEAT: This method assumes that the location where a user touches on the screen will be translated
     * correctly to the appropriate x(row) and y(col) in their grid. This method also assumes a valid
     * ID will be passed in (1-5).
     *
     * @param row coordinates for location to check
     * @param col
     * @param ID ID of the ship that was hit
     */
    public void shipHit(int row, int col, int ID) {
            if (this.playerID == 0) {//human hit computer's ship
                //the player should be unable to click on a spot they already missed
                //their turn may not end until they hit or miss a new spot on the opponent's grid
                if (computerGrid[row][col] == 3) { //if a grid position equals 3, that means a ship is there
                    player1Hits = player1Hits + 1;//increment hits
                    this.playerID = 1;//change the turn of a player
                    computerGrid[row][col] = 1;//1 means there is a hit in this position
                    //loop through all ships
                    for (int i = 0; i < shipID.length; i++) {
                        if (ID == shipID[i]) { //decrease the life of the ship that was hit by 1
                            computerShipsLife[i] = computerShipsLife[i] - 1;
                        }
                    }
                } else {
                    this.shipMissed(row, col);//there is a miss in this location
                }
            } else { //computer hit human's ship
                if (userGrid[row][col] == 3) {//there is a ship in this location
                    player2Hits = player2Hits + 1;//increment hits
                    this.playerID = 0;//change turns
                    userGrid[row][col] = 1;//1 means there is a hit in this position
                    for (int i = 0; i < shipID.length; i++) {
                        if (ID == shipID[i]) {//decrease life of ship that was hit by 1
                            shipsLife[i] = shipsLife[i] - 1;

                        }
                    }
                } else {
                    this.shipMissed(row, col);//there is a miss in this location
                }
            }
    }

    /**
     * Description: This method alters a position in a player's grid so that there is now a "miss" in
     * that position
     *
     * @param row coordinates for location
     * @param col
     */
    public void shipMissed(int row,int col) {
        if (this.playerID == 0){//human missed in computer's grid
            if (computerGrid[row][col] == 0) {//0 means has not been clicked on already and no ships are there
                computerGrid[row][col] = 2;//change to a miss (2 corresponds to miss)
                this.playerID = 1;//change turns
            }
        }
        else {//computer missed in human's grid
            if (userGrid[row][col] == 0) {
                userGrid[row][col] = 2;
                this.playerID = 0;
            }
        }

    }

    /**
     * Description: Method to set up the user's ships. Changes the value in the appropriate coordinate
     * from 0 to 3. 3 means there is a ship in this coordinate.
     *
     * CAVEAT: This method assumes it is being passed valid row and col positions so that it does not
     * go out of bounds of the 10x10 grid.
     *
     * @param shipNum   indicates which ship is being set up
     * @param row       coordinates to set up ship in grid
     * @param col
     * @param isHorizontal  a ship can only be set up horizontally or vertically
     */
    public void setUpUserShips(int shipNum, int row, int col, boolean isHorizontal) {
        if (shipNum == 1) {//carrier ship, 5 positions long
            if (isHorizontal == true) { //the ship is positioned horizontally

                userGrid[row][col] = 3;
                userGrid[row + 1][col] = 3;
                userGrid[row + 2][col] = 3;
                userGrid[row + 3][col] = 3;
                userGrid[row + 4][col] = 3;

            } else {// the ship is positioned vertically
                userGrid[row][col] = 3;
                userGrid[row][col + 1] = 3;
                userGrid[row][col + 2] = 3;
                userGrid[row][col + 3] = 3;
                userGrid[row][col + 4] = 3;
            }
        }
        if (shipNum == 2) {//battleship, 4 positions long
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
        if (shipNum == 3) {//destroyer ship, 3 positions long
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
        if (shipNum == 4) {//submarine, 3 positions long
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
        if (shipNum == 5) {//pt boat, 2 positions long
            if (isHorizontal == true) {

                userGrid[row][col] = 3;
                userGrid[row + 1][col] = 3;

            } else {
                userGrid[row][col] = 3;
                userGrid[row][col + 1] = 3;
            }
        }

    }

    /**
     * Description: Method to set up the computer's ships. Changes the value in the appropriate coordinate
     * from 0 to 3. 3 means there is a ship in this coordinate.
     *
     * CAVEAT: This method assumes it is being passed valid row and col positions so that it does not
     * go out of bounds of the 10x10 grid.
     *
     * @param shipNum   indicates which ship is being set up
     * @param row       coordinates to set up ship in grid
     * @param col
     * @param isHorizontal  a ship can only be set up horizontally or vertically
     */
    public void setUpComputerShips(int shipNum, int row, int col, boolean isHorizontal) {
        if (shipNum == 1) {//carrier ship, 5 positions long
            if (isHorizontal == true) {//the ship is positioned horizontally

                computerGrid[row][col] = 3;
                computerGrid[row + 1][col] = 3;
                computerGrid[row + 2][col] = 3;
                computerGrid[row + 3][col] = 3;
                computerGrid[row + 4][col] = 3;

            } else {//the ship is positioned vertically
                computerGrid[row][col] = 3;
                computerGrid[row][col + 1] = 3;
                computerGrid[row][col + 2] = 3;
                computerGrid[row][col + 3] = 3;
                computerGrid[row][col + 4] = 3;
            }
        }
        if (shipNum == 2) {//battleship, 4 positions long
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
        if (shipNum == 3) {//destroyer ship, 3 positions long
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
        if (shipNum == 4) {//submarine, 3 positions long
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
        if (shipNum == 5) {//pt boat, 2 positions long
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
