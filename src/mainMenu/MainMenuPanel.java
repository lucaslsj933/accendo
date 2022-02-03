package mainMenu;

import javax.swing.*;

public class MainMenuPanel extends MainMenuPanelMasterClass{
	JButton jbInicio,jbNotas,jbPerfil,jbSair;
	
	public MainMenuPanel() {
		super();

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
	}

	public JButton getJbNotas() {
		return jbNotas;
	}

	public void setJbNotas(JButton jbNotas) {
		this.jbNotas = jbNotas;
	}

	public JButton getJbPerfil() {
		return jbPerfil;
	}

	public void setJbPerfil(JButton jbPerfil) {
		this.jbPerfil = jbPerfil;
	}
}
