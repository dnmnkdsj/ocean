package com.mygdx.game.model;

public class WarShip extends Ship {

	public WarShip(Tile position, Player owner) {
		super(position, owner);
		this.setMaxHP(100);
		this.setNowHP(100);
		this.setAtk(100);
		this.setDef(50);
		this.setMinAttackingRange ( 1 );
		this.setMaxAttackingRange ( 4 );//for testing
		this.setMovingRange ( 10 );
	}

	public void destroyedHarbour(Harbour h) {
		h.setIsDestroyed(true);
	}

}
