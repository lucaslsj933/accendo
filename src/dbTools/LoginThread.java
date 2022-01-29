package dbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import main.Main;

public class LoginThread extends Thread{

	public void run() {
		try {
			String idPessoa,password,sql;
			PreparedStatement ps;
			ResultSet rs;
			
			idPessoa=Main.mainUI.getJtfMatricula().getText();
			password=String.valueOf(Main.mainUI.getJpfSenha().getPassword());
			Connection conexao=ConnectionFactory.createConnection();
			sql="select idPessoa,passwordPessoa,tipoPessoa from pessoa where idPessoa=? and passwordPessoa=?";
			ps=conexao.prepareStatement(sql);
			ps.setString(1,idPessoa); ps.setString(2,password);
			rs=ps.executeQuery();
			if(rs.next()) {
				Main.dbMain.setIdPessoa(idPessoa);
				Main.dbMain.setTipoPessoa(rs.getString(3));
				Main.mainUI.getJtfMatricula().setText("");
				Main.mainUI.getJpfSenha().setText("");
				
				if(Main.dbMain.getTipoPessoa().equals("p"))
					Main.startProfHomeMenu(Main.mainUI);
				else
					Main.startHomeMenu(Main.mainUI);
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
