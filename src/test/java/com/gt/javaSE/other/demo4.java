package com.gt.javaSE.other;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ff{
    void show(){
        System.out.println("ff.show()...");
        over();
    }
    void over(){
        System.out.println("ff.over()...");
    }
    void multi(String...args) {
        int length = args.length;
        args.toString();
        System.out.println(args.getClass());
    }
}

class ss extends ff{
    @Override
    void over() {
        System.out.println("ss.over()...");
    }
}

public class demo4 {

    @Test
    public void t6() {
        ff ff = new ff();
        ff.multi("asd","dddd","aafg");
        String[] strings = {"ad", "ad"};
        System.out.println(strings.getClass());
    }

        @Test
    public void t5(){
        ss ss = new ss();
        ss.show();
        System.out.println("**************");
        ff f = ss;
        f.show();
    }

        @Test
    public void t4() throws InterruptedException {
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        Thread.sleep(1000L);
        for (int i = 1; i < 100000; i= i*2) {
        }
        long l2 = System.currentTimeMillis();
        System.out.println("first --------- :" + (l2 -l1));
        l1 = System.currentTimeMillis();
        System.out.println(l1);
        for (int i = 1; i < 100000; i=i<<2) {
        }
        l2 = System.currentTimeMillis();
        System.out.println("first --------- :" + (l2 -l1));
    }

        @Test
    public void t3() {
        String[] sss = new String[]{"aaa","aaa","aaa","aaa"};
        for (String s : sss) {
            System.out.println(s);

        }
    }
        @Test
    public void t2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        for (String o : list) {
            o = "ddd";
        }
        for (String o : list) {
            System.out.println(o);
        }
//        List<? extends Serializable> hh = Arrays.asList("hh", new Date());
//        System.out.println(hh.getClass());
    }

        @Test
    public void t1(){
        Class<ArrayList> arrayListClass = ArrayList.class;
        ArrayList<Object> list = new ArrayList<>();
        Class<? extends ArrayList> aClass = list.getClass();
    }
}
