package dbTools;

import java.sql.*;
import javax.swing.JOptionPane;
import professor.insert.AlunoAndNotasQuery;

import main.Main;

public class ProfInsert_AlunosLoadThread extends Thread{
	@Override
	public void run() {
		try {
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			String sql="select a.idAluno,a.pessoa_idPessoa,p.nome from aluno as a \r\n"
					+ "inner join pessoa as p\r\n"
					+ "on(p.idPessoa=a.pessoa_idPessoa)\r\n"
					+ "where turma_idTurma=?;";
			PreparedStatement ps1=conexao.prepareStatement(sql);
			//Pegando o idTurma
			int jcbIndex=Main.profInsertUI.getJcbTurma().getSelectedIndex();
			int idTurma=Main.profInsertUI.getListaTurmas().get(jcbIndex).getIdTurma();
			ps1.setInt(1, idTurma);
			ResultSet rs1=ps1.executeQuery();
			
			int i=0;
			while(rs1.next()) {
				AlunoAndNotasQuery aAndNQuery=new AlunoAndNotasQuery(
						rs1.getInt(1),
						rs1.getString(2),
						rs1.getString(3)
						);
				
				Main.profInsertUI.getTable().getModel().setValueAt(aAndNQuery.getNome(),i,0);
				Main.profInsertUI.getTable().getModel().setValueAt(aAndNQuery.getPessoa_idPessoa(),i,1);
				
				i++;
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
}
