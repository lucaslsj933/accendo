package dbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import main.Main;

public class ProfileLoadThread extends Thread{

	public void run() {
		try {
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			String sql="select * from aluno where idAluno=? and flag!=0;";
			PreparedStatement ps1=conexao.prepareStatement(sql);
			ps1.setString(1, Main.dbMain.getIdAluno());
			ResultSet rs1=ps1.executeQuery();
			//Dados do Aluno
			//LEMBRE-SE QUE O NEXT É NECESSÁRIO!
			rs1.next();
			String idAluno,nome,rg,cpf,etapa;
			int idade,serie;
			char sexo;
			idAluno=rs1.getString(1);
			nome=rs1.getString(3);
			sexo=rs1.getString(4).charAt(0);
			idade=rs1.getInt(5);
			etapa=rs1.getString(6);
			serie=rs1.getInt(7);
			rg=rs1.getString(8);
			cpf=rs1.getString(9);
			
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
