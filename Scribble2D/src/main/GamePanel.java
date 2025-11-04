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

public class GamePanel extends JPanel {
	
	private float xDelta = 10, yDelta = 10;
	
	private MouseInput mauseInput;
	
	private BufferedImage bufferedImage, subImg;
	
	
	public GamePanel() {
		
		mauseInput = new MouseInput(this);
		importImage();
		addKeyListener(new KeyboardInput(this));
		addMouseListener(mauseInput);
		addMouseMotionListener(mauseInput);
		setPanelSize();
		
		
	}
	
	private void importImage() {
		InputStream is = getClass().getResourceAsStream("/hero.png");
		
		try {
			bufferedImage = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void setPanelSize() {
		
		Dimension size = new Dimension(1280,800);
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);
		
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
		
		subImg = bufferedImage.getSubimage(0, 0, 50, 37);
		g.drawImage(subImg,(int)xDelta ,(int)yDelta,null);
	}
	

}
