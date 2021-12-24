package mainMenu;

import javax.swing.*;

public class MainMenuPanel extends JPanel{
	JButton jbInicio,jbNotas,jbSair;
	
	public MainMenuPanel() {
		jbInicio=new JButton("Início");
		jbInicio.setBounds(0,100,100,30);
		jbInicio.addActionListener(new MainMenuPanelButtonsActionListener(0));
		
		jbNotas=new JButton("Notas");
		jbNotas.setBounds(100,100,100,30);
		jbNotas.addActionListener(new MainMenuPanelButtonsActionListener(1));
		
		jbSair=new JButton("Sair");
		jbSair.setBounds(100,100,100,30);
		jbSair.addActionListener(new MainMenuPanelButtonsActionListener(2));
		
		//Adicionando
		add(jbInicio);add(jbNotas);add(jbSair);
		
		setBounds(0,0,1280,720);
		setVisible(true);
	}

}
