package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class ShipPainting {
    //static ArrayList<Ship> ships;
    ArrayList<Sprite> sprites;

    static private Texture WarShipImg = new Texture("WarShip.png");
    static private Texture CanonShipImg = new Texture("CannonShip.png");
    static private Texture SubmarineImg = new Texture("Submarine.png");
    static private Texture SupplyingShipImg = new Texture("SupplyingShip.png");
    SpriteBatch batch;

    public ShipPainting() {
        //initialize ships from ocean
        this.batch = new SpriteBatch();
//        Test();//test code
        //this.sprites = createSprites();
    }


    void paint() {
        batch.begin();
        for (Sprite sprite : this.sprites) {
            sprite.draw(batch);
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
    ArrayList<Sprite> createSprites(ArrayList<Ship> ships) {
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

    //test this class
    /*void Test() {
        Player player = new Player(0,0);
        Tile tile1 = new Tile(100,1);
        Tile tile2 = new Tile(200,1);
        Tile tile3 = new Tile(300,1);
        Tile tile4 = new Tile(400,1);
        Ship warShip1= new WarShip(tile1,player);
        Ship supplyingShip1= new SupplyingShip(tile2,player);
        Ship cannonShip1= new CannonShip(tile3,player);
        Ship submarine1= new Submarine(tile4,player);
        submarine1.setCanMoveNow(false);
        this.ships = new ArrayList<Ship>(0);
        this.ships.add(warShip1);
        this.ships.add(supplyingShip1);
        this.ships.add(cannonShip1);
        this.ships.add(submarine1);
    }*/
}
