package br.edu.ifpb.entidades;

// Campos da tabela
// ID_PIE, sigla_PIE, nome_PIE, institui��o_ID

// PIE = Programa Institucional de Extens�o

public class ProgramaInstitucionalExtens�o implements Entidade {
	
	private int ID_PIE; 
	private String SiglaPIE;
	private String NomePIE;
	private int Institui��oID;
	
	/* Construtor utilizado para a cria��o de um objeto ProgramaInstitucionalExtens�o quando for inserir
	 * um novo Programa Institucional de Extens�o ao sistema, de modo que a vari�vel
	 * Id_PIE n�o precise ser setada (O pr�prio banco de dados define qual ser� o valor do
	 * Id da ProgramaInstitucionalExtens�o).
	 */
	public ProgramaInstitucionalExtens�o(String siglaPIE, String nomePIE, int institui��oID) {

		setSiglaPIE(siglaPIE);
		setNomePIE(nomePIE);
		setInstitui��oID(institui��oID);
		
	}
	
	/* Para as demais consultas, quando for preciso montar um ProgramaInstitucionalExtens�o j� existente,
	 * deve ser usado esse construtor, pois � necess�rio recuperar o ID da Institui��o.
	 */
	public ProgramaInstitucionalExtens�o(int id_PIE, String siglaPIE, String nomePIE, int institui��oID) {
		
		setID_PIE(id_PIE);
		setSiglaPIE(siglaPIE);
		setNomePIE(nomePIE);
		setInstitui��oID(institui��oID);
		
	}

	public int getID_PIE() {
		return ID_PIE;
	}

	public void setID_PIE(int id_PIE) {
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

	public int getInstitui��oID() {
		return Institui��oID;
	}

	public void setInstitui��oID(int institui��oID) {
		Institui��oID = institui��oID;
	}

}
