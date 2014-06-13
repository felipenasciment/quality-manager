package br.edu.ifpb.dao;

import java.sql.SQLException;

import br.edu.ifpb.Banco;
import br.edu.ifpb.entidades.Entidade;
import br.edu.ifpb.entidades.ProgramaInstitucionalExtens�o;
import br.edu.ifpb.exce��es.ClasseInv�lidaException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

// Campos da tabela
// ID_PIE, sigla_PIE, nome_PIE, institui��o_ID

// PIE = Programa Institucional de Extens�o

public class ProgramaInstitucionalExtens�oDAO implements DAO {
	
	public Connection connection;

	public ProgramaInstitucionalExtens�oDAO(Banco banco) {
		this.connection = (Connection) banco.getConnection();			
	}

	@Override
	public void creat(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.ProgramaInstitucionalExtens�o")) {
			ProgramaInstitucionalExtens�o pie = (ProgramaInstitucionalExtens�o) entidade;
			
			// Cria um insert com os atributos e os valores sem defini��o, apenas
			// com a quantidade de valores a ser inseridos (representado por "?").
			String sql = "INSERT INTO pie (sigla_PIE, nome_PIE, institui��o_ID)"
					+ " values (?,?,?)";

			try {
				// prepara para inser��o
				PreparedStatement stmt = (PreparedStatement) connection
						.prepareStatement(sql);
				// seta os valores
				stmt.setString(1, pie.getSiglaPIE());
				stmt.setString(2, pie.getNomePIE());
				stmt.setInt(3, pie.getInstitui��oID());
				
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
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.ProgramaInstitucionalExtens�o")) {
			
		}
		else {
			throw new ClasseInv�lidaException();
		}
	}

	@Override
	public void update(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.ProgramaInstitucionalExtens�o")) {
			ProgramaInstitucionalExtens�o pie = (ProgramaInstitucionalExtens�o) entidade;
			
			String sql = "UPDATE pie SET sigla_PIP=?, nome_PIP=?, institui��o_ID=?)"
					+ " WHERE ID_PIE=?";

			try {
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setString(1, pie.getSiglaPIE());
				stmt.setString(2, pie.getNomePIE());
				stmt.setInt(3, pie.getInstitui��oID());
				stmt.setInt(4, pie.getID_PIE());
				
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
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.ProgramaInstitucionalExtens�o")) {
			ProgramaInstitucionalExtens�o pie = (ProgramaInstitucionalExtens�o) entidade;
			
			String sql = "DELETE FROM pie WHERE ID_PIE=?";
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setInt(1, pie.getID_PIE());
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
