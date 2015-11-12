package edu.up.cs301.Battleship;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 *  @author Nathan Camacho
 *  @author Hashim AlJawad
 *  @author Kelson Sipe
 *
 *  @version 11/10/15
 *
 *  Description: This is the normal difficulty computer player. It will attempt to play Battleship
 *  how a human would normally play it, by picking random coordinates to fire at and if they get a hit,
 *  choose locations around the hit.
 */

public class BattleshipComputerPlayer1 extends GameComputerPlayer implements BattleshipPlayer {
    /**
     * Constructor for the BattleshipComputerPlayer1 class
     *
     * @param name the player's name
     */
    public BattleshipComputerPlayer1(String name) {
        super(name);
    }

    /**
     * Description: Called when the player receives a new info (mainly the game state) from the game
     *
     * @param info  message from the game
     */
    @Override
    protected void receiveInfo(GameInfo info) {

    }
}
