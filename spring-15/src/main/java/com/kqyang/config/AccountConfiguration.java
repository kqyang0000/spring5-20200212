package com.kqyang.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@Import(JdbcConfiguration.class)
@PropertySource("classpath:jdbc.properties")
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
}
