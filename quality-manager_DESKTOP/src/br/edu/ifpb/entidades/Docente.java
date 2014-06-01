package br.edu.ifpb.entidades;

// 		Campos na tabela
// CPF, Matricula, Nome, Cargo, Endereco, CEP, Telefone, E_mail, Titula��o, Local_de_Trabalho

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
			String titula��o, String localtrabalho) {
		
		setCPF(cpf);
		setMatr�cula(matr�cula);
		setNome(nome);
		setCargo(cargo);
		setEndere�o(endere�o);
		setCEP(cep);
		setTelefone(telefone);
		setEmail(email);
		setTitula��o(titula��o);
		setLocalTrabalho(localtrabalho);
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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

	public void setCEP(String cEP) {
		CEP = cEP;
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
