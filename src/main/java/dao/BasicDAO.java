package dao;

import java.sql.SQLException;

public abstract class BasicDAO {

	public abstract void incluir(Object obj) throws SQLException;
	
	public abstract void deletar(Object obj) throws SQLException;
	
	public abstract void editar(Object obj) throws SQLException;
	
	public abstract void listar(Object obj) throws SQLException;
	
}
