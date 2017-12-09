package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;


public class HUD extends Actor {
    private GameScreen game;
    public HUD (GameScreen game) {
        this.game = game;
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = new BitmapFont();
        TextButton nextTurnButton = new TextButton("Next Turn", textButtonStyle);
        nextTurnButton.setPosition(800, 10);
        nextTurnButton.addListener(
            new InputListener()  {
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    System.out.println("Next TURN!!!");
                    toggleNextTurn();
                    //return true;
                }
				@Override
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    System.out.println("Next TURN!!!");
					return true;
				}
			}
        );

        game.getUiStage().addActor(nextTurnButton);

    }

    private void toggleNextTurn () {
        game.currentTurn += 1;
        game.getModleControlller().resetMove(game.currentTurn);
    }
}



