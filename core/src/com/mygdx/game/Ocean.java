package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ocean extends ApplicationAdapter {
	ShipPainting shipPainting;
	Test test;

	@Override
	public void create () {
		shipPainting = new ShipPainting(this);
		test = new Test(this);
	}

	@Override
	public void render () {
		shipPainting.paint();
	}

	@Override
	public void dispose () {
		shipPainting.dispose();
	}

}
