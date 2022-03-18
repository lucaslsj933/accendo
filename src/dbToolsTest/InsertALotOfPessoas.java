package dbToolsTest;

import java.sql.Connection;

import javax.swing.JOptionPane;

import dbTools.ConnectionFactory;

public class InsertALotOfPessoas {
	public InsertALotOfPessoas() {
		try {
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
}
