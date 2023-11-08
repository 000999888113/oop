package main;
//enum constants value
public enum GameStates {
	PLAYING,
	MENU,
	EDIT,
	SETTINGS;
	
	public static GameStates gameState = MENU;
	
	public static void setGameStates(GameStates state) {
		gameState = state;
	}
}
