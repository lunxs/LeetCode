package com.lunx.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author desong.xie
 * @version 1.0
 * @title DruidConfiguration
 * @date 2019/09/30
 * @description
 */
@Configuration
public class DruidConfiguration4Mysql5 {

    /*@Bean(value = "mysql5DataSource")
    public DataSource dataSource(Environment environment) {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(environment.getProperty("spring.datasource.url-5"));
        datasource.setUsername(environment.getProperty("spring.datasource.data-username-5"));
        // 这里可以做加密处理
        datasource.setPassword(environment.getProperty("spring.datasource.data-password-5"));
        datasource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name-5"));

        // configuration
        // 初始化连接大小
        datasource.setInitialSize(5);
        // 最小连接池数量
        datasource.setMinIdle(5);
        // 最大连接池数量
        datasource.setMaxActive(20);
        // 获取连接时最大等待时间，单位毫秒
        datasource.setMaxWait(60000L);
        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        datasource.setTimeBetweenEvictionRunsMillis(60000L);
        // 配置一个连接在池中最小生存的时间，单位是毫秒
        datasource.setMinEvictableIdleTimeMillis(300000L);
        // 测试连接
        datasource.setValidationQuery("SELECT 1 FROM DUAL");
        // 申请连接的时候检测，建议配置为true，不影响性能，并且保证安全性
        datasource.setTestWhileIdle(true);
        // 获取连接时执行检测，建议关闭，影响性能
        datasource.setTestOnBorrow(false);
        // 归还连接时执行检测，建议关闭，影响性能
        datasource.setTestOnReturn(false);
        // 是否开启PSCache，PSCache对支持游标的数据库性能提升巨大，oracle建议开启，mysql下建议关闭
        datasource.setPoolPreparedStatements(false);
        // 开启poolPreparedStatements后生效
        datasource.setMaxPoolPreparedStatementPerConnectionSize(20);
        try {
            // 配置扩展插件，常用的插件有 => stat:监控统计 wall:防御sql注入 log4j:日志
            datasource.setFilters("stat,wall");
        } catch (SQLException e) {

        }
        // 通过connectProperties属性来打开mergeSql功能;慢SQL记录
        datasource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000");

        return datasource;
    }

    @Bean(value = "mysql5JdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("mysql5DataSource") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }*/

}
