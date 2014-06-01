package br.edu.ifpb.entidades;

import java.sql.Date;

//		Campos da tabela
//N_ano, Inicio_das_inscri��es, Fim_das_inscri��es, Ano, Prazo_do_relat�rio_parcial
//Prazo_do_relat�rio_final, N�mero_de_vagas, Valor_bolsa_docente, Valor Bolsa discente
//PIE_id_programa


public class EditalExtens�o {
	
	private String N_ano;
	private Date �nicioInscri��es;
	private Date Fim�nscri��es;
	private String Ano;
	private Date PrazoRelat�rioParcial;
	private Date PrazoRelat�rioFinal;
	private int N�meroDeVagas;
	private double ValorBolsaDocente;
	private double ValorBolsaDiscente;
	private int PIE_ID;
	
	
	//Construtor do edital de Extens�o
	public EditalExtens�o(String n_ano, Date �nicioinscri��es,
			Date fim�nscri��es, String ano, Date prazorelat�rioparcial,
			Date prazorelat�riofinal, int n�merovagas, double valorbolsadocente,
			double valorbolsadiscente, int pie_id) {
		
		setN_ano(n_ano);
		set�nicioInscri��es(�nicioinscri��es);
		setFim�nscri��es(fim�nscri��es);
		setAno(ano);
		setPrazoRelat�rioParcial(prazorelat�rioparcial);
		setPrazoRelat�rioFinal(prazorelat�riofinal);
		setN�meroDeVagas(n�merovagas);
		setValorBolsaDocente(valorbolsadocente);
		setValorBolsaDiscente(valorbolsadiscente);
		setPIE_ID(pie_id);
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


	public Date getFim�nscri��es() {
		return Fim�nscri��es;
	}


	public void setFim�nscri��es(Date fim�nscri��es) {
		Fim�nscri��es = fim�nscri��es;
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


	public int getPIE_ID() {
		return PIE_ID;
	}


	public void setPIE_ID(int pIE_ID) {
		PIE_ID = pIE_ID;
	}
}