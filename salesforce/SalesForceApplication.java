package pe.kr.deity.salesforce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesForceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesForceApplication.class, args);
    }


    public String test(){
        return "hello, here is SalesForce";
    }
}
