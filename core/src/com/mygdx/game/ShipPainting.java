package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class ShipPainting {
    static ArrayList<Ship> ships;
    ArrayList<Sprite> sprites;

    static private Texture WarShipImg = new Texture("WarShip.png");
    static private Texture CanonShipImg = new Texture("CannonShip.png");
    static private Texture SubmarineImg = new Texture("Submarine.png");
    static private Texture SupplyingShipImg = new Texture("SupplyingShip.png");
    SpriteBatch batch;

    public ShipPainting(ArrayList<Ship> ships) {
        //initialize ships from main class
        this.batch = new SpriteBatch();
        this.ships = ships;
    }


    void paint() {
        // Set newest position
        /*for (Sprite sprite : sprites) {
            sprite.setPosition(ship.getPositionX() * 60, ship.getPositionY()* 60); // Based on tile coordinate
            if (ship.getMoveable() == false) {
                sprite.setColor((149f / 256f), (149f / 256f), (149f / 256f), 1);//if sprite is no-moveable,set it gray
            }
        }*/
        this.sprites = updateSprites(ships);
        batch.begin();
        for (Sprite sprite : this.sprites) {
            sprite.draw(batch);
        }
        for (Ship ship : ships) {
            showInformation(ship);
        }
        batch.end();
    }

    void dispose() {
        batch.dispose();
        WarShipImg.dispose();
        CanonShipImg.dispose();
        SubmarineImg.dispose();
        SubmarineImg.dispose();
    }

    //create a sprite for each ship and store them into ArrayList
    ArrayList<Sprite> updateSprites(ArrayList<Ship> ships) {
        ArrayList<Sprite> ret = new ArrayList<Sprite>(0);
        for (Ship ship : ships) {
            Sprite sprite;
            switch (ship.getType()) {
                case WARSHIP:
                    sprite = new Sprite(WarShipImg, 0, 0, 60, 60);
                    break;
                case CANONNSHIP:
                    sprite = new Sprite(CanonShipImg, 0, 0, 60, 60);
                    break;
                case SUBMARINE:
                    sprite = new Sprite(SubmarineImg, 0, 0, 60, 60);
                    break;
                case SUPPLYINGSHIP:
                    sprite = new Sprite(SupplyingShipImg, 0, 0, 60, 60);
                    break;
                default:
                    sprite = new Sprite(WarShipImg, 0, 0, 0, 0);
                    break;
            }
            sprite.setPosition(ship.getPositionX() * 60, ship.getPositionY()* 60); // Based on tile coordinate
            if (ship.getMoveable() == false) {
                sprite.setColor((149f / 256f), (149f / 256f), (149f / 256f), 1);//if sprite is no-moveable,set it gray
            }
            ret.add(sprite);
        }
        return ret;
    }

    void showInformation(Ship ship){
        BitmapFont font = new BitmapFont();
        String data = "HP:" + ship.nowHP + "ATK:" +ship.atk;
        //attributes: batch, String data, x & y of the line's position
        font.draw(batch, data, ship.getPositionX()*60-20,ship.getPositionY()*60 + 70);
    }
}
