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

			Ship ship1 = new WarShip(Tile.getTileAtXY(0,8),this.nowPlayer);
			this.nowPlayer.shipBatch.add(ship1);
			Tile.getTileAtXY(0,8).setShipAtThisTile(ship1);
			
			Ship ship2 = new CannonShip(Tile.getTileAtXY(1,8),this.nowPlayer);
			this.nowPlayer.shipBatch.add(ship2);
			Tile.getTileAtXY(1,8).setShipAtThisTile(ship2);
			
			Ship ship3 = new Submarine(Tile.getTileAtXY(2,8),this.nowPlayer);
			this.nowPlayer.shipBatch.add(ship3);
			Tile.getTileAtXY(2,8).setShipAtThisTile(ship3);

			Ship ship4 = new SupplyingShip(Tile.getTileAtXY(3,8),this.nowPlayer);
			this.nowPlayer.shipBatch.add(ship4);
			Tile.getTileAtXY(3,8).setShipAtThisTile(ship4);
		
			Ship ship5 = new WarShip(Tile.getTileAtXY(16,3),this.nextPlayer);
			this.nextPlayer.shipBatch.add(ship5);
			Tile.getTileAtXY(16,3).setShipAtThisTile(ship5);
			
			Ship ship6 = new CannonShip(Tile.getTileAtXY(17,3),this.nextPlayer);
			this.nextPlayer.shipBatch.add(ship6);
			Tile.getTileAtXY(17,3).setShipAtThisTile(ship6);
			
			Ship ship7 = new Submarine(Tile.getTileAtXY(18,3),this.nextPlayer);
			this.nextPlayer.shipBatch.add(ship7);
			Tile.getTileAtXY(18,3).setShipAtThisTile(ship7);

			Ship ship8 = new SupplyingShip(Tile.getTileAtXY(19,3),this.nextPlayer);
			this.nextPlayer.shipBatch.add(ship8);
			Tile.getTileAtXY(19,3).setShipAtThisTile(ship8);


	}
    public void resetMove(int roundNum){
        for (Ship ship :  this.players[roundNum%2].getShipBatch()){
            ship.setCanMoveNow(false);
        }
        for (Ship ship :  this.players[(roundNum+1)%2].getShipBatch()){
            ship.setCanMoveNow(true);
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
		//if(this.players[].getHarbourOfThisPlayer().getIsDestroyed())	return true;
		if(0 == this.players[0].shipBatch.size()) return true;
		if(0 == this.players[1].shipBatch.size()) return true;
		return false;
		
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
