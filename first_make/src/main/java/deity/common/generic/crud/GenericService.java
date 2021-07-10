package common.generic.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericService<E extends GenericBean> implements GenericInterface<E>{

	@Autowired
	GenericDao<E> dao;
//	
	@Override
	public int add(E entity) {
		
		return dao.add(entity);
	}

	@Override
	public int update(E entity) {

		return dao.update(entity);
	}

	@Override
	public E view(E id) {
		return dao.view(id);
	}

	@Override
	public int delete(E id) {
		return dao.delete(id);
	}

	@Override
	public List<E> list(E id) {
		return dao.list(id);
	}

}
