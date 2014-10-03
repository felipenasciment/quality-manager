package br.edu.ifpb.qmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.qmanager.entidade.Login;
import br.edu.ifpb.qmanager.entidade.Pessoa;
import br.edu.ifpb.qmanager.entidade.Usuario;
import br.edu.ifpb.qmanager.excecao.QManagerSQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/* serve de fatoração comum de código para Discente e Docente */
public class PessoaDAO implements GenericDAO<Integer, Pessoa> {

	// a conexão com o banco de dados
	public Connection connection;
	private DadosBancariosDAO dadosBancariosDAO;

	public PessoaDAO(DatabaseConnection banco) {
		this.connection = (Connection) banco.getConnection();
		this.dadosBancariosDAO = new DadosBancariosDAO(banco);
	}

	@Override
	public int insert(Pessoa pessoa) throws QManagerSQLException {

		int chave = 0;

		try {

			String sql = String
					.format("%s %s ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
							"INSERT INTO `tb_pessoa` (`nm_pessoa`, `nr_cpf`, `nr_matricula`, `nm_endereco`, `nm_cep`, `nm_telefone`, `nm_email`, `nm_senha`)",
							"VALUES", pessoa.getNomePessoa(), pessoa.getCpf(),
							pessoa.getMatricula(), pessoa.getEndereco(),
							pessoa.getCep(), pessoa.getTelefone(),
							pessoa.getEmail(), pessoa.getSenha());

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			chave = BancoUtil.getGenerateKey(stmt);

			pessoa.setPessoaId(chave);

			this.dadosBancariosDAO.insert(pessoa);

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

			String sql = "UPDATE `tb_pessoa` SET `nm_pessoa`=?, `nr_cpf`=?, `nr_matricula`=?, `nm_endereco`=?, `nm_cep`=?, `nm_telefone`=?, `nm_email`=?"
					+ " WHERE `id_pessoa`=?";

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			stmt.setString(1, pessoa.getNomePessoa());
			stmt.setString(2, pessoa.getCpf());
			stmt.setString(3, pessoa.getMatricula());
			stmt.setString(4, pessoa.getEndereco());
			stmt.setString(5, pessoa.getCep());
			stmt.setString(6, pessoa.getTelefone());
			stmt.setString(7, pessoa.getEmail());
			stmt.setInt(8, pessoa.getPessoaId());

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

			stmt.setInt(1, id);

			stmt.execute();
			stmt.close();

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

	}

	@Override
	public List<Pessoa> getAll() throws QManagerSQLException {
		return null;
	}

	@Override
	public Pessoa getById(Integer id) throws QManagerSQLException {
		return null;
	}

	public Usuario getByLogin(Login login) throws QManagerSQLException {

		Usuario usuario = new Usuario();

		String sql = "SELECT * FROM tb_pessoa WHERE (nm_matricula ="
				+ login.getLogin() + " OR nm_email =" + login.getLogin()
				+ ") AND (nm_senha =" + login.getSenha() + ")";

		try {

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			int tipoPessoa = rs.getInt("tipo_pessoa_id");

			// TODO: fazer busca ao tipo da pessoa no banco
			// pegar nome do tipo da pessoa
			// construir um objeto equivalente ao tipo da pessoa
			/*
			 * ALOCAR um objeto desse tipo e passar todos os valores pra ele
			 * esse ponto merece atenção especial, visto que não consigo gerar o
			 * objeto que eu quiser sem fazer uso do if () else :\
			 */
			// passar esse objeto criado pra referencia da variável dessa função
			// chamada usuario
			// retornar esse bendito usuario se tudo estiver certo!
			// lançar uma exceção QManagerSQLException se Usuário não existir
			// com mensagem adequada ;)

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return null;
	}

	@Override
	public List<Pessoa> convertToList(ResultSet rs) throws QManagerSQLException {
		return null;
	}
}
