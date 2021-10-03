package com.gt.bean;

import lombok.Data;

import java.util.List;

@Data
public class Page <T>{

    private static final int PAGE_SIZE = 5;

    private int pageNo;//当前页数
    private int pageTotal;//总页数
    private int pageTotalCount;//总记录数
    private int pageSize = PAGE_SIZE;//每页显示数量
    private List<T> items;//
}
