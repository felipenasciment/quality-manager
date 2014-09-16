package br.edu.ifpb.qmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.qmanager.entidade.Pessoa;
import br.edu.ifpb.qmanager.excecao.QManagerSQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/* serve de fatoração comum de código para Discente e Docente */
public class PessoaDAO implements GenericDAO<Integer, Pessoa> {

	// a conexão com o banco de dados
	public Connection connection;

	public PessoaDAO(DatabaseConnection banco) {
		this.connection = (Connection) banco.getConnection();
	}

	@Override
	public Pessoa getById(Integer id) throws QManagerSQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Pessoa pessoa) throws QManagerSQLException {

		int chave = 0;

		try {

			// Define um insert com os atributos e cada valor é representado por
			// ?
			String sql = String
					.format("%s %s ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
							"INSERT INTO `tb_pessoa` (`nm_pessoa`, `nr_cpf`, `nr_matricula`, `nm_endereco`, `nm_cep`, `nm_telefone`, `nm_email`)",
							"VALUES", pessoa.getNomePessoa(), pessoa.getCpf(),
							pessoa.getMatricula(), pessoa.getEndereco(),
							pessoa.getCep(), pessoa.getTelefone(),
							pessoa.getEmail());

			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			// envia para o Banco e fecha o objeto
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			chave = BancoUtil.getGenerateKey(stmt);

			stmt.close();

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return chave;

	}

	@Override
	public void update(Pessoa pessoa) throws QManagerSQLException {

		try {
						
			// Define um update com os atributos e cada valor é representado por
			// ?
			String sql = "UPDATE `tb_pessoa` SET `nm_pessoa`=?, `nr_cpf`=?, `nr_matricula`=?, `nm_endereco`=?, `nm_cep`=?, `nm_telefone`=?, `nm_email`=?"
					+ " WHERE `id_pessoa`=?";

			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, pessoa.getNomePessoa());
			stmt.setString(2, pessoa.getCpf());
			stmt.setString(3, pessoa.getMatricula());
			stmt.setString(4, pessoa.getEndereco());
			stmt.setString(5, pessoa.getCep());
			stmt.setString(6, pessoa.getTelefone());
			stmt.setString(7, pessoa.getEmail());
			stmt.setInt(8, pessoa.getPessoaId());

			// envia para o Banco e fecha o objeto
			stmt.execute();
			stmt.close();

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

	}

	@Override
	public void delete(Integer id) throws QManagerSQLException {

		try {

			String sql = "DELETE FROM `tb_pessoa` WHERE `id_pessoa`=?";

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, id);

			// envia para o Banco e fecha o objeto
			stmt.execute();
			stmt.close();

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

	}

	@Override
	public List<Pessoa> findAll() throws QManagerSQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> convertToList(ResultSet rs) throws QManagerSQLException {
		// TODO Auto-generated method stub
		return null;
	}
}