package br.edu.ifpb.qmanager.entidade;

import java.io.Serializable;

public class ProgramaInstitucional implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idProgramaInstitucional;
	private String nomeProgramaInstitucional;
	private String sigla;
	private double orcamento;
	private InstituicaoFinanciadora instituicaoFinanciadora;
	private Gestor gestor;
	private String registro;

	public ProgramaInstitucional() {
		instituicaoFinanciadora = new InstituicaoFinanciadora();
		gestor = new Gestor();
	}

	public ProgramaInstitucional(String nomeProgramaInstitucional,
			String sigla, double orcamento,
			InstituicaoFinanciadora instituicao, Gestor gestor) {
		setNomeProgramaInstitucional(nomeProgramaInstitucional);
		setSigla(sigla);
		setOrcamento(orcamento);
		setInstituicaoFinanciadora(instituicao);
		setGestor(gestor);
	}

	public int getIdProgramaInstitucional() {
		return idProgramaInstitucional;
	}

	public void setIdProgramaInstitucional(int idProgramaInstitucional) {
		this.idProgramaInstitucional = idProgramaInstitucional;
	}

	public String getNomeProgramaInstitucional() {
		return nomeProgramaInstitucional;
	}

	public void setNomeProgramaInstitucional(String nomeProgramaInstitucional) {
		this.nomeProgramaInstitucional = nomeProgramaInstitucional;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}

	public InstituicaoFinanciadora getInstituicaoFinanciadora() {
		return instituicaoFinanciadora;
	}

	public void setInstituicaoFinanciadora(
			InstituicaoFinanciadora instituicaoFinanciadora) {
		this.instituicaoFinanciadora = instituicaoFinanciadora;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

	@Override
	public String toString() {
		return "ProgramaInstitucional [idProgramaInstitucional="
				+ idProgramaInstitucional + ", nomeProgramaInstitucional="
				+ nomeProgramaInstitucional + ", sigla=" + sigla
				+ ", orcamento=" + orcamento + ", instituicaoFinanciadora="
				+ instituicaoFinanciadora + ", gestor=" + gestor
				+ ", registro=" + registro + "]";
	}

}
