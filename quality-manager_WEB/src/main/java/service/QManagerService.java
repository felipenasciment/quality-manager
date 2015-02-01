package service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.edu.ifpb.qmanager.entidade.CargoServidor;
import br.edu.ifpb.qmanager.entidade.Curso;
import br.edu.ifpb.qmanager.entidade.Discente;
import br.edu.ifpb.qmanager.entidade.Edital;
import br.edu.ifpb.qmanager.entidade.InstituicaoBancaria;
import br.edu.ifpb.qmanager.entidade.InstituicaoFinanciadora;
import br.edu.ifpb.qmanager.entidade.Local;
import br.edu.ifpb.qmanager.entidade.Login;
import br.edu.ifpb.qmanager.entidade.Participacao;
import br.edu.ifpb.qmanager.entidade.Pessoa;
import br.edu.ifpb.qmanager.entidade.ProgramaInstitucional;
import br.edu.ifpb.qmanager.entidade.Projeto;
import br.edu.ifpb.qmanager.entidade.Servidor;
import br.edu.ifpb.qmanager.entidade.TipoParticipacao;
import br.edu.ifpb.qmanager.entidade.Turma;
import br.edu.ifpb.qmanager.form.FileUploadForm;

/**
 * Definition: Contains the services interfaces of QManager.
 * 
 * @author Rhavy Maia Guedes
 * 
 */
public interface QManagerService {

	/**
	 * 
	 * @param negotiation
	 * @return
	 */

	/*
	 * Métodos para consulta
	 */

	@POST
	@Path("/consultar/fazerLogin")
	@Consumes("application/json")
	@Produces("application/json")
	public Response fazerLogin(Login login);

	@POST
	@Path("/consultar/instituicoesfinanciadoras")
	@Consumes("application/json")
	@Produces("application/json")
	public List<InstituicaoFinanciadora> consultarInstituicoesFinanciadoras(
			InstituicaoFinanciadora instituicaoFinanciadora)
			throws SQLException;

	@GET
	@Path("/consultar/instituicoesfinanciadoras/listar")
	@Produces("application/json")
	public List<InstituicaoFinanciadora> listarInstituicoesFinanciadoras()
			throws SQLException;

	@GET
	@Path("/consultar/instituicaofinanciadora/{id}")
	@Produces("application/json")
	public Response consultarInstituicao(
			@PathParam("id") int idInstituicaoFinanciadora);

	@POST
	@Path("/consultar/programasinstitucionais")
	@Consumes("application/json")
	@Produces("application/json")
	public List<ProgramaInstitucional> consultarProgramasInstitucionais(
			ProgramaInstitucional programaInstitucional) throws SQLException;

	@GET
	@Path("/consultar/programasinstitucionais/listar")
	@Produces("application/json")
	public List<ProgramaInstitucional> listarProgramasInstitucionais()
			throws SQLException;

	@GET
	@Path("/consultar/programainstitucional/{id}")
	@Produces("application/json")
	public Response consultarProgramaInstitucional(
			@PathParam("id") int idProgramaInstitucional);

	@POST
	@Path("/consultar/editais")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Edital> consultarEditais(Edital edital) throws SQLException;

	@GET
	@Path("/consultar/editais/listar")
	@Produces("application/json")
	public List<Edital> listarEditais() throws SQLException;

	@GET
	@Path("/consultar/edital/{id}")
	@Produces("application/json")
	public Response consultarEdital(@PathParam("id") int idEdital);

	@POST
	@Path("/consultar/editaisprogramainstitucional")
	@Consumes("application/json")
	@Produces("application/json")
	public Response consultarEditais(ProgramaInstitucional programaInstitucional);

	@POST
	@Path("/consultar/projetos")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Projeto> consultarProjetos(Projeto projeto) throws SQLException;

	@GET
	@Path("/consultar/projetos/listar")
	@Produces("application/json")
	public List<Projeto> listarProjetos() throws SQLException;

	@GET
	@Path("/consultar/projeto/{id}")
	@Produces("application/json")
	public Response consultarProjeto(@PathParam("id") int idProjeto);

	@POST
	@Path("/consultar/projetosprogramainstitucional")
	@Consumes("application/json")
	@Produces("application/json")
	public Response consultarProjetos(
			ProgramaInstitucional programaInstitucional);

	@POST
	@Path("/consultar/projetosedital")
	@Consumes("application/json")
	@Produces("application/json")
	public Response consultarProjetos(Edital edital);

