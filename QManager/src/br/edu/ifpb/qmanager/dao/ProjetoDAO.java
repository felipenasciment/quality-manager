package br.edu.ifpb.qmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.qmanager.entidade.Edital;
import br.edu.ifpb.qmanager.entidade.Projeto;
import br.edu.ifpb.qmanager.excecao.QManagerSQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ProjetoDAO implements GenericDAO<Integer, Projeto> {

	// a conexão com o banco de dados
	public Connection connection;
	private DatabaseConnection banco;

	public ProjetoDAO(DatabaseConnection banco) {
		this.connection = (Connection) banco.getConnection();
		this.banco = banco;
	}

	@Override
	public List<Projeto> getAll() throws QManagerSQLException {
		List<Projeto> projetos;

		try {

			String sql = String.format("%s", "SELECT * FROM `tb_projeto`");

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			projetos = convertToList(rs);

			if (projetos.size() == 0) {
				throw new QManagerSQLException(777, "");
			}

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return projetos;
	}
	
	@Override
	public Projeto getById(Integer id) throws QManagerSQLException {

		Projeto projeto = null;

		try {

			String sql = String.format("%s %d",
					"SELECT * FROM `tb_projeto` WHERE `id_projeto` =", id);

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			List<Projeto> projetos = convertToList(rs);

			if (projetos.size() != 0) {
				projeto = projetos.get(0);
			} else {
				throw new QManagerSQLException(777, "'id_projeto= " + id + "'");
			}

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return projeto;

	}

	@Override
	public int insert(Projeto projeto) throws QManagerSQLException {

		int chave = 0;

		try {

			String sql = String
					.format("%s %s ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, %d)",
							"INSERT INTO `tb_projeto` (`nm_projeto`, `dt_inicio_projeto`, `dt_fim_projeto`, `ar_projeto_submetido`, `ar_relatorio_parcial`, `ar_relatorio_final`, `nr_processo`, `tp_projeto`, `vl_orcamento`, `edital_id`)",
							" VALUES", projeto.getNomeProjeto(),
							projeto.getInicioProjeto(),
							projeto.getFimProjeto(),
							projeto.getProjetoSubmetido(),
							projeto.getRelatorioParcial(),
							projeto.getRelatorioFinal(), projeto.getProcesso(),
							projeto.getTipoProjeto(), projeto.getOrcamento(),
							projeto.getEdital().getIdEdital());

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
	public void update(Projeto projeto) throws QManagerSQLException {

		try {

			String sql = "UPDATE `tb_projeto` SET `nm_projeto`=?, `dt_inicio_projeto`=?, "
					+ "`dt_fim_projeto`=?, `relatorio_parcial`=?, `relatorio_final`=?, "
					+ "`nr_processo`=?, `tp_projeto`=?, `edital_id`=? WHERE `id_projeto`=?";

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			stmt.setString(1, projeto.getNomeProjeto());
			stmt.setDate(2, projeto.getInicioProjeto());
			stmt.setDate(3, projeto.getFimProjeto());
			stmt.setString(4, projeto.getRelatorioParcial());
			stmt.setString(5, projeto.getRelatorioFinal());
			stmt.setString(6, projeto.getProcesso());
			stmt.setString(7, String.valueOf(projeto.getTipoProjeto()));
			stmt.setInt(8, projeto.getEdital().getIdEdital());
			stmt.setInt(9, projeto.getIdProjeto());

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

			String sql = "DELETE FROM `tb_projeto` WHERE `id_projeto`=?";

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
	public List<Projeto> findAll() throws QManagerSQLException {
		return null;
	}

	@Override
	public List<Projeto> convertToList(ResultSet rs)
			throws QManagerSQLException {
		List<Projeto> projetos = new ArrayList<Projeto>();

		EditalDAO editalDAO = new EditalDAO(banco);

		try {

			while (rs.next()) {
				Projeto projeto = new Projeto();
				Edital edital = new Edital();
				projeto.setIdProjeto(rs.getInt("id_projeto"));
				projeto.setNomeProjeto(rs.getString("nm_projeto"));
				projeto.setInicioProjeto(rs.getDate("dt_inicio_projeto"));
				projeto.setFimProjeto(rs.getDate("dt_fim_projeto"));
				projeto.setProjetoSubmetido(rs.getString("ar_projeto_submetido"));
				projeto.setRelatorioParcial(rs.getString("ar_relatorio_parcial"));
				projeto.setRelatorioFinal(rs.getString("ar_relatorio_final"));
				projeto.setProcesso(rs.getString("nr_processo"));
				projeto.setTipoProjeto(rs.getString("tp_projeto").charAt(0));
				projeto.setOrcamento(rs.getDouble("vl_orcamento"));
				projeto.setRegistro(rs.getDate("dt_registro"));
				edital = editalDAO.getById(rs.getInt("edital_id"));
				projeto.setEdital(edital);

				projetos.add(projeto);

			}

		} catch (SQLException sqle) {
			throw new QManagerSQLException(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return projetos;
	}

}