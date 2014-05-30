package br.edu.ifpb.entidades;

//		Campos da tabela
//NomeInstitui��o, Sigla, Or�amento


public class Institui��o {
	
	private int IdInstitui��o;
	private String Nome_Institui��o;
	private String Sigla;
	private double Or�amento;
	
	/* Construtor utilizado para a cria��o de um objeto Institui��o quando for inserir
	 * uma nova institui��o ao sistema, de modo que a vari�vel
	 * Id_institui��o n�o precise ser setada (O pr�prio banco de dados define qual ser� o valor do
	 * Id da intitui��o).
	 */
	public Institui��o(String nome_Institui��o, String sigla, double or�amento) {
		
		setNomeInstituicao(nome_Institui��o);
		setSigla(sigla);
		setOr�amento(or�amento);
		
	}
	
	/* Para as demais consultas, quando for preciso montar uma institui��o j� existente,
	 * deve ser usado esse construtor, pois � necess�rio recuperar o ID da Institui��o.
	 */
	public Institui��o(int idInstitui��o, String nome_Institui��o, String sigla, double or�amento) {
		
		setIdInstitui��o(idInstitui��o);
		setNomeInstituicao(nome_Institui��o);
		setSigla(sigla);
		setOr�amento(or�amento);
		
	}

	public String getNomeInstituicao() {
		return this.Nome_Institui��o;
	}

	public void setNomeInstituicao(String nome_Institui��o) {
		this.Nome_Institui��o = nome_Institui��o;
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

	public int getIdInstitui��o() {
		return IdInstitui��o;
	}

	public void setIdInstitui��o(int idInstitui��o) {
		this.IdInstitui��o = idInstitui��o;
	}

}
