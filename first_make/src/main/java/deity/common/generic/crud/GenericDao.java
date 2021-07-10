package common.generic.crud;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.DaoService;

@Repository
public class GenericDao<E extends GenericBean> extends DaoService{

	
	public int add(E entity) {
		String SqlXML = entity.getSqlXML();
		String method = SqlXML +".add";
		return insert(method,entity);
	}

	public int update(E entity) {
		String SqlXML = entity.getSqlXML();
		String method = SqlXML +".modify";
		return update(method,entity);
	}

	public E view(E id) {
		String SqlXML = id.getSqlXML();
		String method = SqlXML +".get";
		return selectOne(method,id);
	}

	public int delete(E id) {
		String SqlXML = id.getSqlXML();
		String method = SqlXML +".delete";		
		return delete(method,id);
	}

	public List<E> list(E id) {
		String SqlXML = id.getSqlXML();
		String method = SqlXML +".getAll";		
		return selectList(method,id);
	}
	
	

}
