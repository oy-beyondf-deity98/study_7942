package common.generic.crud.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.generic.crud.GenericController;
import common.generic.crud.GenericService;

@Controller
@RequestMapping("/rest/test/crud")
public class GenericTestController extends GenericController<GenericTestBean
										, GenericService<GenericTestBean>>{

}
