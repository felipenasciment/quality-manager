package br.edu.ifpb.dao;

import java.sql.SQLException;

import br.edu.ifpb.Banco;
import br.edu.ifpb.entidades.EditalPesquisa;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/*								Dados da tabela
	N_ANO, Inicio_das_inscri��es, Fim_das_escri��es, Ano, Prazo_do_relat�rio_parcial,
	Prazo_do_relat�rio_final, N�mero_de_vagas, Valor_bolsa_docente, Valor_bolsa_discente,
	PIE_Id_Programa 
*/

public class EditalPesquisaDAO {
	
	public Connection connection;

	public EditalPesquisaDAO(Banco banco) {
		
		this.connection = (Connection) banco.getConnection();		
	}
	
	
	// Adicinando um novo Edital de Exten��o ao banco
	public void adiciona(EditalPesquisa edital) {

		// Cria um insert, com os atributos, e os valores sem defini��o, apenas
		// com a quantidade de valores a ser inseridos (representado por "?").
		String sql = "INSERT INTO editalpesquisa (N_ano, �nicioinscri��es, fiminscri��es,"
				+ " ano, prazorelat�rioparcial, prazorelat�riofinal, n�merovagas,"
				+ " valorbolsadocente, valorbolsadiscente, PIP_ID)"
				+ " values (?,?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, edital.getN_ano());
			stmt.setDate(2, edital.get�nicioInscri��es());
			stmt.setDate(3, edital.getFimInscri��es());
			stmt.setString(4, edital.getAno());
			stmt.setDate(5, edital.getPrazoRelat�rioParcial());
			stmt.setDate(6, edital.getPrazoRelatorioFinal());
			stmt.setInt(7, edital.getN�meroDeVagas());
			stmt.setDouble(8, edital.getValorBolsaDocente());
			stmt.setDouble(9, edital.getValorBolsaDiscente());
			stmt.setInt(10, edital.getPIP_ID());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Alterar dados do discente, a partir do CPF(chave prim�ria).
	public void alterar(EditalPesquisa edital) {

		String sql = "UPDATE editalpesquisa SET inicioinscri��es=?, fiminscri��es=?, ano=?,"
				+ " prazorelat�rioparcial=?, prazorelat�riofinal=?, n�merovagas=?,"
				+ " valorbolsadocente=?, valorbolsadiscente=?, PIE_ID=? WHERE N_ano=?";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDate(1, edital.get�nicioInscri��es());
			stmt.setDate(2, edital.getFimInscri��es());
			stmt.setString(3, edital.getAno());
			stmt.setDate(4, edital.getPrazoRelat�rioParcial());
			stmt.setDate(5, edital.getPrazoRelatorioFinal());
			stmt.setInt(6, edital.getN�meroDeVagas());
			stmt.setDouble(7, edital.getValorBolsaDocente());
			stmt.setDouble(8, edital.getValorBolsaDiscente());
			stmt.setInt(9, edital.getPIP_ID());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
		
		// Deletar discente a partir do CPF(chave prim�ria)
		public void deletar(EditalPesquisa edital) {
			String sql = "DELETE FROM editalpesquisa WHERE N_ano=?";
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setString(1, edital.getN_ano());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	
	

}
