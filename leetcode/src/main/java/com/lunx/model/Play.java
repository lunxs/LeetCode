package com.lunx.model;

import java.util.List;

/**
 * @author XieDesong
 * @version 1.0
 * @title Play
 * @description
 * @date 2018/11/06
 */
public class Play {

    private final String a = xx();
    private int id;

    private String name;

    private int age;

    private int weight;

    private boolean flag;

    private List<Integer> phones;

    private String xx() {
        System.out.println("init a");
        return "x";
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getPhones() {
        return phones;
    }

    public void setPhones(List<Integer> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Play{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", flag=" + flag +
                ", phones=" + phones +
                '}';
    }
}
