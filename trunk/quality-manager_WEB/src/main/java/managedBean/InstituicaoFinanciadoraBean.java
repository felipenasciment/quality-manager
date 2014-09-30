package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import br.edu.ifpb.qmanager.entidade.InstituicaoFinanciadora;
import br.edu.ifpb.qmanager.entidade.ProgramaInstitucional;
import br.edu.ifpb.qmanager.entidade.QManagerErro;

@ManagedBean
@RequestScoped
public class InstituicaoFinanciadoraBean extends
		GenericBean<InstituicaoFinanciadora> implements beanInterface {

	private InstituicaoFinanciadora instituicaoFinanciadora = new InstituicaoFinanciadora();
	private List<InstituicaoFinanciadora> instituicoesFinanciadoras;

	public InstituicaoFinanciadora getInstituicaoFinanciadora() {
		return instituicaoFinanciadora;
	}

	public void setInstituicaoFinanciadora(
			InstituicaoFinanciadora instituicaoFinanciadora) {
		this.instituicaoFinanciadora = instituicaoFinanciadora;
	}

	@Override
	public void save() {

		String mensagem = requestCadastrar(instituicaoFinanciadora,
				PathServices.CADASTRAR_INSTITUICAO);
		HttpServletResponse response = null;
	}

	public List<InstituicaoFinanciadora> getInstituicoesFinanciadoras() {
		Response response = requestGetAll(PathServices.CONSULTAR_INSTITUICOES_FINANCIADORAS);

		// TODO: em caso de erro, redirecionar para página de erro
		if (response.getStatus() != 200) {
			QManagerErro qme = response
					.readEntity(new GenericType<QManagerErro>() {
					});

			// utilizar essa mensagem pro cliente
			qme.getMensagem();
			qme.getCodigo(); // esse código é só pra você saber que existe esse
								// campo

		}

		this.instituicoesFinanciadoras = response
				.readEntity(new GenericType<ArrayList<InstituicaoFinanciadora>>() {
				});
		return instituicoesFinanciadoras;
	}

	public void setInstituicoesFinanciadoras(
			List<InstituicaoFinanciadora> instituicoesFinanciadoras) {
		this.instituicoesFinanciadoras = instituicoesFinanciadoras;
	}
}
