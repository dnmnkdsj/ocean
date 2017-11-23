package com.mygdx.game;

public class CannonShip extends Ship {

	private int maxHP = 100;
	private int nowHP = 100;
	private int atk = 100;
	private int def = 50;
	private int minAttackingRange = 3;
	private int maxAttackingRange = 4;
	private int movingRange = 5;
	private boolean canMoveNow=true;

	
	public CannonShip(Tile positionTile, Player owner) {
		super(positionTile, owner);
	}

	
}
