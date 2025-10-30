package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

public class KeyboardInput implements KeyListener{
	
	
	private GamePanel gamePanel;
	
	public KeyboardInput(GamePanel gamePanel) {
		this.gamePanel = gamePanel; 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W: {
			gamePanel.verticalMove(-5);
			break;
		}
		case KeyEvent.VK_A: {
			gamePanel.horizontalMove(-5);
			break;
		}
		case KeyEvent.VK_S: {
			gamePanel.verticalMove(5);
			break;
		}
		case KeyEvent.VK_D: {
			gamePanel.horizontalMove(5);
			break;
		}		
		default:
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
