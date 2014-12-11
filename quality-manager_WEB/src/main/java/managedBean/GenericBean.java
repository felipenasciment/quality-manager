package managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import service.ProviderServiceFactory;
import service.QManagerService;

public class GenericBean {

	protected QManagerService service = ProviderServiceFactory
			.createServiceClient(QManagerService.class);

	public PessoaBean getPessoaBean(FacesContext context) {

		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		PessoaBean pessoaBean = (PessoaBean) session.getAttribute("pessoaBean");

		return pessoaBean;

	}
	
	/**
	 * 
	 * @param expressao
	 * @param obj
	 * @param clazz
	 */
	@SuppressWarnings("unchecked")
	public void setAtributo(String expressao, Object obj, Class clazz) {

		FacesContext current = FacesContext.getCurrentInstance();

		Application app = current.getApplication();

		ExpressionFactory fac = app.getExpressionFactory();

		ValueExpression ve = fac.createValueExpression(current.getELContext(),
				expressao, clazz);
		ve.setValue(current.getELContext(), obj);
	}

	/**
	 * 
	 * @param exp
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object getAtributo(String exp, Class clazz) {

		FacesContext current = FacesContext.getCurrentInstance();

		Application app = current.getApplication();

		ExpressionFactory fac = app.getExpressionFactory();

		ValueExpression ve = fac.createValueExpression(current.getELContext(),
				exp, clazz);
		Object resultado = ve.getValue(current.getELContext());

		return resultado;
	}

	/**
	 * Throws messages in the context.
	 * 
	 * @param key
	 * @param severity
	 */
	public static void setMessage(String clientID, String key,
			Severity severity) {

		FacesMessage message = new FacesMessage(message(key));
		message.setSeverity(severity);

		FacesContext fc = FacesContext.getCurrentInstance();

		fc.addMessage(clientID, message);
	}

	/**
	 * Capture message i18n.
	 * 
	 * @param clientId
	 * @param key
	 * @return
	 */
	public static String message(String key) {
		// Look up the requested message text
		FacesContext fc = FacesContext.getCurrentInstance();

		String text = null;

		try {
			ResourceBundle bundle = ResourceBundle.getBundle(
					"i18n.messages", fc.getViewRoot().getLocale());
			text = bundle.getString(key);
		} catch (Exception e) {
			text = "???" + key + "???";
		}

		return text;
	}

	/**
	 * Recuperar informações de outro bean
	 * 
	 * @param nomeDoBean
	 * @return
	 */
	public Object acessarOutroBean(String nomeDoBean) {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getELContext().getELResolver()
				.getValue(context.getELContext(), null, nomeDoBean);

	}

	/**
	 * Verificar se o objeto é nulo ou vazio
	 * 
	 * @param obj
	 * @return
	 */
	public boolean isEmptyOrNull(Object obj) {
		if (obj == null)
			return true;
		if (obj instanceof String) {
			if (((String) obj).trim().equals(""))
				return true;
		}
		return false;
	}

	/**
	 * Recuperar as configurações do Tomcat
	 * 
	 * @return
	 */
	public String getTomcatHome() {
		
		return System.getProperty("catalina.base");
	}
	
	/**
	 * Recuperar valores armazenados na Sessão do cliente.
	 * 
	 * @param key
	 * @return
	 */
	public static Object getSessionValue(String key) {
		// Recupera cliente da sessão
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		
		return session.getAttribute(key);
	}
	
	/**
	 * Recuperar valores armazenados na Sessão do cliente.
	 * 
	 * @param key
	 * @return
	 */
	public static void setSessionValue(String key, Object value) {
		// Recupera cliente da sessão
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		
		session.setAttribute(key, value);
	}
	
	/**
	 * Recuperar valores do contexto de aplicação
	 * @param key
	 * @return
	 */
	public static Object getApplicationContextValue(String key) {
		
		return FacesContext.getCurrentInstance()
				.getExternalContext()
				.getApplicationMap()
				.get(key);
	}
	
	/**
	 * Adicionar um item vazio ao componente de seleção
	 * 
	 * @param types
	 */
	public static List<SelectItem> initSelectOneItem() {
		
		List<SelectItem> types = new ArrayList<SelectItem>();
				
		types.add(new SelectItem(null, GenericBean.message("selectOne")));
		
		return types;
	}
	
	public static void sendRedirect(String page){
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		try {
			externalContext.redirect(page);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void resetRequestScopedBean(String value) {		  
		FacesContext fc = FacesContext.getCurrentInstance();  
		  if (fc.getExternalContext().getRequestMap().containsKey(value)) { 
		    fc.getExternalContext().getRequestMap().remove(value);  
		  }
	}
	
	public static void resetSessionScopedBean(String value) {		  
		FacesContext fc = FacesContext.getCurrentInstance();  
		  if (fc.getExternalContext().getSessionMap().containsKey(value)) { 
		    fc.getExternalContext().getSessionMap().remove(value);  
		  }
	}

}
