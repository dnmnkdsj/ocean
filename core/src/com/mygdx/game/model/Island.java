package com.mygdx.game.model;

public class Island extends Tile {
	private Player owner;
	
	public Island(int positionX, int positionY, Ship shipAtThisTile) {
		super(positionX, positionY, shipAtThisTile);
	}
	public Island(int positionX, int positionY) {
		super(positionX, positionY);
	}
	

	public void generateAssests() {
		this.owner.setMoney(this.owner.getMoney()+5);
		this.owner.setPopulation(this.owner.getPopulation()+5);
		//TODO 数值待定
	}
}
