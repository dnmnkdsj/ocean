package com.mygdx.game;

import java.util.ArrayList;

public class Harbour extends Tile {
	private boolean isDestroyed;
	
	public ArrayList<Tile> showAvailiableTilesForGenerating(){
		ArrayList<Tile> availiableTilesForGenerating = new ArrayList<Tile>();
		//TODO 求可生产Ship的Tiles
		return availiableTilesForGenerating ;
	}
	
	public void generateShip(Tile goalTile) {
		//TODO 在goalTile处生成Ship
	}
	
	public void destroyedBy(Ship ship) {
		//TODO 判定ship可否摧毁Harbour.若能,则摧毁
	}

	public boolean getIsDestroyed() {
		return isDestroyed;
	}

	public void setIsDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
}
