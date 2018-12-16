package project.oop.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.oop.DrawUtil;
import project.oop.Game;

public class TutorialPanel extends GuiPanel {
	private Font titleFont = Game.main.deriveFont(32f);
	private Font tutorialFont = Game.main.deriveFont(24f);
	private String title = "Tutorial";
	private String tutorial1 = "1. Use keyboard to move";
	private String tutorial2 = "2. Swipe to move all tiles";
	private String tutorial3 = "3. Join the number and get to the";
	private String tutorial31 = "	2048 tile!";
	private String tutorial4 = "4. You can see Top 5 scores on";
	private String tutorial41 = "	scores panel";
	private String tutorial5 = "5. Click on Restart panel for your";
	private String tutorial51 = "	new game";
	private int buttonWidth = 220;
	private int buttonHeight = 60;

	public TutorialPanel() {
		super();

		GuiButton backButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, 480, buttonWidth, buttonHeight);

		backButton.setText("Menu");

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("Menu");
			}

		});

		add(backButton);
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString(title, Game.WIDTH / 2 - DrawUtil.getMessageWidth(title, titleFont, g) / 2, 50);
		g.setFont(tutorialFont);
		g.drawString(tutorial1, 30, 100);
		g.drawString(tutorial2, 30, 150);
		g.drawString(tutorial3, 30, 200);
		g.drawString(tutorial31, 60, 250);
		g.drawString(tutorial4, 30, 300);
		g.drawString(tutorial41, 60, 350);
		g.drawString(tutorial5, 30, 400);
		g.drawString(tutorial51, 60, 450);
	}
}
