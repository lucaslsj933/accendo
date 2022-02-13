package main;

import javax.swing.*;
import java.awt.Font;

public class MainUI extends JFrame{
	private JLabel jlTitle,jlMatricula,jlSenha;
	private JPasswordField jpfSenha;
	private JTextField jtfMatricula;
	private JButton jbAcessar,jbAcessarSaoJose;
	
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
		jtfMatricula.setText("P1111");
		
		jpfSenha=new JPasswordField();
		jpfSenha.setBounds(1280/2,720/2-50,200,30);
		jpfSenha.setText("12345");
		
		//Buttons
		jbAcessar=new JButton("Acessar");
		jbAcessar.setBounds(1280/2+100,720/2,100,30);
		jbAcessar.addActionListener(new MainUIButtonsActionListener(0));
		
		//Buttons
		jbAcessarSaoJose=new JButton("Acessar São José");
		jbAcessarSaoJose.setBounds(1280/2-60,720/2,150,30);
		jbAcessarSaoJose.addActionListener(new MainUIButtonsActionListener(1));
		
		//Adicionando
		add(jlTitle);add(jlMatricula);add(jlSenha);
		
		add(jtfMatricula);add(jpfSenha);
		
		add(jbAcessar);add(jbAcessarSaoJose);
		
		//setLocationRelativeTo(null); centraliza na tela
		setSize(1280,720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
	}

	public JLabel getJlTitle() {
		return jlTitle;
	}

	public void setJlTitle(JLabel jlTitle) {
		this.jlTitle = jlTitle;
	}

	public JLabel getJlMatricula() {
		return jlMatricula;
	}

	public void setJlMatricula(JLabel jlMatricula) {
		this.jlMatricula = jlMatricula;
	}

	public JLabel getJlSenha() {
		return jlSenha;
	}

	public void setJlSenha(JLabel jlSenha) {
		this.jlSenha = jlSenha;
	}

	public JPasswordField getJpfSenha() {
		return jpfSenha;
	}

	public void setJpfSenha(JPasswordField jpfSenha) {
		this.jpfSenha = jpfSenha;
	}

	public JTextField getJtfMatricula() {
		return jtfMatricula;
	}

	public void setJtfMatricula(JTextField jtfMatricula) {
		this.jtfMatricula = jtfMatricula;
	}

	public JButton getJbAcessar() {
		return jbAcessar;
	}

	public void setJbAcessar(JButton jbAcessar) {
		this.jbAcessar = jbAcessar;
	}
	
	
}
