package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import helpz.LoadSave;
import main.Game;
import managers.TileManager;
//import object.Fluid;
import object.Tile;

import ui.Toolbar;

public class Editing extends GameScene implements SceneMethods{

	private int[][] level;
	
	
	
	
	private Tile selectedTile;
	
	private int mouseX,mouseY;
	private int lasttileX,lasttileY,lasttileID;
	
	public boolean drawSelect;
	
	private Toolbar toolbar;

	private int animationIndex;
	private int tick;
	
	//Fluid fluid ;
	public Editing(Game game) {
		super(game);
		loadDefaultLevel();
		toolbar = new Toolbar(0, 640, 640, 160, this);
		
	}
 
	private int tx=0,ty=0;
	@Override
	public void render(Graphics g) {
		
		updatetick();
		
		drawLevel(g);
		toolbar.draw(g);
		drawSelectedTile(g);
		
		g.drawImage(getSprite(3),tx*32,ty*32,null);
		
		
	}
	
	private void updatetick() {
		tick++;
		if(tick >= 25) {
			tick = 0;
			animationIndex++;
			if(animationIndex >=4) {
			   animationIndex=0;
			}
		}
		
	}


	private void drawLevel(Graphics g) {
		for(int i=0;i<level.length;i++) {
			for(int j=0;j<level[i].length;j++) {
				int id = level[i][j];
				if(isAnimation(id)){
					g.drawImage(getSprite(id,animationIndex),j*32,i*32,null);
				}else
					g.drawImage(getSprite(id),j*32,i*32,null);
			}
		}
		
	}
	private boolean isAnimation(int id) {
		return game.getTileManager().isSpriteAnimation(id);
	}


	private void loadDefaultLevel() {
		level = LoadSave.GetLevelData("new_level4");
		
		
	}
	
	
	
	
	private BufferedImage getSprite(int spriteID) {
		return game.getTileManager().getSprite(spriteID);
		
	}
	private BufferedImage getSprite(int spriteID,int animationIndex) {
		return game.getTileManager().getAniSprite(spriteID,animationIndex);
		
	}
	
	
	
	
	
	
	
	public void saveLevel() {
		LoadSave.SaveLevel("new_level4", level);
		//game.getPlay().setLevel(level);
	}
	
	private void drawSelectedTile(Graphics g) {
		if(selectedTile != null && drawSelect) {
			g.drawImage(selectedTile.getSprite(),mouseX,mouseY,32,32,null);	
		}
	}
	public void setSelectedTile(Tile tile) {
		this.selectedTile = tile;
		drawSelect = true;
	}
	
	
	private void changeTile(int x, int y) {
		if(selectedTile != null) {
			int tileX = x/32;
			int tileY = y/32;
			
			if(lasttileX == tileX && lasttileY == tileY && lasttileID == selectedTile.getId()) {
				return;
			}
			lasttileX = tileX;
			lasttileY = tileY;
			lasttileID = selectedTile.getId();
			level[tileY][tileX] = selectedTile.getId();
		}
		
	}

	@Override
	public void mouseClicked(int x, int y) {
		if(y>= 640) {
			toolbar.mouseClicked(x, y);
		}else {
			changeTile(mouseX,mouseY);
		}
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		if(y>= 640) {
			toolbar.mouseMoved(x, y);
			drawSelect = false;
		}else {
			drawSelect = true;
			mouseX = (x/32) * 32;
			mouseY = (y/32) * 32;
		}
		
	}

