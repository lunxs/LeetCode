package com.lunx.test;

/**
 * @author XieDesong
 * @version 1.0
 * @title Derive
 * @description
 * @date 2019/06/04
 */
public class Derive extends Base
{
    private Member m1 = new Member("Member 1");
    {
        System.out.println("Initial Block{}");
    }

    static {
        System.out.println("static{}");
    }

    public Derive() {
        System.out.println("Derive()");
    }

    private Member m2 = new Member("Member 2");
    private int i = getInt();

    private int getInt()
    {
        System.out.println("getInt()");
        return 2;
    }

    public static void main(String[] args)
    {
        new Derive();
    }
}

class Base
{

    public Base()
    {
        System.out.println("Base()");
    }

    {
        System.out.println("base {}");
    }

    private int geti() {
        System.out.println("base geti()");
        return 0;
    }

    static {
        System.out.println("base static{}");
    }
}

class Member
{
    public Member(String m)
    {
        System.out.println("Member() "+m);
    }
}
