package com.tk.loc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tk.common.CommonService;
import com.tk.common.MultiLangDto;

@Service
public class OperationMngService {

	@Autowired 
	private CommonService commonService;
	
	public void saveOperation() {
		MultiLangDto multiLang = new MultiLangDto();
		multiLang.setTable("TBL_PMD_SITE_MST");
		multiLang.setCode("A");
		multiLang.setColumn("A");
//		multiLang.setCodeNm();
		
		multiLang.setCodeNm(Arrays.asList("A","에이","zun"));
		multiLang.setLangs(Arrays.asList("EN","KR","VN"));
		
		commonService.saveMultiLang(multiLang);
		
	}
}
