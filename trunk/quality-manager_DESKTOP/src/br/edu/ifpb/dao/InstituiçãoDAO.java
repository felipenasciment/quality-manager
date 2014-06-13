package br.edu.ifpb.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpb.Banco;
import br.edu.ifpb.entidades.Entidade;
import br.edu.ifpb.entidades.Institui��o;
import br.edu.ifpb.exce��es.ClasseInv�lidaException;

import com.mysql.jdbc.PreparedStatement;

// Campos da tabela
// ID_institui��o, nome_institui��o, sigla, or�amento

public class Institui��oDAO implements DAO {

	// a conex�o com o banco de dados
	public Connection connection;
	
	public Institui��oDAO(Banco banco) {
		this.connection = (Connection) banco.getConnection();
	}

	@Override
	public void creat(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.Institui��o")) {
			Institui��o institui��o = (Institui��o) entidade;
			
			// Cria um insert com os atributos e os valores sem defini��o, apenas
			// com a quantidade de valores a ser inseridos (representado por "?").
			String sql = "INSERT INTO institui��o (nome_institui��o, sigla, or�amento)"
					+ " values (?,?,?)";

			try {
				// prepara para inser��o
				PreparedStatement stmt = (PreparedStatement) connection
						.prepareStatement(sql);
				// seta os valores
				stmt.setString(1, institui��o.getNomeInstitui��o());
				stmt.setString(2, institui��o.getSigla());
				stmt.setDouble(3, institui��o.getOr�amento());
				
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
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.Institui��o")) {
			
		}
		else {
			throw new ClasseInv�lidaException();
		}
	}

	@Override
	public void update(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.Institui��o")) {
			Institui��o institui��o = (Institui��o) entidade;
			
			String sql = "UPDATE institui��o SET nome_institui��o=?, sigla=?, or�amento=?"
					+ " WHERE ID_institui��o=?";

			try {
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setString(1, institui��o.getNomeInstitui��o());
				stmt.setString(2, institui��o.getSigla());
				stmt.setDouble(3, institui��o.getOr�amento());
				stmt.setInt(4, institui��o.getIDInstitui��o());

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
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.Institui��o")) {
			Institui��o institui��o = (Institui��o) entidade;
			
			String sql = "DELETE FROM institui��o WHERE ID_institui��o=?";
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setInt(1, institui��o.getIDInstitui��o());
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
