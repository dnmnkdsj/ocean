package com.mygdx.game.model;

import java.util.ArrayList;

public class Board {
    static private ArrayList<Tile> tiles = new ArrayList<Tile>(0);

    static public void addTile(Tile tile) {
        tiles.add(tile);
    }

    static public ArrayList<Tile> getTiles() {
        return Board.tiles;
    }

}
