package br.edu.ifpb.entidades;

//	Campos da tabela
// Id_programa, SiglaPIP, NomePIP, Institui��o_idInstitui��o

//PIP = Programa Institucional de Pesquisa

public class ProgramaInstitucionalExtens�o {
	
	private int ID_PIE; 
	private String SiglaPIE;
	private String NomePIE;
	private int Institui��o_ID;
	
	/* Construtor utilizado para a cria��o de um objeto ProgramaInstitucionalExtens�o quando for inserir
	 * um novo Programa Institucional de Extens�o ao sistema, de modo que a vari�vel
	 * Id_PIE n�o precise ser setada (O pr�prio banco de dados define qual ser� o valor do
	 * Id da ProgramaInstitucionalExtens�o).
	 */
	public ProgramaInstitucionalExtens�o(String siglaPIE, String nomePIE, int institui��o_ID) {

		setSiglaPIE(siglaPIE);
		setNomePIE(nomePIE);
		setInstitui��o_ID(institui��o_ID);
		
	}
	
	/* Para as demais consultas, quando for preciso montar um ProgramaInstitucionalExtens�o j� existente,
	 * deve ser usado esse construtor, pois � necess�rio recuperar o ID da Institui��o.
	 */
	public ProgramaInstitucionalExtens�o(int id_PIE, String siglaPIE, String nomePIE, int institui��o_ID) {
		
		setId_PIE(id_PIE);
		setSiglaPIE(siglaPIE);
		setNomePIE(nomePIE);
		setInstitui��o_ID(institui��o_ID);
		
	}

	public int getID_PIE() {
		return ID_PIE;
	}

	public void setId_PIE(int id_PIE) {
		ID_PIE = id_PIE;
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

	public int getInstitui��o_ID() {
		return Institui��o_ID;
	}

	public void setInstitui��o_ID(int institui��o_id) {
		Institui��o_ID = institui��o_id;
	}

}
