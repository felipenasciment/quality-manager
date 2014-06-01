package br.edu.ifpb.entidades;

import java.sql.Date;

// Campos da tabela
// ID_evento, nome, descri��o, localidade, ano, in�cio_evento, fim_evento, �rea_atua��o

public class Evento {
	
	private int IDEvento;
	private String Nome;
	private String Descri��o;
	private String Localidade; 
	private String Ano;
	private Date In�cioEvento;
	private Date FimEvento;
	private String �reaAtua��o;
	
	/* Construtor utilizado para a cria��o de um objeto Evento quando for inserir
	 * um novo Evento ao sistema, de modo que a vari�vel
	 * id_evento n�o precise ser setada (O pr�prio banco de dados define qual ser� o valor do
	 * identificador do evento).
	 */
	public Evento(String nome, String descri��o, String localidade, String ano,
			Date in�cioEvento, Date fimEvento, String �reaAtua��o) {
		
		setNome(nome);
		setDescri��o(descri��o);
		setLocalidade(localidade);
		setAno(ano);
		setIn�cioEvento(in�cioEvento);
		setFimEvento(fimEvento);
		set�reaAtua��o(�reaAtua��o);
		
	}
	
	/* Para as demais consultas, quando for preciso montar um Evento j� existente,
	 * deve ser usado esse construtor, pois � necess�rio recuperar o ID da Evento.
	 */	
	public Evento(int idEvento, String nome, String descri��o, String localidade,
			String ano,	Date in�cioEvento, Date fimEvento, String �reaAtua��o) {
		
		setIDEvento(idEvento);
		setNome(nome);
		setDescri��o(descri��o);
		setLocalidade(localidade);
		setAno(ano);
		setIn�cioEvento(in�cioEvento);
		setFimEvento(fimEvento);
		set�reaAtua��o(�reaAtua��o);
		
	}

	public int getIDEvento() {
		return IDEvento;
	}

	public void setIDEvento(int iDEvento) {
		IDEvento = iDEvento;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescri��o() {
		return Descri��o;
	}

	public void setDescri��o(String descri��o) {
		Descri��o = descri��o;
	}

	public String getLocalidade() {
		return Localidade;
	}

	public void setLocalidade(String localidade) {
		Localidade = localidade;
	}

	public String getAno() {
		return Ano;
	}

	public void setAno(String ano) {
		Ano = ano;
	}

	public Date getIn�cioEvento() {
		return In�cioEvento;
	}

	public void setIn�cioEvento(Date in�cioEvento) {
		In�cioEvento = in�cioEvento;
	}

	public Date getFimEvento() {
		return FimEvento;
	}

	public void setFimEvento(Date fimEvento) {
		FimEvento = fimEvento;
	}

	public String get�reaAtua��o() {
		return �reaAtua��o;
	}

	public void set�reaAtua��o(String �reaAtua��o) {
		�reaAtua��o = �reaAtua��o;
	}

}
