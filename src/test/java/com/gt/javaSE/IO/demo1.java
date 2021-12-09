package com.gt.javaSE.IO;

import org.junit.jupiter.api.Test;

import java.io.*;

public class demo1 {

    @Test
    public void streamOut() throws Exception{
        FileOutputStream fos = new FileOutputStream("demo2.txt", true);

    }

    @Test
    public void streamIn() throws Exception{
//        FileOutputStream fos = new FileOutputStream("demo2.txt", true);
        FileInputStream fis = new FileInputStream("demo2.txt");
        byte[] b = new byte[1024];
        byte aa = '-';
        int len;
        while ((len = fis.read(b)) != -1){
            for (int i = 0; i < len; i++) {
                System.out.print(b[i]);
            }
            System.out.println();
            System.out.println("*************");
            String str = new String(b,0,len);
            System.out.println(str);
        }
        fis.close();
    }

    @Test
    public void test2(){
        char a = '汉';
        System.out.println((int)a);
    }

    @Test
    public void test1(){
        File f = new File("hell");
        System.out.println(f.getAbsolutePath());
    }

    @Test
    public void write() throws Exception{
        FileWriter fw = new FileWriter("demo1.txt",false);

        fw.write("大大撒旦demosss");
        fw.close();

    }

    @Test
    public void read() throws Exception{
        FileReader fr = new FileReader("gbk.txt");

        char[] c = new char[10];
        int len;
        while ((len = fr.read(c)) != -1){
            String str = new String(c,0,len);
            System.out.println(str);
        }
        fr.close();
    }
}