	@Override
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int x, int y) {
		if(y>= 640) {
			
		}else {
			changeTile(x,y);
		}
		
	}
	
	
	
	


	public  void move() {
	    int numRows = level.length;
	    int numCols = level[0].length;
	    int[][] updatedGrid = new int[numRows][numCols]; // Create a new grid to store the updated values

	    for (int i = 0; i < numRows; i++) {
	        for (int j = 0; j < numCols; j++) {
	            updatedGrid[i][j] = level[i][j]; // Copy the current state to the new grid
	        }
	    }

	    for (int i = 0; i < numRows; i++) {
	        for (int j = 0; j < numCols; j++) {
	            if (level[i][j] == 2 ) {
	                if (i > 0 && level[i - 1][j] != 4 && updatedGrid[i - 1][j] != 2) {
	                    updatedGrid[i - 1][j] = 2;
	                }
	                if (i < numRows - 1 && level[i + 1][j] != 4 && updatedGrid[i + 1][j] != 2) {
	                    updatedGrid[i + 1][j] = 2;
	                }
	                if (j > 0 && level[i][j - 1] != 4 && updatedGrid[i][j - 1] != 2) {
	                    updatedGrid[i][j - 1] = 2;
	                }
	                if (j < numCols - 1 && level[i][j + 1] != 4 && updatedGrid[i][j + 1] != 2) {
	                    updatedGrid[i][j + 1] = 2;
	                }
	            }
	            if( level[i][j] == 1) {
	            	 if (i > 0 && level[i - 1][j] != 4 && updatedGrid[i - 1][j] != 2) {
		                    updatedGrid[i - 1][j] = 1;
		                }
		                if (i < numRows - 1 && level[i + 1][j] != 4 && updatedGrid[i + 1][j] != 2) {
		                    updatedGrid[i + 1][j] = 1;
		                }
		                if (j > 0 && level[i][j - 1] != 4 && updatedGrid[i][j - 1] != 2) {
		                    updatedGrid[i][j - 1] = 1;
		                }
		                if (j < numCols - 1 && level[i][j + 1] != 4 && updatedGrid[i][j + 1] != 2) {
		                    updatedGrid[i][j + 1] = 1;
		                }
	            }
	        }
	    }

	    level = updatedGrid; // Update the level with the new values
	}

	
	public void keyPressed(KeyEvent e) {
	    
	    if(e.getKeyCode() == KeyEvent.VK_DOWN && ty+1 < 20 && level[ty+1][tx] != 4){
	        ty++;
	        move();
	        if(level[ty][tx] == 2)
	            System.out.println("dead");
	        
	    } else if(e.getKeyCode() == KeyEvent.VK_UP && ty-1 >= 0 && level[ty-1][tx] != 4){
	        ty--;
	        move();
	        if(level[ty][tx] == 2)
	            System.out.println("dead");
	        
	    } else if(e.getKeyCode() == KeyEvent.VK_LEFT && tx-1 >= 0 && level[ty][tx-1] != 4){
	        tx--;
	        move();
	        if(level[ty][tx] == 2)
	            System.out.println("dead");
	        
	    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT && tx+1 < 20 && level[ty][tx+1] != 4){
	        tx++;
	        move();
	        if(level[ty][tx] == 2)
	            System.out.println("dead");
	        
	    }
	    
	}

	
	
	
	
	
	
	
	
	
	
	/*
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			teethY +=32;
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			teethY -= 32;
		}if(e.getKeyCode() == KeyEvent.VK_LEFT){
			teethX -= 32;
			
		}if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			teethX += 32;
		}
	}*/

	

	
	
	/*
	int[][] startteeth = new int[5][2];
	private int recentteethY = 3,recentteethX = 3;
	private int recentsprite;
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			recentteethY++;
			recentsprite = level[startteeth[0][0]+recentteethY][startteeth[0][1]+recentteethX] ;
			if(recentsprite == 2) {
				System.out.println("kwai");
			}
			level[startteeth[0][0]+recentteethY][startteeth[0][1]+recentteethX] = 3;
			level[startteeth[0][0]+recentteethY-1][startteeth[0][1]+recentteethX] = recentsprite;
			
			
			
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			recentteethY--;
			recentsprite = level[startteeth[0][0]+recentteethY][startteeth[0][1]+recentteethX] ;
			if(recentsprite == 2) {
				System.out.println("kwai");
			}
			level[startteeth[0][0]+recentteethY+1][startteeth[0][1]+recentteethX] = recentsprite;
			
			level[startteeth[0][0]+recentteethY][startteeth[0][1]+recentteethX] = 3;
			
		}if(e.getKeyCode() == KeyEvent.VK_LEFT){
			recentteethX--;
			recentsprite = level[startteeth[0][0]+recentteethY][startteeth[0][1]+recentteethX] ;
			if(recentsprite == 2) {
				System.out.println("kwai");
			}
			level[startteeth[0][0]+recentteethY][startteeth[0][1]+recentteethX+1] = recentsprite;
			
			level[startteeth[0][0]+recentteethY][startteeth[0][1]+recentteethX] = 3;
			
		}if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			recentteethX++;
			recentsprite = level[startteeth[0][0]+recentteethY][startteeth[0][1]+recentteethX] ;
			if(recentsprite == 2) {
				System.out.println("kwai");
			}
			level[startteeth[0][0]+recentteethY][startteeth[0][1]+recentteethX-1] = recentsprite;
			
			level[startteeth[0][0]+recentteethY][startteeth[0][1]+recentteethX] = 3;
			
		}
	}*/
	
	
}