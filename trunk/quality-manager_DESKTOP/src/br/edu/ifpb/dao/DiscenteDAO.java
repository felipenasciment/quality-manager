package br.edu.ifpb.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpb.Banco;
import br.edu.ifpb.entidades.Discente;
import br.edu.ifpb.entidades.Entidade;
import br.edu.ifpb.exce��es.ClasseInv�lidaException;

import com.mysql.jdbc.PreparedStatement;

// Campos da tabela
// CPF, matr�cula, nome, curso, endere�o, CEP, telefone, e_mail

public class DiscenteDAO implements DAO {
	// a conex�o com o banco de dados
	public Connection connection;

	public DiscenteDAO(Banco b) {
		this.connection = (Connection) b.getConnection();
	}

	@Override
	public void creat(Entidade entidade) throws ClasseInv�lidaException {
		
		if(entidade.getClass().equals("class br.edu.br.Discente")) {
			
			Discente discente = (Discente) entidade;
			
			// Cria um insert, com os atributos, e os valores sem defini��o, apenas
			// com a quantidade de valores a ser inseridos (representado por "?").
			String sql = "INSERT INTO discente (CPF, matr�cula, nome, curso, endere�o, CEP,"
					+ " telefone, e_mail) values (?,?,?,?,?,?,?,?)";

			try {
				// prepared statement para inser��o
				PreparedStatement stmt = (PreparedStatement) connection
						.prepareStatement(sql);
				// seta os valores
				stmt.setString(1, discente.getCPF());
				stmt.setString(2, discente.getMatr�cula());
				stmt.setString(3, discente.getNome());
				stmt.setInt(4, discente.getCurso().getIDCurso());
				stmt.setString(5, discente.getEndere�o());
				stmt.setString(6, discente.getCEP());
				stmt.setString(7, discente.getTelefone());
				stmt.setString(8, discente.getEmail());

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
		
	}

	@Override
	public void update(Entidade entidade) throws ClasseInv�lidaException {
		
		if(entidade.getClass().equals("class br.edu.br.Discente")) {
			
			Discente discente = (Discente) entidade;
			
			String sql = "UPDATE discente set matr�cula=?, nome=?, curso=?,"
					+ " endere�o=?, CEP=?, telefone=?, e_mail=? WHERE CPF=?";

			try {
				PreparedStatement stmt = (PreparedStatement) connection
						.prepareStatement(sql);
				stmt.setString(1, discente.getMatr�cula());
				stmt.setString(2, discente.getNome());
				stmt.setInt(3, discente.getCurso().getIDCurso());
				stmt.setString(4, discente.getEndere�o());
				stmt.setString(5, discente.getCEP());
				stmt.setString(6, discente.getTelefone());
				stmt.setString(7, discente.getEmail());
				stmt.setString(8, discente.getCPF());

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
		
		if(entidade.getClass().equals("class br.edu.br.Discente")) {
			Discente discente = (Discente) entidade;
			
			String sql = "DELETE FROM discente WHERE CPF=?";
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setString(1, discente.getCPF());
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