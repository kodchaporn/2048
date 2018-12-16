package project.oop.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import project.oop.DrawUtil;
import project.oop.Game;
import project.oop.GameBoard;
import project.oop.ScoreManager;

public class PlayPanel extends GuiPanel {

	private GameBoard board;
	private BufferedImage info;
	private ScoreManager scores;
	private Font scoreFont;

	// Game Over
	private GuiButton tryAgain;
	private GuiButton mainMenu;
	private int smallButtonWidth = 160;
	private int buttonHeight = 60;
	private boolean added;
	private int alpha;
	private Font gameOverFont;

	public PlayPanel() {
		scoreFont = Game.main.deriveFont(24f);
		gameOverFont = Game.main.deriveFont(70f);
		board = new GameBoard(Game.WIDTH / 2 - GameBoard.BOARD_WIDTH / 2, Game.HEIGHT - GameBoard.BOARD_HEIGHT - 20);
		scores = board.getScores();
		info = new BufferedImage(Game.WIDTH, 200, BufferedImage.TYPE_INT_RGB);
		
		GuiButton backButton = new GuiButton(220, 30, 100, buttonHeight);
		GuiButton resetButton = new GuiButton(330, 30, 100, buttonHeight);

		backButton.setText("Menu");
		resetButton.setText("Restart");

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("Menu");
			}

		});
		
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				board.getScores().reset();
				board.reset();
				alpha = 0;

				remove(tryAgain);
				remove(mainMenu);

				added = false;
			}

		});

		add(backButton);
		add(resetButton);

		tryAgain = new GuiButton(Game.WIDTH / 2 - smallButtonWidth / 2, 320, smallButtonWidth, buttonHeight);
		mainMenu = new GuiButton(Game.WIDTH / 2 - smallButtonWidth / 2, 400, smallButtonWidth, buttonHeight);

		tryAgain.setText("Try Again");
		mainMenu.setText("Main Menu");

		tryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.getScores().reset();
				board.reset();
				alpha = 0;

				remove(tryAgain);
				remove(mainMenu);

				added = false;
			}
		});

		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiScreen.getInstance().setCurrentPanel("Menu");
			}
		});
	}
	
	private void drawGui(Graphics2D g) {
		//Formal the times
//		timeF = DrawUtil.formatTime(scores.getTime());
		//Draw it
		Graphics2D g2d = (Graphics2D)info.getGraphics();
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, info.getWidth(), info.getHeight());
		g2d.setColor(new Color(0x907e78));
		g2d.setFont(scoreFont);
		g2d.drawString(""+scores.getCurrentScore(), 30, 40);
		g2d.setColor(new Color(0xdf5222));
		g2d.drawString("Best: "+scores.getCurrentTopScore(), 30, 100);
		
		g2d.dispose();
		g.drawImage(info, 0, 0, null);
	}
	
	public void drawGameOver(Graphics2D g) {
		g.setColor(new Color(222,222,222,alpha));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(new Color(0xdf5222));
		g.setFont(gameOverFont);
		g.drawString("Game Over!", Game.WIDTH/2 - DrawUtil.getMessageWidth("Game Over!", gameOverFont, g)/2, 250);
		
	}
	
//	public void drawYouWon(Graphics2D g) {
//		g.setColor(new Color(222,222,222,alpha));
//		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
//		g.setColor(new Color(0x5eb1bf));
//		g.setFont(gameOverFont);
//		g.drawString("You Won!", Game.WIDTH/2 - DrawUtil.getMessageWidth("You Won!", gameOverFont, g)/2, 250);
//		
//	}
	
	@Override
	public void update() {
		board.update();
		if(board.isDead()) {
			alpha++;
			if(alpha > 170) alpha = 170;
		}
	}
	
	@Override
	public void render(Graphics2D g) {
		drawGui(g);
		board.render(g);
		if(board.isDead()) {
			if(!added) {
				added = true;
				add(mainMenu);
				add(tryAgain);
			}
			drawGameOver(g);
		}
//			else if(board.isWon()) {
//			if(!added) {
//				added = true;
//				add(mainMenu);
//				add(tryAgain);
//			}
//			drawYouWon(g);
//		}
		super.render(g);
	}

}
