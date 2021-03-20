package digytal.java.exemplos.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hsqldb.util.DatabaseManagerSwing;

import digytal.java.exemplos.model.venda.Pedido;
import digytal.java.exemplos.repository.Repository;
import digytal.java.exemplos.util.StartHSQLDB;

public class JdbcPedidoRepository implements Repository<Pedido> {
	private Connection connecton;
	public JdbcPedidoRepository() {
		try {
			connecton= DriverManager.getConnection(StartHSQLDB.JDBC_FILE_URL, "SA", "");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
	}
	public void insert(Pedido e) {
		
		
	}

	public void update(Pedido e) {
		
	}
	public Pedido select(Integer id) {
		return null;
	}

	public List<Pedido> selectAll() {
		return null;
	}
	

}
