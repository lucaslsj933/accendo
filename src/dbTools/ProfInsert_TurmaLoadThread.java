package dbTools;

import java.sql.*;
import java.time.Year;

import javax.swing.JOptionPane;

import main.Main;
import professor.insert.*;

//LEMBRE-SE QUE ISTO NÃO CARREGA OS ALUNOS, APENAS AS TURMAS!

public class ProfInsert_TurmaLoadThread extends Thread{
	@Override
	public void run() {
		try {
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			String sql="select t.* from professor_has_turma as pht\r\n"
					+ "inner join turma as t on(pht.turma_idTurma=t.idTurma)\r\n"
					+ "where professor_pessoa_idPessoa=?;";
			PreparedStatement ps1=conexao.prepareStatement(sql);
			ps1.setString(1,Main.dbMain.getIdPessoa());
			ResultSet rs1=ps1.executeQuery();
			
			while(rs1.next()) {
				Turma t=new Turma(
						rs1.getInt(1),
						rs1.getString(2),
						Year.of(rs1.getInt(3))
						);
				Main.profInsertUI.getListaTurmas().add(t);
			}
			
			//Inserindo na UI
			int size=Main.profInsertUI.getListaTurmas().size();
			for(int i=0;i<size;i++) {
				Main.profInsertUI.getJcbTurma().addItem(
						Main.profInsertUI.getListaTurmas().get(i).getNome()
						);
			}
			
			conexao.close();
			
			//Definindo que não há nenhuma turma selecionada
			Main.profInsertUI.getJcbTurma().setSelectedIndex(-1);
			
			Main.profInsertUI.addALToJcbTurma();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
}
