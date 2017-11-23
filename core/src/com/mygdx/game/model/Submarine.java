package com.mygdx.game.model;

public class Submarine extends Ship {
	private int maxHP = 100;
	private int nowHP = 100;
	private int atk = 100;
	private int def = 50;
	private int minAttackingRange = 1;
	private int maxAttackingRange = 1;
	private int movingRange = 5;
	private boolean canMoveNow=true;
	
	public Submarine(Tile positionTile, Player owner) {
		super(positionTile, owner);
	}
	
	@Override
	public void attack(Ship goalShip) {
		//重写。攻击后暴露，防御降低
		super.attack(goalShip);
		this.setDef(this.getDef()-100);//TODO 值待定
	}
}
