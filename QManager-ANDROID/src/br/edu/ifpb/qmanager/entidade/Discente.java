package br.edu.ifpb.qmanager.entidade;

public class Discente extends Pessoa {

	private Turma turma;

	public Discente() {
		turma = new Turma();
	}

	public Discente(String nomePessoa, String cpf, String matricula,
			String endereco, String cep, String telefone, String email,
			String senha, TipoPessoa tipoPessoa, Local localEstuda,
			DadosBancarios dadosBancarios, Turma turma) {

		super(nomePessoa, cpf, matricula, endereco, cep, telefone, email,
				senha, tipoPessoa, localEstuda, dadosBancarios);

		setTurma(turma);

	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return super.toString() + "Discente [turma=" + turma + "]";
	}

}
