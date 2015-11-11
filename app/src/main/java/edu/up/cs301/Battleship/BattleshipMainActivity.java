package edu.up.cs301.Battleship;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.config.GameConfig;

/**
 * Created by nathancamacho on 11/10/15.
 */
public class BattleshipMainActivity extends GameMainActivity implements View.OnClickListener {

    public Button playNow;
    public Button howToPlay;
    public Spinner chooseAI;
    public Intent sendAI;

    @Override
    public GameConfig createDefaultConfig() {
        return null;
    }

    @Override
    public LocalGame createLocalGame() {
        return null;
    }

    @Override
    public void onClick(View view){

    }
}
