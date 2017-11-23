package com.mygdx.game;

public class WarShip extends Ship {

	public WarShip(Tile positionTile, Player owner) {
		super(positionTile, owner);
		this.setMaxHP(100);
		this.setNowHP(100);
		this.setAtk(100);
		this.setDef(50);
		this.setMinAttackingRange ( 1 );
		this.setMaxAttackingRange ( 4 );//for testing
		this.setMovingRange ( 10 );

	}
	
}
