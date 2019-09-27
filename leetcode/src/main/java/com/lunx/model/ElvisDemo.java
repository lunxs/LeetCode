package com.lunx.model;

/**
 * @author desong.xie
 * @version 1.0
 * @title Elvis
 * @date 2019/09/20
 * @description
 */
public class ElvisDemo {

    private ElvisDemo() {}

    private static final ElvisDemo o = new ElvisDemo();

    public static ElvisDemo getInstance() {
        return o;
    }

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Elvis{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
