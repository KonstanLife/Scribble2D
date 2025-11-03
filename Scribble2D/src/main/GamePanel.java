package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import inputs.KeyboardInput;
import inputs.MouseInput;

public class GamePanel extends JPanel {
	
	private float xDelta = 10, yDelta = 10;
	private float xDir = 1, yDir = 1;
	private MouseInput mauseInput;
	
	private Random random;
	private Color color;
	
	public GamePanel() {
		
		mauseInput = new MouseInput(this);
		addKeyListener(new KeyboardInput(this));
		addMouseListener(mauseInput);
		addMouseMotionListener(mauseInput);
		
		random = new Random();
		
	}
	
	public void horizontalMove(int value) {
		xDelta += value;
	}
	
	public void verticalMove(int value) {
		yDelta += value;	
	}
	
	public void mouseMove(int x, int y) {
		
		this.xDelta = x;
		this.yDelta = y;
				
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(color);
		g.fillRect((int)xDelta, (int)yDelta, 100, 50);
		
		updateRectangle();	
	}
	
	private void updateRectangle() {
		
		xDelta += xDir;
		if(xDelta > 390 || xDelta < 1) {
			xDir *= -1;
			color = updateColor();
		}
		
		yDelta += yDir;
		if(yDelta > 415 || yDelta < 1) {
			yDir *= -1;
			color = updateColor();

		}		
	}
	
	private Color updateColor() {
		
		return new Color(random.nextInt(255),random.nextInt(255), random.nextInt(255));
	}

}
