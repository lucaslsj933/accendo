package dbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import main.Main;

public class ProfileLoadThread extends Thread{
	String nomeInput;
	
	public ProfileLoadThread(String nomeInput) {
		super();
		this.nomeInput=nomeInput;
	}
	
	public void run() {
		try {
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			String sql="select * from aluno where nome like concat('%',?,'%') and flag!=0;";
			PreparedStatement ps1=conexao.prepareStatement(sql);
			ps1.setString(1, nomeInput);
			ResultSet rs1=ps1.executeQuery();
			//Dados do Aluno
			//LEMBRE-SE QUE O NEXT É NECESSÁRIO!
			rs1.next();
			String idAluno,nome,rg,cpf,etapa;
			int idade,serie;
			char sexo;
			idAluno=rs1.getString(1);
			nome=rs1.getString(2);
			sexo=rs1.getString(3).charAt(0);
			idade=rs1.getInt(4);
			etapa=rs1.getString(5);
			serie=rs1.getInt(6);
			rg=rs1.getString(7);
			cpf=rs1.getString(8);
			
			//Inserindo na UI
			Main.profileUI.getJlNameInput().setText(nome);
			Main.profileUI.getJlSexoInput().setText(String.valueOf(sexo));
			Main.profileUI.getJlIdadeInput().setText(String.valueOf(idade));
			Main.profileUI.getJlRGInput().setText(rg);
			Main.profileUI.getJlCpfInput().setText(cpf);
			Main.profileUI.getJlSerieInput().setText(String.valueOf(serie)+"ª");
			Main.profileUI.getJlEtapaInput().setText(etapa);
			
			conexao.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
}
