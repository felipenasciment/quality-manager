package br.edu.ifpb.entidades;

// Campos da tabela
// ID_PIP, sigla_PIP, nome_PIP, institui��o_ID

// PIP = Programa Institucional de Pesquisa

public class ProgramaInstitucionalPesquisa {
	
	private int ID_PIP;
	private String SiglaPIP;
	private String NomePIP;
	private int Institui��oID;
	
	/* Construtor utilizado para a cria��o de um objeto ProgramaInstitucionalPesquisa quando for inserir
	 * um novo Programa Institucional de Pesquisa ao sistema, de modo que a vari�vel
	 * Id_PIP n�o precise ser setada (O pr�prio banco de dados define qual ser� o valor do
	 * Id da ProgramaInstitucionalPesquisa).
	 */
	public ProgramaInstitucionalPesquisa(String siglaPIP, String nomePIP, int institui��oID) {

		setSiglaPIP(siglaPIP);
		setNomePIP(nomePIP);
		setInstitui��oID(institui��oID);
		
	}
	
	/* Para as demais consultas, quando for preciso montar um ProgramaInstitucionalPesquisa j� existente,
	 * deve ser usado esse construtor, pois � necess�rio recuperar o ID da Institui��o.
	 */
	public ProgramaInstitucionalPesquisa(int id_PIP, String siglaPIP, String nomePIP, int institui��oID) {
		
		setID_PIP(id_PIP);
		setSiglaPIP(siglaPIP);
		setNomePIP(nomePIP);
		setInstitui��oID(institui��oID);
		
	}

	public int getID_PIP() {
		return ID_PIP;
	}

	public void setID_PIP(int id_PIP) {
		ID_PIP = id_PIP;
	}

	public String getSiglaPIP() {
		return SiglaPIP;
	}

	public void setSiglaPIP(String siglaPIP) {
		SiglaPIP = siglaPIP;
	}

	public String getNomePIP() {
		return NomePIP;
	}

	public void setNomePIP(String nomePIP) {
		NomePIP = nomePIP;
	}

	public int getInstitui��oID() {
		return Institui��oID;
	}

	public void setInstitui��oID(int institui��oID) {
		Institui��oID = institui��oID;
	}

}
