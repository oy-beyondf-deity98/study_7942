package common.generic.crud;

import java.util.List;

public interface GenericInterface<E> {

	public int add(E entity);
	
	public int update(E entity);
	
	public E view(E entity);
	
	public int delete(E entity);
	
	public List<E> list(E entity);
	
}
