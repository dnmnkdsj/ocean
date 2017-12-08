package com.mygdx.game;



import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.InputAdapter;






	public static int IsClick;//1->ÏÔÊŸ·¶Î§  0->²»ÏÔÊŸ·¶Î§

public Choose() {



		processorEvent = new InputProcessorEvent();



		Gdx.input.setInputProcessor(processorEvent);

	}



class MouseClick extends InputAdapter {



	int mouseX;

	int mouseY;

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //if (Tile.isHereShip(screenX / 60, screenY / 60)) 

		return true;

	}



	boolean IsPersonChoosen(int x1, int x2, int y1, int y2) {

		if (count == 1) {

			if (mouseX >= x1 && mouseX <= x2 && mouseY >= y1 && mouseY <= y2) {

				IsClick = 1;

				return true;

			}

		}

		return false;

	}


	boolean CanMove(int x1, int x2, int y1, int y2) {

		if (count == 2) {

			count = count - 1;

			if (mouseX >= x1 && mouseX <= x2 && mouseY >= y1 && mouseY <= y2) {

				return true;

			}

		}

		return false;

	}



	}

	

}



	

}
