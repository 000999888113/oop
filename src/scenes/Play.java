package scenes;

import static main.GameStates.*;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpz.LoadSave;
import main.Game;
 // import managers.FluidManager;

import object.Box;

import object.Point;
import object.Target;
import object.Teeth;

//import ui.BottomBar;

public class Play extends GameScene implements SceneMethods{
	
	private int[][] level;
	private int lvl =1;
	
	
	//private BottomBar bottomBar;
	
	private int mouseX,mouseY;
	
	
	private int animationIndex;
	private int animationIndexTarget;
	private int tick;
	
	
	// create obj extends tile
	
	//new create
	private Target target = new Target(game.getTileManager().getAniSprites(2,2),6,"TARGET",this);
	private Point point = new Point(this);
	
	//get from tilemanager
	private Box box = new Box(game.getTileManager().getSprite(5),5,"BOX",this);
	private Box box2 = new Box(game.getTileManager().getSprite(5),5,"BOX",this);
	private Box box3 = new Box(game.getTileManager().getSprite(5),5,"BOX",this);
    private Box box4 = new Box(game.getTileManager().getSprite(5),5,"BOX",this);
	private Box box5 = new Box(game.getTileManager().getSprite(5),5,"BOX",this);
	private Box box6 = new Box(game.getTileManager().getSprite(5),5,"BOX",this);
	ArrayList<Box> BOXX = new ArrayList<Box>();
	
	
	
	
	
	private Teeth teeth = new Teeth(game.getTileManager().getAniSprites(0,1),4,"TEETH",this);
	
	private boolean gameOverCheck = false;
	private GameOver GO = new GameOver();
	
	//private FluidManager fluidManager;
	
	public Play(Game game) {
		super(game);
	
		//fluidManager = new FluidManager(this);
		//level
		//tile manager
		loadDefaultLevel();
		
	}
	
	
	public void saveLevel() {
		LoadSave.SaveLevel("new_level", level);
	}
	
	public void setLevel(int[][] level) {
		this.level = level;
		
	}
	
	
	private void loadDefaultLevel() {
		BOXX.add(box);
		level = LoadSave.GetLevelData("new_level");
		teeth.setTX(4);
		teeth.setTY(8);
		box.setTX(4);
		box.setTY(5);
		target.setTX(18);
		target.setTY(9);
		point.setTX(12);
		point.setTY(9);
		animationIndexTarget = 0;
	}
	private void loadDefaultLevel2() {
		BOXX.add(box2);
		level = LoadSave.GetLevelData("new_level2");
		teeth.setTX(9);
		teeth.setTY(13);
		box.setTX(8);
		box.setTY(12);
		box2.setTX(13);
		box2.setTY(11);
		target.setTX(12);
		target.setTY(10);
		point.setTX(9);
		point.setTY(9);
		animationIndexTarget = 0;
		checkPoint = false;
	}
	private void loadDefaultLevel3() {
		level = LoadSave.GetLevelData("new_level3");
		teeth.setTX(9);
		teeth.setTY(6);
		box.setTX(10);
		box.setTY(10);
		box2.setTX(7);
		box2.setTY(5);
		target.setTX(6);
		target.setTY(10);
		point.setTX(16);
		point.setTY(3);
		animationIndexTarget = 0;
		checkPoint = false;
		
		
	}
	private void loadDefaultLevel4() {
		level = LoadSave.GetLevelData("new_level4");
		teeth.setTX(11);
		teeth.setTY(3);
		box.setTX(11);
		box.setTY(4);
		box2.setTX(11);
		box2.setTY(9);
		target.setTX(6);
		target.setTY(10);
		point.setTX(15);
		point.setTY(3);
		animationIndexTarget = 0;
		checkPoint = false;
	}
	private void loadDefaultLevel5() {
		BOXX.add(box3);BOXX.add(box4);BOXX.add(box5);BOXX.add(box6);
		level = LoadSave.GetLevelData("new_level5");
		teeth.setTX(9);
		teeth.setTY(14);
		box.setTX(3);
		box.setTY(6);
		box2.setTX(16);
		box2.setTY(6);
		box3.setTX(8);
		box3.setTY(5);
		box4.setTX(11);
		box4.setTY(5);
		box5.setTX(6);
		box5.setTY(14);
		box6.setTX(13);
		box6.setTY(14);
		target.setTX(17);
		target.setTY(8);
		point.setTX(2);
		point.setTY(8);
		animationIndexTarget = 0;
		checkPoint = false;
		
	}


	


