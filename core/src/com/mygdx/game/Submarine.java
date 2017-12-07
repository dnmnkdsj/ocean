package com.mygdx.game;

public class Submarine extends Ship {
	
	public Submarine(Tile positionTile, Player owner) {
		super(positionTile, owner);
		this.maxHP = 100;
		this.nowHP = 100;
		this.atk = 100;
		this.def = 50;
		this.minAttackingRange = 3;
		this.maxAttackingRange = 4;
		this.movingRange = 5;
		this.type = Type.SUBMARINE;
	}
	
	@Override
	public void attack(Ship goalShip) {
		//重写。攻击后暴露，防御降低
		super.attack(goalShip);
		this.setDef(this.getDef()-100);//TODO 值待定
	}
}
