package professor.insert;

import java.time.Year;

public class Turma {
	private int idTurma;
	private String nome;
	private Year ano;
	
	public Turma(int idTurma, String nome, Year ano) {
		this.idTurma = idTurma;
		this.nome = nome;
		this.ano = ano;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Year getAno() {
		return ano;
	}

	public void setAno(Year ano) {
		this.ano = ano;
	}
}