package br.edu.ifpb.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpb.Banco;
import br.edu.ifpb.entidades.Institui��o;

import com.mysql.jdbc.PreparedStatement;

public class Institui��oDAO {

	// a conex�o com o banco de dados
	public Connection connection;
	
	public Institui��oDAO(Banco banco) {
		this.connection = (Connection) banco.getConnection();
	}
	
	
	
	// Adicinando uma nova institui��o ao banco
		public void adiciona(Institui��o institui��o) {

			// Cria um insert, com os atributos, e os valores sem defini��o, apenas
			// com a quantidade de valores a ser inseridos (representado por "?").
			String sql = "INSERT INTO institui��o (nome_institui��o, sigla, or�amento)"
					+ " values (?,?,?)";

			try {
				// prepared statement para inser��o
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

		// Alterar dados da institui��o, a partir do id_institui��o(chave prim�ria).
		public void alterar(Institui��o institui��o) {

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
		
		// Deletar Institui��o a partir do ID_institui��o(chave prim�ria)
		public void deletar(Institui��o institui��o) {
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

}
