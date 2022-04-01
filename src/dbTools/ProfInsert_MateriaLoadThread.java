package dbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import main.Main;

public class ProfInsert_MateriaLoadThread extends Thread{
	@Override
	public void run() {
		try {
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			String sql="select m.* from professor_has_materia as phm\r\n"
					+ "inner join materia as m\r\n"
					+ "on(m.idMateria=phm.materia_idMateria)\r\n"
					+ "where phm.professor_pessoa_idPessoa=?;";
			PreparedStatement ps1=conexao.prepareStatement(sql);
			ps1.setString(1, Main.dbMain.getIdPessoa());
			ResultSet rs1=ps1.executeQuery();
			
			while(rs1.next()) {
				JOptionPane.showMessageDialog(null,"idMateria: "+rs1.getInt(1)+" nomeMateria: "+rs1.getString(2));
			}
			
			conexao.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}

}
