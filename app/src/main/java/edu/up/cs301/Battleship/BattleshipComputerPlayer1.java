package edu.up.cs301.Battleship;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * Created by nathancamacho on 11/10/15.
 */
public class BattleshipComputerPlayer1 extends GameComputerPlayer implements BattleshipPlayer {
    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public BattleshipComputerPlayer1(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {

    }
}
