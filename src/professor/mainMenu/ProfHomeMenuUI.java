package professor.mainMenu;

import java.awt.Font;

import javax.swing.*;

import dbToolsTest.InsertALotOfAlunos;
import main.Main;
import mainMenu.*;

public class ProfHomeMenuUI extends JFrame{
	private ProfMainMenuPanel profMainMenuPanel;
	private JLabel jlWelcome;
	
	public ProfHomeMenuUI() {
		super("Accendo");
		
		jlWelcome=new JLabel("Bem vindo, Professor!");
		jlWelcome.setBounds(1280/2-220,720/2-200,600,30);
		jlWelcome.setFont(new Font("Lucida Handwriting", Font.PLAIN, 40));

		//Adicionando
		add(jlWelcome);
		
		//Adicionando mainMenuPanel
		profMainMenuPanel=new ProfMainMenuPanel();
		add(profMainMenuPanel);
		
		setSize(1280,720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
	}
	
	
}
