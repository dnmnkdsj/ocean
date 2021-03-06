package com.mygdx.game;

import java.util.ArrayList;

public class Tile {
	static public ArrayList<Tile> tileArray = new ArrayList<Tile>();
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

    public static boolean isHereShip ( int x, int y) {
        for(Tile tile : tileArray) {
            if( x == tile.getPositionX() && y == tile.getPositionY() ) {
                return true;
            }
        }

        return false;
    }
    //交互接口
	public static Tile getTileAtXY(int x,int y) {//XY is in [tile coordinate system]
		for(Tile t :Tile.tileArray) {
			int x_t = t.getPositionX();
			int y_t = t.getPositionY();
			if( x_t == x && y_t == y ) {
				return t;
			}
		}	
		return null;
	}

}
