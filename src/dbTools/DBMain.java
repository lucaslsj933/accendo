package dbTools;

import java.awt.Component;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import main.Main;

public class DBMain {
	public DBMain() {
		//DBTESTE
		/*
		Connection conexao;
		try {
			conexao=ConnectionFactory.createConnection();
			String sql="select nome from teste where testeId=1;";
			PreparedStatement ps1=conexao.prepareStatement(sql);
			ResultSet rs1=ps1.executeQuery();
			rs1.next();
			String nome=rs1.getString(1);
			JOptionPane.showMessageDialog(null,"Nome: "+nome);
			conexao.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
		*/
	}
	
	public void loginStart() {
		LoginThread lt=new LoginThread();
		lt.start();
	}
	
	public void profileLoad(String nomeInput) {
		ProfileLoadThread plt1= new ProfileLoadThread("Lucas");
		plt1.start();
	}
	
	public void consultarLoad(String idInput) {
		ConsultarLoadThread clt1=new ConsultarLoadThread("1111");
		clt1.start();
	}
}
