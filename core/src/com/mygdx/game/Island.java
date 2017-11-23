package com.mygdx.game;

public class Island extends Tile {
	private Player owner;
	
	public Island(int positionX, int positionY, Ship shipAtThisTile) {
		super(positionX, positionY, shipAtThisTile);
	}
	public Island(int positionX, int positionY) {
		super(positionX, positionY);
	}
	
	public void occupiedBy(Ship ship) {
		//TODO 被参数ship的owner占领
	}
	public void generateAssests() {
		//TODO 为this.owner生产money,population
	}
}
