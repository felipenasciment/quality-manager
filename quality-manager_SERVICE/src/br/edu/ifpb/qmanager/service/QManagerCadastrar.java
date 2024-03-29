package br.edu.ifpb.qmanager.service;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.edu.ifpb.qmanager.dao.BancoUtil;
import br.edu.ifpb.qmanager.dao.CursoDAO;
import br.edu.ifpb.qmanager.dao.DiscenteDAO;
import br.edu.ifpb.qmanager.dao.EditalDAO;
import br.edu.ifpb.qmanager.dao.InstituicaoBancariaDAO;
import br.edu.ifpb.qmanager.dao.InstituicaoFinanciadoraDAO;
import br.edu.ifpb.qmanager.dao.ParticipacaoDAO;
import br.edu.ifpb.qmanager.dao.ProgramaInstitucionalDAO;
import br.edu.ifpb.qmanager.dao.ProjetoDAO;
import br.edu.ifpb.qmanager.dao.RecursoInstituicaoFinanciadoraDAO;
import br.edu.ifpb.qmanager.dao.RecursoProgramaInstitucionalDAO;
import br.edu.ifpb.qmanager.dao.ServidorDAO;
import br.edu.ifpb.qmanager.dao.TurmaDAO;
import br.edu.ifpb.qmanager.entidade.Curso;
import br.edu.ifpb.qmanager.entidade.Discente;
import br.edu.ifpb.qmanager.entidade.Edital;
import br.edu.ifpb.qmanager.entidade.Erro;
import br.edu.ifpb.qmanager.entidade.InstituicaoBancaria;
import br.edu.ifpb.qmanager.entidade.InstituicaoFinanciadora;
import br.edu.ifpb.qmanager.entidade.MapErroQManager;
import br.edu.ifpb.qmanager.entidade.Participacao;
import br.edu.ifpb.qmanager.entidade.ProgramaInstitucional;
import br.edu.ifpb.qmanager.entidade.Projeto;
import br.edu.ifpb.qmanager.entidade.RecursoInstituicaoFinanciadora;
import br.edu.ifpb.qmanager.entidade.RecursoProgramaInstitucional;
import br.edu.ifpb.qmanager.entidade.Server;
import br.edu.ifpb.qmanager.entidade.Servidor;
import br.edu.ifpb.qmanager.entidade.TipoParticipacao;
import br.edu.ifpb.qmanager.entidade.Turma;
import br.edu.ifpb.qmanager.excecao.SQLExceptionQManager;
import br.edu.ifpb.qmanager.validacao.Validar;

@Path("cadastrar")
public class QManagerCadastrar {

	/**
	 * Cadastra uma Instituição Financiadora.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @param instituicaoFinanciadora
	 * @return Response
	 */
	@POST
	@Path("/instituicaofinanciadora")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarInstituicao(
			InstituicaoFinanciadora instituicaoFinanciadora) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		int validacao = Validar
				.instituicaoFinanciadora(instituicaoFinanciadora);

