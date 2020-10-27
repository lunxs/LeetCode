package com.lunx.test;

import com.lunx.LeetcodeApplicationTests;
import com.lunx.dao.mapper.TestSecondMapper;
import com.lunx.dao.model.TestSecond;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/10/22
 * @description
 */
public class MybatisTest extends LeetcodeApplicationTests {

    @Resource
    private TestSecondMapper testSecondMapper;

    @Autowired
    private TransactionTest transaction;


    /**
     * mybatis 查询测试
     */
    @Test
    public void test1() {
        TestSecond testSecond = testSecondMapper.selectByPrimaryKey(1);
        System.out.println(testSecond);
    }

    /**
     * 事务测试
     */
    @Test
    public void transactionTest() {
        transaction.transaction(true);
    }


}
