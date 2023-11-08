package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Render {
	
	private Game game;
	
	
	
	
	
	
	
	public Render(Game game) {
		this.game = game;
		
		
	}
	//render in Render for switch scene
	public void render(Graphics g) {
		
		
		switch(GameStates.gameState) {
			case MENU:
				// render in .......(gameState) 
				game.getMenu().render(g);
				
				break;
			case PLAYING:
				// render in .......(gameState) 
				game.getPlay().render(g);
				
				break;
			case EDIT:
				game.getEditor().render(g);
				break;
			case SETTINGS:
				break;
			default:
				break;
			
		}
		
	}
	
	
}
