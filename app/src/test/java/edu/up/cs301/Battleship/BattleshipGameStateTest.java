package edu.up.cs301.Battleship;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nathancamacho on 11/6/15.
 */
public class BattleshipGameStateTest {

    @Test
    public void testBattleshipGameState() throws Exception {
        //test 1st constructor
        BattleshipGameState test = new BattleshipGameState();
        assertEquals(test.getPlayerID(),0);
        assertEquals(test.getPlayer1Hits(),0);
        assertEquals(test.getPlayer2Hits(),0);

        assertEquals(test.getCarrierLife(),5);
        assertEquals(test.getBattleshipLife(),4);
        assertEquals(test.getDestroyerLife(),3);
        assertEquals(test.getSubmarineLife(),3);
        assertEquals(test.getPtBoatLife(),2);
        assertEquals(test.getAICarrierLife(),5);
        assertEquals(test.getAIBattleshipLife(),4);
        assertEquals(test.getAIDestroyerLife(),3);
        assertEquals(test.getAISubmarineLife(),3);
        assertEquals(test.getAIPtBoatLife(),2);

        int[][] testArray = test.getUserGrid();
        boolean dummy = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (testArray[i][j] != 0) {
                    dummy = false;
                }
            }
        }
        assertEquals(dummy,true);

        int[][] testComputerArray = test.getComputerGrid();
        boolean dummy2 = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (testComputerArray[i][j] != 0) {
                    dummy2 = false;
                }
            }
        }
        assertEquals(dummy2,true);

        //tests for 2nd constuctor
        //to test 2nd constructor we will alter the variables from the game state object above and
        //create a new object passing in the altered gameState object as a parameter
        test.setPlayer1Hits(3);
        test.setPlayer2Hits(2);
        test.setPlayerID(1);

        test.setCarrierLife(3);
        test.setAIBattleshipLife(2);
        test.setSubmarineLife(1);
        test.setAIPtBoatLife(0);

        testArray[3][1] = 3;
        testArray[8][6] = 3;

        testComputerArray[9][0] = 3;
        testComputerArray[5][5] = 3;

        BattleshipGameState test2 = new BattleshipGameState(test);

        assertEquals(test2.getPlayerID(), 1);
        assertEquals(test2.getPlayer1Hits(), 3);
        assertEquals(test2.getPlayer2Hits(), 2);

        assertEquals(test2.getCarrierLife(), 3);
        assertEquals(test2.getSubmarineLife(), 1);
        assertEquals(test2.getAIBattleshipLife(), 2);
        assertEquals(test2.getAIPtBoatLife(), 0);

        int[][] test2Array = test2.getUserGrid();
        int counter1 = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (test2Array[i][j] == 3) {
                    counter1++;
                }
            }
        }
        assertEquals(counter1,2);

        int[][] test2ComputerArray = test2.getComputerGrid();
        int counter2 = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (test2ComputerArray[i][j] == 3) {
                    counter2++;
                }
            }
        }
        assertEquals(counter2,2);


    }

    @Test
    public void testShipHit() throws Exception {
        BattleshipGameState test = new BattleshipGameState();

    }

    @Test
    public void testShipMissed() throws Exception {
        BattleshipGameState test = new BattleshipGameState();
        test.shipMissed(3,8);//0
        test.shipMissed(0,0);//1
        test.shipMissed(3,8);//0
        test.setUpComputerShips(2,9,0,false);
        test.shipHit(9, 0, 3);//0
        test.shipMissed(5,4);//1
        test.shipMissed(9,0);//0
        int[][] testComputerArray = test.getComputerGrid();
        int[][] testUserArray = test.getUserGrid();
        assertEquals(2,testComputerArray[3][8]);
        assertEquals(1,testComputerArray[9][0]);
        assertEquals(2,testUserArray[0][0]);
        assertEquals(2,testUserArray[5][4]);
    }
    
    @Test
    public void testSetUpUserShips(int shipNum, int row, int col, boolean isHorizontal) throws Exception {
        BattleshipGameState test = new BattleshipGameState();
        if (shipNum == 1) {//Carrier
            if(isHorizontal){
                assertEquals(test.getUserGrid(), 3);
            }
            else{
                assertEquals(test.getUserGrid(), 3);
            }
        }
        if (shipNum == 2) {//Battleship
            assertEquals(test.getUserGrid(), 3);
        }
        if (shipNum == 3) {//Destroyer
            assertEquals(test.getUserGrid(), 3);
        }
        if (shipNum == 4) {//Submarine
            assertEquals(test.getUserGrid(), 3);
        }
        if (shipNum == 5) {//PTBoat
            assertEquals(test.getUserGrid(), 3);
        }

    }

    @Test
    public void testSetUpComputerShips(int shipNum, int row, int col, boolean isHorizontal) throws Exception {
        BattleshipGameState test = new BattleshipGameState();
        if (shipNum == 1);{//AICarrier
            assertEquals(test.getComputerGrid(),3);
        }
        if (shipNum == 2);{//AIBattleship
            assertEquals(test.getComputerGrid(),3);
        }
        if (shipNum == 3);{//AIDestroyer
            assertEquals(test.getComputerGrid(),3);
        }
        if (shipNum == 4);{//AISubmarine
            assertEquals(test.getComputerGrid(),3);
        }
        if (shipNum == 5);{//AIPTBoat
            assertEquals(test.getComputerGrid(),3);
        }
    }

}