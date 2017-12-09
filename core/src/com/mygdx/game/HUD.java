package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


public class HUD extends Actor {
    private GameScreen game;
    public HUD (GameScreen game) {
        this.game = game;
        //TextButtonStyle ButtonStyle = new ButtonStyle();
        //textButtonStyle.font = new BitmapFont();
        ImageButton nextTurnButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("下一回合.png"))));
        nextTurnButton.setPosition(1140, 660);
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



