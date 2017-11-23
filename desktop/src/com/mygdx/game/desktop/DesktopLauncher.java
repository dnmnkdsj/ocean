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
		
		//初始化
			GameController testGameController = new GameController();
			testGameController.initGame();
		
		/*
			//测试打印所有Tile
			for (Tile t : Tile.tileArray) {
				System.out.print("tilePosition:"+t.getPositionX()+"  ");
			}
			System.out.println();
		*/
		
		/*
			//测试打印nowPlayer的所有Ship
			for (Ship s : testGameController.getNowPlayer().getShipBatch()) {
				System.out.print("shipType:"+s.getClass()+"  ");
			}
			System.out.println();
		 */
		
		/*
			//获取可达Tiles
			ArrayList<Tile> reachabletiles = 
					testGameController.getNowPlayer().getShipBatch().get(2).showReachableTiles();
			for(Tile t : reachabletiles) {
				System.out.println(t.getPositionX());
			}
		
			//移动至可达Tile
			Tile goalTile = reachabletiles.get(0);
			System.out.println("position before moving:"+
			testGameController.getNowPlayer().getShipBatch().get(1).getPositionTile().getPositionX()
			);
			System.out.println("Now the ship at goalTile is :"+goalTile.getShipAtThisTile());
			testGameController.getNowPlayer().getShipBatch().get(1).moveTo(goalTile);//此处以可达Array中的第一个位置为测试用例
			
			System.out.println("position after moving:"+
			testGameController.getNowPlayer().getShipBatch().get(1).getPositionTile().getPositionX()
			);
			System.out.println("Now the ship at goalTile is :"+goalTile.getShipAtThisTile());
		 */
	
		
	}
}

