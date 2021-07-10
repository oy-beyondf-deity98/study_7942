package pe.kr.deity.salesforce;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaAuditing()
//@EnableJpaRepositories(basePackages = {"pe.kr.deity.salesforce"})
//@Configuration
@EnableJpaAuditing
@Configuration
public class JpaConfig {
}
