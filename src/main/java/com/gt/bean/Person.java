package com.gt.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 *     姓名： <input name="userName"/> <br/>
 *     年龄： <input name="age"/> <br/>
 *     生日： <input name="birth"/> <br/>
 *     宠物姓名：<input name="pet.name"/><br/>
 *     宠物年龄：<input name="pet.age"/>
 */
@Data
@ToString
public class Person {

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

}
