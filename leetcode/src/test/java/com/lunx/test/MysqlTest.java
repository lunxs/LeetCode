package com.lunx.test;

import com.lunx.LeetcodeApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * @author desong.xie
 * @version 1.0
 * @title MysqlTest
 * @date 2019/10/08
 * @description
 */
public class MysqlTest extends LeetcodeApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    @Qualifier("mysql5JdbcTemplate")
//    private JdbcTemplate mysql5JdbcTemplate;


    /**
     * DataSource 测试
     */
    @Test
    public void test() {

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from test_first limit 2");
            int row = resultSet.getRow();
            System.out.println(row);
            System.out.println(resultSet);


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    /**
     * JDBC 测试
     */
    @Test
    public void testJDBC() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * from test_first limit 2");
        System.out.println(maps);

    }

    /**
     * 第二个数据源测试
     */
//    @Test
//    public void test2JDBC() {
//
//        List<Map<String, Object>> maps4Mysql5 = mysql5JdbcTemplate.queryForList("SELECT * from ent_base_info limit 2");
//        System.out.println(maps4Mysql5);
//    }

    /**
     * 双数据源 测试
     */
//    @Test
//    public void testTwoJDBC() {
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * from test_first limit 2");
//        System.out.println(maps);
//
//        List<Map<String, Object>> maps4Mysql5 = mysql5JdbcTemplate.queryForList("SELECT * from ent_base_info limit 2");
//        System.out.println(maps4Mysql5);
//    }



}
