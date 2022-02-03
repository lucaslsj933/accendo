package professor.profile;

import javax.swing.JLabel;

import professor.mainMenu.ProfMainMenuPanel;
import profile.*;

public class ProfProfileUI extends ProfileUIMasterClass{
	private ProfMainMenuPanel profMainMenuPanel;
	public ProfProfileUI() {
		super();
		
		JLabel jlGraduacao=new JLabel("Graduação:");
		JLabel jlGraduacaoInput=new JLabel("");
		jlGraduacao.setFont(getBoldBodyFont()); jlGraduacaoInput.setFont(getBodyFont());
		jlGraduacao.setBounds(400,220,120,30);
		jlGraduacaoInput.setBounds(522,220,250,30);
		
		//Adicionando
		add(jlGraduacao); add(jlGraduacaoInput);
		
		//ProfMainMenuPanel
		remove(getMainMenuPanel());
		setMainMenuPanel(null);
		profMainMenuPanel=new ProfMainMenuPanel();
		add(profMainMenuPanel);
	}

}
