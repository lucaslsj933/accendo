package consultar;

import main.Main;

public class Materia {
	private int idMateria;
	//private String aluno_idAluno;
	private String nomeMateria;
	//private float[] valoresTas=new float[4];
	
	public Materia(int idMateria) {
		this.idMateria=idMateria;
		//this.aluno_idAluno=aluno_idAluno;
	}
	
	/*
	public void inserirNaUI(int row) {
		//Nome da Matéria
		Main.consultarUI.getTable().setValueAt(nomeMateria, row, 0);
		
		for(int i=0;i<valoresTas.length;i++) {
			//O param i+1 define em qual TA deve ser inserida. Deve ser 1,2...
			if(valoresTas[i]!=-1)
				Main.consultarUI.getTable().setValueAt(String.valueOf(valoresTas[i]), row, i+1);
		}
		//Main.consultarUI.getTableNotas().setValueAt(String.valueOf(valoresTas[0]), row, 1);
	}
	*/
	
	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public String getNomeMateria() {
		return nomeMateria;
	}

	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}

	/*
	public String getAluno_idAluno() {
		return aluno_idAluno;
	}

	public void setAluno_idAluno(String aluno_idAluno) {
		this.aluno_idAluno = aluno_idAluno;
	}

	public float[] getValoresTas() {
		return valoresTas;
	}

	public void setValoresTas(float[] valoresTas) {
		this.valoresTas = valoresTas;
	}
	*/
}
