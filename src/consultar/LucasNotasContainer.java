package consultar;

import main.Main;

//Por enquanto isto guarda apenas as notas de uma matéria de um aluno!

public class LucasNotasContainer {
	
	private Materia materia;
	//Se a matéria tem quatro notas em um ano, coloque 4 aqui...
	private Nota[] notas=new Nota[4];
	
	public LucasNotasContainer(Materia materia) {
		this.materia=materia;
		
		for(int i=0;i<notas.length;i++) {
			notas[i]=null;
		}
	}
	
	public void inserirNaUI(int row) {
		//Nome da Matéria
		Main.consultarUI.getTable().setValueAt(materia.getNomeMateria(), row, 0);
		
		for(int i=0;i<notas.length;i++) {
			//O param i+1 define em qual TA deve ser inserida. Deve ser 1,2...
			if(notas[i]!=null)
				Main.consultarUI.getTable().setValueAt(notas[i].getValor(), row, i+1);
		}
		
		//Main.consultarUI.getTable().setValueAt(String.valueOf(valoresTas[i]), row, i+1);
		
		//Main.consultarUI.getTableNotas().setValueAt(String.valueOf(valoresTas[0]), row, 1);
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Nota[] getNotas() {
		return notas;
	}

	public void setNotas(Nota[] notas) {
		this.notas = notas;
	}
}
