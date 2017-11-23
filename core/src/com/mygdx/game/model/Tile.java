package com.mygdx.game.model;

import java.util.ArrayList;

public class Tile {
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

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public Ship getShipAtThisTile() {
		return shipAtThisTile;
	}

	public void setShipAtThisTile(Ship shipAtThisTile) {
		this.shipAtThisTile = shipAtThisTile;
	}

	
}
