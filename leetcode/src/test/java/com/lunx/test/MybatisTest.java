package com.lunx.test;

import com.lunx.LeetcodeApplicationTests;
import com.lunx.dao.mapper.TestSecondMapper;
import com.lunx.dao.model.TestSecond;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    /**
     * mybatis 查询测试
     */
    @Test
    public void test1() {
        TestSecond testSecond = testSecondMapper.selectByPrimaryKey(1);
        System.out.println(testSecond);

        TestSecond testSecond1 = testSecondMapper.selectByPrimaryKey(1);
        System.out.println(testSecond1);
    }

    @Test
    public void mybatisCache() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestSecondMapper mapper = sqlSession.getMapper(TestSecondMapper.class);

        TestSecond testSecond = mapper.selectByPrimaryKey(1);
        System.out.println(testSecond);

        testSecond.setName("cache");
        mapper.updateByPrimaryKey(testSecond);

        TestSecond testSecond1 = mapper.selectByPrimaryKey(1);
        System.out.println(testSecond1);


        sqlSession.close();
    }

    /**
     * 事务测试
     */
    @Test
    public void transactionTest() {
        transaction.transaction2();
    }


}
