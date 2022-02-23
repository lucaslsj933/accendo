package dbTools;

import java.sql.*;
import javax.swing.JOptionPane;
import professor.insert.AlunoAndNotasQuery;

import main.Main;

public class ProfInsert_AlunosLoadThread extends Thread{
	private int listaSizeCache;
	private AlunoAndNotasQuery aAndNQueryCache;
	
	@Override
	public void run() {
		try {
			//ListaSizeCache
			listaSizeCache=Main.profInsertUI.getaAndNList().size();
			
			
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
				
				Main.profInsertUI.getaAndNList().add(aAndNQuery);
				
				Main.profInsertUI.getTable().getModel().setValueAt(aAndNQuery.getNome(),i,0);
				Main.profInsertUI.getTable().getModel().setValueAt(aAndNQuery.getPessoa_idPessoa(),i,1);
				
				i++;
			}
			
			//Notas
			String sql2="select n.*,a.turma_idTurma from nota as n \r\n"
					+ "inner join aluno as a on(n.pessoa_idPessoa=a.pessoa_idPessoa)\r\n"
					+ "where n.materia_idMateria=? and a.turma_idTurma=?;";
			PreparedStatement ps2=conexao.prepareStatement(sql2);
			ps2.setInt(1,1);
			ps2.setInt(2,idTurma);
			ResultSet rs2=ps2.executeQuery();
			
			aAndNQueryCache=Main.profInsertUI.getaAndNList().get(0);
			while(rs2.next()) {
				//Se os idPessoa forem iguais
				if(aAndNQueryCache.getPessoa_idPessoa().equals(rs2.getString(6))) {
					//Coloque nada aqui
				}
				else {
					aAndNQueryCache=null;
					aAndNQueryCache=searchInaAndNQueryList(rs2.getString(6));
				}
				
				aAndNQueryCache.getNotas()[rs2.getInt(3)-1]=rs2.getFloat(2);
				
				JOptionPane.showMessageDialog(null,"Nota: "+
						aAndNQueryCache.getNotas()[rs2.getInt(3)-1]);
			}
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
	
	//Lembre-se que requer o listaSizeCache definido
	public AlunoAndNotasQuery searchInaAndNQueryList(String pessoa_idPessoa) {
		for(int i=0;i<listaSizeCache;i++) {
			if(Main.profInsertUI.getaAndNList().get(i).getPessoa_idPessoa().equals(pessoa_idPessoa)) {
				return Main.profInsertUI.getaAndNList().get(i);
			}
		}
		return null;
	}
}
