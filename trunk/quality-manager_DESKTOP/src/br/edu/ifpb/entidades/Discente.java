/**
 * 
 */
package br.edu.ifpb.entidades;

//Falta equals, toString e derivados

public class Discente {

	private String cpf;
	private String Matr�cula;
	private String Nome;
	private String Curso;
	private String Endere�o;
	private String Telefone;
	private String Email;
	private String CEP;
	
	//Construtor Discente
	public Discente(String cpf, String matr�cula, String nome, String curso,
			String endere�o, String cep, String telefone, String email) {
		
		setCpf(cpf);
		setMatr�cula(matr�cula);
		setNome(nome);
		setCurso(curso);
		setEndere�o(endere�o);
		setTelefone(telefone);
		setEmail(email);
		setCEP(cep);
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getCurso() {
		return Curso;
	}

	public void setCurso(String curso) {
		Curso = curso;
	}

	public String getEndere�o() {
		return Endere�o;
	}

	public void setEndere�o(String endere�o) {
		Endere�o = endere�o;
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

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
	
	
}
