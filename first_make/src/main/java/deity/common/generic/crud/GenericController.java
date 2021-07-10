package common.generic.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 테이블에 기반한 가장 기본적인 CRUD를 위한 조치
 * @author deity
 *
 * @param <E>
 * @param <S>
 */
public abstract class GenericController<E,S extends GenericInterface<E>> {

	@Autowired
	S service;
	
	@RequestMapping("/add")
	public void add(E entity) {
		int cnt = service.add(entity);
		//몇건 처리완료 메세지
	}
	
	@RequestMapping("/update")
	public void update(E entity) {
		int cnt = service.update(entity);
	}
	
	@RequestMapping("/view")
	public @ResponseBody E view(E id) {
		E e = service.view(id);
		return e;
//		return null;
	}
	
	@RequestMapping("/delete")
	public void delete(E id) {
		int cnt = service.delete(id);
	}
	
	@RequestMapping("/list")
	public @ResponseBody List<E> list(E id){
		
		
		return service.list(id);
	}
}
