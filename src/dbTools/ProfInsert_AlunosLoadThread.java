package dbTools;

import java.sql.*;
import javax.swing.JOptionPane;
import professor.insert.AlunoAndNotasQuery;
import professor.insert.AlunoAndNotasSyncer;
import professor.insert.LucasNotasContainerPro;
import profile.Aluno;
import main.Main;

public class ProfInsert_AlunosLoadThread extends Thread{
	private int listaSizeCache;
	private AlunoAndNotasQuery aAndNQueryCache;
	
	private LucasNotasContainerPro lncProCache;
	
	@Override
	public void run() {
		try {
			//ListaSizeCache
			listaSizeCache=Main.profInsertUI.getaAndNList().size();
			
			//LncProCache
			lncProCache=Main.profInsertUI.getLncPro();
			
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			String sql="select a.*,p.nome from aluno as a\r\n"
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
				Aluno aluno=new Aluno();
				aluno.setIdAluno(rs1.getInt(1));
				aluno.setIdPessoa(rs1.getString(2));
				aluno.setEtapa(rs1.getString(3));
				aluno.setSerie(rs1.getInt(4));
				aluno.setTurma_idTurma(rs1.getInt(5));
				aluno.setNome(rs1.getString(6));
				
				Main.profInsertUI.getListaAluno().add(aluno);
				
				Main.profInsertUI.getTable().getModel().setValueAt(aluno.getNome(),i,0);
				Main.profInsertUI.getTable().getModel().setValueAt(aluno.getIdPessoa(),i,1);
				
				i++;
			}
			
			//Notas
			int listaSize=Main.profInsertUI.getListaAluno().size();
			int idDaLista,taIndex;
			//AlunoAndNotasQuery aAndNTemp;
			Aluno alunoTemp;
			
			int materia_idMateria=Main.profInsertUI.getmAndPList().get(
					Main.profInsertUI.getJcbMateria().getSelectedIndex()
					).getIdMateria();
			for(idDaLista=0;idDaLista<listaSize;idDaLista++) {
				aAndNTemp=Main.profInsertUI.getaAndNList().get(idDaLista);	
				String sql2="select * from nota\r\n"
						+ "where materia_idMateria=? and pessoa_idPessoa=?;";
				PreparedStatement ps2=conexao.prepareStatement(sql2);
				
				ps2.setInt(1,materia_idMateria);
				ps2.setString(2,aAndNTemp.getPessoa_idPessoa());
				ResultSet rs2=ps2.executeQuery();
				
				//Este while pega as notas de certo aluno. O for lá em cima dita qual será o idDaLista, que é usado para determinar qual aluno
				while(rs2.next()) {
					taIndex=rs2.getInt(3)-1;
					aAndNTemp.setNotaByTaIndex(taIndex,rs2.getFloat(2));
					
					//Inserir na UI
					//A row é idDaLista, a column é taIndex+2
					Main.profInsertUI.getTable().getModel().setValueAt(
							aAndNTemp.getNotaByTaIndex(taIndex)
							,idDaLista,taIndex+2);
				}
			}
			
			conexao.close();
			
			//AlunoAndNotasSyncer
			//Main.profInsertUI.getTable().getModel().addTableModelListener(new AlunoAndNotasSyncer());
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
}