	boolean checkPoint = false;
    // same paintComponent 
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		updatetick();
		if(checkPoint) {
		   updatetickTarget();
		}
		
		drawLevel(g);
	
		
		//try fluid oop
		//fluidManager.draw(g,animationIndex);
		
		
		for(int i=0;i<BOXX.size();i++) {
			BOXX.get(i).draw(g);
		}
		
		target.draw(g, animationIndexTarget);
		teeth.draw(g);
		point.draw(g);
		
		if(gameOverCheck) {
			GO.draw(g);
		}
				
      
		
	}

	private void updatetickTarget() {
		tick++;
		if(tick >= 25) {
			tick = 0;
			animationIndexTarget++;
			if(animationIndexTarget >=4) {
			   animationIndexTarget=0;
			}
		}
		
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
					
					//try fluid oop
					//fluidManager.addFluid(id, j, i);
					
				}else
					g.drawImage(getSprite(id),j*32,i*32,null);
				
				
			}
		}
		for(int i = 20;i<23;i++){
			for(int j=0;j<20;j++) {
				
				g.drawImage(getSprite(4),j*32,i*32,null);
			}
			
		}
		
	}
	
	
	private boolean isAnimation(int id) {
		return game.getTileManager().isSpriteAnimation(id);
	}
	
	

	
	private BufferedImage getSprite(int spriteID) {
		return game.getTileManager().getSprite(spriteID);
		
	}
	private BufferedImage getSprite(int spriteID,int animationIndex) {
		return game.getTileManager().getAniSprite(spriteID,animationIndex);
		
	}
	
	



	

	

	@Override
	public void mouseClicked(int x, int y) {
		if(GO.bReplay.getBounds().contains( x, y)) {
			gameOverCheck = false;
			checkLevel();
		}else if (GO.bMenu.getBounds().contains(x, y)) {
			gameOverCheck = false;
			checkLevel();
			setGameStates(MENU);
		}
		
		
	}

	
	



	@Override
	public void mouseMoved(int x, int y) {
		
		GO.bMenu.setMouseOver(false);
		GO.bReplay.setMouseOver(false);
		
		if (GO.bMenu.getBounds().contains(x, y))
			GO.bMenu.setMouseOver(true);
		else if (GO.bReplay.getBounds().contains(x, y))
			GO.bReplay.setMouseOver(true);
		
		
		
		
	}

	@Override
	public void mousePressed(int x, int y) {
		
		if (GO.bMenu.getBounds().contains(x, y))
			GO.bMenu.setMousePressed(true);
		else if (GO.bReplay.getBounds().contains(x, y))
			GO.bReplay.setMousePressed(true);
		
		
	}

	@Override
	public void mouseReleased(int x, int y) {
		GO.bMenu.resetBooleans();
		GO.bReplay.resetBooleans();
		
		
		
	}
	@Override
	public void mouseDragged(int x, int y) {
		
	}
	
	
	boolean fluid = true;
	
	public  void fluidmove() {
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
	        	
	        		  if (level[i][j] == 2 || level[i][j] == 1) {
	  	                int type = level[i][j];
	  	            	if (	i > 0 && level[i - 1][j] != 4 ) {
	  	            		for(int k =0;k<BOXX.size();k++) {
	  	            			if(i-1 == BOXX.get(k).ty && j == BOXX.get(k).tx) {
	  	            				fluid =false ;
	  	            			}else {
	  	            				fluid =true;
	  	            			}
		  	            		
	  	            		}
	  	            		
	  	            		if(fluid) {
	  	            			if(type == 2 ) {
	  	            				if(updatedGrid[i-1][j ] == 1) {
			  	                		updatedGrid[i -1 ][j] = 4;
			              		    }
			              		    else {
			  	                    updatedGrid[i - 1][j] = type;
			              		    }
	  
	  	            			}else if(type == 1) {
	  	            				if(updatedGrid[i-1][j ] == 2) {
			  	                		updatedGrid[i -1 ][j] = 4;
			              		    }
			              		    else {
			  	                    updatedGrid[i - 1][j] = type;
			              		    }
	  	            				
	  	            			}
	  	            	
	  	            		}
	  	                }
	  	                if (	i < numRows - 1 && level[i + 1][j] != 4 ) {
	  	                	for(int k =0;k<BOXX.size();k++) {
	  	            			if(i+1 == BOXX.get(k).ty && j == BOXX.get(k).tx) {
	  	            				fluid =false ;
	  	            				break;
	  	            			}else {
	  	            				fluid =true;
	  	            			}
		  	            		
	  	            		}
	  	                	if(fluid) {
	  	                		if(type == 2) {
	  	                			if(updatedGrid[i + 1 ][j] == 1) {
			  	                		updatedGrid[i +1 ][j] = 4;
			  	                	}
			  	                	else {
			  	                		updatedGrid[i + 1][j] = type;
			  	                	}
	  	                			
	  	                		}else if(type ==1) {
	  	                			if(updatedGrid[i + 1 ][j] == 2) {
			  	                		updatedGrid[i +1 ][j] = 4;
			  	                	}
			  	                	else {
			  	                		updatedGrid[i + 1][j] = type;
			  	                	}
	  	                		}
		  	                	
	  	                	}
	  	                }
	  	                if (	j > 0 && level[i][j - 1] != 4  ) {
	  	                	
	  	                	for(int k =0;k<BOXX.size();k++) {
	  	            			if(i == BOXX.get(k).ty && j -1 == BOXX.get(k).tx) {
	  	            				fluid =false ;
	  	            				break;
	  	            			}else {
	  	            				fluid =true;
	  	            			}
		  	            		
	  	            		}
	  	                	if(fluid) {
	  	                		if(type == 2) {
	  	                			if(updatedGrid[i][j - 1] == 1) {
			  	                		updatedGrid[i][j -1 ] = 4;
			  	                	}else {
			  	                    updatedGrid[i][j - 1] = type;
			  	                    }
	  	                		}else if(type ==1 ) {
	  	                			if(updatedGrid[i][j - 1] == 2) {
			  	                		updatedGrid[i][j -1 ] = 4;
			  	                	}else {
			  	                    updatedGrid[i][j - 1] = type;
			  	                    }
	  	                		}
	  	          
	  	                	}
	  	                
	  	                }
	  	                if (	j < numCols - 1 && level[i][j + 1] != 4 ) {
	  	                	for(int k =0;k<BOXX.size();k++) {
	  	            			if(i == BOXX.get(k).ty && j + 1 == BOXX.get(k).tx) {
	  	            				fluid =false ;
	  	            				break;
	  	            			}else {
	  	            				fluid =true;
	  	            			}
		  	            		
	  	            		}
	  	                	if(fluid) {
	  	                		if(type ==2 ) {
	  	                			if(updatedGrid[i][j + 1] == 1) {
			  	                		updatedGrid[i][j +1 ] = 4;
			  	                	}else {
			  	                    updatedGrid[i][j + 1] = type;}
	  	                		}else if(type == 1) {
	  	                			if(updatedGrid[i][j + 1] == 2) {
			  	                		updatedGrid[i][j +1 ] = 4;
			  	                	}else {
			  	                    updatedGrid[i][j + 1] = type;}
	  	                		}
	  	                		
	  	                	}
	  	          
	  	                }
	  	            }
	        		 
	        	
	            
	            
	        }
	    }

	    level = updatedGrid; // Update the level with the new values
	}
	
	
	public void checkLevel() {
		 
		  
		    switch(lvl) {
		    	case 1 :
			    	loadDefaultLevel();
			    	break;
		    	case 2:
					loadDefaultLevel2();
					
					break;
				case 3:
				
					loadDefaultLevel3();
					break;
				case 4:
					loadDefaultLevel4();
					break;
				case 5:
					loadDefaultLevel5();
					break;
				default:
					System.out.println("Game Over!");
					break;
				
		    
		    }
		
	}
	
	
	public void checkCollectPoint() {
		if(teeth.tx == point.tx  && teeth.ty == point.ty ) {
    		checkPoint = true;
    		point.tx = -5;
    	}
	}
	
	
	
	
	public void keyPressed(KeyEvent e) {
	    if(!gameOverCheck) {
	    	if(e.getKeyCode() == KeyEvent.VK_DOWN && teeth.getTY()+1 < 20 && level[teeth.getTY() + 1][teeth.getTX()] != 4){
		    	
		    	teeth.ty += 1;
		    
		    	for(int i =0;i<BOXX.size();i++) {
		    		if( teeth.getTY() == BOXX.get(i).ty  && teeth.getTX() ==  BOXX.get(i).tx){
			    	    if(  BOXX.get(i).ty+1 < 20 &&level[ BOXX.get(i).ty+1][ BOXX.get(i).tx] != 4 ) {
			    	    	 // push lava 
			    	    	 level[ BOXX.get(i).ty+1][ BOXX.get(i).tx] = 0;
			    	    	 BOXX.get(i).ty++;
			    	    }
			    	    else { 
			    	    	teeth.ty--;
			    	    }
			    	}
		    		
		    	}
		    	
		    	
		    	fluidmove();
		    	
		    	if(teeth.tx == target.tx && teeth.ty == target.ty && checkPoint == true) {
		    		lvl++;
		    		checkLevel();
		    	}
		    	checkCollectPoint();
		    	
		        if(level[teeth.getTY()][teeth.getTX()] == 2) {
		            System.out.println("dead");
		            gameOverCheck = true;
		        }
		        
		    } else if(e.getKeyCode() == KeyEvent.VK_UP  && teeth.getTY()-1 >= 0 && level[teeth.getTY() - 1][teeth.getTX()] != 4){
		    	teeth.ty -= 1;
		    	
		    	for(int i =0;i<BOXX.size();i++) {
			    	if( teeth.getTY() == BOXX.get(i).ty  && teeth.getTX() == BOXX.get(i).tx) {
			    	    if( BOXX.get(i).ty-1 >= 0  && level[BOXX.get(i).ty-1][BOXX.get(i).tx] != 4) {
			    	    	
			    	    	level[BOXX.get(i).ty-1][BOXX.get(i).tx] = 0;
			    	    	BOXX.get(i).ty--;
			    	    }
			    	    else {
			    	    	teeth.ty++;
			    	    }
			    	}
		    	}
		    	if(teeth.tx == target.tx && teeth.ty == target.ty && checkPoint == true) {
		    		lvl++;
		    		checkLevel();
		    	}

		    	checkCollectPoint();
		    	
		    	fluidmove();
		    	
		    	 if(level[teeth.getTY()][teeth.getTX()] == 2) {
			            System.out.println("dead");
			            gameOverCheck = true;
			       }	        
		    } else if(e.getKeyCode() == KeyEvent.VK_LEFT  && teeth.getTX()-1 >= 0 && level[teeth.getTY()][teeth.getTX() - 1] != 4){
		    	teeth.tx -= 1;
		    	
		    	
		    	for(int i =0;i<BOXX.size();i++) {
			    	if( teeth.getTY() == BOXX.get(i).ty  && teeth.getTX() == BOXX.get(i).tx) {
			    	    if( BOXX.get(i).tx-1 >= 0 && level[BOXX.get(i).ty ][BOXX.get(i).tx -1] != 4  ) {
			    	    	
			    	    	level[BOXX.get(i).ty ][BOXX.get(i).tx -1] = 0;
			    	    	BOXX.get(i).tx--;
			    	    	
			    	    }
			    	    else {
			    	    	teeth.tx++;
			    	    }
			    	}
		    	}
		    	if(teeth.tx == target.tx && teeth.ty == target.ty && checkPoint == true) {
		    		lvl++;
		    		checkLevel();
		    	}

		    	checkCollectPoint();
		    	
		    	fluidmove();
		        
		    	 if(level[teeth.getTY()][teeth.getTX()] == 2) {
			            System.out.println("dead");
			            gameOverCheck = true;
			        }
		        
		    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT  && teeth.getTX()+1 < 20 && level[teeth.getTY()][teeth.getTX() + 1] != 4){
		        teeth.tx += 1;
		        System.out.println("-> ");
		        
		        
		        for(int i =0;i<BOXX.size();i++) {
			        if( teeth.getTY() == BOXX.get(i).ty  && teeth.getTX() == BOXX.get(i).tx) {
			        	if(  BOXX.get(i).tx+1 < 20  && level[BOXX.get(i).ty][BOXX.get(i).tx+1] != 4 ) { 
			        		
			        		level[BOXX.get(i).ty][BOXX.get(i).tx+1] = 0;
			        		BOXX.get(i).tx++;
			        	}
			        	else {
			        		teeth.tx--;
			        	}
			        }
		        }
		        if(teeth.tx == target.tx && teeth.ty == target.ty && checkPoint == true) {
		    		lvl++;
		    		checkLevel();
		    	}

		        checkCollectPoint();
		    	
		        fluidmove();
		        if(level[teeth.getTY()][teeth.getTX()] == 2) {
		            System.out.println("dead");
		            gameOverCheck = true;
		        }
		        
		    }else if(e.getKeyCode() == KeyEvent.VK_R) {
		    	
		    	System.out.println("R");
		    	checkLevel();
		    }
	    }
	    
	    
	}

}






