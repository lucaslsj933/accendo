package dbTools;

import java.sql.Connection;
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
			
			for(int i=0;i<sizeCache;i++) {
				dataCache=aAndNListCache.get(i);
				dataCache.getIdAluno();
				dataCache.getPessoa_idPessoa();
				dataCache.getNome();
				dataCache.getNotaByTaIndex(0);
			}
			
			conexao.close();
			
		}
		catch(Exception e)  {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
	
}
