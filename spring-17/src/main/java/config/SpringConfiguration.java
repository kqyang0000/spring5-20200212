package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.kqyang")
@Import({JdbcConfiguration.class, TransactionConfiguration.class})
@PropertySource("jdbc.properties")
@EnableTransactionManagement
public class SpringConfiguration {
}
