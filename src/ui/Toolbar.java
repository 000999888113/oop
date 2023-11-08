package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;



import static main.GameStates.MENU;
import static main.GameStates.setGameStates;

//import object.Fluid;
import object.Tile;
import scenes.Editing;

public class Toolbar {

	private Editing editing;
	private MyButton bMenu , bSave;
	protected int x, y, width, height;
	
	
	private Tile selectedTile;
	
	private ArrayList<MyButton> tileButtons = new ArrayList<>();
	
	private ArrayList<MyButton> fluidButtons = new ArrayList<>();
	
	
	public Toolbar(int x, int y, int width, int height,Editing editing){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.editing = editing;
		initButtons();
	}
	private void initButtons() {
		
		bMenu = new MyButton("Menu",2,642,100,30);
		bSave = new MyButton("Save",2,674,100,30);
		int w = 50;
		int h = 50;
		int xStart = 110;
		int yStart = 650;
		int xOffset = (int) (w * 1.1f);
		
		
		int i = 0;
		for (int j =0;j<4;j++) {
			tileButtons.add(new MyButton(editing.getGame().getTileManager().tiles.get(j).getName(), xStart + xOffset * i, yStart, w, h, i));
			i++;
		}
		/*
		for (Tile tile :editing.getGame().getTileManager().tiles) {
			tileButtons.add(new MyButton(tile.getName(), xStart + xOffset * i, yStart, w, h, i));
			i++;
		}*/
		
		
	}
	
	private void saveLevel() {
		editing.saveLevel();
		
	}
	
	public void draw(Graphics g) {

		// Background
		g.setColor(new Color(220, 123, 15));
		g.fillRect(x, y, width, height);

		// Buttons
		drawButtons(g);
	}
	
	
	
	private void drawButtons(Graphics g) {
		bMenu.draw(g);
		bSave.draw(g);
		drawTileButtons(g);
		drawSelectedTile(g);
	}
	
	
	private void drawSelectedTile(Graphics g) {
		if(selectedTile != null) {
			g.drawImage(selectedTile.getSprite(),550,650,50,50,null);
			
			//just border
			g.setColor(Color.black);
			g.drawRect(550, 650, 50, 50);
		}
		
	}


	private void drawTileButtons(Graphics g) {
		for(MyButton b: tileButtons) {
			//sprite
			g.drawImage(getButtImg(b.id),b.x,b.y,b.width,b.height,null);
			
			
		    
			//Mouse over
			if(b.isMouseOver()) {
				g.setColor(Color.white);
			}else {
				g.setColor(Color.black);
			}
			
			
			//border
			g.drawRect(b.x, b.y, b.width,b.height);
		}
		
	}
	
	public BufferedImage getButtImg(int id) {
		return editing.getGame().getTileManager().getSprite(id);
	}
	
	
	
	
	
	public void mouseClicked(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			setGameStates(MENU);
		else if (bSave.getBounds().contains(x, y))
			saveLevel();
		else {
			for(MyButton b : tileButtons) {
				if (b.getBounds().contains(x, y)) {
					selectedTile = editing.getGame().getTileManager().getTile(b.getId());
					editing.setSelectedTile(selectedTile);
					return;
				}
			}
		}

	}
	
	public void mouseMoved(int x, int y) {
		
		bMenu.setMouseOver(false);
		bSave.setMouseOver(false);
		for(MyButton b : tileButtons) {
			b.setMouseOver(false);
		}
		
		
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMouseOver(true);
		else if(bSave.getBounds().contains( x, y)){
			bSave.setMouseOver(true);
		}
		else {
			for(MyButton b : tileButtons) {
				if (b.getBounds().contains(x, y)) {
					b.setMouseOver(true);
					return;
				}
			}
		}
	}

	
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMousePressed(true);
		else if(bSave.getBounds().contains( x, y)){
			bSave.setMousePressed(true);
		}
		else {
			for(MyButton b : tileButtons) {
				if (b.getBounds().contains(x, y)) {
					b.setMousePressed(true);
					return;
				}
			}
		}
	}

	
	public void mouseReleased(int x, int y) {
		bMenu.resetBooleans();
		bSave.resetBooleans();
		for(MyButton b : tileButtons) {
			b.resetBooleans();
			
		}
	}
}
