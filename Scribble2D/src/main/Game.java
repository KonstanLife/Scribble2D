package main;

public class Game implements Runnable{
	
	private GamePanel gamePanel;
	private GameWindow gameWindow;
	private Thread thread;
	private final int FPS_SET = 120;
	
	public Game() {
		
		
		gamePanel  = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
		
	}
		
	private void startGameLoop() {
		
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0 / FPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		int frames = 0;
		long lastTimeCheck = System.currentTimeMillis();
		
		while(true) {
			
			now = System.nanoTime();
			if(now - lastFrame >= timePerFrame) {
				gamePanel.repaint();
				lastFrame = now;
				frames ++;
			}		
			
			if(System.currentTimeMillis() - lastTimeCheck >= 1000) {
				lastTimeCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		
	}

}
