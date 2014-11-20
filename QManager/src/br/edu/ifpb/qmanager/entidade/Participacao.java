package br.edu.ifpb.qmanager.entidade;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "participacao")
public class Participacao {

	private int idParticipacao;
	private Projeto projeto;
	private MembroProjeto membroProjeto;
	private Date inicioParticipacao;
	private Date fimParticipacao;
	private double valorBolsa;
	private Date registro;

	public Participacao() {
	}

	public Participacao(Projeto projeto, MembroProjeto membroProjeto,
			java.util.Date inicioParticipacao, java.util.Date fimParticipacao,
			double valorBolsa) {
		setProjeto(projeto);
		setMembroProjeto(membroProjeto);
		setInicioParticipacao(inicioParticipacao);
		setFimParticipacao(fimParticipacao);
		setValorBolsa(valorBolsa);
	}

	@XmlElement
	public int getIdParticipacao() {
		return idParticipacao;
	}

	public void setIdParticipacao(int idParticipacao) {
		this.idParticipacao = idParticipacao;
	}

	@XmlElement
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@XmlElement
	public MembroProjeto getMembroProjeto() {
		return membroProjeto;
	}

	public void setMembroProjeto(MembroProjeto membroProjeto) {
		this.membroProjeto = membroProjeto;
	}

	@XmlElement
	public Date getInicioParticipacao() {
		return inicioParticipacao;
	}

	public void setInicioParticipacao(Date inicioParticipacao) {
		this.inicioParticipacao = inicioParticipacao;
	}

	@XmlElement
	public Date getFimParticipacao() {
		return fimParticipacao;
	}

	public void setFimParticipacao(Date fimParticipacao) {
		this.fimParticipacao = fimParticipacao;
	}

	@XmlElement
	public double getValorBolsa() {
		return valorBolsa;
	}

	public void setValorBolsa(double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}

	@XmlElement
	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	@Override
	public String toString() {
		return "Partipacao [idParticipacao=" + idParticipacao + ", projeto="
				+ projeto + ", membroProjeto=" + membroProjeto
				+ ", inicioParticipacao=" + inicioParticipacao
				+ ", fimParticipacao=" + fimParticipacao + ", valorBolsa="
				+ valorBolsa + ", Registro=" + registro + "]";
	}

}