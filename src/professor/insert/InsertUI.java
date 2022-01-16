package professor.insert;

import javax.swing.*;

import mainMenu.MainMenuPanel;

public class InsertUI extends JFrame{
	private MainMenuPanel mainMenuPanel;
	
	public InsertUI() {
		super("Accendo - Inserir Notas");
		
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
