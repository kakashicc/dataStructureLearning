package com.daojia.datastructures.learn.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/5 19:19.
 */
public class FileTest {

    public static void main(String[] args) {
        read();
        read1();
        copyFile();
    }

    public static void read() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\maosen\\Desktop\\aa.txt");
            int value;
            value = fis.read();
            while (value != -1) {
                System.out.println(value);
                value = fis.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void read1() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\maosen\\Desktop\\aa.txt");
            StringBuilder result = new StringBuilder();
            int value;
            value = fis.read();
            while (value != -1) {
                result.append((char)value);
                value = fis.read();
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void read2() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\maosen\\Desktop\\aa.txt");
            StringBuilder result = new StringBuilder();
            int value;
            byte [] buffer = new byte[1024];
            value = fis.read(buffer);
            while (value != -1) {
                result.append(new String(buffer,0,value));
                value = fis.read(buffer);
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void copyFile(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("C:\\Users\\maosen\\Desktop\\aa.txt");
            fos = new FileOutputStream("C:\\Users\\maosen\\Desktop\\ab.txt");
            StringBuilder result = new StringBuilder();
            int value;
            byte [] buffer = new byte[1];
            value = fis.read(buffer);
            while (value != -1) {
                System.out.println(value);
                System.out.println((char)buffer[0]);
                fos.write(buffer,0,value);
                value = fis.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
