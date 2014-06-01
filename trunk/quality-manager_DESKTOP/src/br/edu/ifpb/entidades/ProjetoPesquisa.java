package br.edu.ifpb.entidades;

import java.sql.Date;

//	 							Campos da tabela
//Nome_do_projeto, Data_de_inicio, Data_de_termino, Ano_do_projeto, Relatorio_parcial,
//Relatorio_final, Processo, EditalPesquisa_N_ANO

public class ProjetoPesquisa {
	
	private String NomeProjeto;
	private Date Data�nicio;
	private Date DataT�rmino;
	private String AnoProjeto;
	private String RelatorioParcial;
	private String RelatorioFinal;
	private String Processo;
	private String EditalPesquisa_N_Ano;
	
	
	/*Contrutor para a inser��o do Projeto de Pesquisa no Banco de dados.
	 * Ou seja, inicialmente n�o � necess�rio ter informa��es como Data de �nicio, Data de termino,
	 * nem nenhum tipo de relat�rios. Tais informa��es ser�o ditas no decorrer do projeto,
	 * ou caso seja aceito.
	 */
	public ProjetoPesquisa(String nomeprojeto, Date data�nicio,	String anoprojeto,
						String processo, String editalpesquisa_N_ano){
		
		setNomeProjeto(nomeprojeto);
		setAnoProjeto(anoprojeto);
		setProcesso(processo);
		setEditalPesquisa_N_Ano(editalpesquisa_N_ano);
		
	}
	
	/* Para as demais consultas, quando for preciso montar um Projeto de pesquisa j� existente,
	 * deve ser usado esse construtor, pois � necess�rio recuperar o todas as informa��es do
	 * projeto de pesquisa.
	 */
	public ProjetoPesquisa(String nomeprojeto, Date data�nicio, Date datat�rmino,
						String anoprojeto, String relat�rioparcial, String relat�riofinal,
						String processo, String editalpesquisa_N_ano) {
		
		setNomeProjeto(nomeprojeto);
		setData�nicio(data�nicio);
		setDataT�rmino(datat�rmino);
		setAnoProjeto(anoprojeto);
		setRelatorioParcial(relat�rioparcial);
		setRelatorioFinal(relat�riofinal);
		setProcesso(processo);
		setEditalPesquisa_N_Ano(editalpesquisa_N_ano);
		
		
	}

	public String getNomeProjeto() {
		return NomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		NomeProjeto = nomeProjeto;
	}

	public Date getData�nicio() {
		return Data�nicio;
	}

	public void setData�nicio(Date data�nicio) {
		Data�nicio = data�nicio;
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

	public String getRelatorioParcial() {
		return RelatorioParcial;
	}

	public void setRelatorioParcial(String relatorioParcial) {
		RelatorioParcial = relatorioParcial;
	}

	public String getRelatorioFinal() {
		return RelatorioFinal;
	}

	public void setRelatorioFinal(String relatorioFinal) {
		RelatorioFinal = relatorioFinal;
	}

	public String getProcesso() {
		return Processo;
	}

	public void setProcesso(String processo) {
		Processo = processo;
	}

	public String getEditalPesquisa_N_Ano() {
		return EditalPesquisa_N_Ano;
	}

	public void setEditalPesquisa_N_Ano(String editalPesquisa_N_ano) {
		EditalPesquisa_N_Ano = editalPesquisa_N_ano;
	}


	

}