		if (validacao == Validar.VALIDACAO_OK) {

			try {

				int idInstituicao = InstituicaoFinanciadoraDAO.getInstance()
						.insert(instituicaoFinanciadora);

				if (idInstituicao != BancoUtil.IDVAZIO) {

					instituicaoFinanciadora
							.setIdInstituicaoFinanciadora(idInstituicao);

					builder.status(Response.Status.OK);
					builder.entity(instituicaoFinanciadora);

				} else {
					builder.status(Response.Status.NOT_MODIFIED);
					// TODO: Inserir mensagem de erro.
				}

			} catch (SQLExceptionQManager qme) {
				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);
			}

		} else {
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.CONFLICT).entity(erro);
		}

		return builder.build();
	}

	/**
	 * Cadastra Recurso para Instituição Financiadora.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @param recurso
	 * @return Response
	 */
	@POST
	@Path("/recursoinstituicaofinanciadora")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarRecursoInstituicao(
			RecursoInstituicaoFinanciadora recurso) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		int validacao = Validar.recursoInstituicaoFinanciadora(recurso);

		if (validacao == Validar.VALIDACAO_OK) {

			try {

				int idRecurso = RecursoInstituicaoFinanciadoraDAO.getInstance()
						.insert(recurso);

				if (idRecurso != BancoUtil.IDVAZIO) {

					recurso.setIdRecursoIF(idRecurso);

					builder.status(Response.Status.OK);
					builder.entity(recurso);

				} else {
					builder.status(Response.Status.NOT_MODIFIED);
					// TODO: Inserir mensagem de erro.
				}

			} catch (SQLExceptionQManager qme) {
				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);
			}

		} else {
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.CONFLICT).entity(erro);
		}

		return builder.build();
	}

	/**
	 * Cadastra um Programa Institucional.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @param ProgramaInstitucional
	 * @return Response
	 */
	@POST
	@Path("/programainstitucional")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarProgramaInstitucional(
			ProgramaInstitucional programaInstitucional) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		int validacao = Validar.programaInstitucional(programaInstitucional);

		if (validacao == Validar.VALIDACAO_OK) {

			try {

				int idProInstitucional = ProgramaInstitucionalDAO.getInstance()
						.insert(programaInstitucional);

				if (idProInstitucional != BancoUtil.IDVAZIO) {

					programaInstitucional
							.setIdProgramaInstitucional(idProInstitucional);

					builder.status(Response.Status.OK);
					builder.entity(programaInstitucional);

				} else {
					builder.status(Response.Status.NOT_MODIFIED);
					// TODO: Inserir mensagem de erro.
				}

			} catch (SQLExceptionQManager qme) {

				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);
			}

		} else {
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.CONFLICT).entity(erro);
		}

		return builder.build();
	}

	/**
	 * Cadastra Recurso para Programa Institucional.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @param recurso
	 * @return Response
	 */
	@POST
	@Path("/recursoprogramainstitucional")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarRecursoPrograma(
			RecursoProgramaInstitucional recurso) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		int validacao = Validar.recursoProgramaInstitucional(recurso);

		if (validacao == Validar.VALIDACAO_OK) {

			try {

				int idRecurso = RecursoProgramaInstitucionalDAO.getInstance()
						.insert(recurso);

				if (idRecurso != BancoUtil.IDVAZIO) {

					recurso.setIdRecursoPI(idRecurso);

					builder.status(Response.Status.OK);
					builder.entity(recurso);

				} else {
					builder.status(Response.Status.NOT_MODIFIED);
					// TODO: Inserir mensagem de erro.
				}

			} catch (SQLExceptionQManager qme) {
				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);
			}

		} else {
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.CONFLICT).entity(erro);
		}

		return builder.build();
	}

	/**
	 * Cadastra um Edital.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @param Edital
	 * @return Response
	 */
	@POST
	@Path("/edital")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarEdital(Edital edital) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		int validacao = Validar.edital(edital);

		if (validacao == Validar.VALIDACAO_OK) {

			try {

				int idEdital = EditalDAO.getInstance().insert(edital);

				if (idEdital != BancoUtil.IDVAZIO) {

					edital.setIdEdital(idEdital);

					builder.status(Response.Status.OK);
					builder.entity(edital);

				} else {
					builder.status(Response.Status.NOT_MODIFIED);
					// TODO: Inserir mensagem de erro.
				}

			} catch (SQLExceptionQManager qme) {

				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);
			}

		} else {
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.NOT_ACCEPTABLE).entity(erro);
		}

		return builder.build();
	}

	/**
	 * Cadastra um Projeto.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @param Projeto
	 * @return Response
	 */
	@POST
	@Path("/projeto")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarProjeto(Projeto projeto) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		int validacao = Validar.projeto(projeto);

		if (validacao == Validar.VALIDACAO_OK) {

			try {

				int idEdital = projeto.getEdital().getIdEdital();
				Edital edital = EditalDAO.getInstance().getById(idEdital);
				projeto.setEdital(edital);

				projeto.setInicioProjeto(edital.getInicioInscricoes());
				projeto.setFimProjeto(edital.getFimInscricoes());

				int idProjeto = ProjetoDAO.getInstance().insert(projeto);

				if (idProjeto != BancoUtil.IDVAZIO) {

					projeto.setIdProjeto(idProjeto);

					// cadastrar orientador do projeto
					// TODO: Melhorar a composição da entre Projeto,
					// Participação e Membro de Projeto.
					Participacao participacaoOrientador = new Participacao();
					Servidor servidor = projeto.getOrientador();

					// Participação
					participacaoOrientador.setPessoa(servidor);
					participacaoOrientador.setProjeto(projeto);
					participacaoOrientador.setInicioParticipacao(projeto
							.getInicioProjeto());
					participacaoOrientador.setValorBolsa(0.0);
					participacaoOrientador
							.setTipoParticipacao(new TipoParticipacao(
									TipoParticipacao.TIPO_ORIENTADOR));

					ParticipacaoDAO.getInstance()
							.insert(participacaoOrientador);

					builder.status(Response.Status.OK);
					builder.entity(projeto);

				} else {
					builder.status(Response.Status.NOT_MODIFIED);
					// TODO: Inserir mensagem de erro.
				}

			} catch (SQLExceptionQManager qme) {

				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);
			}

		} else {
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.NOT_ACCEPTABLE).entity(erro);
		}

		return builder.build();
	}

	/**
	 * Cadastra um Discente.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @param Discente
	 * @return Response
	 */
	@POST
	@Path("/discente")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarDiscente(Discente discente) {
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		int validacao = Validar.discente(discente);
		if (validacao == Validar.VALIDACAO_OK) {

			try {

				int idDiscente = DiscenteDAO.getInstance().insert(discente);

				if (idDiscente != BancoUtil.IDVAZIO) {

					discente.setPessoaId(idDiscente);

					builder.status(Response.Status.OK);
					builder.entity(discente);

				} else {
					builder.status(Response.Status.NOT_MODIFIED);
					// TODO: Inserir mensagem de erro.
				}

			} catch (SQLExceptionQManager qme) {

				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);

			}

		} else {
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.NOT_ACCEPTABLE).entity(erro);
		}

		return builder.build();
	}

	/**
	 * Cadastra um Orientador.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @param Orientador
	 * @return Response
	 */
	@POST
	@Path("/servidor")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarServidor(Servidor servidor) {
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		int validacao = Validar.servidor(servidor);

		if (validacao == Validar.VALIDACAO_OK) {

			try {

				int idOrientador = ServidorDAO.getInstance().insert(servidor);

				if (idOrientador != BancoUtil.IDVAZIO) {

					servidor.setPessoaId(idOrientador);

					builder.status(Response.Status.OK);
					builder.entity(servidor);

				} else {
					builder.status(Response.Status.NOT_MODIFIED);
					// TODO: Inserir mensagem de erro.
				}

			} catch (SQLExceptionQManager qme) {

				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);
			}

		} else {
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.NOT_ACCEPTABLE).entity(erro);
		}

		return builder.build();
	}
	
	/**
	 * Habilitar e cadastrar servidor.
	 * 
	 * @param servidor
	 * @return Response
	 */
	@POST
	@Path("/servidorhabilitado")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarServidorHabilitado(Servidor servidor) {
		
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());
		
		int validacao = Validar.servidor(servidor);

		if (validacao == Validar.VALIDACAO_OK) {

			try {

				// Verificar se servidor está habilitado.
				
				// Cadastrar servidor.
				int idServidor = ServidorDAO.getInstance().insert(servidor);

				if (idServidor != BancoUtil.IDVAZIO) {

					// Definir como habilitado o servidor;

				} else {
					
					builder.status(Response.Status.NOT_MODIFIED);
					// Retornar mensagem como servidor não habilitado
				}

			} catch (SQLExceptionQManager qme) {

				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);
			}

		} else {
			
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.NOT_ACCEPTABLE).entity(erro);
		}
		
		return builder.build();
	}
	/**
	 * Cadastra uma Participação.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @param Participacao
	 * @return Response
	 */
	@POST
	@Path("/participacao")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarParticipacao(Participacao participacao) {
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		int validacao = Validar.participacao(participacao);

		if (validacao == Validar.VALIDACAO_OK) {

			try {

				if (participacao.isBolsista()) {

					int tipoParticipacao = participacao.getTipoParticipacao()
							.getIdTipoParticipacao();

					if (tipoParticipacao == TipoParticipacao.TIPO_ORIENTANDO) {
						double valorBolsa = participacao.getProjeto()
								.getEdital().getBolsaDiscente();
						participacao.setValorBolsa(valorBolsa);
					} else if (tipoParticipacao == TipoParticipacao.TIPO_COORIENTADOR) {
						// TODO: esses caras recebem bolsa? Muda o que a
						// participação
						// deles? Se isso não existir, mudarei depois.
						participacao.setValorBolsa(0.0);
					} else if (tipoParticipacao == TipoParticipacao.TIPO_COLABORADOR) {
						// TODO: esses caras recebem bolsa? Muda o que a
						// participação
						// deles? Se isso não existir, mudarei depois.
						participacao.setValorBolsa(0.0);
					}

				} else {
					participacao.setValorBolsa(0.0);
				}

				int idParticipacao = ParticipacaoDAO.getInstance().insert(
						participacao);

				if (idParticipacao != BancoUtil.IDVAZIO) {

					participacao.setIdParticipacao(idParticipacao);

					builder.status(Response.Status.OK);
					builder.entity(participacao);

				} else {
					builder.status(Response.Status.NOT_MODIFIED);
					// TODO: Inserir mensagem de erro.
				}

			} catch (SQLExceptionQManager qme) {

				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);
			}

		} else {
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.NOT_ACCEPTABLE).entity(erro);
		}

		return builder.build();
	}

	/**
	 * Cadastra uma Instituição Bancária.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @param InstituicaoBancaria
	 * @return Response
	 */
	@POST
	@Path("/instituicaobancaria")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarInstituicaoBancaria(
			InstituicaoBancaria instituicaoBancaria) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		int validacao = Validar.instituicaoBancaria(instituicaoBancaria);

		if (validacao == Validar.VALIDACAO_OK) {

			try {

				int idInstituicaoBancaria = InstituicaoBancariaDAO
						.getInstance().insert(instituicaoBancaria);

				if (idInstituicaoBancaria != BancoUtil.IDVAZIO) {

					instituicaoBancaria
							.setIdInstituicaoBancaria(idInstituicaoBancaria);
					builder.status(Response.Status.OK);
					builder.entity(instituicaoBancaria);

				} else {
					builder.status(Response.Status.NOT_MODIFIED);
					// TODO: Inserir mensagem de erro.
				}

			} catch (SQLExceptionQManager qme) {

				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);
			}

		} else {
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.NOT_ACCEPTABLE).entity(erro);
		}

		return builder.build();
	}

	/**
	 * Cadastra um Curso.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @param Curso
	 * @return Response
	 */
	@POST
	@Path("/curso")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarCurso(Curso curso) {
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		int validacao = Validar.curso(curso);

		if (validacao == Validar.VALIDACAO_OK) {
			try {

				int idCurso = CursoDAO.getInstance().insert(curso);

				if (idCurso != BancoUtil.IDVAZIO) {

					// Curso inserido com sucesso.
					curso.setIdCurso(idCurso);
					builder.status(Response.Status.OK);
					builder.entity(curso);

				} else {
					builder.status(Response.Status.NOT_MODIFIED);
					// TODO: Inserir mensagem de erro.
				}

			} catch (SQLExceptionQManager qme) {

				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);
			}

		} else {
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.NOT_ACCEPTABLE).entity(erro);
		}

		return builder.build();
	}

	/**
	 * Cadastra uma Turma.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @param Turma
	 * @return Response
	 */
	@POST
	@Path("/turma")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarTurma(Turma turma) {
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		int validacao = Validar.turma(turma);

		if (validacao == Validar.VALIDACAO_OK) {

			try {

				int idTurma = TurmaDAO.getInstance().insert(turma);

				if (idTurma != BancoUtil.IDVAZIO) {

					turma.setIdTurma(idTurma);

					builder.status(Response.Status.OK);
					builder.entity(turma);

				} else {
					builder.status(Response.Status.NOT_MODIFIED);
					// TODO: Inserir mensagem de erro.
				}

			} catch (SQLExceptionQManager qme) {

				Erro erro = new Erro();
				erro.setCodigo(qme.getErrorCode());
				erro.setMensagem(qme.getMessage());

				builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
						erro);

			}
		} else {
			MapErroQManager erro = new MapErroQManager(validacao);
			builder.status(Response.Status.NOT_ACCEPTABLE).entity(erro);
		}

		return builder.build();
	}

	/**
	 * Verifica se o servidor está apto pra responder.
	 * 
	 * @author Igor Barbosa
	 * @author Rhavy Maia
	 * @author Emanuel Guimarães
	 * @author Eri Jonhson
	 * @author Felipe Nascimento
	 * @author Ivanildo Terceiro
	 * @return Response
	 */
	@GET
	@Path("/servidorOnline")
	@Produces("application/json")
	public Response servidorOnline() {

		ResponseBuilder builder = Response.status(Response.Status.OK);
		builder.expires(new Date());

		Server server = new Server();
		server.setOnline(true);
		builder.entity(server);

		return builder.build();
	}
}