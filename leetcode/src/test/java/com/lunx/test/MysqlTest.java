package com.lunx.test;

import com.lunx.LeetcodeApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
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
    private JdbcTemplate jdbcTemplate;


    @Test
    public void test() {

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from test_first");
            int row = resultSet.getRow();
            System.out.println(row);
            System.out.println(resultSet);


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Test
    public void testJDBC() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * from test_first");

        System.out.println(maps);
    }
}
