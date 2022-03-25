package dbToolsTest;

import javax.swing.JOptionPane;

import dbTools.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class InsertALotOfAlunos {
	public InsertALotOfAlunos() {
		try {
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			Statement st=conexao.createStatement();
			
			for(int iPessoa=1;iPessoa<=30;iPessoa++) {
				String sql1="insert into pessoa values('A"+ String.valueOf(iPessoa)
						+ "', 'a','12345','Teste " + String.valueOf(iPessoa)
						+ "','M',21,'RG" + String.valueOf(iPessoa)
						+ "','CPF" + String.valueOf(iPessoa)
						+ "',1)";
				st.executeUpdate(sql1);
				
				String sql2="insert into aluno(pessoa_idPessoa,etapa,serie,turma_idTurma) "
						+ "	values('A" + String.valueOf(iPessoa)
						+ "','Fundamental',9,1);";
				st.executeUpdate(sql2);
				
				//Procurando o idAluno
				int idAluno;
				String sqlQueryIdAluno="select idAluno from aluno where pessoa_idPessoa='A" + String.valueOf(iPessoa)
						+ "';";
				ResultSet rs1=st.executeQuery(sqlQueryIdAluno);
				rs1.next();
				idAluno=rs1.getInt(1);
				
				//SQL 3
				String sql3="-- Penúltimo é idAluno\r\n"
						+ "insert into nota(valor,ta,materia_idMateria,aluno_idAluno,pessoa_idPessoa)"
						+ " values(RAND()*(10-5)+5 ,1,1," + String.valueOf(idAluno)
						+ ",'A" + String.valueOf(iPessoa)
						+ "');";
				st.executeUpdate(sql3);
			}
			
			JOptionPane.showMessageDialog(null,"TESTE InsertALotOfAlunos");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
}
