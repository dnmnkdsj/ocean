package com.mygdx.game;

import java.util.ArrayList;

public class Ship {
	protected int maxHP = 100;
	protected int nowHP = 100;
	protected int atk = 100;
	protected int def = 50;
	protected int minAttackingRange = 1;
	protected int maxAttackingRange = 5;//for testing
	protected int movingRange = 5;
	
	private Tile positionTile;
	private boolean canMoveNow=true;
	private Player owner;
	
	public Ship(Tile positionTile, Player owner) {
		this.positionTile = positionTile;
		this.owner = owner;
	}
	public ArrayList<Tile> showReachableTiles() {//计算可达的Tiles
		ArrayList<Tile> reachableTiles = new ArrayList<Tile>();
		for(Tile t : Tile.tileArray) {
			int distance =Math.abs(t.getPositionX()-this.getPositionTile().getPositionX())+Math.abs(t.getPositionY()-this.getPositionTile().getPositionY());
			
			if( distance > this.getMovingRange()) continue;//1.移动力可达
			if( null != t.getShipAtThisTile()) continue;//2.无其他单位所在
			if( false ) continue;//TODO 3.判断地形对船种的可达性.
			
			reachableTiles.add(t);
		}
		
		return reachableTiles;//返回可达Tiles的ArrayList
	}
	public void moveTo(Tile goalTile) {//移动至goalTile 
		this.setPositionTile(goalTile);
		goalTile.setShipAtThisTile(this);
		
	}
	
	public ArrayList<Ship> showAttackableShips() {
		ArrayList<Ship> attackableShips = new ArrayList<Ship>();
		for(Tile t : Tile.tileArray) {//通过遍历Tile.tileArray来遍历所有Ship（qtmd解耦）
			int distance =Math.abs(t.getPositionX()-this.getPositionTile().getPositionX())+Math.abs(t.getPositionY()-this.getPositionTile().getPositionY());
			if( distance > this.getMaxAttackingRange() || distance < this.minAttackingRange) continue;//1.攻击范围内
			if( null == t.getShipAtThisTile()) continue;//2.该tile上有船
			if( this.getOwner() == t.getShipAtThisTile().getOwner()) continue;//3.是敌方船
			
			attackableShips.add(t.getShipAtThisTile());
		}
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
