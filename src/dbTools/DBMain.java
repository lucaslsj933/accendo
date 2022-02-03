package dbTools;

import java.awt.Component;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import main.Main;

public class DBMain {
	private String idPessoa="";
	private String tipoPessoa="";
	
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
	
	public void profileLoad() {
		ProfileLoadThread plt1= new ProfileLoadThread();
		plt1.start();
	}
	
	public void consultarLoad(String idInput) {
		ConsultarLoadThread clt1=new ConsultarLoadThread();
		clt1.start();
	}
	
	//PROFESSOR
	
	public void profProfileLoad() {
		ProfProfileLoadThread pplt1= new ProfProfileLoadThread();
		pplt1.start();
	}

	public String getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(String idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
}
