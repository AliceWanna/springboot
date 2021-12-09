package com.gt.javaSE.Iter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

class ooo{
    public int a = 10;

    @Override
    public String toString() {
        return "ooo{" +
                "a=" + a +
                '}';
    }
}

class ddd extends ooo{

}

public class demo1 {

    @Test
    public void t5(){
        ooo o = null;
        System.out.println(o.getClass());
    }

    @Test
    public void t4() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("aaa");
        list.add(new ooo());
        list.add(new Date());
        list.add(new Object());

        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            if(next instanceof ooo){
                ooo o = (ooo) next;
                o.a =100;
                break;
            }
        }
        Object o = list.get(1);
        System.out.println(o);
    }

        @Test
    public void t3() {
        Object[] objects = new Object[]{new ooo(),"aaa",new Date()};
        ooo o = (ooo) objects[0];
        o.a = 20;
        System.out.println(objects[0]);
        System.out.println(o);
    }

        @Test
    public void t2() {
        ooo o = new ooo();
        System.out.println(o + "------" + o.a);
        ooo oo = o;
        oo = new ooo();
        oo.a = 20;
        System.out.println(oo + "------" + oo.a);
        System.out.println(o + "------" + o.a);

    }

        @Test
    public void t1(){
        ArrayList<Object> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add(new Date());
        list.add(true);

        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            if("aaa".equals(next)){
                next = "DDD";
            }
        }
    }
}
