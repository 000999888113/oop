package scenes;

import java.awt.Color;
import java.awt.Graphics;

import ui.MyButton;

public class GameOver {

	
	public MyButton bMenu, bReplay;
	
	public GameOver() {
		 initButtons();
		
	}
	private void initButtons() {

		int w = 150;
		int h = w / 3;
		int x = 640 / 2 - w / 2;
		int y = 150;
		int yOffset = 80;

		bMenu = new MyButton("Menu", x, y + yOffset, w, h);
		bReplay = new MyButton("Replay", x, y , w, h);
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(120, 100, 400, 250);
		drawButtons(g);
		
	}
	
	
	
	private void drawButtons(Graphics g) {
		bMenu.draw(g);
		bReplay.draw(g);
	}
}
