package professor.insert;

import java.util.ArrayList;

public class AlunoAndNotasQuery {
	private int idAluno;
	private String pessoa_idPessoa;
	//Vem da tabela pessoa
	private String nome;
	
	private float[] notas=new float[4];
			
	public AlunoAndNotasQuery(int idAluno, String pessoa_idPessoa, String nome) {
		super();
		this.idAluno = idAluno;
		this.pessoa_idPessoa = pessoa_idPessoa;
		this.nome = nome;
		
		//Quando uma nota é -1 ela é nula
		for(int i=0;i<notas.length;i++)
			notas[i]=-1;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getPessoa_idPessoa() {
		return pessoa_idPessoa;
	}

	public void setPessoa_idPessoa(String pessoa_idPessoa) {
		this.pessoa_idPessoa = pessoa_idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float[] getNotas() {
		return notas;
	}
	
	public float getNotaByTaIndex(int taIndex) {
		return notas[taIndex];
	}

	public void setNotas(float[] notas) {
		this.notas = notas;
	}
	
	//Lembre-se que tem de ser via index (começa com 0, não 1)
	public void setNotaByTaIndex(int taIndex,float nota) {
		notas[taIndex]=nota;
	}
}
