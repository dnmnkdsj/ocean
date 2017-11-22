package com.mygdx.game;

public class GameController {
	private Player nowPlayer;
	private Player nextPlayer;
	
	public void initGame() {
		//TODO Tile,Ship,Player初始化。及相互绑定，
	}
	public void switchPlayer() {
		/*
		Player temp = new Player();
		temp = this.nowPlayer;
		this.nowPlayer=this.nextPlayer;
		this.nextPlayer=nowPlayer;
		 */
	}
	public boolean isEnd() {//如果nextPlayer的港口被占，则游戏结束
		if(this.nextPlayer.getHarbourOfThisPlayer().getIsDestroyed())	return true;
		else return false;
	}
	public void removeShip() {
		//TODO Ship死亡后移除，并返还对方金钱
	}
}
