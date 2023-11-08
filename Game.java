package main;



import javax.swing.JFrame;

import helpz.LoadSave;
import managers.TileManager;
import scenes.Editing;
import scenes.Menu;
import scenes.Play;

public class Game extends JFrame implements Runnable {
	
	
	
	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;
	
	
	private Thread gameThread;
	
	//Classes
	private GameScreen myGameScreen;
	private Render render;
	private Menu menu;
	private Play play;
	private Editing editing;
	private TileManager tileManager;
	
	
	public Game(){
		
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setResizable(false);
			
			initClasses();
			
			
			add(myGameScreen);
			pack(); // preferred content 
			
			
			setVisible(true);
	}
	
	
	private void initClasses() {
		tileManager = new TileManager();
		render = new Render(this);
		myGameScreen = new GameScreen(this);
		menu = new Menu(this);
		play = new Play(this);
		editing = new Editing(this);
		
	}
	private void start() {
		gameThread = new Thread(this) ;
		gameThread.start();
	}
	
	
	

	public static void main(String[] args) {
			Game myGame = new Game();
			myGame.myGameScreen.initinputs();
			myGame.start();
			
	}

	//Runnable
	//Game loop
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double timeperframe= 1000000000.0/FPS_SET;;
		double timeperupdates = 1000000000.0/UPS_SET;
		
		long lasttimecheck = System.currentTimeMillis();
		long lastupdate = System.nanoTime();
		long lastframe = System.nanoTime();
		
		int frames = 0;
		int updates = 0;
		
		long now;
		while(true) {
			//render
			now = System.nanoTime();
			if( now - lastframe >= timeperframe) {
				repaint();
				lastframe = System.nanoTime();
				frames++;
			}
			
			//update
			if(now - lastupdate >= timeperupdates) {
				
				lastupdate = System.nanoTime();
				updates++;
				
			}
			
			if(System.currentTimeMillis() - lasttimecheck >= 1000) {
				System.out.println("FPS  "+frames+" | " + "UPS  " +updates );
				frames = 0;
				updates = 0;
				lasttimecheck = System.currentTimeMillis();
			}
		}
	}
	
	
	//getter setter
	public Render getRender() {
		return render;
	}
	public Menu getMenu() {
		return menu;
	}

	public Play getPlay() {
		return play;
	}
	public Editing getEditor() {
		return editing;
	}

	public TileManager getTileManager() {
		return tileManager;
	}

	public void setTileManager(TileManager tileManager) {
		this.tileManager = tileManager;
	}
	

}
