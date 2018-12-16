package project.oop;

import javax.swing.JFrame;


import java.awt.Toolkit;
import java.net.URL;

public class Start {

	public static void main(String[] args) {
		Game game = new Game();
		
		JFrame window = new JFrame("2048");
		URL imageURL = Start.class.getResource("2048_logo.png");
		window.setIconImage(Toolkit.getDefaultToolkit().getImage(imageURL));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.add(game);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		game.start();
	}
}
