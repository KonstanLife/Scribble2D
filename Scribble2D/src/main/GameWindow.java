package main;

import javax.swing.JFrame;

public class GameWindow {
	
	private JFrame jframe;
	
	public GameWindow(GamePanel gamePanel) {
		
		jframe = new JFrame();	
		
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Añadir panel
		jframe.add(gamePanel);
	
		jframe.setLocationRelativeTo(null);
		
		jframe.setResizable(false);
		jframe.pack();
				
		jframe.setVisible(true);
	}

}
