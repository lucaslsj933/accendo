package consultar;

import java.awt.Font;

import javax.swing.*;
import javax.swing.table.TableColumn;

import main.Main;
import mainMenu.MainMenuPanel;
import mainMenu.MainMenuPanel;

public class ConsultarUI extends JFrame{
	private JTable tableNotas;
	private JScrollPane jsp;
	private MainMenuPanel mainMenuPanel;
	private Font bodyFont=new Font("Arial", Font.PLAIN, 20); //Font.PLAIN
	
	public ConsultarUI() {
		super("Accendo - Notas");
		
		//Dados e colunas
		String data[][]= {
			{"Matéria 1","","","",""},
			{"Matéria 2","","","",""},
			{"Matéria 3","","","",""},
			{"Matéria 4","","","",""},
			{"Matéria 5","","","",""}
		};
		String colunas[]={"Matéria","TA1","TA2","TA3","TA4"};
		
		//Iniciando JTable,tamanho das colunas e jsp
		tableNotas=new JTable(data,colunas);
		
		tableNotas.getTableHeader().setFont(bodyFont);
		tableNotas.setFont(bodyFont);
		tableNotas.setRowHeight(30);
		
		TableColumn tb0=tableNotas.getColumnModel().getColumn(0);
		TableColumn tb1=tableNotas.getColumnModel().getColumn(1);
		TableColumn tb2=tableNotas.getColumnModel().getColumn(2);
		TableColumn tb3=tableNotas.getColumnModel().getColumn(3);
		TableColumn tb4=tableNotas.getColumnModel().getColumn(4);
		tb0.setMaxWidth(800);
		tb1.setMaxWidth(100); tb2.setMaxWidth(100); tb3.setMaxWidth(100); tb4.setMaxWidth(100);
		
		jsp = new JScrollPane(tableNotas);
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

	public JTable getTableNotas() {
		return tableNotas;
	}

	public void setTableNotas(JTable tableNotas) {
		this.tableNotas = tableNotas;
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