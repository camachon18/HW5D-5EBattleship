package edu.up.cs301.Battleship;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

/**
 * Created by nathancamacho on 11/10/15.
 */
public class BattleshipHitAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public BattleshipHitAction(GamePlayer player) {
        super(player);
    }
}
