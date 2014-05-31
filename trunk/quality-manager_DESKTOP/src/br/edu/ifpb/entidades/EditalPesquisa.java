package br.edu.ifpb.entidades;

import java.sql.Date;

//		Campos da tabela
//N_ano, Inicio_das_inscri��es, Fim_das_inscri��es, Ano, Prazo_do_relat�rio_parcial
//Prazo_do_relat�rio_final, N�mero_de_vagas, Valor_bolsa_docente, Valor Bolsa discente
//PIP_id_programa


public class EditalPesquisa {
	
	private String N_ano;
	private Date InicioInscri��es;
	private Date FimInscri��es;
	private String Ano;
	private Date PrazoRelat�rioParcial;
	private Date PrazoRelatorioFinal;
	private int N�meroDeVagas;
	private double ValorBolsaDocente;
	private double ValorBolsaDiscente;
	private int PIP_id;
	
	
	//Construtor do edital de Pesquisa
	public EditalPesquisa(String n_ano, Date inicioInscri��es,
			Date fimInscri��es, String ano, Date prazoRelat�rioParcial,
			Date prazoRelatorioFinal, int n�meroDeVagas, double valorBolsaDocente,
			double valorBolsaDiscente, int pip_id) {
		
		setN_ano(n_ano);
		setInicioInscri��es(inicioInscri��es);
		setFimInscri��es(fimInscri��es);
		setAno(ano);
		setPrazoRelat�rioParcial(prazoRelat�rioParcial);
		setPrazoRelatorioFinal(prazoRelatorioFinal);
		setN�meroDeVagas(n�meroDeVagas);
		setValorBolsaDocente(valorBolsaDocente);
		setValorBolsaDiscente(valorBolsaDiscente);
		setPIP_id(pip_id);
	}

	public String getN_ano() {
		return N_ano;
	}

	public void setN_ano(String n_ano) {
		N_ano = n_ano;
	}

	public Date getInicioInscri��es() {
		return InicioInscri��es;
	}

	public void setInicioInscri��es(Date inicioInscri��es) {
		InicioInscri��es = inicioInscri��es;
	}

	public Date getFimInscri��es() {
		return FimInscri��es;
	}

	public void setFimInscri��es(Date fimInscri��es) {
		FimInscri��es = fimInscri��es;
	}

	public String getAno() {
		return Ano;
	}

	public void setAno(String ano) {
		Ano = ano;
	}

	public Date getPrazoRelat�rioParcial() {
		return PrazoRelat�rioParcial;
	}

	public void setPrazoRelat�rioParcial(Date prazoRelat�rioParcial) {
		PrazoRelat�rioParcial = prazoRelat�rioParcial;
	}

	public Date getPrazoRelatorioFinal() {
		return PrazoRelatorioFinal;
	}

	public void setPrazoRelatorioFinal(Date prazoRelatorioFinal) {
		this.PrazoRelatorioFinal = prazoRelatorioFinal;
	}

	public int getN�meroDeVagas() {
		return N�meroDeVagas;
	}

	public void setN�meroDeVagas(int n�meroDeVagas) {
		N�meroDeVagas = n�meroDeVagas;
	}

	public double getValorBolsaDocente() {
		return ValorBolsaDocente;
	}

	public void setValorBolsaDocente(double valorBolsaDocente) {
		ValorBolsaDocente = valorBolsaDocente;
	}

	public double getValorBolsaDiscente() {
		return ValorBolsaDiscente;
	}

	public void setValorBolsaDiscente(double valorBolsaDiscente) {
		ValorBolsaDiscente = valorBolsaDiscente;
	}

	public int getPIP_id() {
		return PIP_id;
	}

	public void setPIP_id(int pIP_id) {
		PIP_id = pIP_id;
	}

}
