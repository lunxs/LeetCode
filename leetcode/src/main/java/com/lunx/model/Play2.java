package com.lunx.model;

/**
 * @author XieDesong
 * @version 1.0
 * @title Play2
 * @description
 * @date 2018/12/26
 */
public class Play2 extends Play {

    private int come;

    public int getCome() {
        return come;
    }

    public void setCome(int come) {
        this.come = come;
    }

    @Override
    public String toString() {
        return "Play2{" +
                "come=" + come +
                '}';
    }
}
