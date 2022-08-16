package consultar;

import java.math.BigDecimal;

public class NotaClass {
	private int idNota;
	private Float valor;
	private int ta;
	private int materia_idMateria;
	private String aluno_idAluno;
	private String pessoa_idPessoa;
	
	//private int idMateria;
	//private String nomeMateria;
	
	public NotaClass(Float valor,int ta) {
		this.valor=valor;
		this.ta=ta;
	}

	public int getIdNota() {
		return idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}
	
	public int getTa() {
		return ta;
	}

	public void setTa(int ta) {
		this.ta = ta;
	}

	public int getMateria_idMateria() {
		return materia_idMateria;
	}

	public void setMateria_idMateria(int materia_idMateria) {
		this.materia_idMateria = materia_idMateria;
	}

	public String getAluno_idAluno() {
		return aluno_idAluno;
	}

	public void setAluno_idAluno(String aluno_idAluno) {
		this.aluno_idAluno = aluno_idAluno;
	}

	/*
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
	
	*/

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getPessoa_idPessoa() {
		return pessoa_idPessoa;
	}

	public void setPessoa_idPessoa(String pessoa_idPessoa) {
		this.pessoa_idPessoa = pessoa_idPessoa;
	}
}

