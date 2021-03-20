package digytal.java.exemplos.jdbcjpa.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import digytal.java.exemplos.jdbcjpa.model.venda.Pedido;
import digytal.java.exemplos.jdbcjpa.repository.Repository;

public class JpaPedidoRepository implements Repository<Pedido> {
	private EntityManager entityManager;

	public JpaPedidoRepository() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MY_PU");
		entityManager = factory.createEntityManager();
	}

	public void insert(Pedido e) {
		entityManager.getTransaction().begin();
		entityManager.persist(e);
		entityManager.getTransaction().commit();

	}

	public void update(Pedido e) {
		entityManager.getTransaction().begin();
		entityManager.merge(e);
		entityManager.getTransaction().commit();

	}

	public Pedido select(Integer id) {
		return entityManager.find(Pedido.class,id);
	}

	public List<Pedido> selectAll() {
		Query query = entityManager.createQuery("SELECT e FROM Pedido e");
		return query.getResultList();
	}

}
