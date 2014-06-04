package br.edu.ifpb.dao;

import java.sql.SQLException;

import br.edu.ifpb.Banco;
import br.edu.ifpb.entidades.EditalExtens�o;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

// Campos da tabela
// N_ano, in�cio_inscri��es, fim_inscri��es, ano, prazo_relat�rio_parcial, prazo_relat�rio_final, n�mero_vagas, valor_bolsa_docente, valor_bolsa_discente, PIE_ID

public class EditalExtens�oDAO {
	
	public Connection connection;

	public EditalExtens�oDAO(Banco banco) {		
		this.connection = (Connection) banco.getConnection();		
	}
	
	// Adicinando um novo Edital de Exten��o ao banco
	public void adiciona(EditalExtens�o edital) {

		// Cria um insert, com os atributos, e os valores sem defini��o, apenas
		// com a quantidade de valores a ser inseridos (representado por "?").
		String sql = "INSERT INTO edital_extens�o (N_ano, in�cio_inscri��es,"
				+ " fim_escri��es, ano, prazo_relat�rio_parcial, prazo_relat�rio_final,"
				+ " n�mero_vagas, valor_bolsa_docente, valor_bolsa_discente,"
				+ " PIE_ID) values (?,?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, edital.getNAno());
			stmt.setDate(2, edital.getIn�cioInscri��es());
			stmt.setDate(3, edital.getFimInscri��es());
			stmt.setString(4, edital.getAno());
			stmt.setDate(5, edital.getPrazoRelat�rioParcial());
			stmt.setDate(6, edital.getPrazoRelat�rioFinal());
			stmt.setInt(7, edital.getN�meroVagas());
			stmt.setDouble(8, edital.getValorBolsaDocente());
			stmt.setDouble(9, edital.getValorBolsaDiscente());
			stmt.setInt(10, edital.getPIE_ID());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Alterar dados do Edital de Extens�o, a partir do N_ano(chave prim�ria).
	public void alterar(EditalExtens�o edital) {

		String sql = "UPDATE edital_extens�o SET in�cio_inscri��es=?, fim_escri��es=?,"
				+ " ano=?, prazo_relat�rio_parcial=?, prazo_relat�rio_final=?, n�mero_vagas=?,"
				+ " valor_bolsa_docente=?, valor_bolsa_discente=?,"
				+ " PIE_ID=? WHERE N_ano=?";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDate(1, edital.getIn�cioInscri��es());
			stmt.setDate(2, edital.getFimInscri��es());
			stmt.setString(3, edital.getAno());
			stmt.setDate(4, edital.getPrazoRelat�rioParcial());
			stmt.setDate(5, edital.getPrazoRelat�rioFinal());
			stmt.setInt(6, edital.getN�meroVagas());
			stmt.setDouble(7, edital.getValorBolsaDocente());
			stmt.setDouble(8, edital.getValorBolsaDiscente());
			stmt.setInt(9, edital.getPIE_ID());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
		
	// Deletar Edital de Entens�o a partir do N_ano(chave prim�ria)
	public void deletar(EditalExtens�o edital) {
		String sql = "DELETE FROM edital_extens�o WHERE N_ano=?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, edital.getNAno());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
