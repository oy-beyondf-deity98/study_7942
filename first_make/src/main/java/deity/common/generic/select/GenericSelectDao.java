package common.generic.select;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import common.DaoService;

@Repository
public class GenericSelectDao extends DaoService{

	public List<Map<String, Object>> select(String reqMethod, Map<String, Object> paramMap) {
		
		return selectList(reqMethod,paramMap);
	}
	
	/**
	 * Java7 (1.7.0_71)을 사용하여 MacOSX에서 이것을 실행하면 StackOverflowError가 발생 
	 * 하지만 Java8 (1.8.0_25)에서 실행하면 성공적으로 실행됩니다.
	 * 근데난 java8인데도 문제가 발생하였다.
	 * @param reqMethod
	 * @param bean
	 * @return
	 */
	public <K,E> E select(String reqMethod, K paramMap) {
		return select(reqMethod, paramMap);
	}
	
}
