package mainMenu;

import javax.swing.*;

import main.Main;

public class HomeMenuUI extends JFrame{
	private MainMenuPanel mainMenuPanel;
	
	public HomeMenuUI() {
		super("Accendo");
		
		//Adicionando mainMenuPanel
		mainMenuPanel=new MainMenuPanel();
		add(mainMenuPanel);
		
		setSize(1280,720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
	}
}
