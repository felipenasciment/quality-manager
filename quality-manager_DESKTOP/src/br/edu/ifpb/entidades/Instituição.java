package br.edu.ifpb.entidades;

// Campos da tabela
// ID_institui��o, nome_institui��o, sigla, or�amento

public class Institui��o implements Entidade {
	
	private int IDInstitui��o;
	private String NomeInstitui��o;
	private String Sigla;
	private double Or�amento;
	
	/* Construtor utilizado para a cria��o de um objeto Institui��o quando for inserir
	 * uma nova institui��o ao sistema, de modo que a vari�vel
	 * Id_institui��o n�o precise ser setada (O pr�prio banco de dados define qual ser� o valor do
	 * Id da intitui��o).
	 */
	public Institui��o(String nomeInstitui��o, String sigla, double or�amento) {
		
		setNomeInstitui��o(nomeInstitui��o);
		setSigla(sigla);
		setOr�amento(or�amento);
		
	}
	
	/* Para as demais consultas, quando for preciso montar uma institui��o j� existente,
	 * deve ser usado esse construtor, pois � necess�rio recuperar o ID da Institui��o.
	 */
	public Institui��o(int idInstitui��o, String nomeInstitui��o, String sigla, double or�amento) {
		
		setIDInstitui��o(idInstitui��o);
		setNomeInstitui��o(nomeInstitui��o);
		setSigla(sigla);
		setOr�amento(or�amento);
		
	}

	public int getIDInstitui��o() {
		return IDInstitui��o;
	}

	public void setIDInstitui��o(int idInstitui��o) {
		IDInstitui��o = idInstitui��o;
	}

	public String getNomeInstitui��o() {
		return NomeInstitui��o;
	}

	public void setNomeInstitui��o(String nomeInstitui��o) {
		NomeInstitui��o = nomeInstitui��o;
	}

	public String getSigla() {
		return Sigla;
	}

	public void setSigla(String sigla) {
		Sigla = sigla;
	}

	public double getOr�amento() {
		return Or�amento;
	}

	public void setOr�amento(double or�amento) {
		Or�amento = or�amento;
	}
	
}
