package com.lunx.test;

import com.lunx.LeetcodeApplicationTests;
import com.lunx.dao.mapper.TestSecondMapper;
import com.lunx.dao.model.TestSecond;
import org.junit.Test;

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


    @Test
    public void test1() {
        TestSecond testSecond = testSecondMapper.selectByPrimaryKey(1);
        System.out.println(testSecond);
    }

}
