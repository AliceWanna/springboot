package com.javaSE.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class demo1 {

    /*
    void add(int index, Object ele)：在index位置插入ele元素
    boolean addAll(int index, Collection eles)：从index位置开始将eles中 的所有元素添加进来
    Object get(int index)：获取指定index位置的元素
    int indexOf(Object obj)：返回obj在集合中首次出现的位置
    int lastIndexOf(Object obj)：返回obj在当前集合中末次出现的位置
    Object remove(int index)：移除指定index位置的元素，并返回此元素 Object set(int index, Object ele):设置指定index位置的元素为ele
    List subList(int fromIndex, int toIndex)：返回从fromIndex到toIndex 位置的子集合
     */
    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
    }

    @Test
    public void testListRemove() {
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add("ad");
    }

    private static void updateList(List list) {
        list.remove(2);
    }
}
