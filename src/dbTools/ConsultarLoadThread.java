package dbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import consultar.MateriaDoAluno;
import consultar.NotaClass;
import main.Main;

public class ConsultarLoadThread extends Thread{
	private String idInput;
	ArrayList<NotaClass> listaNC=new ArrayList<NotaClass>();
	ArrayList<MateriaDoAluno> listaMDA=new ArrayList<MateriaDoAluno>(); 
	
	public ConsultarLoadThread(String idInput) {
		super();
		this.idInput=idInput;
	}
	
	public void run() {
		try {
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			String sql="select * from nota as n inner join materia as m on(n.materia_idMateria=m.idMateria) where aluno_idAluno=?";
			PreparedStatement ps=conexao.prepareStatement(sql);
			ps.setString(1,idInput);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				//Inicializando com valor e TA
				NotaClass nc=new NotaClass(rs.getFloat(2),rs.getInt(3));
				nc.setMateria_idMateria(rs.getInt(4));
				nc.setAluno_idAluno(rs.getString(5));
				nc.setIdMateria(rs.getInt(6));
				nc.setNomeMateria(rs.getString(7));
				
				CheckIfExistsAndAdd(nc);
				//Inserindo na UI
				//Main.consultarUI.getTableNotas().setValueAt(String.valueOf(nc.getValor()), 0, nc.getTa());
			}
			conexao.close();
			
			
			//Inserindo na UI
			//A linha da tabela onde a matéria será inserido está no i de inserirNaUI(i)
			int listaMDASize=listaMDA.size();
			for(int i=0;i<listaMDASize;i++) {
				listaMDA.get(i).inserirNaUI(i);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
	
	public void CheckIfExistsAndAdd(NotaClass nc) {
		int size=listaMDA.size();
		if(size==0) {
			createMDAAndAddToLista(nc);
			return;
		}

		for(int i=0;i<size;i++) {
			if(listaMDA.get(i).getIdMateria()==nc.getIdMateria()) {
				//As matérias são iguais, então adicione
				listaMDA.get(i).getValoresTas()[nc.getTa()-1]=nc.getValor();
				//JOptionPane.showMessageDialog(null,"Teste"+
				//		listaMDA.get(i).getValoresTas()[nc.getTa()-1]);
				
				return;
			}
		}
		//Se nenhuma matéria for igual, adicione a matéria
		createMDAAndAddToLista(nc);
		
	}
	
	public void createMDAAndAddToLista(NotaClass nc) {
		MateriaDoAluno mda=new MateriaDoAluno(nc.getIdMateria(),nc.getAluno_idAluno());
		mda.setNomeMateria(nc.getNomeMateria());
		mda.getValoresTas()[nc.getTa()-1]=nc.getValor();
		//Adicionando à lista
		listaMDA.add(mda);
		
		//JOptionPane.showMessageDialog(null,"Teste ADD MDA "+mda.getNomeMateria());
	}
}
