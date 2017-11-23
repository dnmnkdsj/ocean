package com.mygdx.game;

public class GameController {
	private Player nowPlayer;
	private Player nextPlayer;
	
	public void initGame() {
		//TODO 按Player,Tile,Ship的顺序进行初始化。及相互绑定，
		this.initPlayers();
		this.initTiles();
		this.initShips();
	}
	public void initPlayers() {
		// 初始化双方玩家
		Player player1 = new Player(10,10);
		Player player2 = new Player(10,10);
		this.nowPlayer = player1;
		this.nextPlayer = player2;	
	}
	public void initTiles() {
		//TODO 初始化所有地图块。
		/*
		 *需实例化Tile对象，并add到Tile.TileArray中。
		 *具体Tile位置分布是与地图和关卡有关的。
		 *对于Harbour,island等自带属性的地形，还需初始化其属性
		 * */
			//(以下新建的Tiles为测试用)
			for (int i = 1; i < 15; i++) {
				Tile.tileArray.add(new DeepSea(i,i));
			}
	}
	public void initShips() {
		//TODO 初始化所有船只
		/*需实例化Ship对象，并add到对应Player.shipBatch中，同时绑定到对应Tile.ShipAtThisTile上。
		 * 具体Ship数量、所有权、位置分布是与关卡设置有关
		 * */
			//(以下新建的Ships为测试用)
			
//			for (int i = 1; i < 4; i++) {
//				this.nowPlayer.shipBatch.add(new WarShip(Tile.tileArray.get(i),this.nowPlayer));
//			}
		
			Ship ship1 = new WarShip(Tile.tileArray.get(0),this.nowPlayer);
			this.nowPlayer.shipBatch.add(ship1);
			Tile.tileArray.get(0).setShipAtThisTile(ship1);
			
			Ship ship2 = new CannonShip(Tile.tileArray.get(1),this.nowPlayer);
			this.nowPlayer.shipBatch.add(ship2);
			Tile.tileArray.get(1).setShipAtThisTile(ship2);
			
			Ship ship3 = new Submarine(Tile.tileArray.get(2),this.nowPlayer);
			this.nowPlayer.shipBatch.add(ship3);
			Tile.tileArray.get(2).setShipAtThisTile(ship3);

			Ship ship4 = new SupplyingShip(Tile.tileArray.get(3),this.nowPlayer);
			this.nowPlayer.shipBatch.add(ship3);
			Tile.tileArray.get(3).setShipAtThisTile(ship3);
		
	}
	public void switchPlayer() {
		/*
		Player temp = new Player();
		temp = this.nowPlayer;
		this.nowPlayer=this.nextPlayer;
		this.nextPlayer=nowPlayer;
		 */
	}
	public boolean isEnd() {//如果nextPlayer的港口被占，则游戏结束
		if(this.nextPlayer.getHarbourOfThisPlayer().getIsDestroyed())	return true;
		else return false;
	}
	public void removeShip() {
		//TODO Ship死亡后移除，并返还对方金钱
	}
	public Player getNowPlayer() {
		return nowPlayer;
	}
	public void setNowPlayer(Player nowPlayer) {
		this.nowPlayer = nowPlayer;
	}
	public Player getNextPlayer() {
		return nextPlayer;
	}
	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}

	
	
}
