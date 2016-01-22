package lab.spring.jpa.example.controller;

import java.util.Date;

import lab.spring.jpa.example.domain.JustOne;
import lab.spring.jpa.example.domain.JustOneEnum;
import lab.spring.jpa.example.repository.JustOneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JustOneController {

	@Autowired JustOneRepository repository;
	
	@RequestMapping("/one")
	String test(){
		JustOne one = new JustOne();
		one.setDateJoin(new Date());
		one.setEnumOne(JustOneEnum.ONE);
		one.setMessage("hello");
		one.setPasswordConfirm("1234");
		repository.save(one);
		
		return "test/test";
	}
}
