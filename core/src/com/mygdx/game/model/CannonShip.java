package com.mygdx.game.model;

public class CannonShip extends Ship {

	private int maxHP = 100;
	private int nowHP = 100;
	private int atk = 100;
	private int def = 50;
	private int min_atk_range = 3;
	private int max_atk_range = 4;
	private int moving_range = 5;
	private boolean moveable=true;

	
	public CannonShip(Tile position, Player owner) {
		super(position, owner);
	}

	
}
