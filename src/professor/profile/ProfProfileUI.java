package professor.profile;

import javax.swing.JLabel;

import professor.mainMenu.ProfMainMenuPanel;
import profile.*;

public class ProfProfileUI extends ProfileUIMasterClass{
	private JLabel jlGraduacao,jlGraduacaoInput;
	private ProfMainMenuPanel profMainMenuPanel;
	
	public ProfProfileUI() {
		super();
		
		jlGraduacao=new JLabel("Graduação:");
		jlGraduacaoInput=new JLabel("");
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
	
	public ProfMainMenuPanel getProfMainMenuPanel() {
		return profMainMenuPanel;
	}
	public void setProfMainMenuPanel(ProfMainMenuPanel profMainMenuPanel) {
		this.profMainMenuPanel = profMainMenuPanel;
	}

	public JLabel getJlGraduacao() {
		return jlGraduacao;
	}

	public void setJlGraduacao(JLabel jlGraduacao) {
		this.jlGraduacao = jlGraduacao;
	}

	public JLabel getJlGraduacaoInput() {
		return jlGraduacaoInput;
	}

	public void setJlGraduacaoInput(JLabel jlGraduacaoInput) {
		this.jlGraduacaoInput = jlGraduacaoInput;
	}
}
