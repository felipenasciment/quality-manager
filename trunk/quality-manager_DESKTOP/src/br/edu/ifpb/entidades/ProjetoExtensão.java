package br.edu.ifpb.entidades;

import java.sql.Date;

//	 							Campos da tabela
//Nome_do_projeto, Data_de_inicio, Data_de_termino, Ano_do_projeto, Relatorio_final,
//Relatorio_parcial, Processo, Registro, EditalPesquisa_N_ANO

public class ProjetoExtens�o {
	
	private String NomeProjeto;
	private Date Data�nicio;
	private Date DataTermino;
	private String AnoProjeto;
	private String RelatorioFinal;
	private String RelatorioParcial;
	private String Processo;
	private String Registro;
	private String EditalPesquisa_N_ANO;
	
	
	/*Contrutor para a inser��o do Projeto de Pesquisa no Banco de dados.
	 * Ou seja, inicialmente n�o � necess�rio ter informa��es como Data de �nicio, Data de termino,
	 * nem nenhum tipo de relat�rios. Tais informa��es ser�o ditas no decorrer do projeto,
	 * ou caso seja aceito.
	 */
	public ProjetoExtens�o(String nomeprojeto,	String anoprojeto,
						String processo, String editalpesquisa_N_ano){
		
		setNomeProjeto(nomeprojeto);
		setAnoProjeto(anoprojeto);
		setProcesso(processo);
		setEditalPesquisa_N_ANO(editalpesquisa_N_ano);
		
	}
	
	/* Para as demais consultas, quando for preciso montar um Projeto de pesquisa j� existente,
	 * deve ser usado esse construtor, pois � necess�rio recuperar o todas as informa��es do
	 * projeto de pesquisa.
	 */
	public ProjetoExtens�o(String nomeprojeto, Date data�nicio, Date datat�rmino, String anoprojeto,
			String relat�rioparcial, String relat�riofinal, String processo,
			String registro, String editalpesquisa_N_ano) {
		
		setNomeProjeto(nomeprojeto);
		setData�nicio(data�nicio);
		setDataTermino(datat�rmino);
		setAnoProjeto(anoprojeto);
		setRelatorioParcial(relat�rioparcial);
		setRelatorioFinal(relat�riofinal);
		setProcesso(processo);
		setRegistro(registro);
		setEditalPesquisa_N_ANO(editalpesquisa_N_ano);
		
		
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

	public Date getDataTermino() {
		return DataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		DataTermino = dataTermino;
	}

	public String getAnoProjeto() {
		return AnoProjeto;
	}

	public void setAnoProjeto(String anoProjeto) {
		AnoProjeto = anoProjeto;
	}

	public String getRelatorioFinal() {
		return RelatorioFinal;
	}

	public void setRelatorioFinal(String relatorioFinal) {
		RelatorioFinal = relatorioFinal;
	}

	public String getRelatorioParcial() {
		return RelatorioParcial;
	}

	public void setRelatorioParcial(String relatorioParcial) {
		RelatorioParcial = relatorioParcial;
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

	public String getEditalPesquisa_N_ANO() {
		return EditalPesquisa_N_ANO;
	}

	public void setEditalPesquisa_N_ANO(String editalPesquisa_N_ANO) {
		EditalPesquisa_N_ANO = editalPesquisa_N_ANO;
	}

	
	
}