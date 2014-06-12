package br.edu.ifpb.exce��es;

public class ClasseInv�lidaException extends Exception {
	
	private static final long serialVersionUID = -1290509255312012050L;

	public ClasseInv�lidaException() {
		super("Classe inv�lida! Verifique tipo de Classe passada como par�metro!");
	}
	
	public ClasseInv�lidaException(String mensagem) {
		super(mensagem);
	}
	
}
