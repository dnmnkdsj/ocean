package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;

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

    private Stage uiStage;

    private ArrayList<Ship> allShips = new ArrayList<Ship> ();

    boolean isOver = true;
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
        modleControlller.resetMove(currentTurn);
        this.initShips();
        
        // Set Sprites
        shipPaint = new ShipPainting(allShips);

        // Set uiStage
        uiStage = new Stage();
        new HUD(this);

        // Set Event Process
        mouseClick = new MouseClick(this);
        InputMultiplexer inputProcess = new InputMultiplexer(uiStage, mouseClick);
        Gdx.input.setInputProcessor(inputProcess);

    }

    
    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        tiledMapRenderer.render();

        // Render Sprites
        shipPaint.paint();
        
        // Stage
        uiStage.act();
        uiStage.draw();

        this.batch.begin();
        if (isOver) {
            System.out.println("Game Over!!!");
            batch.draw(new Texture("game over.png"), 0, 0);
        }
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

    /**
     * @return the modleControlller
     */
    public ModelController getModleControlller() {
        return modleControlller;
    }

    /**
     * @return the uiStage
     */
    public Stage getUiStage() {
        return uiStage;
    }

    /**
     * @param uiStage the uiStage to set
     */
    public void setUiStage(Stage uiStage) {
        this.uiStage = uiStage;
    }

    /**
     * @return the isOver
     */
    public boolean isOver() {
        return isOver;
    }

    /**
     * @param isOver the isOver to set
     */
    public void setOver(boolean isOver) {
        this.isOver = isOver;
    }
       
}

