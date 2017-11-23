package com.mygdx.game.model;

import java.util.ArrayList;

public class Player {
	private int money;
	private int population;
	private Harbour harbour;
	ArrayList<Ship> ship_batch = new ArrayList<Ship>();
	
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
		return harbour;
	}
	public void setHarbourOfThisPlayer(Harbour harbour) {
		this.harbour = harbour;
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
		return ship_batch;
	}

	public void setShipBatch(ArrayList<Ship> ship_batch) {
		this.ship_batch = ship_batch;
	}



}


