package edu.up.cs301.Battleship;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;

/**
 * Created by nathancamacho on 11/10/15.
 */
public class BattleshipLocalGame extends LocalGame implements BattleshipGame {

    private BattleshipGameState state;

    public BattleshipLocalGame(){
        state = new BattleshipGameState();
    }
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {

    }

    @Override
    protected boolean canMove(int playerIdx) {
        return false;
    }

    @Override
    protected String checkIfGameOver() {
        return null;
    }

    @Override
    protected boolean makeMove(GameAction action) {
        return false;
    }
}
