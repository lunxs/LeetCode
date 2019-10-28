package com.lunx.test;

import com.lunx.LeetcodeApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;

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


    @Test
    public void test() {

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from test_first");
            System.out.println(resultSet);


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
