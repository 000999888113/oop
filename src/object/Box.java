package object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import scenes.Play;

public class Box extends Tile{
	
	
	public int tx = -1,ty = 0 ;
	private Play playing;
	public Box(BufferedImage sprite,int id,String name,Play playing) {
		super(sprite,id,name);
		this.playing = playing;
	}
	
	
	public void draw(Graphics g) {
		g.drawImage(getSprite(),tx*32,ty*32,null);
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


