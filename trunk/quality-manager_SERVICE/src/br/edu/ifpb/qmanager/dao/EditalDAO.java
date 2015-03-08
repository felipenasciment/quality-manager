package br.edu.ifpb.qmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.edu.ifpb.qmanager.entidade.Edital;
import br.edu.ifpb.qmanager.entidade.ProgramaInstitucional;
import br.edu.ifpb.qmanager.excecao.SQLExceptionQManager;

public class EditalDAO implements GenericDAO<Integer, Edital> {

	static DBPool banco;
	private static EditalDAO instance;

	public static EditalDAO getInstance() {
		if (instance == null) {
			banco = DBPool.getInstance();
			instance = new EditalDAO(banco);
		}
		return instance;
	}

	public Connection connection;

	public EditalDAO(DBPool banco) {
		this.connection = (Connection) banco.getConn();
	}

	@Override
	public int insert(Edital edital) throws SQLExceptionQManager {

		int idEdital = BancoUtil.IDVAZIO;

		PreparedStatement stmt = null;

		try {

			// TODO: rever o causo do arquivo
			String sql = String
					.format("%s %s ('lembre_do_arquivo', %d, %d, '%s', '%s', '%s', '%s', %d, %s, %s, '%c', '%d', '%d')",
							"INSERT INTO tb_edital (ar_edital, nr_edital, nr_ano, "
									+ "dt_inicio_inscricoes, dt_fim_inscricoes, dt_relatorio_parcial, "
									+ "dt_relatorio_final, nr_vagas, vl_bolsa_discente, "
									+ "vl_bolsa_docente, tp_edital, pessoa_id, programa_institucional_id)",
							"VALUES", edital.getNumero(), edital.getAno(),
							new Date(edital.getInicioInscricoes().getTime()),
							new Date(edital.getFimInscricoes().getTime()),
							new Date(edital.getRelatorioParcial().getTime()),
							new Date(edital.getRelatorioFinal().getTime()),
							edital.getVagas(), edital.getBolsaDiscente(),
							edital.getBolsaDocente(), edital.getTipoEdital(),
							edital.getGestor().getPessoaId(), edital
									.getProgramaInstitucional()
									.getIdProgramaInstitucional());

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			idEdital = BancoUtil.getGenerateKey(stmt);

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		} finally {

			banco.closeQuery(stmt);
		}

		return idEdital;

	}

	@Override
	public void update(Edital edital) throws SQLExceptionQManager {

		PreparedStatement stmt = null;

		try {

			String sql = "UPDATE tb_edital SET ar_edital=?, nr_edital=?, nr_ano=?, "
					+ "dt_inicio_inscricoes=?, dt_fim_inscricoes=?, dt_relatorio_parcial=?, "
					+ "dt_relatorio_final=?, nr_vagas=?, vl_bolsa_discente=?, "
					+ "vl_bolsa_docente=?, tp_edital=? " + "WHERE id_edital=?";

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			// TODO: rever o causo do arquivo
			stmt.setString(1, "lembre_do_aqrquivo");
			stmt.setInt(2, edital.getNumero());
			stmt.setInt(3, edital.getAno());
			stmt.setDate(4, new Date(edital.getInicioInscricoes().getTime()));
			stmt.setDate(5, new Date(edital.getFimInscricoes().getTime()));
			stmt.setDate(6, new Date(edital.getRelatorioParcial().getTime()));
			stmt.setDate(7, new Date(edital.getRelatorioFinal().getTime()));
			stmt.setInt(8, edital.getVagas());
			stmt.setDouble(9, edital.getBolsaDiscente());
			stmt.setDouble(10, edital.getBolsaDocente());
			stmt.setString(11, String.valueOf(edital.getTipoEdital()));
			// stmt.setInt(13,
			// edital.getProgramaInstitucional().getIdProgramaInstitucional());
			stmt.setInt(12, edital.getIdEdital());

			stmt.execute();

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		} finally {

			banco.closeQuery(stmt);
		}

	}

	// TODO: Rever essa função, pois se excluir o edital tem que excluir os
	// projetos associados a ele
	@Override
	public void delete(Integer id) throws SQLExceptionQManager {

		PreparedStatement stmt = null;

		try {

			String sql = "DELETE FROM tb_edital WHERE id_edital=?";

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setInt(1, id);

			stmt.execute();

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		} finally {

			banco.closeQuery(stmt);
		}

	}

	@Override
	public List<Edital> getAll() throws SQLExceptionQManager {
		List<Edital> editais;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String
					.format("%s",
							"SELECT edital.id_edital, edital.ar_edital, edital.nr_edital, edital.nr_ano, "
									+ "edital.dt_inicio_inscricoes, edital.dt_fim_inscricoes, "
									+ "edital.dt_relatorio_parcial, edital.dt_relatorio_final, "
									+ "edital.nr_vagas, edital.vl_bolsa_discente, "
									+ "edital.vl_bolsa_docente, edital.tp_edital, "
									+ "edital.programa_institucional_id, edital.pessoa_id, "
									+ "edital.dt_registro FROM tb_edital edital");

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			editais = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		} finally {

			banco.closeQuery(stmt, rs);
		}

