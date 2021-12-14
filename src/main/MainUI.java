package main;

import javax.swing.*;
import java.awt.Font;

public class MainUI extends JFrame{
	private JLabel jlTitle,jlMatricula,jlSenha;
	private JTextField jtfMatricula,jtfSenha;
	private JButton jbAcessar;
	
	public MainUI() {
		super("Accendo");
		
		//Labels
		jlTitle=new JLabel("Accendo");
		jlTitle.setBounds(1280/2-100,720/2-200,200,30);
		jlTitle.setFont(new Font("Lucida Handwriting", Font.PLAIN, 40));
		
		jlMatricula=new JLabel("Matrícula: ");
		jlMatricula.setBounds(1280/2-200,720/2-100,100,30);
		
		jlSenha=new JLabel("Senha: ");
		jlSenha.setBounds(1280/2-200,720/2-50,100,30);
		
		//TextFields
		jtfMatricula=new JTextField();
		jtfMatricula.setBounds(1280/2,720/2-100,200,30);
		
		jtfSenha=new JTextField();
		jtfSenha.setBounds(1280/2,720/2-50,200,30);
		
		//Buttons
		jbAcessar=new JButton("Acessar");
		jbAcessar.setBounds(1280/2+100,720/2,100,30);
		
		//Adicionando
		add(jlTitle);add(jlMatricula);add(jlSenha);
		
		add(jtfMatricula);add(jtfSenha);
		
		add(jbAcessar);
		
		//setLocationRelativeTo(null); centraliza na tela
		setSize(1280,720);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}
}
