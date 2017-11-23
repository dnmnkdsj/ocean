package com.mygdx.game;

import java.util.ArrayList;

public class Tile {
	static public ArrayList<Tile> TileArray;
	private int positionX;
	private int positionY;
	private Ship shipAtThisTile;

	public Tile(int positionX, int positionY, Ship shipAtThisTile) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.shipAtThisTile = shipAtThisTile;
	}
	
	public Tile(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
}
