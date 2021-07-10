package com.tk.loc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import common.DaoService;

@Repository
public class OperationMngDao extends DaoService {
	
	Logger logger = Logger.getLogger(OperationMngDao.class);
	public List saveOp(Map map) {
		
		logger.info("Dao Start~~~");
		
		List list = selectList("com.tk.operationDaoMapper.select",map);
		
		logger.info("Dao End~~~");
		logger.info(list);
		return list;
	}

}
