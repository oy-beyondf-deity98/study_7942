package com.tk.common;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tk.loc.OperationMngDao;

@Component
public class CommonService {
	Logger logger = Logger.getLogger(CommonService.class);
	
	
	@Autowired
	private OperationMngDao dao;	
	
	public void saveMultiLang(MultiLangDto dto)  {
		
		String queryId = "com-cello-tk-dao-commonDao-saveMultiLang";
		
		Map<String, Object> saveMap = new HashMap<String,Object>();
		
		try {
			saveMap = BeanUtils.describe(dto);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		if(dto.getCodeNm() == null || dto.getLangs() == null || dto.getCodeNm().size() !=dto.getLangs().size()) {
			throw new RuntimeException("코드명과 언어의길이가 같지 않습니다.");
		}
		
		saveMap.put("clntCd", "VT");
		saveMap.put("userId", "kgp79");
		
		for(int i=0;i<dto.getCodeNm().size();i++) {
			saveMap.put("nm",dto.getCodeNm().get(i));
			saveMap.put("lang",dto.getLangs().get(i));

		}
		
		logger.info(dao.saveOp(saveMap));
		logger.info("------------------------");
		logger.info("------------------------");
		logger.info("------------------------");
		logger.info("------------------------");
		
//		for(int i=0;i<dto.getCodeNm().length;i++) {
//			saveMap.put("codeNm",dto.getCodeNm()[i]);
//			saveMap.put("codeNm",dto.getLangs()[i]);
//			
////			dao.update(queryId, saveMap);
//		}
//		
	}	
}
