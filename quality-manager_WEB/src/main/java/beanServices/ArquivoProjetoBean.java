package beanServices;

import java.io.IOException;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;
import javax.ws.rs.core.Response;

import managedBean.GenericBean;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;

import service.ProviderServiceFactory;
import service.QManagerService;
import util.FileUtil;
import br.edu.ifpb.qmanager.form.FileUploadForm;

@ManagedBean
@RequestScoped
public class ArquivoProjetoBean {

	private Part arquivo;

	public void importa() {

		try {
			
			QManagerService service = ProviderServiceFactory
					.createServiceClient(QManagerService.class);
			FileUploadForm fuf = new FileUploadForm();

			InputStream is = this.arquivo.getInputStream();
			byte[] bytes = IOUtils.toByteArray(is);

			fuf.setFileName(FileUtil.getFileName(arquivo));
			fuf.setData(bytes);
			
			//TODO: Alterar para o Código(ID) real do projeto.
			Response response = service.uploadFile("01", fuf);
			
			if (response.getStatus() == HttpStatus.SC_OK) {
				GenericBean.setMessage("info.sucessoUploadArquivo", 
						FacesMessage.SEVERITY_INFO);
			}			

		} catch (IOException e) {
			GenericBean.setMessage("erro.uploadArquivo", 
					FacesMessage.SEVERITY_ERROR);
		}
	}	

	public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}	
}