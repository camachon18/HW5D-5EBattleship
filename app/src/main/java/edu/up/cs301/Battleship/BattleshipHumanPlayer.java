package edu.up.cs301.Battleship;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import edu.up.cs301.game.GameHumanPlayer;
import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * Created by nathancamacho on 11/10/15.
 */
public class BattleshipHumanPlayer extends GameHumanPlayer implements View.OnTouchListener, View.OnClickListener, BattleshipPlayer {

    private TextView gameInfo;
    /**
     * constructor
     *
     * @param name
     */
    public BattleshipHumanPlayer(String name) {
        super(name);
    }

    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {

    }

    public void setAsGui(GameMainActivity activity) {

    }

    public void onClick(View view) {

    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }


}
