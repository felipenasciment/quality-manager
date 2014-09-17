package br.edu.ifpb.qmanager.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumeroValidator implements QManagerValidator{


	private Pattern pattern;
	private Matcher matcher;

	private static final String STRING_PATTERN = "[0-9]*";

	public NumeroValidator() {
		pattern = Pattern.compile(STRING_PATTERN);
	}
	
	@Override
	public boolean validate(final String value) {
		matcher = pattern.matcher(value.trim());
		return matcher.matches();
	}
	
	public boolean validate(final String value, int tamanho) {
		return (validate(value) 
				&& value.length() == tamanho);
	}
	
	public boolean isInteiroPositivo(int valor) {
		return (valor >= 0);		
	}
	
	public boolean isDoublePositivo(double valor) {
		return (valor >= 0);		
	}	
}
