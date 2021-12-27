package mainMenu;

import javax.swing.*;

public class MainMenuPanel extends JPanel{
	JButton jbInicio,jbNotas,jbPerfil,jbSair;
	
	public MainMenuPanel() {
		jbInicio=new JButton("Início");
		jbInicio.setBounds(0,100,100,30);
		jbInicio.addActionListener(new MainMenuPanelButtonsActionListener(0));
		
		jbNotas=new JButton("Notas");
		jbNotas.setBounds(100,100,100,30);
		jbNotas.addActionListener(new MainMenuPanelButtonsActionListener(1));
		
		jbPerfil=new JButton("Perfil");
		jbPerfil.setBounds(100,100,100,30);
		jbPerfil.addActionListener(new MainMenuPanelButtonsActionListener(2));
		
		jbSair=new JButton("Sair");
		jbSair.setBounds(100,100,100,30);
		jbSair.addActionListener(new MainMenuPanelButtonsActionListener(3));
		
		//Adicionando
		add(jbInicio);add(jbNotas);add(jbPerfil);add(jbSair);
		
		setBounds(0,0,1280,50);
		setVisible(true);
	}

}
