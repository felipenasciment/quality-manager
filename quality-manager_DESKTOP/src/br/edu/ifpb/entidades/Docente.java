package br.edu.ifpb.entidades;

// Campos da tabela
// CPF, matr�cula, nome, cargo, endere�o, CEP, telefone, e_mail, titula��o, local_trabalho

// Falta equals, toString e derivados

public class Docente {
	
	private String CPF;
	private String Matr�cula;
	private String Nome;
	private String Cargo;
	private String Endere�o;
	private String CEP;
	private String Telefone;
	private String Email;
	private String Titula��o;
	private String LocalTrabalho;
	
	public Docente(String cpf, String matr�cula, String nome, String cargo,
			String endere�o, String cep, String telefone, String email,
			String titula��o, String localTrabalho) {
		
		setCPF(cpf);
		setMatr�cula(matr�cula);
		setNome(nome);
		setCargo(cargo);
		setEndere�o(endere�o);
		setCEP(cep);
		setTelefone(telefone);
		setEmail(email);
		setTitula��o(titula��o);
		setLocalTrabalho(localTrabalho);
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

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
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

	public String getTitula��o() {
		return Titula��o;
	}

	public void setTitula��o(String titula��o) {
		Titula��o = titula��o;
	}

	public String getLocalTrabalho() {
		return LocalTrabalho;
	}

	public void setLocalTrabalho(String localTrabalho) {
		LocalTrabalho = localTrabalho;
	}
	
}
