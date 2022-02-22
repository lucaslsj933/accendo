package professor.insert;

import java.util.ArrayList;

public class AlunoAndNotasQuery {
	private int idAluno;
	private String pessoa_idPessoa;
	//Vem da tabela pessoa
	private String nome;
	
	public AlunoAndNotasQuery(int idAluno, String pessoa_idPessoa, String nome) {
		super();
		this.idAluno = idAluno;
		this.pessoa_idPessoa = pessoa_idPessoa;
		this.nome = nome;
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
}
