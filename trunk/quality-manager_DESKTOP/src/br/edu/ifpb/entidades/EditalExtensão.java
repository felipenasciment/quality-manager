package br.edu.ifpb.entidades;

import java.sql.Date;

// Campos da tabela
// N_ano, in�cio_inscri��es, fim_inscri��es, ano, prazo_relat�rio_parcial, prazo_relat�rio_final, n�mero_vagas, valor_bolsa_docente, valor_bolsa_discente, PIE_ID


public class EditalExtens�o {
	
	private String NAno;
	private Date In�cioInscri��es;
	private Date FimInscri��es;
	private String Ano;
	private Date PrazoRelat�rioParcial;
	private Date PrazoRelat�rioFinal;
	private int N�meroVagas;
	private double ValorBolsaDocente;
	private double ValorBolsaDiscente;
	private int PIE_ID;
	
	//Construtor do edital de Extens�o
	public EditalExtens�o(String nAno, Date in�cioInscri��es,
			Date fimInscri��es, String ano, Date prazoRelat�rioParcial,
			Date prazoRelat�rioFinal, int n�meroVagas, double valorBolsaDocente,
			double valorBolsaDiscente, int pie_id) {
		
		setNAno(nAno);
		setIn�cioInscri��es(in�cioInscri��es);
		setFimInscri��es(fimInscri��es);
		setAno(ano);
		setPrazoRelat�rioParcial(prazoRelat�rioParcial);
		setPrazoRelat�rioFinal(prazoRelat�rioFinal);
		setN�meroVagas(n�meroVagas);
		setValorBolsaDocente(valorBolsaDocente);
		setValorBolsaDiscente(valorBolsaDiscente);
		setPIE_ID(pie_id);
	}

	public String getNAno() {
		return NAno;
	}

	public void setNAno(String nAno) {
		NAno = nAno;
	}

	public Date getIn�cioInscri��es() {
		return In�cioInscri��es;
	}

	public void setIn�cioInscri��es(Date in�cioInscri��es) {
		In�cioInscri��es = in�cioInscri��es;
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

	public Date getPrazoRelat�rioFinal() {
		return PrazoRelat�rioFinal;
	}

	public void setPrazoRelat�rioFinal(Date prazoRelat�rioFinal) {
		PrazoRelat�rioFinal = prazoRelat�rioFinal;
	}

	public int getN�meroVagas() {
		return N�meroVagas;
	}

	public void setN�meroVagas(int n�meroVagas) {
		N�meroVagas = n�meroVagas;
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

	public int getPIE_ID() {
		return PIE_ID;
	}

	public void setPIE_ID(int pie_id) {
		PIE_ID = pie_id;
	}
	
}
