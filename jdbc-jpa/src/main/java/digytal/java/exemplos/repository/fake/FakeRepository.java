package digytal.java.exemplos.repository.fake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import digytal.java.exemplos.repository.Repository;

public class FakeRepository <E> implements Repository<E> {
	//repositorio - em memoria - atraves de um map
	private Map<Integer, E> dados = new HashMap<Integer, E>();

	public void insert(E e) {
		dados.put(dados.size() + 1, e);
	}
	
	public void update(Integer id, E e) {
		dados.put(id, e);
	}
	
	public E select(Integer id) {
		return dados.get(id);
	}


	public List<E> selectAll() {
		return new ArrayList<E>(dados.values());
	}
}
