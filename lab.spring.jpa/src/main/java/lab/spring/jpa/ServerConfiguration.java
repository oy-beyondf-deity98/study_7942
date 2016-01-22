package lab.spring.jpa;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 파일업로드때문에 넣음.
 * @author deity
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class ServerConfiguration extends WebMvcAutoConfiguration {

}
