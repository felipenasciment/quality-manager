package br.edu.ifpb.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpb.Banco;
import br.edu.ifpb.entidades.Docente;

import com.mysql.jdbc.PreparedStatement;

// Campos da tabela
// CPF, matr�cula, nome, cargo, endere�o, CEP, telefone, e_mail, titula��o, local_trabalho

public class DocenteDAO  {
	// a conex�o com o banco de dados
	public Connection connection;

	public DocenteDAO(Banco banco) {
		this.connection = (Connection) banco.getConnection();
	}

	// Adicinando um novo docente ao banco
	public void adiciona(Docente docente) {

		// Cria um insert, com os atributos, e os valores sem defini��o, apenas
		// com a quantidade de valores a ser inseridos (representado por "?").
		String sql = "INSERT INTO docente (CPF, matr�cula, nome, cargo, endere�o, CEP,"
				+ " telefone, e_mail, titula��o, local_trabalho) values (?,?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, docente.getCPF());
			stmt.setString(2, docente.getMatr�cula());
			stmt.setString(3, docente.getNome());
			stmt.setString(4, docente.getCargo());
			stmt.setString(5, docente.getEndere�o());
			stmt.setString(6, docente.getCEP());
			stmt.setString(7, docente.getTelefone());
			stmt.setString(8, docente.getEmail());
			stmt.setString(9, docente.getTitula��o());
			stmt.setString(10, docente.getLocalTrabalho());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Alterar dados do discente, a partir do CPF(chave prim�ria).
	public void alterar(Docente docente) {

		String sql = "UPDATE docente SET matr�cula=?, nome=?, Cargo=?, endere�o=?,"
				+ " CEP=?, telefone=?, e_mail=?, titula��o=?, local_trabalho=?"
				+ " WHERE CPF=?";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, docente.getMatr�cula());
			stmt.setString(2, docente.getNome());
			stmt.setString(3, docente.getCargo());
			stmt.setString(4, docente.getEndere�o());
			stmt.setString(5, docente.getCEP());
			stmt.setString(6, docente.getTelefone());
			stmt.setString(7, docente.getEmail());
			stmt.setString(8, docente.getTitula��o());
			stmt.setString(9, docente.getLocalTrabalho());
			stmt.setString(10, docente.getCPF());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	// Deletar discente a partir do CPF(chave prim�ria)
	public void deletar(Docente docente) {
		String sql = "DELETE FROM docente WHERE CPF=?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, docente.getCPF());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}