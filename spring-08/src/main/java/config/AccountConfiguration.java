package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan(basePackages = {"com.kqyang"})
public class AccountConfiguration {

    /**
     * 当有参数时，相当于 @AutoWired的作用
     *
     * @param dataSource
     * @return
     */
    @Bean
    @Scope("singleton")
    public QueryRunner queryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://62.234.136.79:3306/spring5");
            dataSource.setUser("root");
            dataSource.setPassword("asdQWE123");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
