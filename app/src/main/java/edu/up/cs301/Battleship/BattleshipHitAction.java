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
 * Description: A BattleshipHitAction is an action that represents a player successfully hitting one
 * of the opponent's ships.
 *
 */
public class BattleshipHitAction extends GameAction {
    /**
     * Constructor for the BattleshipHitAction class
     *
     * @param player the player who created the action
     */
    public BattleshipHitAction(GamePlayer player) {
        super(player);//invoke superclass constructor
    }
}
