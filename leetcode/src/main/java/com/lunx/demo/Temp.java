package com.lunx.demo;

public class Temp {

    public static void main(String args[]) {
        int array[] = { 1, 2, 3, 4, 5 };
        printArray(array);
        could_modify(array);
        printArray(array);
    }

    static void could_modify(int a[]) {
        for (int i = 0; i < a.length; i++)
            a[i] *= i;
    }

    static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + "\t");
        System.out.println();
    }
}
