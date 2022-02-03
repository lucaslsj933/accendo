package profile;

import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;

import dbTools.DBMain;
import mainMenu.MainMenuPanel;
import java.awt.Font;


public class ProfileUI extends ProfileUIMasterClass{
	private JLabel jlSerie,
		jlSerieInput,jlEtapa,jlEtapaInput,jlTurma,jlTurmaInput;
	
	public ProfileUI() {
		super();
		
		jlSerie=new JLabel("Série/Ano:");
		jlSerieInput=new JLabel("");
		jlSerie.setFont(getBoldBodyFont()); jlSerieInput.setFont(getBodyFont());
		jlSerie.setBounds(400,220,104,30);
		jlSerieInput.setBounds(511,220,28,30);
		
		jlEtapa=new JLabel("Etapa:");
		jlEtapaInput=new JLabel("");
		jlEtapa.setFont(getBoldBodyFont()); jlEtapaInput.setFont(getBodyFont());
		jlEtapa.setBounds(400,250,68,30);
		jlEtapaInput.setBounds(471,250,127,30);
		
		jlTurma=new JLabel("Turma:");
		jlTurmaInput=new JLabel("");
		jlTurma.setFont(getBoldBodyFont()); jlTurmaInput.setFont(getBodyFont());
		jlTurma.setBounds(400,280,68,30);
		jlTurmaInput.setBounds(479,280,127,30);
		
		//Adicionando
		getContentPane().add(jlSerie); getContentPane().add(jlSerieInput);
		getContentPane().add(jlEtapa); getContentPane().add(jlEtapaInput); getContentPane().add(jlTurma); getContentPane().add(jlTurmaInput);
	}
	
	public JLabel getJlSerie() {
		return jlSerie;
	}

	public void setJlSerie(JLabel jlSerie) {
		this.jlSerie = jlSerie;
	}

	public JLabel getJlSerieInput() {
		return jlSerieInput;
	}

	public void setJlSerieInput(JLabel jlSerieInput) {
		this.jlSerieInput = jlSerieInput;
	}

	public JLabel getJlEtapa() {
		return jlEtapa;
	}

	public void setJlEtapa(JLabel jlEtapa) {
		this.jlEtapa = jlEtapa;
	}

	public JLabel getJlEtapaInput() {
		return jlEtapaInput;
	}

	public void setJlEtapaInput(JLabel jlEtapaInput) {
		this.jlEtapaInput = jlEtapaInput;
	}

	public JLabel getJlTurma() {
		return jlTurma;
	}

	public void setJlTurma(JLabel jlTurma) {
		this.jlTurma = jlTurma;
	}

	public JLabel getJlTurmaInput() {
		return jlTurmaInput;
	}

	public void setJlTurmaInput(JLabel jlTurmaInput) {
		this.jlTurmaInput = jlTurmaInput;
	}
}