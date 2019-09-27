package com.lunx.test;

import com.lunx.LeetcodeApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;

/**
 * @author desong.xie
 * @version 1.0
 * @title RedisTest
 * @date 2019/09/27
 * @description
 */
public class RedisTest extends LeetcodeApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("test-key", "test-demo");

        String s = stringRedisTemplate.opsForValue().get("test-key");

        System.out.println(s);
    }

    @Test
    public void testHash() {
        BoundHashOperations aaa = redisTemplate.boundHashOps("aaa");
        aaa.put("123", "123");

        Object o = aaa.get("123");
        System.out.println(o);
    }

    @Test
    public void testList() {
        BoundListOperations kkk = redisTemplate.boundListOps("kkk");
        System.out.println("size:" + kkk.size());

        Long aLong = kkk.leftPush("234", "345");
        System.out.println("aLong:" + aLong);
        System.out.println("size:" + kkk.size());

        Object o = kkk.rightPop();
        System.out.println(o);
        System.out.println("size:" + kkk.size());
    }

    @Test
    public void testStrList() {
        ListOperations<String, String> stringStringListOperations = stringRedisTemplate.opsForList();
//        stringStringListOperations.leftPush("789", "456");
//        stringStringListOperations.leftPush("789", "567");
//        stringStringListOperations.leftPush("789", "678");
        Long size = stringStringListOperations.size("789");
        System.out.println("size:" + size);

//        String s = stringStringListOperations.rightPop("789");
//        System.out.println("s:" + s);
        String index = stringStringListOperations.index("789", 1);
        System.out.println(index);


    }
}
