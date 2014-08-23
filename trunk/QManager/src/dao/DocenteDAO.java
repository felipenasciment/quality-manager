package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import principal.Banco;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import entidades.Docente;
import excecoes.ClasseInvalidaException;

/*
 TABLE `docente`
 `pessoa_id` INT NOT NULL,
 `nm_titulacao` VARCHAR(45) NOT NULL,
 `nm_cargo` VARCHAR(45) NOT NULL,
 `nm_local_trabalho` VARCHAR(45) NOT NULL
 */

public class DocenteDAO implements GenericDAO<Integer, Docente> {

	// a conexão com o banco de dados
	public Connection connection;

	private PessoaDAO pessoaDAO;

	public DocenteDAO(Banco banco) {
		this.connection = (Connection) banco.getConnection();
		pessoaDAO = new PessoaDAO(banco);
	}

	@Override
	public int insert(Docente docente) throws ClasseInvalidaException {

		int idPessoa = pessoaDAO.insert(docente);

		if (idPessoa != 0) {

			try {

				String sql = String
						.format("%s %s ('%s', '%s', '%s', '%s')",
								"INSERT INTO `tb_docente` (`pessoa_id`, `nm_titulacao`, `nm_cargo`, `nm_local_trabalho`)",
								"VALUES", idPessoa, docente.getTitulacao(),
								docente.getCargo(), docente.getLocalTrabalho());

				// prepared statement para inserção
				PreparedStatement stmt = (PreparedStatement) connection
						.prepareStatement(sql);

				// envia para o Banco e fecha o objeto
				stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

				stmt.close();

			} catch (SQLException sqle) {
				Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE,
						null, sqle);
			}

		} else {
			// TODO: Tratar melhor esse erro! Verificar registros duplicados
			System.err.println("Não foi possível inserir pessoa!");
		}

		return idPessoa;
	}

	@Override
	public Docente getById(Integer id) throws ClasseInvalidaException {

		Docente docente = null;

		try {

			String sql = String
					.format("%s %d",
							"SELECT P.id_pessoa, P.nm_pessoa, P.nr_cpf, P.nr_matricula, P.nm_endereco, P.nm_cep, P.nm_telefone, P.nm_email,"
									+ " D.nm_titulacao, D.nm_cargo, D.nm_local_trabalho, D.dt_registro"
									+ " FROM `tb_docente` D"
									+ " INNER JOIN `pessoa` P ON D.`pessoa_id` = P.`id_pessoa`"
									+ " INNER JOIN `dados_bancarios` DB ON DB.`pessoa_id` = P.`id_pessoa`"
									+ " WHERE D.`pessoa_id`=", id);

			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			List<Docente> docentes = convertToList(rs);

			docente = docentes.get(0);

		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}

		return docente;

	}

	@Override
	public void update(Docente entidade) throws ClasseInvalidaException {

		Docente docente = (Docente) entidade;

		pessoaDAO.update(docente);

		try {

			String sql = "UPDATE `tb_docente` SET `nm_titulacao`=?, `nm_cargo`=?, `nm_local_trabalho`=?"
					+ " WHERE `pessoa_id`=?";

			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, docente.getTitulacao());
			stmt.setString(2, docente.getCargo());
			stmt.setString(3, docente.getLocalTrabalho());
			stmt.setInt(4, docente.getPessoaId());

			// envia para o Banco e fecha o objeto
			stmt.execute();

		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}

	}

	@Override
	public void delete(Docente entidade) throws ClasseInvalidaException {

		Docente docente = (Docente) entidade;

		try {

			// Deleta uma tupla setando o atributo de identificação com
			// valor representado por ?
			String sql = "DELETE FROM `tb_docente` WHERE `pessoa_id`=?";

			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, docente.getPessoaId());

			// envia para o Banco e fecha o objeto
			stmt.execute();
			stmt.close();

			pessoaDAO.delete(docente);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

	@Override
	public List<Docente> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Docente> convertToList(ResultSet rs) {

		List<Docente> docentes = new ArrayList<Docente>();

		Docente docente = new Docente();

		try {

			while (rs.next()) {
				/*
				 * P.id_pessoa, P.nm_pessoa, P.nr_cpf, P.nr_matricula, P.nm_endereco, 
				 * P.nm_cep, P.nm_telefone, P.nm_email,"
									+ " D.nm_titulacao, D.nm_cargo, D.nm_local_trabalho, D.dt_registro"
				 */
				// tabela pessoa
				docente.setPessoaId(rs.getInt("P.id_pessoa"));
				docente.setNomePessoa(rs.getString("P.nm_pessoa"));
				docente.setCpf(rs.getString("P.nr_cpf"));
				docente.setMatricula(rs.getString("P.nr_matricula"));
				docente.setEndereco(rs.getString("P.nm_endereco"));
				docente.setCep(rs.getString("P.nm_cep"));
				docente.setTelefone(rs.getString("P.nm_telefone"));
				docente.setEmail(rs.getString("P.nm_email"));

				// docente
				docente.setTitulacao(rs.getString("D.nm_titulacao"));
				docente.setCargo(rs.getString("D.nm_cargo"));
				docente.setLocalTrabalho(rs.getString("D.nm_local_trabalho"));
				docente.setRegistro(rs.getDate("D.dt_registro"));

			}

		} catch (SQLException e) {
			Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE,
					null, e);
		}

		return docentes;
	}
}