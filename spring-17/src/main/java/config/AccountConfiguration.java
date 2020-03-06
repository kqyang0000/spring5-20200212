package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(JdbcConfiguration.class)
@PropertySource("classpath:jdbc.properties")
@ComponentScan(basePackages = {"com.kqyang"})
public class AccountConfiguration {

}
