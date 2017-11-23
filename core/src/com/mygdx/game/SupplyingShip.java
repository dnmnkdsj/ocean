package com.mygdx.game;

public class SupplyingShip extends Ship {
	private int maxHP = 100;
	private int nowHP = 100;
	private int atk = -50;
	private int def = 50;
	private int minAttackingRange = 1;
	private int maxAttackingRange = 1;
	private int movingRange = 5;
	private boolean canMoveNow=true;

	public SupplyingShip(Tile positionTile, Player owner) {
		super(positionTile, owner);
	}
}
