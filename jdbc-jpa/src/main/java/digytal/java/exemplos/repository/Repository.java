package digytal.java.exemplos.repository;

import java.util.List;

public interface Repository<E> {
	public void insert(E e);
	public void update(E e);
	public E select(Integer id);
	public List<E> selectAll();
}
