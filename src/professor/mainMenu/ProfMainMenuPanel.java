package professor.mainMenu;

import javax.swing.JButton;

import mainMenu.*;

public class ProfMainMenuPanel extends MainMenuPanelMasterClass{
	private JButton jbInicio,jbPerfil,jbSair;
	
	public ProfMainMenuPanel() {
		super();

		jbInicio=new JButton("Início");
		jbInicio.setBounds(0,100,100,30);
		jbInicio.addActionListener(new ProfMainMenuPanelButtonsActionListener(0));
		
		jbPerfil=new JButton("Perfil");
		jbPerfil.setBounds(100,100,100,30);
		jbPerfil.addActionListener(new ProfMainMenuPanelButtonsActionListener(1));
		
		jbSair=new JButton("Sair");
		jbSair.setBounds(100,100,100,30);
		jbSair.addActionListener(new ProfMainMenuPanelButtonsActionListener(2));
		
		//Adicionando
		add(jbInicio);add(jbPerfil);add(jbSair);
	}

	public JButton getJbInicio() {
		return jbInicio;
	}

	public void setJbInicio(JButton jbInicio) {
		this.jbInicio = jbInicio;
	}

	public JButton getJbPerfil() {
		return jbPerfil;
	}

	public void setJbPerfil(JButton jbPerfil) {
		this.jbPerfil = jbPerfil;
	}

	public JButton getJbSair() {
		return jbSair;
	}

	public void setJbSair(JButton jbSair) {
		this.jbSair = jbSair;
	}

	
}
