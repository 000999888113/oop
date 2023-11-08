package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Game;
import main.GameStates;

public  class mouse implements MouseListener,MouseMotionListener {
	//mouse listener
	private Game game;
	public mouse(Game game) {
		this.game = game;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == MouseEvent.BUTTON1) {
			switch (GameStates.gameState) {
			case MENU:
				game.getMenu().mouseClicked(e.getX(), e.getY());
				break;
			case PLAYING:
				game.getPlay().mouseClicked(e.getX(), e.getY());
				break;
			case EDIT:
				game.getEditor().mouseClicked(e.getX(), e.getY());
				break;
			default:
				break;
			}
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		switch (GameStates.gameState) {
		case MENU:
			game.getMenu().mouseMoved(e.getX(), e.getY());
			break;
		case PLAYING:
			game.getPlay().mouseMoved(e.getX(), e.getY());
			break;
		case EDIT:
			game.getEditor().mouseMoved(e.getX(), e.getY());
			break;
		default:
			break;
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			switch (GameStates.gameState) {
			case MENU:
				game.getMenu().mousePressed(e.getX(), e.getY());
				break;
			case PLAYING:
				game.getPlay().mousePressed(e.getX(), e.getY());
				break;
			case EDIT:
				game.getEditor().mousePressed(e.getX(), e.getY());
				break;
			default:
				break;
			}
		}
		
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			switch (GameStates.gameState) {
			case MENU:
				game.getMenu().mouseReleased(e.getX(), e.getY());
				break;
			case PLAYING:
				game.getPlay().mouseReleased(e.getX(), e.getY());
				break;
			case EDIT:
				game.getEditor().mouseReleased(e.getX(), e.getY());
				break;
			default:
				break;
			}
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	//mouse motion
	@Override
	public void mouseDragged(MouseEvent e) {
		
			switch (GameStates.gameState) {
			case MENU:
				game.getMenu(). mouseDragged(e.getX(), e.getY());
				break;
			case PLAYING:
				game.getPlay(). mouseDragged(e.getX(), e.getY());
				break;
			case EDIT:
				game.getEditor().mouseDragged(e.getX(), e.getY());
				break;
			default:
				break;
			}
		
		
	}

	

}
