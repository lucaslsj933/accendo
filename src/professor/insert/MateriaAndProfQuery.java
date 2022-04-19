package professor.insert;

public class MateriaAndProfQuery {
	private int idMateria;
	private String nomeMateria;
	private String professor_pessoa_idPessoa;
	
	public MateriaAndProfQuery(int idMateria, String nomeMateria, String professor_pessoa_idPessoa) {
		super();
		this.idMateria = idMateria;
		this.nomeMateria = nomeMateria;
		this.professor_pessoa_idPessoa = professor_pessoa_idPessoa;
	}
	
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
	public String getProfessor_pessoa_idPessoa() {
		return professor_pessoa_idPessoa;
	}
	public void setProfessor_pessoa_idPessoa(String professor_pessoa_idPessoa) {
		this.professor_pessoa_idPessoa = professor_pessoa_idPessoa;
	}
	
	
}
