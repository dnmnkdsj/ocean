package com.mygdx.game;

public class CannonShip extends Ship {

	
	public CannonShip(Tile positionTile, Player owner) {
		super(positionTile, owner);
		this.maxHP = 100;
		this.nowHP = 100;
		this.atk = 100;
		this.def = 50;
		this.minAttackingRange = 3;
		this.maxAttackingRange = 4;
		this.movingRange = 5;
		this.type = Type.CANONNSHIP;
	}

	
}