	@POST
	@Path("/consultar/projetospessoa")
	@Consumes("application/json")
	@Produces("application/json")
	public Response consultarProjetosPessoa(Pessoa pessoa);

	@POST
	@Path("/consultar/projetoinformacoes")
	@Consumes("application/json")
	@Produces("application/json")
	public Response consultarInformacoesProjeto(Projeto projeto);

	@POST
	@Path("/consultar/servidores")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Servidor> consultarServidores(Servidor servidor)
			throws SQLException;

	@GET
	@Path("/consultar/servidores/listar")
	@Produces("application/json")
	public List<Servidor> listarServidores() throws SQLException;

	@POST
	@Path("/consultar/servidoresprojeto")
	@Consumes("application/json")
	@Produces("application/json")
	public Response consultarServidoresProjeto(Projeto projeto);

	@GET
	@Path("/consultar/servidorespesquisa")
	@Produces("application/json")
	public Response consultarServidoresPesquisa();

	@GET
	@Path("/consultar/servidoresextensao")
	@Produces("application/json")
	public Response consultarServidoresExtensao();

	@GET
	@Path("/consultar/servidorespesquisa/{ano}")
	@Produces("application/json")
	public Response consultarServidoresPesquisa(@PathParam("ano") int ano);

	@GET
	@Path("/consultar/servidoresextensao/{ano}")
	@Produces("application/json")
	public Response consultarServidoresExtensao(@PathParam("ano") int ano);

	@GET
	@Path("/consultar/servidor/{id}")
	@Produces("application/json")
	public Response consultarServidor(@PathParam("id") int idServidor);

	@GET
	@Path("/consultar/coordenadores")
	@Produces("application/json")
	public List<Servidor> consultarCoordenadores() throws SQLException;

	@GET
	@Path("/consultar/coordenador/{id}")
	@Produces("application/json")
	public Response consultarCoordenador(@PathParam("id") int idCoordenador);

	@GET
	@Path("/consultar/gestores")
	@Produces("application/json")
	public List<Servidor> consultarGestores() throws SQLException;

	@GET
	@Path("/consultar/gestor/{id}")
	@Produces("application/json")
	public Response consultarGestor(@PathParam("id") int idGestor);

	@GET
	@Path("/consultar/discentes")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Discente> consultarDiscentes(Discente discente)
			throws SQLException;

	@GET
	@Path("/consultar/discentes/listar")
	@Produces("application/json")
	public List<Discente> listarDiscentes() throws SQLException;

	@GET
	@Path("/consultar/discente/{id}")
	@Produces("application/json")
	public Response consultarDiscente(@PathParam("id") int idDiscente);

	@POST
	@Path("/consultar/discentesprojeto")
	@Consumes("application/json")
	@Produces("application/json")
	public Response consultarDiscentesProjeto(Projeto projeto);

	@POST
	@Path("/consultar/instituicoesbancarias")
	@Consumes("application/json")
	@Produces("application/json")
	public List<InstituicaoBancaria> consultarInstituicoesBancarias(
			InstituicaoBancaria instituicaoBancaria) throws SQLException;

	@GET
	@Path("/consultar/instituicoesbancarias/listar")
	@Produces("application/json")
	public List<InstituicaoBancaria> listarInstituicoesBancarias()
			throws SQLException;

	@GET
	@Path("/consultar/instituicaobancaria/{id}")
	@Produces("application/json")
	public Response consultarInstituicaoBancaria(
			@PathParam("id") int idInstituicaoBancaria);

	@POST
	@Path("/consultar/cursos")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Curso> consultarCursos(Curso curso) throws SQLException;

	@GET
	@Path("/consultar/cursos/listar")
	@Produces("application/json")
	public List<Curso> listarCursos() throws SQLException;

	@GET
	@Path("/consultar/curso/{idcurso}")
	@Produces("application/json")
	public Response consultarCurso(@PathParam("idcurso") int idCurso);

	@GET
	@Path("/consultar/turmascoordenador/{id}")
	@Produces("application/json")
	public Response consultarTurmasCoordenador(
			@PathParam("id") int idCoordenador);

	@POST
	@Path("/consultar/cargos")
	@Consumes("application/json")
	@Produces("application/json")
	public List<CargoServidor> consultarCargos(CargoServidor cargoServidor)
			throws SQLException;

	@GET
	@Path("/consultar/cargos/listar")
	@Produces("application/json")
	public List<CargoServidor> listarCargos() throws SQLException;

	@GET
	@Path("/consultar/cargo/{id}")
	@Produces("application/json")
	public Response consultarCargo(@PathParam("id") int idCargo);

