package dbTools;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Main;
import professor.insert.AlunoAndNotasQuery;

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
			
			//MYSQL CODE QUE PRECISA SER TERMINADO!
			/*
			 * use accendoDBNEW;

select idNota from nota
where pessoa_idPessoa="A1113" and ta=2 and materia_idMateria=1;

insert into nota(valor,ta,materia_idMateria,aluno_idAluno,pessoa_idPessoa)
values (10,2,1,3,"A1113")
on duplicate key update valor=10,ta=2,materia_idMateria=1,aluno_idAluno=3,pessoa_idPessoa="A1113";

delimiter $$
create procedure insertNota(i int)
begin
	declare id int;
	set id=(select idNota from nota where pessoa_idPessoa="A1113" and ta=2 and materia_idMateria=1);
    
    -- LEMBRE-SE QUE QUANDO MODIFICAR ESTE CÓDIGO, MODIFIQUE TANTO O INSERT QUANTO O UPDATE!!
     if(id is null) then 
		insert into nota(valor,ta,materia_idMateria,aluno_idAluno,pessoa_idPessoa)
		values (10,2,1,3,"A1113");
     else 
	 	select id;
	 end if;
end;
$$
delimiter ;

drop procedure insertNota;

call insertNota(1);
			 * 
			 * 
			 * 
			 * 
			 */
			conexao.close();
			
		}
		catch(Exception e)  {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
	
}
