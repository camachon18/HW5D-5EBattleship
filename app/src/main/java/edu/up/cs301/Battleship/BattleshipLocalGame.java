package edu.up.cs301.Battleship;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;

/**
 * @author Nathan Camacho
 * @author Hashim AlJawad
 * @author Kelson Sipe
 *
 * @version 11/10/15
 *
 * Description: The BattleshipLocalGame class for a Battleship game. Makes sure the game is played according
 * to the rules. Also, handles interactions between players.
 */
public class BattleshipLocalGame extends LocalGame implements BattleshipGame {

    private BattleshipGameState state;//the game's state

    /**
     *  Description: Constructor for the BattleshipLocalGame class
     */
    public BattleshipLocalGame(){
        super();
        state = new BattleshipGameState();
    }

    /**
     * Description: Sends the updated to state to a given player
     *
     * @param p  the player to which the state is to be sent
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {

    }

    /**
     * Description: Checks to see if a certain player is allowed to make a move at a certain point
     * in the game
     *
     * @param playerIdx
     * 		the player's player-number (ID)
     * @return  true if the player is allowed to move
     */
    @Override
    protected boolean canMove(int playerIdx) {
        return false;
    }

    /**
     * Description: Method to check if the game is over.
     *
     * @return  a string message saying who the winner is, null if the game is not over yet
     */
    @Override
    protected String checkIfGameOver() {
        return null;
    }

    /**
     * Description: Makes a move on behalf of the player
     *
     * @param action
     * 			The move that the player has sent to the game
     * @return  true if move was legal, else false
     */
    @Override
    protected boolean makeMove(GameAction action) {
        return false;
    }
}
