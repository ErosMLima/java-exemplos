package digytal.java.exemplos.jdbcjpa.repository.jdbc;

import java.util.List;

import digytal.java.exemplos.jdbcjpa.model.venda.Pedido;
import digytal.java.exemplos.jdbcjpa.repository.Repository;

public class JdbcPedidoRepository extends JDBCConnection implements Repository<Pedido> {
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
