package com.vertexid.hdt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class MessageController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
	
	
	@RequestMapping(value = "/hdt/message")
	public String getMessage(Model model, @RequestParam(value="param", required=false) String param){
		
		LOGGER.debug(param);
		//System.out.println(param);
		
		
		return "home";
	}

}
