//ProfInsert_MateriaLoadThread 2

package dbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import consultar.Materia;
import main.Main;
import professor.insert.MateriaAndProfQuery;

//Lembre-se que para a mat�ria aparecer, o professor e a turma devem ser associadas � mat�ria!
public class ProfInsert_MandPQueryLoadThread extends Thread{
	private int turma_idTurma;
	
	public ProfInsert_MandPQueryLoadThread(int turma_idTurma) {
		super();
		this.turma_idTurma=turma_idTurma;
	}
	
	@Override
	public void run() {
		try {

			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			String sql="select m.*,phm.professor_pessoa_idPessoa from professor_has_materia as phm\r\n"
					+ "inner join materia as m on(m.idMateria=phm.materia_idMateria)\r\n"
					+ "inner join turma_has_materia as thm on(phm.materia_idMateria=thm.materia_idMateria)\r\n"
					+ "where phm.professor_pessoa_idPessoa=?\r\n"
					+ "and thm.turma_idTurma=?;";
			PreparedStatement ps1=conexao.prepareStatement(sql);
			ps1.setString(1, Main.dbMain.getIdPessoa());
			ps1.setInt(2,turma_idTurma);
			ResultSet rs1=ps1.executeQuery();
			
			while(rs1.next()) {
				//JOptionPane.showMessageDialog(null,"idMateria: "+rs1.getInt(1)+" nomeMateria: "+rs1.getString(2)+" PHM.p_p_idPessoa: "+rs1.getString(3));
				Materia m=new Materia(rs1.getInt(1));
				m.setNomeMateria(rs1.getString(2));
				Main.profInsertUI.getListaMateria().add(m);
			}
			
			int size=Main.profInsertUI.getListaMateria().size();
			for(int i=0;i<size;i++) {
				Main.profInsertUI.getJcbMateria().addItem(
						Main.profInsertUI.getListaMateria().get(i).getNomeMateria()
						);
			}
			
			/*
			 *  			//Parte 2
			String sql2="select * from turma_has_materia\r\n"
					+ "where turma_idTurma=?;";
			PreparedStatement ps2=conexao.prepareStatement(sql2);
			ps2.setInt(1,1);
			ResultSet rs2=ps2.executeQuery();
			
			while(rs2.next()) {
				
			}
			*/
			
			conexao.close();
			
			
			/*
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			String sql="select m.*,phm.professor_pessoa_idPessoa from professor_has_materia as phm\r\n"
					+ "inner join materia as m on(m.idMateria=phm.materia_idMateria)\r\n"
					+ "inner join turma_has_materia as thm on(phm.materia_idMateria=thm.materia_idMateria)\r\n"
					+ "where phm.professor_pessoa_idPessoa=?\r\n"
					+ "and thm.turma_idTurma=?;";
			PreparedStatement ps1=conexao.prepareStatement(sql);
			ps1.setString(1, Main.dbMain.getIdPessoa());
			ps1.setInt(2,turma_idTurma);
			ResultSet rs1=ps1.executeQuery();
			
			while(rs1.next()) {
				//JOptionPane.showMessageDialog(null,"idMateria: "+rs1.getInt(1)+" nomeMateria: "+rs1.getString(2)+" PHM.p_p_idPessoa: "+rs1.getString(3));
				MateriaAndProfQuery mAndP=new MateriaAndProfQuery(
						rs1.getInt(1),
						rs1.getString(2),
						rs1.getString(3));
				Main.profInsertUI.getmAndPList().add(mAndP);
			}
			
			int size=Main.profInsertUI.getmAndPList().size();
			for(int i=0;i<size;i++) {
				Main.profInsertUI.getJcbMateria().addItem(
						Main.profInsertUI.getmAndPList().get(i).getNomeMateria()
						);
			}
			
			
			/*
			 *  			//Parte 2
			String sql2="select * from turma_has_materia\r\n"
					+ "where turma_idTurma=?;";
			PreparedStatement ps2=conexao.prepareStatement(sql2);
			ps2.setInt(1,1);
			ResultSet rs2=ps2.executeQuery();
			
			while(rs2.next()) {
				
			}
			
			
			conexao.close();
			 */
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}

}