package mainMenu;

import java.awt.Font;
import java.sql.Connection;

import javax.swing.*;

import main.Main;

import java.sql.*;
import dbTools.*;


public class HomeMenuUI extends JFrame{
	private MainMenuPanel mainMenuPanel;
	private JLabel jlWelcome;
	
	public HomeMenuUI() {
		super("Accendo");
		
		jlWelcome=new JLabel("Bem Vindo!");
		jlWelcome.setBounds(1280/2-120,720/2-200,600,30);
		jlWelcome.setFont(new Font("Lucida Handwriting", Font.PLAIN, 40));
		
		//Adicionando
		add(jlWelcome);
		
		//Adicionando mainMenuPanel
		mainMenuPanel=new MainMenuPanel();
		add(mainMenuPanel);
		
		setSize(1280,720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
	}

	public MainMenuPanel getMainMenuPanel() {
		return mainMenuPanel;
	}

	public void setMainMenuPanel(MainMenuPanel mainMenuPanel) {
		this.mainMenuPanel = mainMenuPanel;
	}

	public JLabel getJlWelcome() {
		return jlWelcome;
	}

	public void setJlWelcome(JLabel jlWelcome) {
		this.jlWelcome = jlWelcome;
	}
	
	
}
