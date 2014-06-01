package br.edu.ifpb.entidades;

//		Campos da tabela
//NomeInstitui��o, Sigla, Or�amento


public class Institui��o {
	
	private int ID_Institui��o;
	private String NomeInstitui��o;
	private String Sigla;
	private double Or�amento;
	
	/* Construtor utilizado para a cria��o de um objeto Institui��o quando for inserir
	 * uma nova institui��o ao sistema, de modo que a vari�vel
	 * Id_institui��o n�o precise ser setada (O pr�prio banco de dados define qual ser� o valor do
	 * Id da intitui��o).
	 */
	public Institui��o(String nomeinstitui��o, String sigla, double or�amento) {
		
		setNomeInstitui��o(nomeinstitui��o);
		setSigla(sigla);
		setOr�amento(or�amento);
		
	}
	
	/* Para as demais consultas, quando for preciso montar uma institui��o j� existente,
	 * deve ser usado esse construtor, pois � necess�rio recuperar o ID da Institui��o.
	 */
	public Institui��o(int idinstitui��o, String nomeinstitui��o, String sigla, double or�amento) {
		
		setID_Institui��o(idinstitui��o);
		setNomeInstitui��o(nomeinstitui��o);
		setSigla(sigla);
		setOr�amento(or�amento);
		
	}

	public int getID_Institui��o() {
		return ID_Institui��o;
	}

	public void setID_Institui��o(int iD_Institui��o) {
		ID_Institui��o = iD_Institui��o;
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
