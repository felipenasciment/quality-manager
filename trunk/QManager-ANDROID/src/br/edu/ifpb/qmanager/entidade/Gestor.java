package br.edu.ifpb.qmanager.entidade;

import java.io.Serializable;

public class Gestor extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	public Gestor() {
		super();
	}

	public Gestor(String nomePessoa, String cpf, String matricula,
			String endereco, String cep, String telefone, String email,
			String senha, DadosBancarios dadosBancarios) {
		super(nomePessoa, cpf, matricula, endereco, cep, telefone, email,
				senha, dadosBancarios);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
