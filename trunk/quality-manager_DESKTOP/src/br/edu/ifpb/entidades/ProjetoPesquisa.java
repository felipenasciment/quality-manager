package br.edu.ifpb.entidades;

import java.sql.Date;

// Campos da tabela
// ID_projeto, nome_projeto, data_in�cio, data_t�rmino, ano_projeto, relat�rio_parcial, relat�rio_final, processo, ano_N

public class ProjetoPesquisa {
	
	private String NomeProjeto;
	private Date DataIn�cio;
	private Date DataT�rmino;
	private String AnoProjeto;
	private String Relat�rioParcial;
	private String Relat�rioFinal;
	private String Processo;
	private String AnoN;
	
	
	/* Contrutor para a inser��o do Projeto de Pesquisa no Banco de dados.
	 * Ou seja, inicialmente n�o � necess�rio ter informa��es como Data de �nicio, Data de termino,
	 * nem nenhum tipo de relat�rios. Tais informa��es ser�o ditas no decorrer do projeto,
	 * ou caso seja aceito.
	 */
	public ProjetoPesquisa(String nomeProjeto, Date dataIn�cio,	String anoProjeto,
						String processo, String anoN){
		
		setNomeProjeto(nomeProjeto);
		setAnoProjeto(anoProjeto);
		setProcesso(processo);
		setAnoN(anoN);
		
	}
	
	/* Para as demais consultas, quando for preciso montar um Projeto de pesquisa j� existente,
	 * deve ser usado esse construtor, pois � necess�rio recuperar o todas as informa��es do
	 * projeto de pesquisa.
	 */
	public ProjetoPesquisa(String nomeProjeto, Date dataIn�cio, Date dataT�rmino,
						String anoProjeto, String relat�rioParcial, String relat�rioFinal,
						String processo, String anoN) {
		
		setNomeProjeto(nomeProjeto);
		setDataIn�cio(dataIn�cio);
		setDataT�rmino(dataT�rmino);
		setAnoProjeto(anoProjeto);
		setRelat�rioParcial(relat�rioParcial);
		setRelat�rioFinal(relat�rioFinal);
		setProcesso(processo);
		setAnoN(anoN);
		
	}

	public String getNomeProjeto() {
		return NomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		NomeProjeto = nomeProjeto;
	}

	public Date getDataIn�cio() {
		return DataIn�cio;
	}

	public void setDataIn�cio(Date dataIn�cio) {
		DataIn�cio = dataIn�cio;
	}

	public Date getDataT�rmino() {
		return DataT�rmino;
	}

	public void setDataT�rmino(Date dataT�rmino) {
		DataT�rmino = dataT�rmino;
	}

	public String getAnoProjeto() {
		return AnoProjeto;
	}

	public void setAnoProjeto(String anoProjeto) {
		AnoProjeto = anoProjeto;
	}

	public String getRelat�rioParcial() {
		return Relat�rioParcial;
	}

	public void setRelat�rioParcial(String relat�rioParcial) {
		Relat�rioParcial = relat�rioParcial;
	}

	public String getRelat�rioFinal() {
		return Relat�rioFinal;
	}

	public void setRelat�rioFinal(String relat�rioFinal) {
		Relat�rioFinal = relat�rioFinal;
	}

	public String getProcesso() {
		return Processo;
	}

	public void setProcesso(String processo) {
		Processo = processo;
	}

	public String getAnoN() {
		return AnoN;
	}

	public void setAnoN(String anoN) {
		AnoN = anoN;
	}
	
}
