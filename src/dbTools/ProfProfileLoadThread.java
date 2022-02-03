package dbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import main.Main;

public class ProfProfileLoadThread extends Thread{

	public void run() {
		try {
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			String sql="select * from pessoa as p\r\n"
					+ "inner join professor as prof\r\n"
					+ "on(p.idPessoa=prof.pessoa_idPessoa)\r\n"
					+ "where idPessoa=? and flag!=0;";
			PreparedStatement ps1=conexao.prepareStatement(sql);
			ps1.setString(1, Main.dbMain.getIdPessoa());
			ResultSet rs1=ps1.executeQuery();
			//Dados de Pessoa
			//LEMBRE-SE QUE O NEXT É NECESSÁRIO!
			rs1.next();
			String idPessoa,nome,rg,cpf;
			int idade;
			char sexo;
			idPessoa=rs1.getString(1);
			nome=rs1.getString(4);
			sexo=rs1.getString(5).charAt(0);
			idade=rs1.getInt(6);
			rg=rs1.getString(7);
			cpf=rs1.getString(8);
			
			//Dados de Professor
			String graduacao;
			graduacao=rs1.getString(12);
			
			//Inserindo na UI - Pessoa
			Main.profProfileUI.getJlNameInput().setText(nome);
			Main.profProfileUI.getJlSexoInput().setText(String.valueOf(sexo));
			Main.profProfileUI.getJlIdadeInput().setText(String.valueOf(idade));
			Main.profProfileUI.getJlRGInput().setText(rg);
			Main.profProfileUI.getJlCpfInput().setText(cpf);
			
			//Inserindo na UI - Professor
			Main.profProfileUI.getJlGraduacaoInput().setText(graduacao);
			
			conexao.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
}
