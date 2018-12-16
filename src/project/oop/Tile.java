package project.oop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static final int WIDTH = 90;
	public static final int HEIGHT = 90;
	public static final int SLIDE_SPEED = 20;
	public static final int ARC_WIDTH = 15;
	public static final int ARC_HEIGHT = 15;
	
	private int value;
	private BufferedImage tileImage;
	private Color background;
	private Color text;
	private Font font;
	private Point slideTo;
	private int x;
	private int y;
	
	private boolean canCombine = true;
	
	public Tile(int value, int x, int y) {
		this.value = value;
		this.x = x;
		this.y = y;
		slideTo = new Point(x, y);
		tileImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		drawImage();		
	}
	
	private void drawImage() {
		Graphics2D g = (Graphics2D)tileImage.getGraphics();
		if(value == 2) {
			background = new Color(0xeee4da);
			text = new Color(0x000000);
		}
		else if (value == 4) {
			background = new Color(0xede0c8);
			text = new Color(0x000000);
		}
		else if (value == 8) {
			background = new Color(0xf2b179);
			text = new Color(0xffffff);
		}
		else if (value == 16) {
			background = new Color(0xf59563);
			text = new Color(0xffffff);
		}
		else if (value == 32) {
			background = new Color(0xf67c5f);
			text = new Color(0xffffff);
		}
		else if (value == 64) {
			background = new Color(0xf65e3b);
			text = new Color(0xffffff);
		}
		else if (value == 128) {
			background = new Color(0xedcf72);
			text = new Color(0x000000);
		}
		else if (value == 256) {
			background = new Color(0xedcc61);
			text = new Color(0x000000);
		}
		else if (value == 512) {
			background = new Color(0xedc850);
			text = new Color(0x000000);
		}
		else if (value == 1024) {
			background = new Color(0xedc53f);
			text = new Color(0xffffff);
		}
		else if (value == 2048) {
			background = new Color(0xedc22e);
			text = new Color(0xffffff);
		}
		else {
			background = Color.black;
			text = Color.white;
		}
		
		g.setColor(background);
		g.fillRoundRect(0, 0, WIDTH, HEIGHT, ARC_WIDTH, ARC_HEIGHT);
		
		g.setColor(text);
		if(value <= 64) {
			font = Game.main.deriveFont(36f);
		}else {
			font = Game.main;
		}
		g.setFont(font);
		
		int drawX = WIDTH / 2 - DrawUtil.getMessageWidth("" + value, font, g) / 2;
		int drawY = HEIGHT / 2 + DrawUtil.getMessageWidth("" + value, font, g) / 2;
		g.drawString("" + value, drawX, drawY);
		g.dispose();
	}
	
	public void update() {
		
	}
	
	public void render(Graphics2D g) {
		g.drawImage(tileImage, x, y, null);
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
		drawImage();
	}
	
	public boolean CanCombine() {
		return canCombine;
	}
	
	public void setCanCombine(boolean canCombine) {
		this.canCombine = canCombine;
	}

	public Point getSlideTo() {
		return slideTo;
	}

	public void setSlideTo(Point slideTo) {
		this.slideTo = slideTo;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
