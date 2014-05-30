package br.edu.ifpb.entidades;

//	Campos da tabela
// Id_programa, SiglaPIP, NomePIP, Institui��o_idInstitui��o

//PIP = Programa Institucional de Pesquisa

public class ProgramaInstitucionalPesquisa {
	
	private int Id_PIP; 
	private String SiglaPIP;
	private String NomePIP;
	private int Institui��o_id;
	
	/* Construtor utilizado para a cria��o de um objeto ProgramaInstitucionalPesquisa quando for inserir
	 * um novo Programa Institucional de Pesquisa ao sistema, de modo que a vari�vel
	 * Id_PIP n�o precise ser setada (O pr�prio banco de dados define qual ser� o valor do
	 * Id da ProgramaInstitucionalPesquisa).
	 */
	public ProgramaInstitucionalPesquisa(String siglaPIP, String nomePIP, int institui��o_id) {

		setSiglaPIP(siglaPIP);
		setNomePIP(nomePIP);
		setInstitui��o_id(institui��o_id);
		
	}
	
	/* Para as demais consultas, quando for preciso montar um ProgramaInstitucionalPesquisa j� existente,
	 * deve ser usado esse construtor, pois � necess�rio recuperar o ID da Institui��o.
	 */
	public ProgramaInstitucionalPesquisa(int id_PIP, String siglaPIP, String nomePIP, int institui��o_id) {
		
		setId_PIP(id_PIP);
		setSiglaPIP(siglaPIP);
		setNomePIP(nomePIP);
		setInstitui��o_id(institui��o_id);
		
	}

	public int getId_PIP() {
		return Id_PIP;
	}

	public void setId_PIP(int id_PIP) {
		Id_PIP = id_PIP;
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

	public int getInstitui��o_id() {
		return Institui��o_id;
	}

	public void setInstitui��o_id(int institui��o_id) {
		Institui��o_id = institui��o_id;
	}

}
