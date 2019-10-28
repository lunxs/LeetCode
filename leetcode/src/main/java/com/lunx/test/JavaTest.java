package com.lunx.test;

import com.lunx.model.ElvisDemo;
import com.lunx.model.Play;
import org.springframework.beans.BeanUtils;

/**
 * @author desong.xie
 * @version 1.0
 * @title JavaTest
 * @date 2019/09/09
 * @description
 */
public class JavaTest {

    private static void test() {
        Play play = new Play();
        play.setId(2);

        Play p = new Play();
        BeanUtils.copyProperties(play, p);
        p.setAge(3);

        System.out.println(play);
        System.out.println(p);
    }

    private static void test1() {
        ElvisDemo e1 = ElvisDemo.getInstance();
        e1.setId(1);
        System.out.println(e1);

        ElvisDemo e2 = ElvisDemo.getInstance();
        e2.setName("bb");
        System.out.println(e2);

    }

    public static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }

        System.out.println(param);
    }

    private static void test2() {
        String a = "2019102015:13:02.000000000";
        String b = "2019/10/2015:13:02.300000000";

        System.out.println(a.substring(1, 8));
    }

    public static void main(String[] args) {
        test2();
    }
}
