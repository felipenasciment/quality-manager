package br.edu.ifpb.dao;

import java.sql.SQLException;

import br.edu.ifpb.Banco;
import br.edu.ifpb.entidades.EditalExtens�o;
import br.edu.ifpb.entidades.Entidade;
import br.edu.ifpb.exce��es.ClasseInv�lidaException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

// Campos da tabela
// N_ano, in�cio_inscri��es, fim_inscri��es, ano, prazo_relat�rio_parcial, prazo_relat�rio_final, n�mero_vagas, valor_bolsa_docente, valor_bolsa_discente, PIE_ID

public class EditalExtens�oDAO implements DAO {
	
	public Connection connection;

	public EditalExtens�oDAO(Banco banco) {		
		this.connection = (Connection) banco.getConnection();		
	}

	@Override
	public void creat(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.EditalExtens�o")) {
			EditalExtens�o edital = (EditalExtens�o) entidade;
			
			// Cria um insert com os atributos e os valores sem defini��o, apenas
			// com a quantidade de valores a ser inseridos (representado por "?").
			String sql = "INSERT INTO edital_extens�o (N_ano, in�cio_inscri��es,"
					+ " fim_escri��es, ano, prazo_relat�rio_parcial, prazo_relat�rio_final,"
					+ " n�mero_vagas, valor_bolsa_docente, valor_bolsa_discente,"
					+ " PIE_ID) values (?,?,?,?,?,?,?,?,?,?)";

			try {
				// prepara para inser��o
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
		else {
			throw new ClasseInv�lidaException();
		}
	}

	@Override
	public void read(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.EditalExtens�o")) {
			
		}
		else {
			throw new ClasseInv�lidaException();
		}
	}

	@Override
	public void update(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.EditalExtens�o")) {
			EditalExtens�o edital = (EditalExtens�o) entidade;
			
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
		else {
			throw new ClasseInv�lidaException();
		}
	}

	@Override
	public void delete(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.EditalExtens�o")) {
			EditalExtens�o edital = (EditalExtens�o) entidade;
			
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
		else {
			throw new ClasseInv�lidaException();
		}
	}

}
