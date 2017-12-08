package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
 

public class GameScreen extends ScreenAdapter {
    
    private SpriteBatch batch;

    private TiledMapTileLayer colorLayer;
    private TiledMapTile colorTile;
    private TiledMapTileLayer.Cell cell;
    private TiledMap tiledMap;

    private OrthographicCamera camera;
    private TiledMapRenderer tiledMapRenderer;

    private ShipPainting shipPaint;

    private ModelController modleControlller;
    private MouseClick mouseClick;

    private ArrayList<Ship> allShips = new ArrayList<Ship> ();

    boolean isOver = false;
    int currentTurn = 0;
    public Ship currentShip = null;

    public GameScreen() {
        this.batch = new SpriteBatch();

        // Set camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 720);
        camera.update();

        // Set Tiled Map
        tiledMap = new TmxMapLoader().load("tiledMap/example.tmx");
        colorLayer = (TiledMapTileLayer)tiledMap.getLayers().get("Color");
        colorTile = tiledMap.getTileSets().getTileSet("Color_Set").getTile(1);

        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        tiledMapRenderer.setView(camera);

        // Init Model
        modleControlller = new ModelController();
        this.initShips();
        
        // Set Sprites
        shipPaint = new ShipPainting();
        shipPaint.sprites = shipPaint.createSprites(allShips);

        // Set Event Process
	    mouseClick = new MouseClick(this);
		Gdx.input.setInputProcessor(mouseClick);

    }

    
    @Override
    public void render (float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        tiledMapRenderer.render();

        // Render Sprites
        shipPaint.paint();

		this.batch.begin();
		//this.batch.draw(img, (float)50, (float)50);
		this.batch.end();
    }


    public void initShips () {
        if(modleControlller.getNowPlayer().getShipBatch()== null)
            System.out.println("Null Point");
        for(Ship ship: modleControlller.getNowPlayer().getShipBatch()) {
            allShips.add(ship);
        }
        for(Ship ship: modleControlller.getNextPlayer().getShipBatch()) {
            allShips.add(ship);
        }
    }

    public void showRegion (ArrayList<Tile> tiles) {
        for (Tile tile : tiles) {
            cell = colorLayer.getCell(tile.getPositionX(), tile.getPositionY());
            if (cell == null ){  System.out.println(tile.getPositionX());
                                System.out.println(tile.getPositionY());}
            cell.setTile(colorTile);
        }
    }

    public void removeRegion (ArrayList<Tile> tiles) {
        for (Tile tile : tiles) {
            if(colorLayer.getCell(tile.getPositionX(), tile.getPositionY()) != null) {
                colorLayer.getCell(tile.getPositionX(), tile.getPositionY()).setTile(null);
            }
        }
    }

       
}

