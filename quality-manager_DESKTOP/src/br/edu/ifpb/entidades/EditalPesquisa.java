package br.edu.ifpb.entidades;

import java.sql.Date;

//		Campos da tabela
//N_ano, Inicio_das_inscri��es, Fim_das_inscri��es, Ano, Prazo_do_relat�rio_parcial
//Prazo_do_relat�rio_final, N�mero_de_vagas, Valor_bolsa_docente, Valor Bolsa discente
//PIP_id_programa


public class EditalPesquisa {
	
	private String N_ano;
	private Date �nicioInscri��es;
	private Date FimInscri��es;
	private String Ano;
	private Date PrazoRelat�rioParcial;
	private Date PrazoRelatorioFinal;
	private int N�meroDeVagas;
	private double ValorBolsaDocente;
	private double ValorBolsaDiscente;
	private int PIP_ID;
	
	
	//Construtor do edital de Pesquisa
	public EditalPesquisa(String n_ano, Date �nicioinscri��es,
			Date fiminscri��es, String ano, Date prazorelat�rioparcial,
			Date prazorelatoriofinal, int n�merovagas, double valorbolsadocente,
			double valorbolsadiscente, int pip_id) {
		
		setN_ano(n_ano);
		set�nicioInscri��es(�nicioinscri��es);
		setFimInscri��es(fiminscri��es);
		setAno(ano);
		setPrazoRelat�rioParcial(prazorelat�rioparcial);
		setPrazoRelatorioFinal(prazorelatoriofinal);
		setN�meroDeVagas(n�merovagas);
		setValorBolsaDocente(valorbolsadocente);
		setValorBolsaDiscente(valorbolsadiscente);
		setPIP_ID(pip_id);
	}


	public String getN_ano() {
		return N_ano;
	}


	public void setN_ano(String n_ano) {
		N_ano = n_ano;
	}


	public Date get�nicioInscri��es() {
		return �nicioInscri��es;
	}


	public void set�nicioInscri��es(Date �nicioInscri��es) {
		�nicioInscri��es = �nicioInscri��es;
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
		PrazoRelatorioFinal = prazoRelatorioFinal;
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


	public int getPIP_ID() {
		return PIP_ID;
	}


	public void setPIP_ID(int pIP_ID) {
		PIP_ID = pIP_ID;
	}

	

}
