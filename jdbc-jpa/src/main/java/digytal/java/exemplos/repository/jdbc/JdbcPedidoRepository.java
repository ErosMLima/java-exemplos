package digytal.java.exemplos.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hsqldb.util.DatabaseManagerSwing;

import digytal.java.exemplos.model.venda.Pedido;
import digytal.java.exemplos.repository.Repository;

public class JdbcPedidoRepository implements Repository<Pedido> {
	private Connection connecton;
	public JdbcPedidoRepository() {
		try {
			connecton= DriverManager.getConnection("jdbc:hsqldb:file:/temp/db/exemplo-db", "SA", "");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
	}
	public void insert(Pedido e) {
		
		
	}

	public void update(Integer id, Pedido e) {
		
	}
	public Pedido select(Integer id) {
		return null;
	}

	public List<Pedido> selectAll() {
		return null;
	}
	

}
