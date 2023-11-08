package object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import scenes.Play;

public class Target extends Tile {

	
	private Play playing;
	public int tx,ty;
	
	
	public Target(BufferedImage[] sprite, int id, String name,Play playing) {
		super(sprite, id, name);
		this.playing = playing;
	}

	

	public void draw(Graphics g , int animationIndex) {
		
		for(int j=0;j<4;j++) {
			g.drawImage(getSprite(animationIndex),tx*32,ty*32,null);		
		}
			
			
	}
	
	
	public void setTX(int tx) {
		this.tx= tx;
	}
	public void setTY(int ty) {
		this.ty= ty;
	}
	
	
	public int getTX() {
		return tx;
	}
	public int getTY() {
		return ty;
	}
}
