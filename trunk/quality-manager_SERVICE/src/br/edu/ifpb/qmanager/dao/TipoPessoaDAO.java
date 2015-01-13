package br.edu.ifpb.qmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.edu.ifpb.qmanager.entidade.TipoPessoa;
import br.edu.ifpb.qmanager.excecao.SQLExceptionQManager;

public class TipoPessoaDAO implements GenericDAO<Integer, TipoPessoa> {

	static DBPool banco;
	private static TipoPessoaDAO instance;

	public static TipoPessoaDAO getInstance() {
		if (instance == null) {
			banco = DBPool.getInstance();
			instance = new TipoPessoaDAO(banco);
		}
		return instance;
	}

	public Connection connection;

	public TipoPessoaDAO(DBPool banco) {
		this.connection = (Connection) banco.getConn();
	}

	@Override
	public int insert(TipoPessoa tipoPessoa) throws SQLExceptionQManager {

		int chave = 0;

		String sql = String.format("%s %s('%s')",
				"INSERT INTO tb_tipo_pessoa(nm_tipo_pessoa)", "VALUES",
				tipoPessoa.getNomeTipoPessoa());

		try {

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			chave = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.close();

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return chave;
	}

	@Override
	public void update(TipoPessoa tipoPessoa) throws SQLExceptionQManager {

		try {

			String sql = "UPDATE tb_tipo_pessoa SET nm_tipo_pessoa=?"
					+ " WHERE id_tipo_pessoa=?";

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			stmt.setString(1, tipoPessoa.getNomeTipoPessoa());
			stmt.setInt(2, tipoPessoa.getIdTipoPessoa());

			stmt.execute();
			stmt.close();

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

	}

	@Override
	public void delete(Integer id) throws SQLExceptionQManager {

		try {

			String sql = "DELETE FROM tb_tipo_pessoa WHERE id_tipo_pessoa=?";

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			stmt.setInt(1, id);

			stmt.execute();

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

	}

	@Override
	public List<TipoPessoa> getAll() throws SQLExceptionQManager {

		List<TipoPessoa> tiposPessoa;

		try {

			String sql = String.format("%s", "SELECT * FROM tb_tipo_pessoa");

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			tiposPessoa = convertToList(rs);

			stmt.close();
			rs.close();

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return tiposPessoa;

	}

	@Override
	public TipoPessoa getById(Integer id) throws SQLExceptionQManager {
		TipoPessoa tipoPessoa = null;

		try {

			String sql = String.format("%s %d",
					"SELECT * FROM tb_tipo_pessoa WHERE id_tipo_pessoa =", id);

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			List<TipoPessoa> tiposPessoa = convertToList(rs);

			if (!tiposPessoa.isEmpty())
				tipoPessoa = tiposPessoa.get(0);

			stmt.close();
			rs.close();

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return tipoPessoa;

	}

	@Override
	public List<TipoPessoa> convertToList(ResultSet rs)
			throws SQLExceptionQManager {
		List<TipoPessoa> tiposPessoa = new LinkedList<TipoPessoa>();

		try {

			while (rs.next()) {
				TipoPessoa tipoPessoa = new TipoPessoa();
				tipoPessoa.setIdTipoPessoa(rs.getInt("id_tipo_pessoa"));
				tipoPessoa.setNomeTipoPessoa(rs.getString("nm_tipo_pessoa"));

				tiposPessoa.add(tipoPessoa);
			}

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return tiposPessoa;
	}

}
