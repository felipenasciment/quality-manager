package br.edu.ifpb.entidades;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Campos da tabela
// N_ano, in�cio_inscri��es, fim_inscri��es, ano, prazo_relat�rio_parcial, prazo_relat�rio_final, n�mero_vagas, valor_bolsa_docente, valor_bolsa_discente, PIP_ID


public class EditalPesquisa implements Entidade {
	
	private String NAno;
	private Date In�cioInscri��es;
	private Date FimInscri��es;
	private String Ano;
	private Date PrazoRelat�rioParcial;
	private Date PrazoRelat�rioFinal;
	private int N�meroVagas;
	private double ValorBolsaDocente;
	private double ValorBolsaDiscente;
	private int PIP_ID;
	
	
	// Construtor do Edital de Pesquisa
	public EditalPesquisa(String nAno, String in�cioInscri��es,
			String fimInscri��es, String ano, String prazoRelat�rioParcial,
			String prazoRelatorioFinal, int n�meroVagas, double valorBolsaDocente,
			double valorBolsaDiscente, int pip_id) throws ParseException {
		
		setNAno(nAno);
		setIn�cioInscri��es(recuperarDataJDBC(in�cioInscri��es));
		setFimInscri��es(recuperarDataJDBC(fimInscri��es));
		setAno(ano);
		setPrazoRelat�rioParcial(recuperarDataJDBC(prazoRelat�rioParcial));
		setPrazoRelat�rioFinal(recuperarDataJDBC(prazoRelatorioFinal));
		setN�meroVagas(n�meroVagas);
		setValorBolsaDocente(valorBolsaDocente);
		setValorBolsaDiscente(valorBolsaDiscente);
		setPIP_ID(pip_id);
		
	}
	
	//Ap�s informar data no formato String, ele retornara um tipo java.sql.Date,
	//Pronto para ser inserido ao banco.
	public Date recuperarDataJDBC(String data) throws ParseException{
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		
		java.util.Date dataUtil = f.parse(data);
		
		java.sql.Date dataJDBC = new java.sql.Date(dataUtil.getTime());
		return dataJDBC;
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

	public int getPIP_ID() {
		return PIP_ID;
	}

	public void setPIP_ID(int pIP_ID) {
		PIP_ID = pIP_ID;
	}
	
}
