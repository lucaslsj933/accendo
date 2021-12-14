package consultar;

import java.awt.Font;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class ConsultarUI extends JFrame{
	private JTable tableNotas;
	private JScrollPane jsp;
	
	public ConsultarUI() {
		super("Accendo - Consultar");
		
		//Dados e colunas
		String data[][]= {
			{"Programa��o Orientada a Objeto I","9,0","8,5"},
			{"Mat�ria 2","9,0","8,5"},
			{"Mat�ria 3","9,0","8,5"},
			{"Mat�ria 4","9,0","8,5"},
			{"Mat�ria 5","9,0","8,5"}
		};
		String colunas[]={"Mat�ria","TA1","TA2"};
		
		//Iniciando JTable,tamanho das colunas e jsp
		tableNotas=new JTable(data,colunas);
		
		TableColumn tb0=tableNotas.getColumnModel().getColumn(0);
		TableColumn tb1=tableNotas.getColumnModel().getColumn(1);
		TableColumn tb2=tableNotas.getColumnModel().getColumn(2);
		tb0.setMaxWidth(300);
		tb1.setMaxWidth(425);
		tb2.setMaxWidth(425);
		
		jsp = new JScrollPane(tableNotas);
		jsp.setBounds(50,50,1150,550);
		jsp.setVisible(true);
		
		//Adicionando
		add(jsp);
		
		setSize(1280,720);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}
}