package com.mygdx.game.model;

import java.util.ArrayList;

public class Player {
	private int money;
	private int population;
	private Harbour harbourOfThisPlayer;
	ArrayList<Ship> shipBatch = new ArrayList<Ship>();
	
	public Player(int money, int population) {
		this.money = money;
		this.population = population;
	}
	
	void acquireMoney(int n) {
		this.money += n ; 
	}
	void acquirePopulation(int n) {
		this.population += n ;
	}

	//setter&getter
	public Harbour getHarbourOfThisPlayer() {
		return harbourOfThisPlayer;
	}
	public void setHarbourOfThisPlayer(Harbour harbourOfThisPlayer) {
		this.harbourOfThisPlayer = harbourOfThisPlayer;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public ArrayList<Ship> getShipBatch() {
		return shipBatch;
	}

	public void setShipBatch(ArrayList<Ship> shipBatch) {
		this.shipBatch = shipBatch;
	}



}


