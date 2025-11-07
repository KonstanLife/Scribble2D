package main;

import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInput;
import inputs.MouseInput;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Direcions.*;

public class GamePanel extends JPanel {
	
	private float xDelta = 10, yDelta = 10;
	
	private MouseInput mauseInput;
	
	private BufferedImage bufferedImage;
	private BufferedImage[][] animations;
	
	private int animationTick, animationIndex, animationSpeed = 30;
	
	private int playerAcion = IDLE;
	private int playerDirection = -1;
	private boolean moving = false;
	
	public GamePanel() {
		
		mauseInput = new MouseInput(this);
		importImage();
		loadAnimation();
		addKeyListener(new KeyboardInput(this));
		addMouseListener(mauseInput);
		addMouseMotionListener(mauseInput);
		setPanelSize();
		
		
	}
	
	private void loadAnimation() {
		animations = new BufferedImage[11][7];
		for(int j = 0; j < animations.length; j++) {
			for(int i = 0; i <animations[j].length; i++) {
				animations[j][i] =bufferedImage.getSubimage(i * 50, j * 37, 50, 37);
			}
		}
		
	}

	private void importImage() {
		InputStream is = getClass().getResourceAsStream("/hero.png");
		
		try {
			bufferedImage = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

	private void setPanelSize() {
		
		Dimension size = new Dimension(1280,800);
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);
		
	}
	
	
	public void setDirection(int direction) {
		this.playerDirection = direction;
		this.moving = true;
	}
	
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	private void updateAnimation() {
		
		animationTick++;
		
		if(animationTick >= animationSpeed) {
			animationTick = 0;
			animationIndex ++;
			if(animationIndex >= GetSpriteAmount(playerAcion)) {
				animationIndex = 0;
			}
		}
		
	}
	
	private void setAnimation() {
		if(moving) {
			playerAcion = RUNNING;
		}else {
			playerAcion = IDLE;
		}
		
	}
	
	private void upadtePosition() {
		
		if(moving) {
			
			switch (playerDirection) {
			case LEFT:
				xDelta -=5;
			case UP: 
				yDelta -=5;
			case RIGHT: 
				xDelta += 5;
			case DOWN: 
				yDelta += 5;
				
				break;
			
		}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//subImg = bufferedImage.getSubimage(0, 0, 50, 37);
		updateAnimation();
		
		setAnimation();
		upadtePosition();
		
		g.drawImage(animations[playerAcion][animationIndex],(int)xDelta ,(int)yDelta,50*2,37*2,null);
	}
	

}
