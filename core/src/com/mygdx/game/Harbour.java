package com.mygdx.game;

import java.util.ArrayList;

public class Harbour extends Tile {

	private boolean isDestroyed = false;
	
	public Harbour(int positionX, int positionY, Ship shipAtThisTile) {
		super(positionX, positionY, shipAtThisTile);
	}
	public Harbour(int positionX, int positionY) {
		super(positionX, positionY);
	}
	
	
	public ArrayList<Tile> showAvailiableTilesForGenerating(){
		ArrayList<Tile> availiableTilesForGenerating = new ArrayList<Tile>();
		for(Tile t : Tile.tileArray) {
			int distance = Math.abs(t.getPositionX()-this.getPositionX())
					+ Math.abs(t.getPositionY()-this.getPositionY());			
			if  ( 1 == distance ) availiableTilesForGenerating.add(t);
		}
		return availiableTilesForGenerating ;
	}
	
	public void generateShip(Tile goalTile) {
		//TODO 在goalTile处生成Ship
	}
	

	public boolean getIsDestroyed() {
		return isDestroyed;
	}

	public void setIsDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
}