/*
  public  void fluidmove() {
int numRows = level.length;
int numCols = level[0].length;
int[][] updatedGrid = new int[numRows][numCols]; // Create a new grid to store the updated values

for (int i = 0; i < numRows; i++) {
for (int j = 0; j < numCols; j++) {
updatedGrid[i][j] = level[i][j]; // Copy the current state to the new grid
}
}



int ty = box.ty;
int tx = box.tx;
for (int i = 0; i < numRows; i++) {
for (int j = 0; j < numCols; j++) {

  if (level[i][j] == 2 || level[i][j] == 1) {
      int type = level[i][j];
  	if (i > 0 
      		&& level[i - 1][j] != 4 
      	
      	    && updatedGrid[i - 1][j] != 2) {
  		for(int k =0;k<BOXX.size();k++) {
  			if(i-1 == BOXX.get(k).ty && j == BOXX.get(k).tx) {
  				fluid =false ;
  			}else {
  				fluid =true;
  			}
      		
  		}
  		
  		if(fluid) {
  			if(type == 2 ) {
  				if(updatedGrid[i-1][j ] == 1) {
              		updatedGrid[i -1 ][j] = 4;
      		    }
      		    else {
                  updatedGrid[i - 1][j] = type;
      		    }

  			}
  			
  			
  		}
      	
         
      }
      if (i < numRows - 1 
      		&& level[i + 1][j] != 4 
      		&&  (i+1 != ty || j != tx)
      	    && updatedGrid[i + 1][j] != 2) {
      	for(int k =0;k<BOXX.size();k++) {
  			if(i+1 == BOXX.get(k).ty && j == BOXX.get(k).tx) {
  				fluid =false ;
  			}else {
  				fluid =true;
  			}
      		
  		}
      	if(fluid) {
      		if(type == 2) {
      			if(updatedGrid[i + 1 ][j] == 1) {
              		updatedGrid[i +1 ][j] = 4;
              	}
              	else {
              		updatedGrid[i + 1][j] = type;
              	}
      			
      		}
          	
      	}
      }
      if (j > 0 
      		&& level[i][j - 1] != 4 
      		&&  (i != ty || j-1 != tx)  
      	    && updatedGrid[i][j - 1] != 2) {
      	
      	for(int k =0;k<BOXX.size();k++) {
  			if(i == BOXX.get(k).ty && j -1 == BOXX.get(k).tx) {
  				fluid =false ;
  			}else {
  				fluid =true;
  			}
      		
  		}
      	if(fluid) {
      		if(type == 2) {
      			if(updatedGrid[i][j - 1] == 1) {
              		updatedGrid[i][j -1 ] = 4;
              	}else {
                  updatedGrid[i][j - 1] = type;
                  }
      		}
      		
      		
      		
      	}
      
      }
      if (j < numCols - 1 
      		&& level[i][j + 1] != 4 
      		&&  (i != ty || j+1 != tx)  
      		&& updatedGrid[i][j + 1] != 2) {
      	for(int k =0;k<BOXX.size();k++) {
  			if(i == BOXX.get(k).ty && j + 1 == BOXX.get(k).tx) {
  				fluid =false ;
  			}else {
  				fluid =true;
  			}
      		
  		}
      	if(fluid) {
      		if(type ==2 ) {
      			if(updatedGrid[i][j + 1] == 1) {
              		updatedGrid[i][j +1 ] = 4;
              	}else {
                  updatedGrid[i][j + 1] = type;}
      		
      		
      		
      	}
      	
      }
  }
  if( level[i][j] == 1) {
  	 if (i > 0 
  			 && level[i - 1][j] != 4 
  			 &&  (i-1 != ty || j != tx)
  			 && updatedGrid[i - 1][j] != 1) {
  		for(int k =0;k<BOXX.size();k++) {
  			if(i-1 == BOXX.get(k).ty && j == BOXX.get(k).tx) {
  				fluid =false ;
  			}else {
  				fluid =true;
  			}
      		
  		}   
  		 if(updatedGrid[i-1][j ] == 2) {
          		updatedGrid[i -1 ][j] = 4;
  		    }
  		    else {
              updatedGrid[i - 1][j] = 1;
  		    }
          }
          if (i < numRows - 1 
          		&& level[i + 1][j] != 4
          		&&  (i+1 != ty || j != tx)
          		&& updatedGrid[i + 1][j] != 1) {
          		for(int k =0;k<BOXX.size();k++) {
  			if(i-1 == BOXX.get(k).ty && j == BOXX.get(k).tx) {
  				fluid =false ;
  			}else {
  				fluid =true;
  			}
      		
  		}
              	if(updatedGrid[i + 1 ][j] == 2) {
              		updatedGrid[i +1 ][j] = 4;
              	}
              	else {
              		updatedGrid[i + 1][j] = 1;
              	}
          }
          if (j > 0 
          		&& level[i][j - 1] != 4 
          		&&  (i != ty || j-1 != tx)
          		&& updatedGrid[i][j - 1] != 1) {
          		for(int k =0;k<BOXX.size();k++) {
  			if(i-1 == BOXX.get(k).ty && j == BOXX.get(k).tx) {
  				fluid =false ;
  			}else {
  				fluid =true;
  			}
      		
  		}
          	
          	if(updatedGrid[i][j - 1] == 2) {
          		updatedGrid[i][j -1 ] = 4;
          	}else {
              updatedGrid[i][j - 1] = 1;}
          }
          if (j < numCols - 1 
          		&& level[i][j + 1] != 4
          		&&  (i != ty || j+1 != tx)
          		&& updatedGrid[i][j + 1] != 1) {
          		for(int k =0;k<BOXX.size();k++) {
  			if(i-1 == BOXX.get(k).ty && j == BOXX.get(k).tx) {
  				fluid =false ;
  			}else {
  				fluid =true;
  			}
      		
  		}
          	if(updatedGrid[i][j + 1] == 2) {
          		updatedGrid[i][j +1 ] = 4;
          	}else {
              updatedGrid[i][j + 1] = 1;}
          }
  }
*/









