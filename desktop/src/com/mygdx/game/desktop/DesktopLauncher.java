package com.mygdx.game.desktop;

import java.util.ArrayList;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.DeepSea;
import com.mygdx.game.GameController;
import com.mygdx.game.Ocean;
import com.mygdx.game.Ship;
import com.mygdx.game.Tile;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Ocean(), config);//测试期间暂时备注掉
	}
}

