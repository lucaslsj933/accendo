package dbTools;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Main;
import professor.insert.AlunoAndNotasQuery;

//O código SQL está no DB como uma procedure chamada insertNota!

public class ProfInsert_InsertNotasThread extends Thread{ 
	public void run() {
		try {
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			
			ArrayList<AlunoAndNotasQuery> aAndNListCache=Main.profInsertUI.getaAndNList();
			int sizeCache=aAndNListCache.size();
			AlunoAndNotasQuery dataCache;
			int idMateriaAtual=Main.profInsertUI.getIdMateriaAtual();
			String sql;
			CallableStatement cs;
			ResultSet rs=null;
			
			
			//JOptionPane.showMessageDialog(null,"TA1: "+dataCache.getNotaByTaIndex(0)+
			//		" TA2: "+dataCache.getNotaByTaIndex(1)+
			//		" TA3: "+dataCache.getNotaByTaIndex(2)+
			//		" TA4: "+dataCache.getNotaByTaIndex(3));
			
			
			sql="{call insertNota(?,?,?,?,?)}";
			cs=conexao.prepareCall(sql);
			
			//Este for faz o for de baixo ser executado em todos os alunos
			for(int iUpper=0;iUpper<sizeCache;iUpper++) {
				dataCache=aAndNListCache.get(iUpper);
				
				//Este for insere e/ou atualiza todas as notas de certo aluno 
				for(int i=0;i<dataCache.getNotas().length;i++) {
					//Se a nota for nula, ir para a próxima...
					if(dataCache.getNotaByTaIndex(i)==-1) continue;
					
					cs.setFloat(1,dataCache.getNotaByTaIndex(i));
					cs.setInt(2, i+1); //TA
					cs.setInt(3, idMateriaAtual);
					cs.setInt(4,dataCache.getIdAluno());
					cs.setString(5,dataCache.getPessoa_idPessoa());
					cs.execute();
					
					rs=null;
					rs=cs.getResultSet();
				}
			}
			
			//Lembre-se que você precisa do next para pegar o que a procedure retorna
			rs.next();
			JOptionPane.showMessageDialog(null,rs.getString(1)+" "+rs.getString(2));

			
			/*
			for(int i=0;i<sizeCache;i++) {
				dataCache=aAndNListCache.get(i);
				dataCache.getIdAluno();
				dataCache.getPessoa_idPessoa();
				dataCache.getNome();
				dataCache.getNotaByTaIndex(0);
			}
			*/
			conexao.close();
			
		}
		catch(Exception e)  {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
	
}
