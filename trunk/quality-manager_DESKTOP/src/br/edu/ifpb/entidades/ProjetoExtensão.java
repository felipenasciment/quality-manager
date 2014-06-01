package br.edu.ifpb.entidades;

import java.sql.Date;

// Campos da tabela
// ID_projeto, nome_projeto, data_início, data_término, ano_projeto, relatório_final, relatório_parcial, processo, registro, ano_N

public class ProjetoExtensão {
	
	private String NomeProjeto;
	private Date DataInício;
	private Date DataTérmino;
	private String AnoProjeto;
	private String RelatórioParcial;
	private String RelatórioFinal;
	private String Processo;
	private String Registro;
	private String AnoN;
	
	/* Contrutor para a inserção do Projeto de Pesquisa no Banco de dados.
	 * Ou seja, inicialmente não é necessário ter informações como Data de ínicio, Data de termino,
	 * nem nenhum tipo de relatórios. Tais informações serão ditas no decorrer do projeto,
	 * ou caso seja aceito.
	 */
	public ProjetoExtensão(String nomeProjeto,	String anoProjeto,
						String processo, String anoN){
		
		setNomeProjeto(nomeProjeto);
		setAnoProjeto(anoProjeto);
		setProcesso(processo);
		setAnoN(anoN);
		
	}
	
	/* Para as demais consultas, quando for preciso montar um Projeto de pesquisa já existente,
	 * deve ser usado esse construtor, pois é necessário recuperar o todas as informações do
	 * projeto de pesquisa.
	 */
	public ProjetoExtensão(String nomeProjeto, Date dataInício, Date dataTérmino, String anoProjeto,
			String relatórioParcial, String relatórioFinal, String processo,
			String registro, String anoN) {
		
		setNomeProjeto(nomeProjeto);
		setDataInício(dataInício);
		setDataTérmino(dataTérmino);
		setAnoProjeto(anoProjeto);
		setRelatórioParcial(relatórioParcial);
		setRelatórioFinal(relatórioFinal);
		setProcesso(processo);
		setRegistro(registro);
		setAnoN(anoN);
		
	}

	public String getNomeProjeto() {
		return NomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		NomeProjeto = nomeProjeto;
	}

	public Date getDataInício() {
		return DataInício;
	}

	public void setDataInício(Date dataInício) {
		DataInício = dataInício;
	}

	public Date getDataTérmino() {
		return DataTérmino;
	}

	public void setDataTérmino(Date dataTérmino) {
		DataTérmino = dataTérmino;
	}

	public String getAnoProjeto() {
		return AnoProjeto;
	}

	public void setAnoProjeto(String anoProjeto) {
		AnoProjeto = anoProjeto;
	}

	public String getRelatórioParcial() {
		return RelatórioParcial;
	}

	public void setRelatórioParcial(String relatórioParcial) {
		RelatórioParcial = relatórioParcial;
	}

	public String getRelatórioFinal() {
		return RelatórioFinal;
	}

	public void setRelatórioFinal(String relatórioFinal) {
		RelatórioFinal = relatórioFinal;
	}
	
	public String getProcesso() {
		return Processo;
	}

	public void setProcesso(String processo) {
		Processo = processo;
	}

	public String getRegistro() {
		return Registro;
	}

	public void setRegistro(String registro) {
		Registro = registro;
	}

	public String getAnoN() {
		return AnoN;
	}

	public void setAnoN(String editalPesquisa_N_ANO) {
		AnoN = editalPesquisa_N_ANO;
	}
	
}