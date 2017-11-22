package com.mygdx.game;

import java.util.ArrayList;

public class Ship {
	private int maxHP;
	private int nowHP;
	private int atk;
	private int def;
	private int minAttackingRange;
	private int maxAttackingRange;
	private Tile positionTile;
	private int movingRange;
	private boolean canMoveNow;
	private Player owner;
	
	public ArrayList<Tile> showReachableTiles() {
		ArrayList<Tile> reachableTiles = new ArrayList<Tile>();
		//TODO 求可抵达的Tiles
		return reachableTiles;
	}
	public void moveTo(Tile goalTile) {
		//TODO 移动至goalTile
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
