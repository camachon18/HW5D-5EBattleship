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

        //human ships
        test.setUpUserShips(1, 5, 5, true);//userGird[5-9][5] horizontally
        test.setUpUserShips(2, 0, 0, true);//userGrid[0-3][0] horizontally
        test.setUpUserShips(3, 5, 0, false);//userGrid[5][0-2] vertically
        test.setUpUserShips(4, 6, 0, false);//userGrid[6][0-2] vertically
        test.setUpUserShips(5, 4, 2, false);//userGrid[4][2-3] vertically

        //computer ships
        test.setUpComputerShips(1, 9, 5, false);//computerGird[9][5-9] vertically
        test.setUpComputerShips(2, 0, 0, true);//computerGird[0-3][2] horizontally
        test.setUpComputerShips(3, 2, 4, true);//computerGrid[2-4][4] horizontally
        test.setUpComputerShips(4, 6, 1, false);//computerGrid[6][1-3] vertically
        test.setUpComputerShips(5, 5, 0, false);//computerGrid[5][0-1] vertically

        //check that both players have 0 hits before the game starts
        assertEquals(test.getPlayer1Hits(), 0);
        assertEquals(test.getPlayer2Hits(), 0);

        //human turn
        test.shipHit(9, 5, 1);//hit

        //computer turn
        test.shipHit(1, 0, 2);//hit

        //human turn
        test.shipHit(2, 6, 6);//should miss

        //computer turn
        test.shipHit(6, 2 ,4);//hit

        //human turn
        test.shipHit(9, 6, 1);//hit

        //computer turn
        test.shipHit(4, 3 ,5);//hit

        //human turn
        test.shipHit(6, 2, 4);//hit

        //computer turn
        test.shipHit(5, 1, 3);//hit

        //human turn
        test.shipHit(0, 0, 2);//hit

        //computer turn
        test.shipHit(5, 6, 7);//should miss

        //human turn
        test.shipHit(5, 1, 5);//hit

        //computer turn
        test.shipHit(4, 2, 5);//hit

        BattleshipGameState test1 = new BattleshipGameState(test);

        //this should be correct because the human got 5 hits and the computer got 5 hits
        assertEquals(test1.getPlayer1Hits(), 5);
        assertEquals(test1.getPlayer2Hits(), 5);

        //the computer carrier ship life should be 3 because it got hit once.
        //the human carrier ship life should be 5 because it did not get hit.
        assertEquals(test1.getAICarrierLife(), 3);
        assertEquals(test1.getCarrierLife(), 5);

        //the computer battleship life should be 3 because it got hit once.
        //the human battleship life should be 3 because it got hit once.
        assertEquals(test1.getAIBattleshipLife(), 3);
        assertEquals(test1.getBattleshipLife(), 3);

        //the computer destroyer ship life should be 3 because it did not get hit.
        //the human destroyer ship life should be 2 because it got hit once.
        assertEquals(test1.getAIDestroyerLife(), 3);
        assertEquals(test1.getDestroyerLife(), 2);

        //the human submarine ship life should be 2 because it got hit once.
        //the computer submarine ship life should be 2 because it got hit once.
        assertEquals(test1.getSubmarineLife(), 2);
        assertEquals(test1.getAISubmarineLife(),2);

        //the human pt boat life should be 0 because it got hit twice.
        //the computer pt boat life should be 1 because it got hit once.
        assertEquals(test1.getPtBoatLife(),0);
        assertEquals(test1.getAIPtBoatLife(),1);

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
    public void testSetUpUserShips() throws Exception {
        BattleshipGameState test = new BattleshipGameState();
        test.setUpUserShips(1,5,5,true);

    }

    @Test
    public void testSetUpComputerShips() throws Exception {
    }

}