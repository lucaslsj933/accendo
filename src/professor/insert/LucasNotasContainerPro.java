package professor.insert;

import main.Main;
import consultar.Nota;
import java.util.ArrayList;

//Esta classe (a PRO) guarda as notas de todos os alunos de todas as mat�rias (que forem pedidos pelo user)

public class LucasNotasContainerPro {
	
	//Se a mat�ria tem quatro notas em um ano, coloque 4 aqui...
	private ArrayList<Nota> notaList;
	
	public LucasNotasContainerPro() {
		notaList=new ArrayList<Nota>();
	}
	
	public void adic(Nota n) {
		notaList.add(n);
	}
	
	/*
	public void inserirNaUI(int row) {
		//Nome da Mat�ria
		Main.consultarUI.getTable().setValueAt(materia.getNomeMateria(), row, 0);
		
		for(int i=0;i<notas.length;i++) {
			//O param i+1 define em qual TA deve ser inserida. Deve ser 1,2...
			if(notas[i]!=null)
				Main.consultarUI.getTable().setValueAt(notas[i].getValor(), row, i+1);
		}
		
		//Main.consultarUI.getTable().setValueAt(String.valueOf(valoresTas[i]), row, i+1);
		
		//Main.consultarUI.getTableNotas().setValueAt(String.valueOf(valoresTas[0]), row, 1);
	}
	*/

	public ArrayList<Nota> getNotaList() {
		return notaList;
	}

	public void setNotaList(ArrayList<Nota> notaList) {
		this.notaList = notaList;
	}
}
