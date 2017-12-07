package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;

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
