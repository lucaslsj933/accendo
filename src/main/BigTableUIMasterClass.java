package main;

import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import main.Main;
import mainMenu.MainMenuPanel;

//LEMBRE-SE QUE O setVisible(true); DEVE SER EXECUTADO DEPOIS PARA FICAR VISÍVEL!

//Lembre-se que é uma boa ideia copiar o código Max Width nas sub-classes a não ser que você queira usá-lo exatamente igual

public class BigTableUIMasterClass extends JFrame{
	private JTable table;
	private JScrollPane jsp;
	private MainMenuPanel mainMenuPanel;
	private Font bodyFont=new Font("Arial", Font.PLAIN, 20); //Font.PLAIN
	
	/*
	 * Alterar os dados e colunas
	 
	   String data2[][]= {
			{"Matéria 1","","","",""},
			{"Matéria 2","","","",""},
			{"Matéria 3","","","",""},
			{"Matéria 4","","","",""},
			{"Matéria 5","","","",""}
		};
	String colunas2[]={"Matéria","TA1","TA2","TA3","TA4"};
	
	tableNotas.setModel(new DefaultTableModel(data2, colunas2));
	 * 
	 */
	
	public BigTableUIMasterClass() {
		//Dados e colunas
		String data[][]= {
			{"Exemplo 1","Exemplo 2"},
		};
		String colunas[]={"Exemplo","Exemplo 2"};
		
		//Iniciando JTable,tamanho das colunas e jsp
		table=new JTable(data,colunas);
		
		table.getTableHeader().setFont(bodyFont);
		table.setFont(bodyFont);
		table.setRowHeight(30);
		
		//Max Width
		TableColumn tb0=table.getColumnModel().getColumn(0);
		TableColumn tb1=table.getColumnModel().getColumn(1);
		tb0.setMaxWidth(800);
		tb1.setMaxWidth(800);
		
		//JSP
		jsp = new JScrollPane(table);
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
	}
	
	public JTable getTable() {
		return table;
	}
	
	public void setTable(JTable table) {
		this.table = table;
	}

	public Font getBodyFont() {
		return bodyFont;
	}

	public void setBodyFont(Font bodyFont) {
		this.bodyFont = bodyFont;
	}

	public JScrollPane getJsp() {
		return jsp;
	}

	public void setJsp(JScrollPane jsp) {
		this.jsp = jsp;
	}

	public MainMenuPanel getMainMenuPanel() {
		return mainMenuPanel;
	}

	public void setMainMenuPanel(MainMenuPanel mainMenuPanel) {
		this.mainMenuPanel = mainMenuPanel;
	}
}