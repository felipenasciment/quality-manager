package br.edu.ifpb.entidades;

//	Campos da tabela
// Id_programa, SiglaPIP, NomePIP, Institui��o_idInstitui��o

//PIP = Programa Institucional de Pesquisa

public class ProgramaInstitucionalExtens�o {
	
	private int Id_PIE; 
	private String SiglaPIE;
	private String NomePIE;
	private int Institui��o_id;
	
	/* Construtor utilizado para a cria��o de um objeto ProgramaInstitucionalPesquisa quando for inserir
	 * um novo Programa Institucional de Pesquisa ao sistema, de modo que a vari�vel
	 * Id_PIP n�o precise ser setada (O pr�prio banco de dados define qual ser� o valor do
	 * Id da ProgramaInstitucionalPesquisa).
	 */
	public ProgramaInstitucionalExtens�o(String siglaPIE, String nomePIE, int institui��o_id) {

		setSiglaPIE(siglaPIE);
		setNomePIE(nomePIE);
		setInstitui��o_id(institui��o_id);
		
	}
	
	/* Para as demais consultas, quando for preciso montar um ProgramaInstitucionalPesquisa j� existente,
	 * deve ser usado esse construtor, pois � necess�rio recuperar o ID da Institui��o.
	 */
	public ProgramaInstitucionalExtens�o(int id_PIE, String siglaPIE, String nomePIE, int institui��o_id) {
		
		setId_PIE(id_PIE);
		setSiglaPIE(siglaPIE);
		setNomePIE(nomePIE);
		setInstitui��o_id(institui��o_id);
		
	}

	public int getId_PIE() {
		return Id_PIE;
	}

	public void setId_PIE(int id_PIE) {
		Id_PIE = id_PIE;
	}

	public String getSiglaPIE() {
		return SiglaPIE;
	}

	public void setSiglaPIE(String siglaPIE) {
		SiglaPIE = siglaPIE;
	}

	public String getNomePIE() {
		return NomePIE;
	}

	public void setNomePIE(String nomePIE) {
		NomePIE = nomePIE;
	}

	public int getInstitui��o_id() {
		return Institui��o_id;
	}

	public void setInstitui��o_id(int institui��o_id) {
		Institui��o_id = institui��o_id;
	}

}
