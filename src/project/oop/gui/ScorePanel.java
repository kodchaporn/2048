package project.oop.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.oop.Game;

public class ScorePanel extends GuiPanel {
	
	private int buttonWidth = 220;
	private int buttonHeight = 60;
	
	public ScorePanel() {
		super();
		
		GuiButton backButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, 440, buttonWidth, buttonHeight);
		
		backButton.setText("Back");
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GuiScreen.getInstance().setCurrentPanel("Menu");
			}
			
		});
		
		add(backButton);
	}
}