		return editais;

	}

	@Override
	public Edital getById(Integer id) throws SQLExceptionQManager {

		Edital edital = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String
					.format("%s %d",
							"SELECT edital.id_edital, edital.ar_edital, edital.nr_edital, edital.nr_ano, "
									+ "edital.dt_inicio_inscricoes, edital.dt_fim_inscricoes, "
									+ "edital.dt_relatorio_parcial, edital.dt_relatorio_final, "
									+ "edital.nr_vagas, edital.vl_bolsa_discente, "
									+ "edital.vl_bolsa_docente, edital.tp_edital, "
									+ "edital.programa_institucional_id, edital.pessoa_id, "
									+ "edital.dt_registro FROM tb_edital edital "
									+ "WHERE edital.id_edital =", id);

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Edital> editais = convertToList(rs);

			if (!editais.isEmpty())
				edital = editais.get(0);

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		} finally {

			banco.closeQuery(stmt, rs);
		}

		return edital;

	}

	public List<Edital> getByProgramaInstitucional(
			ProgramaInstitucional programaInstitucional)
			throws SQLExceptionQManager {
		List<Edital> editais = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String
					.format("%s %d",
							"SELECT edital.id_edital, edital.ar_edital, edital.nr_edital, edital.nr_ano, "
									+ "edital.dt_inicio_inscricoes, edital.dt_fim_inscricoes, "
									+ "edital.dt_relatorio_parcial, edital.dt_relatorio_final, "
									+ "edital.nr_vagas, edital.vl_bolsa_discente, "
									+ "edital.vl_bolsa_docente, edital.tp_edital, "
									+ "edital.programa_institucional_id, edital.pessoa_id, "
									+ "edital.dt_registro FROM tb_edital edital, "
									+ "INNER JOIN tb_programa_institucional programa_institucional"
									+ "ON edital.programa_institucional_id = programa_institucional.id_programa_institucional "
									+ "WHERE edital.programa_institucional_id =",
							programaInstitucional.getIdProgramaInstitucional());

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			editais = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		} finally {

			banco.closeQuery(stmt, rs);
		}

		return editais;

	}

	@Override
	public List<Edital> find(Edital edital) throws SQLExceptionQManager {
		List<Edital> editais = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String
					.format("%s %d %s %d",
							"SELECT edital.id_edital, edital.ar_edital, edital.nr_edital, edital.nr_ano, "
									+ "edital.dt_inicio_inscricoes, edital.dt_fim_inscricoes, "
									+ "edital.dt_relatorio_parcial, edital.dt_relatorio_final, "
									+ "edital.nr_vagas, edital.vl_bolsa_discente, "
									+ "edital.vl_bolsa_docente, edital.tp_edital, "
									+ "edital.programa_institucional_id, edital.pessoa_id, "
									+ "edital.dt_registro FROM tb_edital edital "
									+ "WHERE edital.nr_ano =", edital.getAno(),
							"OR edital.nr_edital =", edital.getNumero());

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			editais = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		} finally {

			banco.closeQuery(stmt, rs);
		}

		return editais;

	}

	public List<Integer> getAnosEditais() throws SQLExceptionQManager {

		List<Integer> anosEditais = new ArrayList<Integer>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT edital.nr_ano" + " FROM tb_edital edital"
					+ " GROUP BY edital.nr_ano";

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int i = rs.getInt("edital.nr_ano");
				anosEditais.add(i);
			}

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		} finally {

			banco.closeQuery(stmt, rs);
		}

		return anosEditais;

	}

	public List<Edital> getByAno(int ano) throws SQLExceptionQManager {

		List<Edital> editais;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s %d", "SELECT edital.id_edital,"
					+ " edital.ar_edital," + " edital.nr_edital,"
					+ " edital.nr_ano, " + " edital.dt_inicio_inscricoes,"
					+ " edital.dt_fim_inscricoes, "
					+ " edital.dt_relatorio_parcial,"
					+ " edital.dt_relatorio_final, " + " edital.nr_vagas,"
					+ " edital.vl_bolsa_discente, "
					+ " edital.vl_bolsa_docente," + " edital.tp_edital, "
					+ " edital.programa_institucional_id,"
					+ " edital.pessoa_id, " + " edital.dt_registro"
					+ "FROM edital.nr_ano = ", ano);

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			editais = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		} finally {

			banco.closeQuery(stmt, rs);
		}

		return editais;

	}

	@Override
	public List<Edital> convertToList(ResultSet rs) throws SQLExceptionQManager {

		List<Edital> editais = new ArrayList<Edital>();

		try {

			while (rs.next()) {

				Edital edital = new Edital();

				edital.getProgramaInstitucional().setIdProgramaInstitucional(
						rs.getInt("edital.programa_institucional_id"));

				edital.getGestor().setPessoaId(rs.getInt("edital.pessoa_id"));

				edital.setIdEdital(rs.getInt("edital.id_edital"));
				edital.setArquivo(rs.getString("edital.ar_edital"));
				edital.setNumero(rs.getInt("edital.nr_edital"));
				edital.setAno(rs.getInt("edital.nr_ano"));
				edital.setInicioInscricoes(rs
						.getDate("edital.dt_inicio_inscricoes"));
				edital.setFimInscricoes(rs.getDate("edital.dt_fim_inscricoes"));
				edital.setRelatorioParcial(rs
						.getDate("edital.dt_relatorio_parcial"));
				edital.setRelatorioFinal(rs
						.getDate("edital.dt_relatorio_final"));
				edital.setVagas(rs.getInt("edital.nr_vagas"));
				edital.setBolsaDiscente(rs
						.getDouble("edital.vl_bolsa_discente"));
				edital.setBolsaDocente(rs.getDouble("edital.vl_bolsa_docente"));
				edital.setTipoEdital(rs.getString("edital.tp_edital").charAt(0));
				edital.setRegistro(rs.getDate("edital.dt_registro"));

				editais.add(edital);
			}

		} catch (SQLException sqle) {
			throw new SQLExceptionQManager(sqle.getErrorCode(),
					sqle.getLocalizedMessage());
		}

		return editais;
	}

}