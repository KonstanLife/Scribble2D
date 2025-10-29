package main;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	public GamePanel() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.fillRect(10, 10, 100, 50);
	}

}
