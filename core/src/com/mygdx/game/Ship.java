package com.mygdx.game;

import java.util.ArrayList;

public class Ship {
	private int maxHP = 100;
	private int nowHP = 100;
	private int atk = 100;
	private int def = 50;
	private int minAttackingRange = 1;
	private int maxAttackingRange = 1;
	private Tile positionTile;
	private int movingRange = 5;
	private boolean canMoveNow=true;
	private Player owner;
	
	public Ship(Tile positionTile, Player owner) {
		this.positionTile = positionTile;
		this.owner = owner;
	}
	public ArrayList<Tile> showReachableTiles() {
		ArrayList<Tile> reachableTiles = new ArrayList<Tile>();
		for(Tile t : Tile.tileArray) {
			int distance =Math.abs(t.getPositionX()-this.getPositionTile().getPositionX())+Math.abs(t.getPositionY()-this.getPositionTile().getPositionY());
			
			if( distance > this.getMovingRange()) continue;//移动力可达
			if( null != t.getShipAtThisTile()) continue;//无其他单位所在
			if( false ) continue;//TODO 判断地形对船种的可达性.
			
			reachableTiles.add(t);
		}
		
		return reachableTiles;//返回可达Tiles的ArrayList
	}
	public void moveTo(Tile goalTile) {
		//UNTESTED 移动至goalTile 
		this.setPositionTile(goalTile);
		goalTile.setShipAtThisTile(this);
		
	}
	
	public ArrayList<Ship> showAttackableShips() {
		ArrayList<Ship> attackableShips = new ArrayList<Ship>();
		//TODO 求可攻击的Ships
		return attackableShips ;
	}

	public void attack(Ship goalShip) {
		goalShip.nowHP -= this.atk-goalShip.def;//TODO 计算公式待确认
		//TODO 判定是否可反击:
		if(true) goalShip.attackBack(this);
	}
	public void attackBack(Ship goalShip) {
		goalShip.nowHP -= this.atk-goalShip.def;//TODO 计算公式待确认
	}
	
	//setter&getter:
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int getNowHP() {
		return nowHP;
	}
	public void setNowHP(int nowHP) {
		this.nowHP = nowHP;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getMinAttackingRange() {
		return minAttackingRange;
	}
	public void setMinAttackingRange(int minAttackingRange) {
		this.minAttackingRange = minAttackingRange;
	}
	public int getMaxAttackingRange() {
		return maxAttackingRange;
	}
	public void setMaxAttackingRange(int maxAttackingRange) {
		this.maxAttackingRange = maxAttackingRange;
	}
	public Tile getPositionTile() {
		return positionTile;
	}
	public void setPositionTile(Tile positionTile) {
		this.positionTile = positionTile;
	}
	public int getMovingRange() {
		return movingRange;
	}
	public void setMovingRange(int movingRange) {
		this.movingRange = movingRange;
	}
	public boolean isCanMoveNow() {
		return canMoveNow;
	}
	public void setCanMoveNow(boolean canMoveNow) {
		this.canMoveNow = canMoveNow;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
}
