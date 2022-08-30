package profile;

public class Aluno extends Pessoa{
	private int idAluno;
	private String etapa;
	private int serie;
	private int turma_idTurma;
	
	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	public String getEtapa() {
		return etapa;
	}
	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	public int getTurma_idTurma() {
		return turma_idTurma;
	}
	public void setTurma_idTurma(int turma_idTurma) {
		this.turma_idTurma = turma_idTurma;
	}
}
