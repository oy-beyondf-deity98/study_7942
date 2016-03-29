package lab.spring.jpa;

/**
 * 설정정보 : http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "hello world!";
    }
    
	@RequestMapping("/login")
	String body(){
		return "index";
	}    

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
    
    
}
