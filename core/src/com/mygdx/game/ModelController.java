package com.mygdx.game;

public class ModelController{
	private Player[] players;
	private Player nowPlayer;
	private Player nextPlayer;
	
	public ModelController() {//按Player,Tile,Ship的顺序进行初始化。及根据关卡设置，相互绑定。
		this.initPlayers();
		//TODO 按照关卡，设置具体的整张地图，生成双方对应的Ships
		this.initTiles();
		this.initShips();
				
	}
	public void initPlayers() {
		// 初始化双方玩家
		Player player1 = new Player(10,10);
		Player player2 = new Player(10,10);
		this.nowPlayer = player1;
		this.nextPlayer = player2;	
        players = new Player[2];
		this.players[0] = player1;
		this.players[1] = player2;
	}
	public void initTiles() {
		//TODO 初始化所有地图块。
		/*
		 *需实例化Tile对象，并add到Tile.TileArray中。
		 *具体Tile位置分布是与地图和关卡有关的。
		 *对于Harbour,island等自带属性的地形，还需初始化其属性
		 * */
			//(以下新建的Tiles为测试用)
			for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 12; j++) {
                	
	                if( i == 3 && j == 4 ) {Tile.tileArray.add(new Reef(i,j));continue;}
	                if( i == 3 && j == 7 ) {Tile.tileArray.add(new Reef(i,j));continue;}
	                if( i == 6 && j == 4 ) {Tile.tileArray.add(new Reef(i,j));continue;}
	                if( i == 6 && j == 7 ) {Tile.tileArray.add(new Reef(i,j));continue;}
	                if( i == 16 && j == 4 ) {Tile.tileArray.add(new Reef(i,j));continue;}
	                if( i == 16 && j == 7 ) {Tile.tileArray.add(new Reef(i,j));continue;}
	                if( i == 13 && j == 4 ) {Tile.tileArray.add(new Reef(i,j));continue;}
	                if( i == 13 && j == 7 ) {Tile.tileArray.add(new Reef(i,j));continue;}
	                
	                Tile.tileArray.add(new DeepSea(i,j));
			
                }
			}
			//3,4;3,7;6,4;6,7;16,4;16,7;13,4;13,7;  
			for(Tile t : Tile.tileArray) {
				System.out.println(t.getClass());
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
		    // TODO 初始化时只让第一个Player的Ship可移动
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
			this.nowPlayer.shipBatch.add(ship4);
			Tile.tileArray.get(3).setShipAtThisTile(ship4);
		
			Ship ship5 = new WarShip(Tile.tileArray.get(4),this.nextPlayer);
			this.nextPlayer.shipBatch.add(ship5);
			Tile.tileArray.get(4).setShipAtThisTile(ship5);
			
			Ship ship6 = new CannonShip(Tile.tileArray.get(5),this.nextPlayer);
			this.nextPlayer.shipBatch.add(ship6);
			Tile.tileArray.get(5).setShipAtThisTile(ship6);
			
			Ship ship7 = new Submarine(Tile.tileArray.get(6),this.nextPlayer);
			this.nextPlayer.shipBatch.add(ship7);
			Tile.tileArray.get(6).setShipAtThisTile(ship7);

			Ship ship8 = new SupplyingShip(Tile.tileArray.get(7),this.nextPlayer);
			this.nextPlayer.shipBatch.add(ship8);
			Tile.tileArray.get(7).setShipAtThisTile(ship8);


	}
    public void resetMove(int roundNum){
        for (Ship ship :  this.players[roundNum%2].getShipBatch()){
            ship.setCanMoveNow(false);
        }
    }

	public void switchPlayer() {
		/*
		Player temp = new Player();
		temp = this.nowPlayer;
		this.nowPlayer=this.nextPlayer;
		this.nextPlayer=nowPlayer;
		 */
	}
	public boolean isEnd() {//返回布尔值.如果nextPlayer的港口被占则为true。
		if(this.nextPlayer.getHarbourOfThisPlayer().getIsDestroyed())	return true;
		else return false;
	}
	public void removeShip(Ship p) {//移除(死亡的)Ship，并结算给对方金钱
		//TODO 
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
