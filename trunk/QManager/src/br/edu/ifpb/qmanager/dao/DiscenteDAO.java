package br.edu.ifpb.qmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Banco;
import br.edu.ifpb.qmanager.entidade.Discente;
import br.edu.ifpb.qmanager.entidade.Turma;
import br.edu.ifpb.qmanager.excecao.QManagerSQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DiscenteDAO implements GenericDAO<Integer, Discente> {

	// a conexão com o banco de dados
	public Banco banco;
	public Connection connection;

	private PessoaDAO pessoaDAO;

	public DiscenteDAO(Banco banco) {
		this.banco = banco;
		this.connection = (Connection) banco.getConnection();
		pessoaDAO = new PessoaDAO(banco);
	}

	@Override
	public Discente getById(Integer id) throws QManagerSQLException {

		Discente discente = null;

		try {

			String sql = String
					.format("%s %d",
							"SELECT P.id_pessoa, P.nm_pessoa, P.nr_cpf, P.nr_matricula, P.nm_endereco, P.nm_cep, P.nm_telefone, P.nm_email,"
									+ " D.turma_id, P.dt_registro"
									+ " FROM `tb_discente` D"
									+ " INNER JOIN `tb_pessoa` P ON D.`pessoa_id` = P.`id_pessoa`"
									+ " WHERE D.`pessoa_id`=", id);

			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			List<Discente> discentes = convertToList(rs);

			discente = discentes.get(0);

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return discente;
	}

	@Override
	public int insert(Discente discente) throws QManagerSQLException {

		// Inserir Pessoa
		int idPessoa = pessoaDAO.insert(discente);

		try {
			String sql = String.format("%s %s ('%s', '%s')",
					"INSERT INTO `tb_discente` (`pessoa_id`, `turma_id`)",
					"VALUES", idPessoa, discente.getTurma().getIdTurma());

			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			// envia para o Banco e fecha o objeto
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.close();

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return idPessoa;

	}

	@Override
	public void update(Discente discente) throws QManagerSQLException {

		pessoaDAO.update(discente);

		try {

			String sql = "UPDATE `tb_discente` SET `turma_id`=?"
					+ " WHERE `pessoa_id`=?";

			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, discente.getTurma().getIdTurma());
			stmt.setInt(2, discente.getPessoaId());

			// envia para o Banco e fecha o objeto
			stmt.execute();

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}
	}

	@Override
	public void delete(Integer id) throws QManagerSQLException {

		try {

			// Deleta uma tupla setando o atributo de identificação com
			// valor representado por ?
			String sql = "DELETE FROM `tb_discente` WHERE `pessoa_id`=?";

			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, id);

			// envia para o Banco e fecha o objeto
			stmt.execute();
			stmt.close();

			pessoaDAO.delete(id);

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}
	}

	@Override
	public List<Discente> findAll() throws QManagerSQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Discente> convertToList(ResultSet rs)
			throws QManagerSQLException {

		List<Discente> discentes = new ArrayList<Discente>();

		Discente discente = new Discente();
		Turma turma = new Turma();
		TurmaDAO turmaDAO = new TurmaDAO(banco);

		try {

			while (rs.next()) {

				// tabela pessoa
				discente.setPessoaId(rs.getInt("P.id_pessoa"));
				discente.setNomePessoa(rs.getString("P.nm_pessoa"));
				discente.setCpf(rs.getString("P.nr_cpf"));
				discente.setMatricula(rs.getString("P.nr_matricula"));
				discente.setEndereco(rs.getString("P.nm_endereco"));
				discente.setCep(rs.getString("P.nm_cep"));
				discente.setTelefone(rs.getString("P.nm_telefone"));
				discente.setEmail(rs.getString("P.nm_email"));
				discente.setRegistro(rs.getDate("P.dt_registro"));

				// tabela discente
				turma = turmaDAO.getById(rs.getInt("D.turma_id"));
				discente.setTurma(turma);

				discentes.add(discente);

			}

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return discentes;
	}
}