package br.edu.ifpb.entidades;

// Campos da tabela
// cargo, titula��o, local_trabalho

// Falta equals, toString e derivados

public class Docente extends Pessoa implements Entidade {

	private String Cargo;
	private String Titula��o;
	private String LocalTrabalho;

	public Docente(String cpf, String matr�cula, String nome, String endere�o,
			String cep, String telefone, String email, String cargo,
			String titula��o, String localTrabalho) {
		super(cpf, matr�cula, nome, endere�o, cep, telefone, email);
		setCargo(cargo);
		setTitula��o(titula��o);
		setLocalTrabalho(localTrabalho);
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
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
