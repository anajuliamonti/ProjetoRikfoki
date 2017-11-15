package model;

public class Cliente {
	
	private String nome;
	private String endereco;
	private String contato;
	private String email;
	private String cpf_cnpj;
	
	public static String[] getAtributes () {
		String[] r = {"nome", "endereco", "contato", "email", "cpf/cnpj"};
		return r;
	}
	
	public Object[] getInfo() {
		Object[] r = new Object[5];
		r[0] = nome;
		r[1] = endereco;
		r[2] = contato;
		r[3] = email;
		r[4] = cpf_cnpj;
		
		return r;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

}
