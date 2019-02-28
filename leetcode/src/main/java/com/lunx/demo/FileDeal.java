package com.lunx.demo;

import java.io.*;

/**
 * @author XieDesong
 * @version 1.0
 * @title FileDeal
 * @description
 * @date 2019/02/28
 * Coffee Box 连咖啡
 */
public class FileDeal {

    private static void read() {
        // 1、创建一个文件对象
        // E:\ddd
        File file = new File("E:\\ddd\\0b49aabca1f7552e9dddd2bec067f3dbac8e6ca9");

        // 2、使用字节流对象读入内存

        try {
            InputStream fileIn = new FileInputStream(file);
            //DataInputStream in = new DataInputStream(fileIn);

            // 使用缓存区读入对象效率更快
            BufferedInputStream in = new BufferedInputStream(fileIn);

            FileOutputStream fileOut = new FileOutputStream("E:\\ddd\\Java1Demo.java");
            DataOutputStream dataOut = new DataOutputStream(fileOut);

            // 使用缓存区写入对象效率更快
            //BufferedOutputStream dataOut=new BufferedOutputStream(fileOut);
            int temp;
            while ((temp = in.read()) != -1) {
                dataOut.write(temp);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void readDirectory(String directoryPath) {
        // 1、创建一个文件夹
        File directory = new File(directoryPath);

        // 2、使用字节流对象读入内存
        try {
            String[] list = directory.list();

            for (int i = 0; i < list.length; i++) {

                InputStream fileIn = new FileInputStream(new File(directoryPath + "\\" + list[i]));
                BufferedInputStream in = new BufferedInputStream(fileIn);

                FileOutputStream fileOut = new FileOutputStream(directoryPath + "\\" + i + ".java");
                DataOutputStream dataOut = new DataOutputStream(fileOut);

                int temp;
                while ((temp = in.read()) != -1) {
                    dataOut.write(temp);
                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        readDirectory("E:\\ddd");
    }
}
