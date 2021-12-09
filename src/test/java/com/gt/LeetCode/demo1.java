package com.gt.LeetCode;

import org.junit.Test;

/**
 * Definition for singly-linked list.

 */

public class demo1{

    public int tai(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        return tai(n-1) + tai(n-2);
    }

    @Test
    public void test1(){
        System.out.println(tai(6));
    }

}

