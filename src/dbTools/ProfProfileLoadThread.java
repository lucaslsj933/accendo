package dbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import main.Main;
import professor.profile.Professor;

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
			
			Professor prof=new Professor();
			prof.setIdPessoa(rs1.getString(1));
			prof.setNome(rs1.getString(4));
			prof.setSexo(rs1.getString(5).charAt(0));
			prof.setIdade(rs1.getInt(6));
			prof.setRg(rs1.getString(7));
			prof.setCpf(rs1.getString(8));
			
			//Dados de Professor
			prof.setGraduacao(rs1.getString(12));
			
			//Inserindo na UI - Pessoa
			Main.profProfileUI.getJlNameInput().setText(
					prof.getNome());
			Main.profProfileUI.getJlSexoInput().setText(
					String.valueOf(prof.getSexo()));
			Main.profProfileUI.getJlIdadeInput().setText(
					String.valueOf(prof.getIdade()));
			Main.profProfileUI.getJlRGInput().setText(
					prof.getRg());
			Main.profProfileUI.getJlCpfInput().setText(
					prof.getCpf());
			
			//Inserindo na UI - Professor
			Main.profProfileUI.getJlGraduacaoInput().setText(
					prof.getGraduacao());
			
			conexao.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
}
