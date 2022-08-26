package dbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//import consultar.MateriaDoAluno;
import consultar.LucasNotasContainer;
import consultar.Materia;
import consultar.Nota;
import main.Main;

public class ConsultarLoadThread extends Thread{
	private String idInput;
	ArrayList<Nota> listaNC=new ArrayList<Nota>();
	//LucasNotasContainer
	ArrayList<LucasNotasContainer> listaLNC=new ArrayList<LucasNotasContainer>(); 
	
	public void run() {
		try {
			Connection conexao;
			conexao=ConnectionFactory.createConnection();
			String sql="select * from nota as n inner join materia as m on(n.materia_idMateria=m.idMateria) where pessoa_idPessoa=?";
			PreparedStatement ps=conexao.prepareStatement(sql);
			ps.setString(1,Main.dbMain.getIdPessoa());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				//Inicializando com valor e TA
				Nota nc=new Nota(rs.getFloat(2),rs.getInt(3));
				nc.setMateria_idMateria(rs.getInt(4));
				nc.setAluno_idAluno(rs.getString(5));
				nc.setPessoa_idPessoa(rs.getString(6));
				
				Materia m;
				m=new Materia(rs.getInt(7)); //o Int 7 pega o id da Matéria
				m.setNomeMateria(rs.getString(8));
				
				CheckIfExistsAndAdd(nc,m);
				//Inserindo na UI
				//Main.consultarUI.getTableNotas().setValueAt(String.valueOf(nc.getValor()), 0, nc.getTa());
			}
			conexao.close();
			
			int listaLNCSize=listaLNC.size();
			for(int i=0;i<listaLNCSize;i++) {
				listaLNC.get(i).inserirNaUI(i);
			}
			
			//Inserindo na UI (MDA)
			//A linha da tabela onde a matéria será inserido está no i de inserirNaUI(i)
			/*
			int listaMDASize=listaMDA.size();
			for(int i=0;i<listaMDASize;i++) {
				listaMDA.get(i).inserirNaUI(i);
			}
			*/
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO DB!"+e.getMessage());
		}
	}
	
	public void CheckIfExistsAndAdd(Nota nc,Materia m) {
		int size=listaLNC.size();
		if(size==0) {
			createLNCAndAddToLista(nc,m);
			return;
		}
		
		for(int i=0;i<size;i++) {
			if(listaLNC.get(i).getMateria().getIdMateria()==m.getIdMateria()) {
				//As matérias são iguais, então adicione
				listaLNC.get(i).getNotas()[nc.getTa()-1]=nc;
				//JOptionPane.showMessageDialog(null,"Teste"+
				//		listaMDA.get(i).getValoresTas()[nc.getTa()-1]);
				return;
			}
		}
		//Se nenhuma matéria for igual, adicione a matéria
		createLNCAndAddToLista(nc,m);
		
	}
	
	public void createLNCAndAddToLista(Nota nc,Materia m) {
		LucasNotasContainer lnc=new LucasNotasContainer(m);
		lnc.getNotas()[0]=nc;
		listaLNC.add(lnc);
		
		//JOptionPane.showMessageDialog(null,"Teste ADD MDA "+mda.getNomeMateria());
	}
}
