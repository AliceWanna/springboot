package com.gt.javaSE.other;

import com.javaSE.bean.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class demo1 {


    public void autoWrapper(Object o){
        System.out.println(o.getClass());
    }


    abstract class demo{
      abstract void method();
    }

    @Test
    public void InterfaceDemo(){
        demo demo = new demo() {
            @Override
            public void method() {

            }
        };
    }

    @Test
    public void test11() {
        System.out.println(demo22.n);
    }


        @Test
    public void test10() {
        Integer a1 = 1;
        Integer a2 = 1;
        Integer b1 = new Integer(1);
        Integer b2 = new Integer(1);
        System.out.println(a1==a2);
        System.out.println(b1==b2);
    }

        @Test
    public void test9() {
        ConstructorDemo a;
    }

        @Test
    public void test8() {
        Sub s  = new Sub();
        System.out.println("-------------------------");
        s.common();
    }

        @Test
    public void test7() {
        BlockDemo b = null;
        b = new BlockDemo();
    }

        @Test
    public void test6() {
        System.out.println(Integer.MIN_VALUE);
        autoWrapper(1);

    }

    @Test
    public void test5(){
        //1.boolean equals(int[] a,int[] b):判断两个数组是否相等。
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,3,2,4};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);

        //2.String toString(int[] a):输出数组信息。
        System.out.println(Arrays.toString(arr1));


        //3.void fill(int[] a,int val):将指定值填充到数组之中。
        Arrays.fill(arr1,10);
        System.out.println(Arrays.toString(arr1));


        //4.void sort(int[] a):对数组进行排序。
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        //5.int binarySearch(int[] a,int key)
        int[] arr3 = new int[]{-98,-34,2,34,54,66,79,105,210,333};
        int index = Arrays.binarySearch(arr3, 210);
        if(index >= 0){
            System.out.println(index);
        }else{
            System.out.println("未找到");
        }

    }

    @Test
    public  void t4() {
        Sub s = new Sub();
        Class<? extends Sub> aClass1 = s.getClass();
        Base b = s;
        Class<? extends Base> aClass = b.getClass();
        Class<Sub> subClass = Sub.class;
        System.out.println("b.class---->");
//        Sub sub = new Sub();
//        sub.say();
//        System.out.println(sub.getCount());
//        Base b = sub;
//        b.say();
//        System.out.println(b.getCount());
//        Assertions.assertEquals(sub,b,"not equals");

    }

        @Test
    public  void t3() {
        son s = new son();
        s.say();
    }

        @Test
    public void t2(){
        son s = new son();

        System.out.println(s);
    }

        @Test
    public void t1(){
        ReloadDemo reloadDemo = new ReloadDemo();
        reloadDemo.test("for1","for2","for3");
    }
}
