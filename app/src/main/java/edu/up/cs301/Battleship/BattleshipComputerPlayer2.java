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
 *  Description: This is the harder difficulty computer player. It will have a slight edge over the
 *  human player by being able to know specifically where a few of the humans ships are placed.
 */
public class BattleshipComputerPlayer2 extends GameComputerPlayer implements BattleshipPlayer {
    /**
     * The constructor for the BattleshipComputerPlayer2 class
     *
     * @param name the player's name
     */
    public BattleshipComputerPlayer2(String name) {
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
