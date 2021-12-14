package consultar;

import javax.swing.*;

public class ConsultarUI extends JFrame{
	private JTable tableNotas;
	private JScrollPane jsp;
	
	public ConsultarUI() {
		super("Accendo - Consultar");
		
		//Dados e colunas
		String data[][]= {
			{"Matéria 1","9,0","8,5"},
			{"Matéria 2","9,0","8,5"}
		};
		String colunas[]={"Matéria","TA1","TA2"};
		
		//Iniciando JTable e jsp
		tableNotas=new JTable(data,colunas);
		tableNotas.setBounds(20,50,200,300);
		jsp = new JScrollPane(tableNotas);
		
		jsp.setSize(300,400); 
		jsp.setVisible(true);
		
		//Adicionando
		add(jsp);
		
		setSize(1280,720);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}
}