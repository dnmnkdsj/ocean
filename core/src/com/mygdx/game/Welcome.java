package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
 

public class Welcome extends ScreenAdapter {
    
    private SpriteBatch batch;
    TiledMap tiledMap;
	Texture img;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;

    public Welcome() {
        this.batch = new SpriteBatch();
		this.img = new Texture("badlogic.jpg");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1024, 768);
        camera.update();
        tiledMap = new TmxMapLoader().load("tiledMap/example.tmx");
        TiledMapTileLayer layer = (TiledMapTileLayer)tiledMap.getLayers().get("Color");
        TiledMapTileLayer.Cell cell = layer.getCell(0, 0);
        
        TiledMapTileSets tilesets = tiledMap.getTileSets();
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        cell.setTile(tilesets.getTileSet("Color_Set").getTile(1));
        //if(tilesets.getTileSet("Color_Set").getTile(17) == null || cell == null)
        //    System.out.println("Empty!!!");
        //cell.setTile(tilesets.getTile(73));
    }

    
    @Override
    public void render (float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
		this.batch.begin();
		this.batch.draw(img, (float)50, (float)50);
		this.batch.end();
    }

}

