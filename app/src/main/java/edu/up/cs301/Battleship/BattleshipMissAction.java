package edu.up.cs301.Battleship;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

/**
 * @author Nathan Camacho
 * @author Hashim AlJawad
 * @author Kelson Sipe
 *
 * @version 11/10/15
 *
 * Description: A BattleshipMissAction is an action that represents a player failing to hit one
 * of the opponent's ships therefore they have missed their opponent's ships.
 */
public class BattleshipMissAction extends GameAction {
    /**
     * Constructor for the BattleshipMissAction class
     *
     * @param player the player who created the action
     */
    public BattleshipMissAction(GamePlayer player) {
        super(player);//invoke superclass constructor
    }
}
