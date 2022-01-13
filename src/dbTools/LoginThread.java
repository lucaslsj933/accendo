package dbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import main.Main;

public class LoginThread extends Thread{

	public void run() {
		try {
			String idAluno,password,sql;
			PreparedStatement ps;
			ResultSet rs;
			
			idAluno=Main.mainUI.getJtfMatricula().getText();
			password=String.valueOf(Main.mainUI.getJpfSenha().getPassword());
			Connection conexao=ConnectionFactory.createConnection();
			sql="select idAluno,passwordAluno from aluno where idAluno=? and passwordAluno=?";
			ps=conexao.prepareStatement(sql);
			ps.setString(1,idAluno); ps.setString(2,password);
			rs=ps.executeQuery();
			if(rs.next()) {
				Main.dbMain.setIdAluno(idAluno);
				Main.startHomeMenu(Main.mainUI);
				Main.mainUI.getJtfMatricula().setText("");
				Main.mainUI.getJpfSenha().setText("");;
			}
			else {
				JOptionPane.showMessageDialog(null,"Matrícula ou senha incorreta!");
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO!"+e.getMessage());
		}
	}
}
