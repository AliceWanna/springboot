package com.gt.javaSE.String;

import org.junit.jupiter.api.Test;

class StringDemo1111{
    String a = new String("aa");
    String b = "bb";
//    StringBuilder

    public void change1(String str1,String str2){
        System.out.println(str1 == a);
        System.out.println("a---hashcode:" + a.hashCode());
        System.out.println("b---hashcode:" + b.hashCode());
        System.out.println("str1---hashcode:" + str1.hashCode());
        System.out.println("str2---hashcode:" +str2.hashCode());
        str1 = new String("aaa-aaa");
        str2 = "bbb-bbb";
        System.out.println("********************");
        System.out.println("a---hashcode:" + a.hashCode() + a);
        System.out.println("b---hashcode:" + b.hashCode());
        System.out.println("str1---hashcode:" + str1.hashCode() + str1);
        System.out.println("str2---hashcode:" +str2.hashCode());
    }

    public void change2(String str1,String str2){
        System.out.println("a---hashcode:" + a.hashCode());
        System.out.println("b---hashcode:" + b.hashCode());
        a = str1;
        b = str2;
        System.out.println("********************");
        System.out.println("a---hashcode:" + a.hashCode());
        System.out.println("b---hashcode:" + b.hashCode());
    }
}

public class demo {

    @Test
    public void t6() {
        String a = "a";
        String aa = "a";
        System.out.println(a.hashCode());
        a = "b";
        System.out.println(a.hashCode());
        System.out.println(a == aa);
        System.out.println("****************");
        a = "a";
        a = new String("b");
        System.out.println(a.hashCode());
        System.out.println(a == aa);
    }

        @Test
    public void t4() {
        StringDemo1111 s = new StringDemo1111();
        s.change1(s.a,s.b);
        System.out.println("----------------");
        System.out.println("a---hashcode:" + s.a.hashCode());
        System.out.println("b---hashcode:" + s.b.hashCode());
        System.out.println("a :" + s.a );
        System.out.println("b :" + s.b );
    }

    @Test
    public void t3() {
        StringDemo1111 s = new StringDemo1111();
        s.change2("aa-aa",new String("bb-bb"));
        System.out.println("----------------");
        System.out.println("a---hashcode:" + s.a.hashCode());
        System.out.println("b---hashcode:" + s.b.hashCode());
        System.out.println("a :" + s.a );
        System.out.println("b :" + s.b );
    }
    @Test
    public void t5() {

        String a = "";
        String b = new String();
        System.out.println(a == b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    @Test
    public void t2() {

        String a = "abc";
        String b = "def";
        String c = "abc" + "def";
        String d = new String("abc");
        String e = new String("def");
        String f = d;
        String g = a + "";
        String gg = a ;

        String h = d + e;
        String i = a + b;
        System.out.println(a == gg);
        System.out.println(a == g);
        System.out.println(a.equals(g));
        System.out.println(i == c);
        System.out.println(h == c);


        System.out.println(g == d);
        System.out.println(f == d);
        System.out.println(a == f);


    }

        @Test
    public void t1(){
        String a = "222";
        String b = new String("222");
        String c = "111";
        b = "111";
        System.out.println(a==b);
        System.out.println(b==c);
        b = new String("111");
        System.out.println(b == c);
    }
}
