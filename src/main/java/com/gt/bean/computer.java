package com.gt.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class computer {
    private int id;
    private String name;
    private double price;
//    private Date outDate;
    private int number;
}