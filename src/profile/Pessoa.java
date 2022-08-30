package profile;

public class Pessoa {
	private String idPessoa;
	private char tipoPessoa;
	private String passwordPessoa;
	private String nome;
	private char sexo;
	private int idade;
	private String rg;
	private String cpf;
	private int flag;
	
	public String getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(String idPessoa) {
		this.idPessoa = idPessoa;
	}
	public char getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(char tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public String getPasswordPessoa() {
		return passwordPessoa;
	}
	public void setPasswordPessoa(String passwordPessoa) {
		this.passwordPessoa = passwordPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
