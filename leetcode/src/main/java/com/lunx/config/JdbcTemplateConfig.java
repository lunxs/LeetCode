package com.lunx.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/10/23
 * @description
 */
@Configuration
public class JdbcTemplateConfig {

    @Bean(value = "jdbcTemplate")
    @Primary
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

//    @Bean(value = "mysql5JdbcTemplate")
//    public JdbcTemplate jdbcTemplate2(@Qualifier("mysql5DataSource") DataSource dataSource) {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        return jdbcTemplate;
//    }
}
