/**
 * 
 */
package br.edu.ifpb.entidades;

//Falta equals, toString e derivados

public class Discente {

	private String cpf;
	private String MatrÝcula;
	private String Nome;
	private String Curso;
	private String Enderešo;
	private String Telefone;
	private String Email;
	private String CEP;
	
	//Construtor Discente
	public Discente(String cpf, String matrÝcula, String nome, String curso,
			String enderešo, String cep, String telefone, String email) {
		
		setCpf(cpf);
		setMatrÝcula(matrÝcula);
		setNome(nome);
		setCurso(curso);
		setEnderešo(enderešo);
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

	public String getMatrÝcula() {
		return MatrÝcula;
	}

	public void setMatrÝcula(String matrÝcula) {
		MatrÝcula = matrÝcula;
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

	public String getEnderešo() {
		return Enderešo;
	}

	public void setEnderešo(String enderešo) {
		Enderešo = enderešo;
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
