package main;

import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInput;
import inputs.MouseInput;

public class GamePanel extends JPanel {
	
	private int xDelta = 10, yDelta = 10;
	
	public GamePanel() {
		
		addKeyListener(new KeyboardInput(this));
		//addMouseListener(new MouseInput());
		
	}
	
	public void horizontalMove(int value) {
		xDelta += value;
		repaint();
	}
	
	public void verticalMove(int value) {
		yDelta += value;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.fillRect(xDelta, yDelta, 100, 50);
	}

}
