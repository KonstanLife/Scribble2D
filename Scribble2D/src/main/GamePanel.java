package main;

import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInput;
import inputs.MouseInput;

public class GamePanel extends JPanel {
	
	private int xDelta = 10, yDelta = 10;
	private MouseInput mauseInput;
	
	public GamePanel() {
		
		mauseInput = new MouseInput(this);
		addKeyListener(new KeyboardInput(this));
		addMouseListener(mauseInput);
		addMouseMotionListener(mauseInput);
		
	}
	
	public void horizontalMove(int value) {
		xDelta += value;
		repaint();
	}
	
	public void verticalMove(int value) {
		yDelta += value;
		repaint();
	}
	
	public void mouseMove(int x, int y) {
		
		this.xDelta = x;
		this.yDelta = y;
		
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.fillRect(xDelta, yDelta, 100, 50);
	}

}
