package com.gt.javaSE.String;

import org.junit.jupiter.api.Test;

public class mathTest {

    /*
    1）模拟一个trim方法，去除字符串两端的空格。
    2）将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
    3）获取一个字符串在另一个字符串中出现的次数。
          比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
    4）获取两个字符串中最大相同子串。比如：
       str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
       提示：将短的那个串进行长度依次递减的子串与较长的串比较。
    5）对字符串中字符进行自然顺序排序。
     */
    public String trimDemo(String param){
        int i = param.indexOf(' ');
        int j = param.lastIndexOf(' ');
        int temp = 0;
        if(i==-1)
            return param;
        if(i == 0){
            while (true) {
                temp = i;
                i = param.indexOf(' ', i + 1);
                if (i != (temp + 1)) {
                    i = temp;
                    break;
                }
            }
        }else {
            i = -1;
        }
        if(j == param.length()-1 ){
            while (true) {
                temp = j;
                j = param.lastIndexOf(' ', j - 1);
                if (j != (temp - 1)) {
                    j = temp;
                    break;
                }
            }
        }else {
            j = param.length();
        }
        return param.substring(i + 1,j);
    }
    @Test
    public void t1(){
        String i = "         01234";
        System.out.println(i.indexOf(' '));
        System.out.println(i.lastIndexOf(' ',5));
        System.out.println("***" + trimDemo(i) + "************");
    }
}
