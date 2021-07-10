package common.generic.select;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericSelectService {

	@Autowired
	GenericSelectDao dao;
	
	public List<Map<String,Object>> select(String reqMethod, Map<String,Object> bean) {
		
		return dao.select(reqMethod,bean);
		
	}
	
	
	
	public <E,K> E select2(String reqMethod, K bean) {
		return dao.select(reqMethod, bean);
	}

}
