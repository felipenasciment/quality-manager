package br.edu.ifpb.entidades;

// Campos da tabela
// CPF, matr�cula, nome, endere�o, CEP, telefone, e_mail

public abstract class Pessoa {
	
	private String CPF;
	private String Matr�cula;
	private String Nome;
	private String Endere�o;
	private String CEP;
	private String Telefone;
	private String Email;
	
	public Pessoa(String cpf, String matr�cula, String nome, String endere�o,
			String cep, String telefone, String email) {
		setCPF(cpf);
		setMatr�cula(matr�cula);
		setNome(nome);
		setEndere�o(endere�o);
		setCEP(cep);
		setTelefone(telefone);
		setEmail(email);
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cpf) {
		CPF = cpf;
	}

	public String getMatr�cula() {
		return Matr�cula;
	}

	public void setMatr�cula(String matr�cula) {
		Matr�cula = matr�cula;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndere�o() {
		return Endere�o;
	}

	public void setEndere�o(String endere�o) {
		Endere�o = endere�o;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cep) {
		CEP = cep;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
}
