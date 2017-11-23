package com.mygdx.game.desktop;

import java.util.ArrayList;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.DeepSea;
import com.mygdx.game.GameController;
import com.mygdx.game.Ocean;
import com.mygdx.game.Ship;
import com.mygdx.game.Tile;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//new LwjglApplication(new Ocean(), config);//测试期间暂时备注掉
	
		//TEST:
		
		//初始化(测试版
			GameController testGameController = new GameController();
			testGameController.initGame();
			Ship ship1 = testGameController.getNowPlayer().getShipBatch().get(0);//nowPlayer Warship
			Ship ship2 = testGameController.getNowPlayer().getShipBatch().get(1);//nowPlayer CannonShip
			Ship ship3 = testGameController.getNextPlayer().getShipBatch().get(0);//nextPlayer Submarine
			Ship ship4 = testGameController.getNextPlayer().getShipBatch().get(1);//nextPlayer SupplyingShip
		

//			//测试打印所有Tile
//			for (Tile t : Tile.tileArray) {
//				System.out.print("tilePosition:"+t.getPositionX()+"  ");
//			}
//			System.out.println();

		
			//测试打印nowPlayer的所有Ship

//			System.out.print("shipType:"+ship1.getClass()+"  ");
//			System.out.print("shipType:"+ship2.getClass()+"  ");
//			System.out.print("shipType:"+ship3.getClass()+"  ");
//			System.out.print("shipType:"+ship4.getClass()+"  ");			
//			System.out.println();
		 
		
		
			//获取可达Tiles,此处以ship1为例
//			ArrayList<Tile> reachabletiles = ship1.showReachableTiles();
//			for(Tile t : reachabletiles) {
//				System.out.println(t.getPositionX());
//			}
//		
			//移动至可达Tile
//			Tile goalTile = reachabletiles.get(0);
//			System.out.println("position before moving:" + ship1.getPositionTile().getPositionX()
//			);
//			System.out.println("Now the ship at goalTile is :"+goalTile.getShipAtThisTile());
//			ship1.moveTo(goalTile);//此处以可达Array中的第一个位置为测试用例
//			
//			System.out.println("position after moving:" + ship1.getPositionTile().getPositionX()
//			);
//			System.out.println("Now the ship at goalTile is :"+goalTile.getShipAtThisTile());
		
		
		
			//(普通船)获取可攻击到的Ships
			
//			ArrayList<Ship>	attackabletiles = ship2.showAttackableShips();
//			for(Ship s : attackabletiles ) {
//				System.out.println(s.getPositionTile().getPositionX());
//			}
			//攻击
//			System.out.println("ship2HP:"+ship2.getNowHP()+"enmHp:"+attackabletiles.get(0).getNowHP());
//			ship2.attack(attackabletiles.get(0));//以能攻击到的第一条船为例
//			System.out.println("ship2HP:"+ship2.getNowHP()+"enmHp:"+attackabletiles.get(0).getNowHP());
			//攻击成功。反击成功
		
			//(奶船)获取可攻击到的Ships
//			ArrayList<Ship> attackabletiles = ship4.showAttackableShips();
//			for(Ship s : attackabletiles ) {
//				System.out.println(s.getPositionTile().getPositionX());
//			}
			//攻击
//			System.out.println("ship4HP:"+ship4.getNowHP()+"enmHp:"+attackabletiles.get(0).getNowHP());
//			ship4.attack(attackabletiles.get(0));//以能攻击到的第一条船为例
//			System.out.println("ship4HP:"+ship4.getNowHP()+"enmHp:"+attackabletiles.get(0).getNowHP());
			//回血成功。不会反击
			

	}
}

