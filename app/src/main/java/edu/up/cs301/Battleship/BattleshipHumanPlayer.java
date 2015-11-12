package edu.up.cs301.Battleship;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.up.cs301.game.GameHumanPlayer;
import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * @author Nathan Camacho
 * @author Hashim AlJawad
 * @author Kelson Sipe
 *
 * @version 11/10/15
 *
 * Description: A GUI that allows a human to play Battleship. The user will first have to set up their
 * ships on their grid. Then, they will be able to make moves by clicking on a square coordinate location.
 *
 */
public class BattleshipHumanPlayer extends GameHumanPlayer implements View.OnTouchListener, View.OnClickListener, BattleshipPlayer {

    private TextView messageScreen;//to display information about the game to the user
    private GameMainActivity myActivity;//the current activity
    private BattleshipGameState state;//the game's state
    private SurfaceView sv;//what we will use to draw the grids on
    public Button readyToPlay;//button to be clicked when user is finished setting up ships
    /**
     * Constructor for the BattleshipHumanPlayer class
     *
     * @param name name of the player
     */
    public BattleshipHumanPlayer(String name) {
        super(name);
    }

    /**
     * Description: Returns the GUI's top view
     *
     * @return  the GUI's top view
     */
    @Override
    public View getTopView() {
        return null;
    }


    /**
     * Description: Called when the player receives a new info (mainly the game state) from the game
     *
     * @param info  the message
     */
    @Override
    public void receiveInfo(GameInfo info) {

    }

    /**
     * Description: Called whenever the GUI has changed
     *
     * @param activity  the current activity
     */
    public void setAsGui(GameMainActivity activity) {

    }

    /**
     * Description: Called when buttons in the GUI are clicked
     *
     * @param view
     */
    public void onClick(View view) {

    }

    /**
     * Description: Called when we receive a touch on the screen
     *
     * @param view
     * @param motionEvent
     * @return
     */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    /**
     * Description: Converts the pixel coordinates from where the user touches the screen into square
     * coordinates
     *
     * @param x  the x pixel coordinate
     * @param y  the y pixel coordinate
     * @return   a Point that corresponds to the row and column in a player's grid
     */
    public Point changeToXY(int x, int y) {

        return null;
    }

    /**
     * Description: Method to draw the user's ships on their grid
     *
     * CAVEAT: do not know if we will need parameters
     *
     */
    public void drawShips() {

    }

    /**
     * Description: Method to draw a red or white square on a player's grid that will symbolize a hit or
     * a miss action
     *
     * @param x  the row in the grid
     * @param y  the col in the grid
     */
    public void drawSquare(int x, int y){

    }

}
