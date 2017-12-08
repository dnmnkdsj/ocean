package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;



public class GameController extends InputAdapter {
        public static int count;
        public static int IsClick;


		int mouseX;
		int mouseY;

		public GameController() {
			count = count + 1;
		}

		public boolean touchDown(int screenX, int screenY, int pointer, int button) {
			mouseX = screenX;
			mouseY = screenY;
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

		void ShowArea(int IsClick) {
			if (IsClick == 1) {
				// show
			}
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

		void Move(boolean CanMove) {
			if (CanMove) {
				IsClick=0;
				// move
			}
		}
		
		void RemoveArea() {
			if(IsClick==0) {
				//remove
			}
		}

		
	}
