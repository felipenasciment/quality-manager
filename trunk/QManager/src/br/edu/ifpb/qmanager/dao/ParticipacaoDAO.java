package br.edu.ifpb.qmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.qmanager.entidade.MembroProjeto;
import br.edu.ifpb.qmanager.entidade.Partipacao;
import br.edu.ifpb.qmanager.entidade.Projeto;
import br.edu.ifpb.qmanager.excecao.QManagerSQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ParticipacaoDAO implements GenericDAO<Integer, Partipacao> {

	// a conexão com o banco de dados
	public Connection connection;
	private DatabaseConnection banco;

	public ParticipacaoDAO(DatabaseConnection banco) {
		this.connection = (Connection) banco.getConnection();
		this.banco = banco;
	}

	@Override
	public Partipacao getById(Integer id) throws QManagerSQLException {

		Partipacao participacao = null;

		try {

			String sql = String
					.format("%s %d",
							"SELECT * FROM `tb_participacao` WHERE `id_participacao` =",
							id);

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			List<Partipacao> participacoes = convertToList(rs);

			if (participacoes.size() != 0) {
				participacao = participacoes.get(0);
			} else {
				throw new QManagerSQLException(777, "'id_participacao= " + id + "'");
			}

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return participacao;

	}

	@Override
	public int insert(Partipacao participacao) throws QManagerSQLException {

		int chave = 0;

		try {

			String sql = String
					.format("%s %s ('%d', '%d', '%s', '%s', %s)",
							"INSERT INTO `tb_participacao` (`pessoa_id`, `projeto_id`, `dt_inicio`, `dt_fim`, `vl_bolsa`)",
							"VALUES", participacao.getMembroProjeto()
									.getPessoaId(), participacao.getProjeto()
									.getIdProjeto(), participacao
									.getInicioParticipacao(), participacao
									.getFimParticipacao(), participacao
									.getValorBolsa());

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

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
	public void update(Partipacao participacao) throws QManagerSQLException {

		try {

			String sql = "UPDATE `tb_participacao` SET `pessoa_id`=?, `projeto_id`=?, `dt_inicio`=?, `dt_fim`=?, `fl_bolsista`=? "
					+ "WHERE `id_participacao`=?";

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			stmt.setInt(1, participacao.getMembroProjeto().getPessoaId());
			stmt.setInt(2, participacao.getProjeto().getIdProjeto());
			stmt.setDate(3, participacao.getInicioParticipacao());
			stmt.setDate(4, participacao.getFimParticipacao());
			stmt.setDouble(5, participacao.getValorBolsa());
			stmt.setInt(6, participacao.getIdParticipacao());

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

			String sql = "DELETE FROM `tb_participacao` WHERE `id_participacao`=?";

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
	public List<Partipacao> findAll() throws QManagerSQLException {
		return null;
	}

	@Override
	public List<Partipacao> convertToList(ResultSet rs)
			throws QManagerSQLException {

		List<Partipacao> participacoes = new ArrayList<Partipacao>();

		Partipacao participacao = new Partipacao();
		PessoaDAO pessoaDAO = new PessoaDAO(banco);
		ProjetoDAO projetoDAO = new ProjetoDAO(banco);
		MembroProjeto membroProjeto;
		Projeto projeto;

		try {

			while (rs.next()) {
				membroProjeto = (MembroProjeto) pessoaDAO.getById(rs
						.getInt("pessoa_id"));
				participacao.setMembroProjeto(membroProjeto);
				projeto = projetoDAO.getById(rs.getInt("projeto_id"));
				participacao.setProjeto(projeto);
				participacao.setInicioParticipacao(rs.getDate("dt_inicio"));
				participacao.setFimParticipacao(rs.getDate("dt_fim"));
				participacao.setValorBolsa(rs.getInt("fl_bolsista"));

				participacoes.add(participacao);

			}

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return participacoes;

	}

}