package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class ShipPainting {
    static Ocean ocean;
//    static ArrayList<Ship> ships;

    static private Texture WarShipImg = new Texture("WarShip.png");
    static private Texture CanonShipImg = new Texture("CannonShip.png");
    static private Texture SubmarineImg = new Texture("Submarine.png");
    static private Texture SupplyingShipImg = new Texture("SupplyingShip.png");
    SpriteBatch batch;

    ShipPainting(Ocean ocean) {
        this.ocean = ocean;
        //initialize ships from ocean
        this.batch = new SpriteBatch();
    }

    void paint(){
        Gdx.gl.glClearColor( 0.5f, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(WarShipImg, 0, 0);
        batch.draw(CanonShipImg, 30, 0);
        batch.draw(SubmarineImg, 60, 0);
        batch.draw(SupplyingShipImg, 100, 0);
        batch.end();
    }

    void dispose() {
		batch.dispose();
		WarShipImg.dispose();
		CanonShipImg.dispose();
		SubmarineImg.dispose();
		SubmarineImg.dispose();
    }
}