	@POST
	@Path("/consultar/tiposparticipacao")
	@Consumes("application/json")
	@Produces("application/json")
	public List<TipoParticipacao> consultarTiposParticipacao(
			TipoParticipacao tipoParticipacao) throws SQLException;

	@GET
	@Path("/consultar/tiposparticipacao/listar")
	@Produces("application/json")
	public List<TipoParticipacao> listarTiposParticipacao() throws SQLException;

	@GET
	@Path("/consultar/tipoparticipacao/{id}")
	@Produces("application/json")
	public Response consultarTipoParticipacao(
			@PathParam("id") int idTipoParticipacao);

	@POST
	@Path("/consultar/pessoas")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Pessoa> consultarPessoas(Pessoa pessoa) throws SQLException;

	@GET
	@Path("/consultar/pessoa/{id}")
	@Produces("application/json")
	public Response consultarPessoa(@PathParam("id") int idPessoa);

	@GET
	@Path("/consultar/pessoa/{idPessoa}/{idTipoPessoa}")
	@Produces("application/json")
	public Response consultarPessoaPorTipo(@PathParam("idPessoa") int idPessoa,
			@PathParam("idTipoPessoa") int idTipoPessoa);

	@POST
	@Path("/consultar/locais")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Local> consultarLocais(Local local) throws SQLException;

	@GET
	@Path("/consultar/locais/listar")
	@Produces("application/json")
	public List<Local> listarLocais() throws SQLException;

	@GET
	@Path("/consultar/local/{id}")
	@Produces("application/json")
	public Response consultarLocal(@PathParam("id") int idLocal);

	/*
	 * Métodos de cadastro
	 */
	@POST
	@Path("/cadastrar/instituicaofinanciadora")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarInstituicao(
			InstituicaoFinanciadora instituicaoFinanciadora);

	@POST
	@Path("/cadastrar/programainstitucional")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarProgramaInstitucional(
			ProgramaInstitucional programaInstitucional);

	@POST
	@Path("/cadastrar/edital")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarEdital(Edital edital);

	@POST
	@Path("/cadastrar/projeto")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarProjeto(Projeto projeto);

	@POST
	@Path("/cadastrar/discente")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarDiscente(Discente discente);

	@POST
	@Path("/cadastrar/orientador")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarServidor(Servidor servidor);

	@POST
	@Path("/cadastrar/participacao")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarParticipacao(Participacao participacao);

	@POST
	@Path("/cadastrar/instituicaobancaria")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarInstituicaoBancaria(
			InstituicaoBancaria instituicaoBancaria);

	@POST
	@Path("/cadastrar/curso")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarCurso(Curso curso);

	@POST
	@Path("/cadastrar/turma")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarTurma(Turma turma);

	@GET
	@Path("/cadastrar/servidorOnline")
	@Produces("application/json")
	public Response servidorOnline();

	/*
	 * Métodos de update
	 */

	@POST
	@Path("/editar/instituicaofinanciadora")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editarInstituicaoFinanciadora(
			InstituicaoFinanciadora instituicaoFinanciadora);

	@POST
	@Path("/editar/programainstitucional")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editarProgramaInstitucional(
			ProgramaInstitucional programaInstitucional);

	@POST
	@Path("/editar/edital")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editarEdital(Edital edital);

	@POST
	@Path("/editar/projeto")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editarProjeto(Projeto projeto);

	@POST
	@Path("/editar/discente")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editarDiscente(Discente discente);

	@POST
	@Path("/editar/orientador")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editarServidor(Servidor servidor);

	@POST
	@Path("/editar/coordenador")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editarCoordenador(Servidor coordenador);

	@POST
	@Path("/editar/gestor")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editarGestor(Servidor gestor);

	@POST
	@Path("/editar/participacao")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editarParticipacaoOrientador(Participacao participacao);

	@POST
	@Path("/editar/instituicaobancaria")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editarInstituicaoBancaria(
			InstituicaoBancaria instituicaoBancaria);

	@POST
	@Path("/editar/curso")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editarCurso(Curso curso);

	@POST
	@Path("/editar/turma")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editarTurma(Turma turma);

	@POST
	@Path("/arquivo/upload/projeto/{idprojeto}")
	@Consumes(MediaType.MULTIPART_FORM_DATA + ";charset=UTF-8")
	@Produces("application/json")
	public Response uploadFile(@PathParam("idprojeto") String idProjeto,
			@MultipartForm FileUploadForm form);
}