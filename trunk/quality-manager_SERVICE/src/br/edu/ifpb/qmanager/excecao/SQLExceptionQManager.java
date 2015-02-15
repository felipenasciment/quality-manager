package br.edu.ifpb.qmanager.excecao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import br.edu.ifpb.qmanager.entidade.Erro;

public class SQLExceptionQManager extends SQLException {

	private static final long serialVersionUID = 6315776920468858333L;

	private Logger logger = Logger.getLogger(SQLExceptionQManager.class);
	
	private static final Map<Integer, String> erros = new HashMap<Integer, String>();
	static {
		erros.put(100, "Erro: Usuário não existe no sistema.");
		erros.put(101, "Erro: Senha inválida!");
		erros.put(102, "Erro: Orçamento insuficiente!");
		erros.put(666, "Erro: Falha conversão da data.");
		erros.put(1062, "Chave duplicada.");
		erros.put(1052, "Consulta com coluna ambígua.");
		erros.put(1054, "Coluna desconhecida.");
		erros.put(1136,
				"Contagem de colunas não confere com a contagem de valores.");
		erros.put(1146, "Tabela não existe.");
		erros.put(1406, "Dado muito longo para a coluna.");
		erros.put(1451, "Não é possível excluir ou atualizar uma "
				+ "linha pai: uma restrição de chave estrangeira falhou.");
		erros.put(1452, "A restrição de chave estrangeira falhou.");
		erros.put(1364, "Campo não tem um valor padrão.");
	}

	private int errorCode;

	public SQLExceptionQManager(int errorCode, String localizedMessage) {

		super(erros.get(errorCode));

		setErrorCode(errorCode);

		logger.error(errorCode + ": " + localizedMessage);

		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public Erro getErro() {
		return new Erro(errorCode, erros.get(errorCode));		
	}
}