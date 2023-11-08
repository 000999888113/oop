package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import static main.GameStates.*;//import every value MENU,PLAYING

import main.Game;
import main.GameStates;

public class keyboard implements KeyListener{

	private Game game;
	
	
	public keyboard(Game game){
		this.game =game;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_A){
			GameStates.gameState = MENU;
			System.out.println("A ");
		}else if(e.getKeyCode() == KeyEvent.VK_R){
			if(GameStates.gameState == PLAYING) {
				game.getPlay().keyPressed(e);
			}
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if(GameStates.gameState == PLAYING) {
				game.getPlay().keyPressed(e);
			}
			else
				game.getEditor().keyPressed(e);
			
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			if(GameStates.gameState == PLAYING) {
				game.getPlay().keyPressed(e);
				//System.out.println("^ ");
			}
			else {
				game.getEditor().keyPressed(e);
				
			}
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(GameStates.gameState == PLAYING) {
				game.getPlay().keyPressed(e);
				//System.out.println("<- ");
			}
			else {
				game.getEditor().keyPressed(e);
				
			}
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(GameStates.gameState == PLAYING) {
				game.getPlay().keyPressed(e);
				//System.out.println("-> ");
			}
			else {
				game.getEditor().keyPressed(e);
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
