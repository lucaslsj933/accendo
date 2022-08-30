package dbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import main.Main;
import profile.Pessoa;
import profile.Aluno;

public class ProfileLoadThread extends Thread{

	public void run() {
		try {
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			String sql="select * from pessoa as p\r\n"
					+ "inner join aluno as a\r\n"
					+ "on(p.idPessoa=a.pessoa_idPessoa)\r\n"
					+ "where idPessoa=? and flag!=0;";
			PreparedStatement ps1=conexao.prepareStatement(sql);
			ps1.setString(1, Main.dbMain.getIdPessoa());
			ResultSet rs1=ps1.executeQuery();
			//Dados do Aluno
			//LEMBRE-SE QUE O NEXT É NECESSÁRIO!
			rs1.next();
			Aluno aluno=new Aluno();
			
			aluno.setIdPessoa(rs1.getString(1));
			aluno.setNome(rs1.getString(4));
			aluno.setSexo(rs1.getString(5).charAt(0));
			aluno.setIdade(rs1.getInt(6));
			aluno.setEtapa(rs1.getString(12));
			aluno.setSerie(rs1.getInt(13));
			aluno.setRg(rs1.getString(7));
			aluno.setCpf(rs1.getString(8));
			aluno.setTurma_idTurma(rs1.getInt(14));
			
			//Inserindo na UI
			Main.profileUI.getJlNameInput().setText(
					aluno.getNome());
			Main.profileUI.getJlSexoInput().setText(
					String.valueOf(aluno.getSexo()));
			Main.profileUI.getJlIdadeInput().setText(
					String.valueOf(aluno.getIdade()));
			Main.profileUI.getJlRGInput().setText(
					aluno.getRg());
			Main.profileUI.getJlCpfInput().setText(
					aluno.getCpf());
			Main.profileUI.getJlSerieInput().setText(
					String.valueOf(aluno.getSerie())+"ª");
			Main.profileUI.getJlEtapaInput().setText(
					aluno.getEtapa());
			Main.profileUI.getJlTurmaInput().setText(
					String.valueOf(aluno.getTurma_idTurma()));
			
			conexao.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
}
