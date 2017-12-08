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
        if (gameScreen.currentShip != null) {   
            System.out.println("yes");
            if (gameScreen.currentShip.isCanMoveNow()) {  // 2. have already not  achieve first move
                System.out.println("yes, enter seconed");
                if (gameScreen.currentShip.isReachable(screenX, screenY)) {  // Achiecve first movement 
                    System.out.println("yes, Reachable");
                    gameScreen.removeRegion(gameScreen.currentShip.showReachableTiles());
                    gameScreen.currentShip.moveTo(screenX / 60, screenY / 60);
                }
            }
            else {  // 2. already achieve the first move
                if (gameScreen.currentShip.isClickingItself (screenX, screenY)) { // Click itself
                    gameScreen.currentShip = null;
                    gameScreen.currentShip.setCanMoveNow(false);
                }
                else if (gameScreen.currentShip.isAttackable(screenX, screenY)) {   //  Attack
                    gameScreen.currentShip.attack(screenX, screenY);
                    
                }
            }
        }
        else {  
            gameScreen.currentShip = Ship.getClickShip(screenX, screenY);
            System.out.println(screenX);
            System.out.println(screenY);
            if (gameScreen.currentShip != null) {
                //if (gameScreen.currentShip.showReachableTiles() != null)
                gameScreen.showRegion(gameScreen.currentShip.showReachableTiles());

            }
        }
            

		return true;
	}

}
