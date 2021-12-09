package com.javaSE;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClasslooderDemo {

    public static void main(String[] args) throws IOException {
        InputStream is = ClasslooderDemo.class.getClassLoader().getResourceAsStream("demo.properties");
        Properties props = new Properties();
        props.load(is);
        System.out.println(props);

    }
}
