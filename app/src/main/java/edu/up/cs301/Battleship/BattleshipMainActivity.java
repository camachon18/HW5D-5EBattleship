package edu.up.cs301.Battleship;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.config.GameConfig;

/**
 * @author Nathan Camacho
 * @author Hashim AlJawad
 * @author Kelson Sipe
 *
 * @version 11/10/15
 *
 * Description: The primary activity for the Battleship Game. This is the screen that will pop up when
 * the game is first launched.
 *
 */
public class BattleshipMainActivity extends GameMainActivity implements View.OnClickListener {

    public Button playNow;//button to take player to play a new Battleship Game
    public Button howToPlay;//button to take player to the howToPlay activity
    public Spinner chooseAI;//Spinner that will allow the user to choose which AI they will play
    public ArrayList<String> AInames;//"normal" or "hard"
    public Intent sendAI;//data to send to the game

    /**
     * Description: A Battleship game is strictly for two players. The default is human vs. computer
     *
     * @return
     */
    @Override
    public GameConfig createDefaultConfig() {
        return null;
    }

    /**
     * Description: Creates a new game for the user
     *
     * @return  should return an instance of BattleshipLocalGame
     */
    @Override
    public LocalGame createLocalGame() {
        return null;
    }

    /**
     * Description: Called when a button is clicked
     *
     * @param view
     */
    @Override
    public void onClick(View view){

    }
}
