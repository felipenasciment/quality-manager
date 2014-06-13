package br.edu.ifpb.dao;

import java.sql.SQLException;

import br.edu.ifpb.Banco;
import br.edu.ifpb.entidades.Entidade;
import br.edu.ifpb.entidades.ProgramaInstitucionalPesquisa;
import br.edu.ifpb.exce��es.ClasseInv�lidaException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

//Campos da tabela
//ID_PIP, sigla_PIP, nome_PIP, institui��o_ID

//PIP = Programa Institucional de Pesquisa

public class ProgramaInstitucionalPesquisaDAO implements DAO {
	
	public Connection connection;

	public ProgramaInstitucionalPesquisaDAO(Banco banco) {
		this.connection = (Connection) banco.getConnection();
	}

	@Override
	public void creat(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.ProgramaInstitucionalPesquisa")) {
			ProgramaInstitucionalPesquisa pip = (ProgramaInstitucionalPesquisa) entidade;
			
			// Cria um insert com os atributos e os valores sem defini��o, apenas
			// com a quantidade de valores a ser inseridos (representado por "?").
			String sql = "INSERT INTO pip (sigla_PIP, nome_PIP, institui��o_ID)"
					+ " values (?,?,?)";

			try {
				// prepara para inser��o
				PreparedStatement stmt = (PreparedStatement) connection
						.prepareStatement(sql);
				// seta os valores
				stmt.setString(1, pip.getSiglaPIP());
				stmt.setString(2, pip.getNomePIP());
				stmt.setInt(3, pip.getInstitui��oID());
				
				// executa
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		else {
			throw new ClasseInv�lidaException();
		}
	}


	@Override
	public void read(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.ProgramaInstitucionalPesquisa")) {
			
		}
		else {
			throw new ClasseInv�lidaException();
		}
	}


	@Override
	public void update(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.ProgramaInstitucionalPesquisa")) {
			ProgramaInstitucionalPesquisa pip = (ProgramaInstitucionalPesquisa) entidade;
			
			String sql = "UPDATE pip SET sigla_PIP=?, nome_PIP=?, institui��o_ID=?)"
					+ " WHERE ID_PIP=?";

			try {
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setString(1, pip.getSiglaPIP());
				stmt.setString(2, pip.getNomePIP());
				stmt.setInt(3, pip.getInstitui��oID());
				stmt.setInt(4, pip.getID_PIP());
				
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		else {
			throw new ClasseInv�lidaException();
		}
	}


	@Override
	public void delete(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.ProgramaInstitucionalPesquisa")) {
			ProgramaInstitucionalPesquisa pip = (ProgramaInstitucionalPesquisa) entidade;
			
			String sql = "DELETE FROM pip WHERE ID_PIP=?";
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setInt(1, pip.getID_PIP());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			throw new ClasseInv�lidaException();
		}
	}

}
