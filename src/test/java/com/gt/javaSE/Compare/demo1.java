package com.gt.javaSE.Compare;

import org.junit.jupiter.api.Test;

class student implements Comparable<student> {
    public int score;

    @Override
    public int compareTo(student o) {
        return Integer.compare(this.score, o.score);
    }

}

public class demo1 {
    @Test
    public void t1(){
        student student1 = new student();
        student1.score = 20;
        student student2 = new student();
        student1.score = 30;
    }
}
