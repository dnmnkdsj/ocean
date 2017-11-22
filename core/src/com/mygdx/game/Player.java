package com.mygdx.game;

import java.util.ArrayList;

public class Player {
	private int money;
	private int population;
	private Harbour harbourOfThisPlayer;
	ArrayList<Ship> shipBatch;
	
	void acquireMoney(int n) {
		this.money += n ; 
	}
	void acquirePopulation(int n) {
		this.population += n ;
	}
	public Harbour getHarbourOfThisPlayer() {
		return harbourOfThisPlayer;
	}
	public void setHarbourOfThisPlayer(Harbour harbourOfThisPlayer) {
		this.harbourOfThisPlayer = harbourOfThisPlayer;
	}
}
