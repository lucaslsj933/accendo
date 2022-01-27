package professor.insert;

import java.awt.Font;

import javax.swing.*;
import javax.swing.table.TableColumn;

import mainMenu.MainMenuPanel;

public class InsertNotasUI extends JFrame{
	private MainMenuPanel mainMenuPanel;
	private JTable tableNotasAlunos;
	private JScrollPane jsp;
	private Font bodyFont=new Font("Arial", Font.PLAIN, 20); //Font.PLAIN
	
	public InsertNotasUI() {
		super("Accendo - Inserir Notas");
		
		String colunas[]={"Aluno","TA1","TA2","TA3","TA4"};
		String data[][]=new String[30][5];
		
		for(int i=0;i<30;i++) {
			data[i][0]="Aluno "+(String.valueOf(i+1));
			data[i][1]=""; data[i][2]=""; data[i][3]=""; data[i][4]="";
		}
		
		//Esta tabela é igual à de ConsultarUI
		tableNotasAlunos=new JTable(data,colunas);
		tableNotasAlunos.getTableHeader().setFont(bodyFont);
		tableNotasAlunos.setFont(bodyFont);
		tableNotasAlunos.setRowHeight(30);

		TableColumn tb0=tableNotasAlunos.getColumnModel().getColumn(0);
		TableColumn tb1=tableNotasAlunos.getColumnModel().getColumn(1);
		TableColumn tb2=tableNotasAlunos.getColumnModel().getColumn(2);
		TableColumn tb3=tableNotasAlunos.getColumnModel().getColumn(3);
		TableColumn tb4=tableNotasAlunos.getColumnModel().getColumn(4);
		tb0.setMaxWidth(800);
		tb1.setMaxWidth(100); tb2.setMaxWidth(100); tb3.setMaxWidth(100); tb4.setMaxWidth(100);
		
		jsp = new JScrollPane(tableNotasAlunos);
		jsp.setBounds(50,50,1150,550);
		jsp.setVisible(true);
		
		//Adicionando
		add(jsp);
		
		//Adicionando mainMenuPanel
		mainMenuPanel=new MainMenuPanel();
		add(mainMenuPanel);
		
		setSize(1280,720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
	}
}
