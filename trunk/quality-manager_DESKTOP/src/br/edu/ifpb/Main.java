/**
 * 
 */
package br.edu.ifpb;

import java.sql.SQLException;
import java.text.ParseException;

import br.edu.ifpb.dao.EditalExtens�oDAO;
import br.edu.ifpb.dao.Institui��oDAO;
import br.edu.ifpb.dao.ProgramaInstitucionalExtens�oDAO;
import br.edu.ifpb.entidades.EditalExtens�o;
import br.edu.ifpb.entidades.Institui��o;
import br.edu.ifpb.entidades.ProgramaInstitucionalExtens�o;

/**
 * @author 
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws SQLException, ParseException {
		
		
		Banco b = new Banco();
		b.iniciarConexao("root", "ifpbinfo");
		
		Institui��o inst = new Institui��o("Conselho Nacional de Desenvolvimento Cient�fico e Tecnol�gico", "CNPQ", 1000);
		Institui��oDAO daoInst = new Institui��oDAO(b);
		daoInst.adiciona(inst);
		
		
		ProgramaInstitucionalExtens�o pie = new ProgramaInstitucionalExtens�o("PIBIC",
				"Programa Institucional de Bolsas de Inicia��o Cient�fica", 7);
		ProgramaInstitucionalExtens�oDAO daoPIE = new ProgramaInstitucionalExtens�oDAO(b);
		daoPIE.adiciona(pie);
		
		
		EditalExtens�oDAO daoEdt = new EditalExtens�oDAO(b);
		EditalExtens�o edt = new EditalExtens�o("2011.1", "12/03/2011", "25/03/2011",
				"2011", "20/09/2011", "20/02/2012", 10, 500, 100, 4);
		daoEdt.adiciona(edt);
		
		b.encerrarConexao();

	}

}
