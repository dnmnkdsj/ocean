package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class MouseClick extends InputAdapter {

    private GameScreen gameScreen;

    public MouseClick (GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

	@Override
	public boolean touchUp(int screenX, int Y, int pointer, int button) {
        int screenY = 720 - Y;
        if ( ! gameScreen.isOver()) {
            if (gameScreen.currentShip != null) {   
                if (gameScreen.currentShip.isCanMoveNow()) {  // 2. have already not  achieve first move
                    if (gameScreen.currentShip.isReachable(screenX, screenY)) {  // Achiecve first movement 
                        System.out.println("yes, Reachable, achieve first movemoent, Next is attack");
                        gameScreen.removeRegion(gameScreen.currentShip.showReachableTiles());
                        gameScreen.currentShip.setCanMoveNow(false);
                        gameScreen.currentShip.moveTo(screenX / 60, screenY / 60);
                    }
                }
                else {  // 2. already achieve the first move
                    if (gameScreen.currentShip.isClickingItself (screenX, screenY)) { // Click itself
                        System.out.println("yes, All is achieved");
                        gameScreen.currentShip = null;
                        //gameScreen.currentShip.setCanMoveNow(false);
                    }
                    else if (gameScreen.currentShip.isAttackable(screenX/60, screenY/60)) {   //  Attack
                        System.out.println("yes, Complete attack");
                        gameScreen.currentShip.attack(screenX, screenY);
                        gameScreen.currentShip = null;
                        if (gameScreen.getModleControlller().isEnd())   gameScreen.setOver(true);
                    }
                }
            }
            else {  
                gameScreen.currentShip = Ship.getClickShip(screenX, screenY);
                System.out.println(screenX);
                System.out.println(screenY);
                if (gameScreen.currentShip != null) {
                    if (gameScreen.currentShip.isCanMoveNow() )
                        gameScreen.showRegion(gameScreen.currentShip.showReachableTiles());
                    else {
                        gameScreen.currentShip = null;
                    }

                }
            }
        }
            

		return true;
	}

}
