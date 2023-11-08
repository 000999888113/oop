package object;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import helpz.LoadSave;
import scenes.Play;

public class Teeth extends Tile {
	
	
	
	public int tx=0,ty=0;
    private Play playing;
	public Teeth(BufferedImage[] sprite, int id, String name,Play playing) {
		super(sprite, id, name);
		this.playing = playing;
		
	}

	
	


	public void draw( Graphics g) {
		g.drawImage(getSprite(0),tx*32,ty*32,null);
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
