package com.lunx.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author desong.xie
 * @version 1.0
 * @title DruidConfiguration
 * @date 2019/09/30
 * @description
 */
@Configuration
public class DruidConfiguration {

    @Bean
    @Primary
    public DataSource dataSource(Environment environment) {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(environment.getProperty("spring.datasource.url"));
        datasource.setUsername(environment.getProperty("spring.datasource.data-username"));
        // 这里可以做加密处理
        datasource.setPassword(environment.getProperty("spring.datasource.data-password"));
        datasource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));

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

    @Bean(value = "jdbcTemplate")
    @Primary
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 设置ip白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // 设置ip黑名单，优先级高于白名单
        servletRegistrationBean.addInitParameter("deny", "192.168.0.19");
        // 设置控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "root");
        servletRegistrationBean.addInitParameter("loginPassword", "root");
        // 是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter() {
        // 创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        // 忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
