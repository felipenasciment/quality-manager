package br.edu.ifpb.dao;

import br.edu.ifpb.entidades.Entidade;
import br.edu.ifpb.exce��es.ClasseInv�lidaException;

public interface DAO {
	
	// Padr�o CRUD para Database
	
	// fun��o padr�o para inser��o no banco de dados
	public void creat(Entidade entidade) throws ClasseInv�lidaException;
	
	// fun��o padr�o para sele��o no banco de dados
	public void read(Entidade entidade) throws ClasseInv�lidaException;
	
	// fun��o padr�o para altera��o no banco de dados
	public void update(Entidade entidade) throws ClasseInv�lidaException;
	
	// fun��o padr�o para exclus�o no banco de dados
	public void delete(Entidade entidade) throws ClasseInv�lidaException;
	
}
