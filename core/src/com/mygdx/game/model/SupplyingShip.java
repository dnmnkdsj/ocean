package com.mygdx.game.model;

import java.util.ArrayList;

public class SupplyingShip extends Ship {

	public SupplyingShip(Tile position, Player owner) {
		super(position, owner);
		this.setMaxHP(100);
		this.setNowHP(100);
		this.setAtk(100);
		this.setDef(50);
		this.setMinAttackingRange ( 1 );
		this.setMaxAttackingRange ( 2 );//for testing
		this.setMovingRange ( 10 );
	}

	@Override
	public ArrayList<Ship> showAttackableShips() {//只改动了可攻击对象的敌我判定，其他与父类Ship类的方法完全相同。重复代码懒得改了。。
		ArrayList<Ship> attackableShips = new ArrayList<Ship>();
		for(Tile t : Board.getTiles()) {//通过遍历Tile.tileArray来遍历所有Ship（qtmd解耦）
			int distance =Math.abs(t.getPositionX()-this.getPositionTile().getPositionX())+Math.abs(t.getPositionY()-this.getPositionTile().getPositionY());
			if( distance > this.getMaxAttackingRange() || distance < this.min_atk_range) continue;//1.攻击范围内
			if( null == t.getShipAtThisTile()) continue;//2.该tile上有船
			//重载之处：
			if( this.getOwner() != t.getShipAtThisTile().getOwner()) continue;//3.是敌方船
			
			attackableShips.add(t.getShipAtThisTile());
		}
		return attackableShips ;
				
	}
	//而且不触发反击

	@Override
	public void attack(Ship goalShip) {
		goalShip.nowHP += this.atk;//TODO 计算公式待确认
	}
	
	
}
