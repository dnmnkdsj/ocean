package com.mygdx.game;

public class Submarine extends Ship {
	

	@Override
	public void attack(Ship goalShip) {
		//重写。攻击后暴露，防御降低
		super.attack(goalShip);
		this.setDef(this.getDef()-100);//值待定
	}
}
