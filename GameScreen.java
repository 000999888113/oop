package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import static main.GameStates.*;
import input.keyboard;
import input.mouse;
import scenes.Menu;
import scenes.Play;

public class GameScreen extends JPanel {
	
	
	
	
	
	
	
	private Game game;

	private Dimension size;
	
	private mouse myMouse;
	private keyboard myKeyboard;
	
	

	public GameScreen(Game game) {
		this.game = game;
		
		setPanelSize();
		
	}
	
	
	public void initinputs() {
		myMouse = new mouse(game);
		myKeyboard = new keyboard(game);
		
		addMouseListener(myMouse);
		addMouseMotionListener(myMouse);
		addKeyListener(myKeyboard);
		
		
		//focus input
		requestFocus();
	}
	
	private void setPanelSize() {
		// TODO Auto-generated method stub
		
		
		
		 int width = 640;
		 int height = 740;
		  
		
	    size = new Dimension(width,height);
		
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		repaint();
	}


	//paint 
	public void paintComponent(Graphics g){
		super.paintComponent(g); 
		//paint render in Render after choose scene
		game.getRender().render(g);
		

	}
	
	
}

