package managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpz.LoadSave;
import main.Game;
//import object.Fluid;
//import object.Lava;
import object.Teeth;
import object.Tile;
//import object.Water;

public class TileManager {
	
	
	public Tile FLOOR,WATER,LAVA,BOX,TARGET,TEETH,WALL,POINT;
	//public Fluid watertest,lavatest;
	public BufferedImage atlas;
	public ArrayList<Tile> tiles = new ArrayList<>();
	
	//public ArrayList<Fluid> fluid = new ArrayList<>();
	
	public TileManager() {
		
		loadAtlas();
		createTiles();
		
	}



	private void loadAtlas() {
		atlas = LoadSave.getSpriteAtlas();
		
	}



	private void createTiles() {
		int id= 0;
		tiles.add(FLOOR = new Tile(getSprites(0,2),id++,"Floor"));
		tiles.add(WATER = new Tile(getAniSprites(0,0),id++,"Water"));
		tiles.add(LAVA = new Tile(getAniSprites(4,0),id++,"LAVA"));
		tiles.add(WALL = new Tile(getSprites(4,1),id++,"WALL"));
		tiles.add(TEETH = new Tile(getSprites(4,1),id++,"TEETH"));
		tiles.add(BOX = new Tile(getSprites(1,2),id++,"BOX"));	
		tiles.add(TARGET = new Tile(getAniSprites(2,2),id++,"TARGET"));
		tiles.add(POINT = new Tile(getAniSprites(0,0),id++,"POINT"));	
		
	}
	
	
	public Tile getTile(int id) {
		return tiles.get(id);
	}
	public  ArrayList<Tile> getTiles() {
		return tiles;
	}
	
	//for create tiles
	public BufferedImage getSprites(int x,int y) {
		return atlas.getSubimage(x*32, y*32, 32, 32);
	}
	public BufferedImage[] getAniSprites(int x,int y) {
		BufferedImage[] arr = new BufferedImage[4];
		for(int i=0;i<4;i++) {
			arr[i] = getSprites(x+i,y); 
		}
		return arr;
	}
	
	
	
	//getter
	public BufferedImage getSprite(int id) {
		//getSprite in class Tile , return sprite
		return tiles.get(id).getSprite();
	}
	public BufferedImage getAniSprite(int id,int animationIndex) {
		//getSprite in class Tile , return sprite
		return tiles.get(id).getSprite(animationIndex);
	}
	
	
	
	
	
	public boolean isSpriteAnimation(int id) {
		return tiles.get(id).isAnimation();
		
	}
	
	
	
	
	
}
