package professor.insert;

import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import main.BigTableUIMasterClass;
import mainMenu.MainMenuPanel;
import professor.mainMenu.ProfMainMenuPanel;


public class ProfInsertUI extends BigTableUIMasterClass{
	private ProfMainMenuPanel profMainMenuPanel;
	private JLabel jlTurma;
	private JComboBox jcbTurma;
	private JButton jbLoadTurma;
	
	public ProfInsertUI() {
		setTitle("Accendo - Inserir Notas");
		
		//Turma Select
		
		jlTurma=new JLabel("Turma: ");
		jlTurma.setBounds(50,60,100,30);
		jlTurma.setFont(getBodyFont());
		
		String dataJcbTurma[]={"Turma 1","Turma 2","Turma 3","Turma 4","Turma 5"};
		jcbTurma=new JComboBox(dataJcbTurma);
		jcbTurma.setBounds(120,50,400,50);
		
		jbLoadTurma=new JButton("Carregar Turma");
		jbLoadTurma.setBounds(540,50,300,50);
		
		//Table
		
		String colunas[]={"Aluno","TA1","TA2","TA3","TA4"};
		String data[][]=new String[30][5];
		
		for(int i=0;i<30;i++) {
			data[i][0]="Aluno "+(String.valueOf(i+1));
			data[i][1]=""; data[i][2]=""; data[i][3]=""; data[i][4]="";
		}
		
		//Definindo tamanho, posição e inserindo dados
		getJsp().setBounds(50,120,1150,550);
		getTable().setModel(new DefaultTableModel(data, colunas));
		
		TableColumn tb0=getTable().getColumnModel().getColumn(0);
		TableColumn tb1=getTable().getColumnModel().getColumn(1);
		TableColumn tb2=getTable().getColumnModel().getColumn(2);
		TableColumn tb3=getTable().getColumnModel().getColumn(3);
		TableColumn tb4=getTable().getColumnModel().getColumn(4);
		tb0.setMaxWidth(800);
		tb1.setMaxWidth(100); tb2.setMaxWidth(100); tb3.setMaxWidth(100); tb4.setMaxWidth(100);
		
		//Adicionando (além da super-classe)
		add(jlTurma);add(jcbTurma);add(jbLoadTurma);
		
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

	public JComboBox getJcbTurma() {
		return jcbTurma;
	}

	public void setJcbTurma(JComboBox jcbTurma) {
		this.jcbTurma = jcbTurma;
	}

	public JLabel getJlTurma() {
		return jlTurma;
	}

	public void setJlTurma(JLabel jlTurma) {
		this.jlTurma = jlTurma;
	}

	public JButton getJbLoadTurma() {
		return jbLoadTurma;
	}

	public void setJbLoadTurma(JButton jbLoadTurma) {
		this.jbLoadTurma = jbLoadTurma;
	}
}