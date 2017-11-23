package com.mygdx.game.model;

public class Submarine extends Ship {
	private int maxHP = 100;
	private int nowHP = 100;
	private int atk = 100;
	private int def = 50;
	private int min_atk_range = 1;
	private int max_atk_range = 1;
	private int moving_range = 5;
	private boolean moveable=true;
	
	public Submarine(Tile position, Player owner) {
		super(position, owner);
	}
	
	@Override
	public void attack(Ship goal) {
		//重写。攻击后暴露，防御降低
		super.attack(goal);
		this.setDef(this.getDef()-100);//TODO 值待定
	}
}
