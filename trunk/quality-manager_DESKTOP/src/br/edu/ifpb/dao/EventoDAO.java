package br.edu.ifpb.dao;

import java.sql.SQLException;

import br.edu.ifpb.Banco;
import br.edu.ifpb.entidades.Entidade;
import br.edu.ifpb.entidades.Evento;
import br.edu.ifpb.exce��es.ClasseInv�lidaException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

// Campos da tabela
// ID_evento, nome, descri��o, localidade, ano, in�cio_evento, fim_evento, �rea_atua��o

public class EventoDAO implements DAO {
	
	public Connection connection;
	
	public EventoDAO(Banco banco) {
		
		this.connection = (Connection) banco.getConnection();	
		
	}

	@Override
	public void creat(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.Evento")) {
			Evento evento = (Evento) entidade;
			
			// Cria um insert com os atributos e os valores sem defini��o, apenas
			// com a quantidade de valores a ser inseridos (representado por "?").
			String sql = "INSERT INTO evento (nome, descri��o, localidade,"
					+ " ano, in�cio_evento, fim_evento, �rea_atua��o)"
					+ " values (?,?,?,?,?,?,?)";
		
			try {
				// prepara para inser��o
				PreparedStatement stmt = (PreparedStatement) connection
						.prepareStatement(sql);
				// seta os valores
				stmt.setString(1, evento.getNome());
				stmt.setString(2, evento.getDescri��o());
				stmt.setString(3, evento.getLocalidade());
				stmt.setString(4, evento.getAno());
				stmt.setDate(5, evento.getIn�cioEvento());
				stmt.setDate(6, evento.getFimEvento());
				stmt.setString(7, evento.get�reaAtua��o());
				
				// executa
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		else {
			throw new ClasseInv�lidaException();
		}
	}

	@Override
	public void read(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.Evento")) {
			
		}
		else {
			throw new ClasseInv�lidaException();
		}
	}

	@Override
	public void update(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.Evento")) {
			Evento evento = (Evento) entidade;
			
			String sql = "UPDATE evento SET nome=?, descri��o=?, localidade=?, ano=?,"
					+ " in�cio_evento=?, fim_evento=?, �rea_atuacao=? WHERE id_evento=?";
		
			try {
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setString(1, evento.getNome());
				stmt.setString(2, evento.getDescri��o());
				stmt.setString(3, evento.getLocalidade());
				stmt.setString(4, evento.getAno());
				stmt.setDate(5, evento.getIn�cioEvento());
				stmt.setDate(6, evento.getFimEvento());
				stmt.setString(7, evento.get�reaAtua��o());
				stmt.setInt(7, evento.getIDEvento());
				
				stmt.execute();
				stmt.close();
		
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		else {
			throw new ClasseInv�lidaException();
		}
	}

	@Override
	public void delete(Entidade entidade) throws ClasseInv�lidaException {
		if(entidade.getClass().equals("class br.edu.ifpb.entidades.Evento")) {
			Evento evento = (Evento) entidade;
			
			String sql = "DELETE FROM evento WHERE ID_evento=?";
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setInt(1, evento.getIDEvento());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			throw new ClasseInv�lidaException();
		}
	}

}
