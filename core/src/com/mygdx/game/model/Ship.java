package com.mygdx.game.model;

import java.util.ArrayList;

public class Ship {
	protected int maxHP = 100;
	protected int nowHP = 100;
	protected int atk = 100;
	protected int def = 50;
	protected int min_atk_range = 1;
	protected int max_atk_range = 5;//for testing
	protected int moving_range = 5;

	private Tile position;
	private boolean moveable=true;
	private Player owner;
	
	public Ship(Tile position, Player owner) {
		this.position = position;
		this.owner = owner;
	}
	public ArrayList<Tile> showReachableTiles() {//计算可达的Tiles
		ArrayList<Tile> reachableTiles = new ArrayList<Tile>();
		for(Tile t : Board.getTiles()) {
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
		
	}//移动之后控制攻击，静止，占领的操作由controller负责


	//show all enemy's ships reachable
	public ArrayList<Ship> showAttackableShips() {
		ArrayList<Ship> attackableShips = new ArrayList<Ship>();
		for(Tile t : Board.getTiles()) {//通过遍历Tile.tileArray来遍历所有Ship（qtmd解耦）
			int distance =Math.abs(t.getPositionX()-this.getPositionTile().getPositionX())
					+ Math.abs(t.getPositionY()-this.getPositionTile().getPositionY());
			if( distance > this.getMaxAttackingRange() || distance < this.min_atk_range) continue;//1.攻击范围内
			if( null == t.getShipAtThisTile()) continue;//2.该tile上有船
			if( this.getOwner() == t.getShipAtThisTile().getOwner()) continue;//3.是敌方船
			
			attackableShips.add(t.getShipAtThisTile());
		}
		return attackableShips ;
	}

	public void attack(Ship goalShip) {
		goalShip.nowHP -= this.atk-goalShip.def;//TODO 计算公式待确认
		//判定反击:
		int distance =Math.abs(goalShip.getPositionTile().getPositionX()-this.getPositionTile().getPositionX())
				+ Math.abs(goalShip.getPositionTile().getPositionY()-this.getPositionTile().getPositionY());
		if(distance > goalShip.getMaxAttackingRange() || distance < goalShip.min_atk_range) {;}
		else goalShip.attackBack(this);
		
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
		return min_atk_range;
	}
	public void setMinAttackingRange(int min_atk_range) {
		this.min_atk_range = min_atk_range;
	}
	public int getMaxAttackingRange() {
		return max_atk_range;
	}
	public void setMaxAttackingRange(int max_atk_range) {
		this.max_atk_range = max_atk_range;
	}
	public Tile getPositionTile() {
		return position;
	}
	public void setPositionTile(Tile position) {
		this.position = position;
	}
	public int getMovingRange() {
		return moving_range;
	}
	public void setMovingRange(int moving_range) {
		this.moving_range = moving_range;
	}
	public boolean isMoveable() {
		return moveable;
	}
	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
}
